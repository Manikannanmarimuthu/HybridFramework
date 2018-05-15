/**
 * 
 */
package com.gsswitch.qa.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.StringJoiner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.gsswitch.qa.database.SqlQuery;
import com.gsswitch.qa.model.ClientInst;
import com.gsswitch.qa.pages.helper.ClientInstFilesHistInqHelper;
import com.opencsv.CSVWriter;

/**
 * @author Saravanan M
 *
 */
public class ApplicationUtil {

	private static ApplicationUtil appUtil = null;

	private static Connection conn = null;

	private static GsSwAppCfg appCfg = null;

	private static SqlQuery sqlQry = null;

	private ApplicationUtil() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		appCfg = new GsSwAppCfg();
		sqlQry = new SqlQuery();
		conn = createDbConn();
	}

	public static ApplicationUtil getInstance()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		if (appUtil == null) {
			appUtil = new ApplicationUtil();
		}
		return appUtil;
	}

	private Connection createDbConn() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Class.forName(appCfg.getDbDriver());
		conn = DriverManager.getConnection(appCfg.getDbUrl(), appCfg.getDbUser(), appCfg.getDbPass());
		return conn;
	}

	public Connection getDBConn() {
		return conn;
	}

	public GsSwAppCfg getGsSwAppCfg() {
		return appCfg;
	}

	public SqlQuery getSQLQuery() {
		return sqlQry;
	}

	public void closeDBConn(final Connection con) {
		try {
			if (conn != null) {
				conn.close();
			}
			if (con != null) {
				con.close();
			}
			System.out.println("DB Connection closed...");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void closePrepStmt(final PreparedStatement prepStmt) {
		try {
			if (prepStmt != null) {
				prepStmt.close();
			}
			System.out.println("Prepared Statement closed...");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String getCurrentDateTime() {
		final DateFormat YYYYMMDDSSS = new SimpleDateFormat("yyyyMMddSSS", Locale.getDefault());
		return YYYYMMDDSSS.format(new Date());
	}

	public String getTableHeader(final List<WebElement> tblRowList) {
		final StringJoiner tblHeader = new StringJoiner(",");
		for (final WebElement webElmt : tblRowList.get(0).findElements(By.tagName("th"))) {
			tblHeader.add(webElmt.getText());
		}
		return tblHeader.toString();
	}

	public void writeErrInst(final List<WebElement> tblRowList, final String errFileDir, final String moduleName,
			final List<?> errList) {
		
		final String tblHeader = getTableHeader(tblRowList);
		
		final File errFile = new File(errFileDir + File.separator + moduleName + "_" + getCurrentDateTime() + ".csv");
		
		try (final CSVWriter csvWriter = new CSVWriter(
				new OutputStreamWriter(new FileOutputStream(errFile), StandardCharsets.UTF_8));) {

			final List<String[]> strArrList = new ArrayList<String[]>();
			strArrList.add(tblHeader.split(","));
			
			switch (moduleName) {
			
			case Constants.CLIENT_INST_HISTORY:
				@SuppressWarnings("unchecked")
				final List<ClientInst> cliInstErrList = (List<ClientInst>) errList;
				cliInstErrList.forEach(c -> {
					strArrList.add(ClientInstFilesHistInqHelper.mapClientInstObjToString(c));
				});
				break;
				
			case Constants.REFUND_RESEND_HISTORY:
				break;
				
			default:
				System.out.println("Module : " + moduleName + " in progress...");
				break;
			}
			
			csvWriter.writeAll(strArrList);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<?> mapWebElmtToObject(final String moduleName, final List<WebElement> webElList) {
		List<?> tableDataList = null;
		valBlk: {
			if (webElList == null || webElList.isEmpty()) {
				break valBlk;
			}
			
			switch (moduleName) {
			case Constants.CLIENT_INST_HISTORY:
				tableDataList = ClientInstFilesHistInqHelper.
							mapWebElmtToClientInstHistObject(webElList.size(), webElList);
				break;
			case Constants.REFUND_RESEND_HISTORY:
				break;
			default:
				System.out.println("Module : " + moduleName + " in progress...");
			}
		}
		return tableDataList;
	}

}
