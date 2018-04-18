package com.gsswitch.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gsswitch.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory = OR:
	@FindBy(name = "loginId")
	WebElement userName;

	@FindBy(xpath = "//input[@id = \"pwdStr\"]")
	WebElement password;

	@FindBy(id = "btnLogin")
	WebElement loginBtn;

	@FindBy(xpath = "//*[@id=\"logo\"]/a")
	WebElement logo;

	// Initializing the page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean ValidateCRMLogog() {
		return logo.isDisplayed();
	}

	public HomePage login(String username, String pwd) throws InterruptedException {
		userName.sendKeys(username);
		password.sendKeys(pwd);
		Thread.sleep(5000);
		loginBtn.click();
		return new HomePage();
	}

}
