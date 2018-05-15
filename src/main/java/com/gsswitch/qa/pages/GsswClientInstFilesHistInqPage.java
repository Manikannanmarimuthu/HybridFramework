/**
 * 
 */
package com.gsswitch.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gsswitch.qa.base.GsSwitchUIBase;

/**
 * @author Saravanan M
 * @Created on 07-May-2018 11:25:05 AM
 * 
 */
public class GsswClientInstFilesHistInqPage extends GsSwitchUIBase {

	@FindBy(xpath = "//*[@id=\"batchHistoryTable\"]")
	WebElement tableId;

	public GsswClientInstFilesHistInqPage() throws InterruptedException {
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> getTableData() {
		return tableId.findElements(By.tagName("tr"));
	}

}
