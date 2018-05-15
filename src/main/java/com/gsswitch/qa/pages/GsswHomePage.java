package com.gsswitch.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gsswitch.qa.base.GsSwitchUIBase;

public class GsswHomePage extends GsSwitchUIBase {

	@FindBy(xpath = "//*[contains(@title,'Geo')]")
	WebElement homePageLogo;

	@FindBy(xpath = "//*[contains(@id,'tagline')]")
	WebElement homePageWelcomelogo;

	@FindBy(xpath = "//h2[contains(@style,'text-align:')]")
	WebElement homePageWelcomeText;

	@FindBy(linkText = "Logout")
	WebElement homePageLogOut;

	@FindBy(xpath = "//b[contains(text(),\"Client Instruction Files History Inquiry\")]")
	WebElement clickOnClientInstPageLink;

	@FindBy(xpath = "//a[contains(text(),\"Client Instruction Files History Inquiry\")]")
	WebElement showClientInstPage;

	public GsswHomePage() throws InterruptedException {
		PageFactory.initElements(driver, this);
	}

	public boolean validateHomePageLogo() {
		return homePageLogo.isDisplayed();
	}

	public boolean homePageWelcomelogo() {
		return homePageWelcomelogo.isDisplayed();
	}

	public boolean homePageWelcomeText() {
		return homePageWelcomeText.isDisplayed();
	}

	public boolean homePageLogOut() {
		return homePageLogOut.isDisplayed();
	}

	public String validateHomePageTitle() {
		return driver.getTitle();
	}

	public void clickOnClientInstFilesHistInqLink() throws InterruptedException {
		clickOnClientInstPageLink.click();
		// return new GsswClientInstFilesHistInqPage();
	}

	public GsswClientInstFilesHistInqPage showClientInstHistInqPage() throws InterruptedException {
		clickOnClientInstFilesHistInqLink();
		showClientInstPage.click();
		return new GsswClientInstFilesHistInqPage();
	}

}
