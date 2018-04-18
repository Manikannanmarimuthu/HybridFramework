package com.google.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleHomePageTest {

	private WebDriver driver;
	String appURL = "http://google.com";

	@BeforeClass
	public void testSetUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\Testleaf\\Softwares\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void verifyGooglePageTittle() {
		driver.navigate().to(appURL);
		String getTitle = driver.getTitle();
		Assert.assertEquals(getTitle, "Google");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}