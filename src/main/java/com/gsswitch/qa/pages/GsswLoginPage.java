/**
 * 
 */
package com.gsswitch.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gsswitch.qa.base.GsSwitchUIBase;

/**
 * @author Saravanan M
 * @created on 04-May-2018 12:22:11 PM
 */
public class GsswLoginPage extends GsSwitchUIBase {

	@FindBy(id = "loginId")
	WebElement userName;

	@FindBy(xpath = "//input[@id = \"pwdStr\"]")
	WebElement password;

	@FindBy(id = "btnLogin")
	WebElement loginBtn;

	@FindBy(xpath = "//*[@id=\"logo\"]/a")
	WebElement logo;

	public GsswLoginPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateGsLogo() {
		return logo.isDisplayed();
	}

	public GsswHomePage login() throws InterruptedException {
		userName.sendKeys(appCfg.getAppLoginUser());
		password.sendKeys(appCfg.getAppLoginPass());
		Thread.sleep(3000);
		loginBtn.click();
		return new GsswHomePage();
	}

}
