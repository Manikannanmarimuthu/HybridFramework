package com.gsswitch.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gsswitch.qa.base.TestBase;
import com.gsswitch.qa.pages.HomePage;
import com.gsswitch.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
	}

	@AfterMethod
	public void tearDown() {
		// driver.quit();
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String loginTitle = loginPage.validateLoginPageTitle();
		Assert.assertEquals(loginTitle, "Geoswift Switch", "Title Mismatch");
	}

	@Test(priority = 2)
	public void crmLogoTest() {
		Boolean flag = loginPage.ValidateCRMLogog();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void loginTest() throws InterruptedException {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
}
