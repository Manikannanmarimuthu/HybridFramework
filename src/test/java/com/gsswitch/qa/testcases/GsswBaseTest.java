package com.gsswitch.qa.testcases;

import org.automationtesting.excelreport.Xl;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.gsswitch.qa.base.GsSwitchUIBase;
import com.gsswitch.qa.pages.GsswHomePage;
import com.gsswitch.qa.pages.GsswLoginPage;
import com.gsswitch.qa.util.Constants;

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
		appUtil.closeDBConn(conn);
		appUtil.closePrepStmt(prepStmt);
	}
}
