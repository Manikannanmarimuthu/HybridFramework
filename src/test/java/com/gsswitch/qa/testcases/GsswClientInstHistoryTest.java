/**
 * 
 */
package com.gsswitch.qa.testcases;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gsswitch.qa.model.ClientInst;
import com.gsswitch.qa.pages.GsswClientInstFilesHistInqPage;
import com.gsswitch.qa.pages.GsswLoginPage;
import com.gsswitch.qa.pages.helper.ClientInstFilesHistInqHelper;
import com.gsswitch.qa.util.Constants;

/**
 * @author Saravanan M
 * @created on 02-May-2018 3:43:30 PM
 */
public class GsswClientInstHistoryTest extends GsswBaseTest {

	List<WebElement> tblRowList = null;
	List<ClientInst> clientInstList = null;
	GsswClientInstFilesHistInqPage clientPage;

	@BeforeMethod
	public void setup() throws InterruptedException, FileNotFoundException, IOException {
		initialization();
		loginPage = new GsswLoginPage();
		homePage = loginPage.login();
	}

	@Test
	@SuppressWarnings("unchecked")
	public void validateRecords() throws InterruptedException {
		clientPage = homePage.showClientInstHistInqPage();
		tblRowList = clientPage.getTableData();
		// mapping table rows to list of object.
		clientInstList = (List<ClientInst>) appUtil.mapWebElmtToObject(Constants.CLIENT_INST_HISTORY, tblRowList);
		compare();
	}

	private void compare() {
		// Mismatching Table rows and Database table rows.
		final List<ClientInst> cliInstErrList = getMisMatchingData();
		if (cliInstErrList.isEmpty()) {
			System.out.println("Client Instruction Files History Inquiry - Tested sucessfully");
		} else {
			appUtil.writeErrInst(tblRowList, appCfg.getErrFileDir(), Constants.CLIENT_INST_HISTORY, cliInstErrList);
		}
	}

	/**
	 * This method comparing the table data with database table data.
	 * 
	 * @return List<ClientInst>
	 */
	private List<ClientInst> getMisMatchingData() {
		final List<ClientInst> mismatchingInstList = new ArrayList<>();
		if (clientInstList != null && !clientInstList.isEmpty()) {
			// Table Name = replacing #### with clientId
			final String sqlQry = sqlQryCfg.getClientInstQry1().replace(Constants.REPLACE_CLIENT_ID,
					appCfg.getClientId());
			try {
				prepStmt = conn.prepareStatement(sqlQry);
				for (final ClientInst clientTblRow : clientInstList) {
					prepStmt.setString(1, clientTblRow.getBatchId());
					final ResultSet resultSet = prepStmt.executeQuery();
					final ClientInst clientDbRow = ClientInstFilesHistInqHelper.mapResultSetToObject(resultSet);
					if (!clientTblRow.equals(clientDbRow)) {
						mismatchingInstList.add(clientTblRow);
					}
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return mismatchingInstList;
	}
}
