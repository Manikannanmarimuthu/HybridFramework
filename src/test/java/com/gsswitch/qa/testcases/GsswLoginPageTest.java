package com.gsswitch.qa.testcases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gsswitch.qa.pages.GsswLoginPage;

public class GsswLoginPageTest extends GsswBaseTest {

	@BeforeMethod
	public void setup() throws InterruptedException, FileNotFoundException, IOException {
		initialization();
		loginPage = new GsswLoginPage();
	}

	@Test(dataProvider = "testdataset")
	public void loginTest(String UserName, String Password) throws InterruptedException {
		loginPage.login(UserName, Password);
	}

}
