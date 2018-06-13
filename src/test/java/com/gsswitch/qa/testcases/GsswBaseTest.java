package com.gsswitch.qa.testcases;

import org.automationtesting.excelreport.Xl;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.gsswitch.qa.base.GsSwitchUIBase;
import com.gsswitch.qa.pages.GsswHomePage;
import com.gsswitch.qa.pages.GsswLoginPage;
import com.gsswitch.qa.util.Constants;
import com.gsswitch.qa.util.SendMail;
import com.gsswitch.qa.util.ZipFile;

public class GsswBaseTest extends GsSwitchUIBase {

	GsswLoginPage loginPage;
	GsswHomePage homePage;

	@BeforeSuite
	public void beforeSuite() {
	}

	@BeforeTest
	public void beforeTest() {
	}

	@AfterMethod
	public void afterMethod() {
		try {
			quitBrowser();
		} catch (Exception e) {
		}
	}

	@AfterTest
	public void afterTest() {
	}

	@AfterSuite
	public void afterSuite() throws Exception {
		Xl.generateReport(Constants.EXCEL_REPORT_PATH, appCfg.getExcelFileReportName());
		ZipFile.zip(Constants.EXCEL_REPORT_PATH, appCfg.getExcelFileReportName());
		SendMail.execute("GS-Switch Test Report.xlsx");
		appUtil.closeDBConn(conn);
		appUtil.closePrepStmt(prepStmt);
	}

	@DataProvider(name = "testdataset")
	public Object[][] getData() {
		// Create object with two paraments
		Object[][] data = new Object[2][2];
		data[0][0] = "gssmaker";
		data[0][1] = "welcome12";
		data[1][0] = "gssmaker";
		data[1][1] = "welcome12";
		return data;
	}
}
