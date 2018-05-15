package com.gsswitch.qa.listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.gsswitch.qa.base.GsSwitchUIBase;

public class WebEventListener extends GsSwitchUIBase implements WebDriverEventListener {

	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before Navigating to '" + url);
	}

	public void afterChangeValueOf(WebElement arg0, WebDriver arg1) {
		System.out.println("inside method afterChangeValueOf on " + arg0.toString());
	}

	public void afterClickOn(WebElement arg0, WebDriver arg1) {
		System.out.println("inside method afterClickOn on " + arg0.toString());
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Just before finding element " + by.toString());
	}

	public void afterNavigateBack(WebDriver arg0) {
		System.out.println("Inside the after navigateback to " + arg0.getCurrentUrl());
	}

	public void afterNavigateForward(WebDriver arg0) {
		System.out.println("Inside the afterNavigateForward to " + arg0.getCurrentUrl());
	}

	public void afterNavigateTo(String arg0, WebDriver arg1) {
		System.out.println("Inside the afterNavigateTo to " + arg0);
	}

	public void afterScript(String arg0, WebDriver arg1) {
		System.out.println("Inside the afterScript to, Script is " + arg0);
	}

	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1) {
		System.out.println("Inside the beforeChangeValueOf method");
	}

	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		System.out.println("About to click on the " + arg0.toString());

	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Just before finding element " + by.toString());

	}

	public void beforeNavigateBack(WebDriver arg0) {
		System.out.println("Just before beforeNavigateBack " + arg0.getCurrentUrl());

	}

	public void beforeNavigateForward(WebDriver arg0) {
		System.out.println("Just before beforeNavigateForward " + arg0.getCurrentUrl());

	}

	public void beforeScript(String arg0, WebDriver arg1) {
		System.out.println("Just before beforeScript " + arg0);
	}

	public void onException(Throwable error, WebDriver driver) {
		System.out.println("Exception occured at " + error);
		GsSwitchUIBase.takeScreenshot();
	}

	@Override
	public void afterAlertAccept(WebDriver arg0) {
	}

	@Override
	public void afterAlertDismiss(WebDriver arg0) {
	}

	@Override
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
	}

	@Override
	public void afterNavigateRefresh(WebDriver arg0) {
	}

	@Override
	public void afterSwitchToWindow(String arg0, WebDriver arg1) {

	}

	@Override
	public void beforeAlertAccept(WebDriver arg0) {
	}

	@Override
	public void beforeAlertDismiss(WebDriver arg0) {
	}

	@Override
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {

	}

	@Override
	public void beforeNavigateRefresh(WebDriver arg0) {
	}

	@Override
	public void beforeSwitchToWindow(String arg0, WebDriver arg1) {
	}
}