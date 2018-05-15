package com.gsswitch.qa.testcases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gsswitch.qa.pages.GsswLoginPage;

public class GsswHomePageTest extends GsswBaseTest {

	@BeforeMethod
	public void setup() throws InterruptedException, FileNotFoundException, IOException {
		initialization();
		loginPage = new GsswLoginPage();
		homePage = loginPage.login();
	}

	@Test
	public void clickOnClienentInstPageinquiry() throws InterruptedException {
		homePage.clickOnClientInstFilesHistInqLink();
	}

}
