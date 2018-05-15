/**
 * 
 */
package com.gsswitch.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.google.common.io.Files;
import com.gsswitch.qa.database.SqlQuery;
import com.gsswitch.qa.listeners.WebEventListener;
import com.gsswitch.qa.util.ApplicationUtil;
import com.gsswitch.qa.util.Constants;
import com.gsswitch.qa.util.GsSwAppCfg;

/**
 * @author Saravanan M
 * @created on 04-May-2018 11:08:15 AM
 */
public abstract class GsSwitchUIBase {

	public static GsSwAppCfg appCfg = null;
	public static SqlQuery sqlQryCfg = null;
	public static ApplicationUtil appUtil = null;

	public static WebDriver driver;
	public static Properties prop = null;

	public static Connection conn = null;
	public static PreparedStatement prepStmt = null;

	public GsSwitchUIBase() {
		try {
			loadProp();
			appUtil = ApplicationUtil.getInstance();
			sqlQryCfg = appUtil.getSQLQuery();
			appCfg = appUtil.getGsSwAppCfg();
			conn = appUtil.getDBConn();
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	public static void loadProp() throws FileNotFoundException, IOException {
		if (prop == null) {
			prop = new Properties();
			prop.load(new FileInputStream(new File("./gsswitch.properties")));
		}
	}

	public static String getFilePropertyKey(final String key) {
		return prop.getProperty(key, null);
	}

	public static WebDriver initialization() {
		final String browserName = appCfg.getBrowserName();
		final DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName(browserName);
		dc.setPlatform(Platform.WINDOWS);
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty(Constants.CHROME_WEBDRIVER, "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty(Constants.FIREFOX_WEBDRIVER, "./drivers/chromedriver.exe");
			driver = new FirefoxDriver();
		}

		// Now create object of EventListenerHandler to register it with
		// EventFiringWebDriver
		final WebEventListener eventListener = new WebEventListener();
		final EventFiringWebDriver e_driver = new EventFiringWebDriver(driver);
		e_driver.register(eventListener);
		driver = e_driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(appCfg.getAppLoginUrl());
		return driver;
	}

	public static void takeScreenshot() {
		try {
			final File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			Files.copy(scrFile,
					new File(appCfg.getScreenShotDir() + File.separator + System.currentTimeMillis() + ".png"));
		} catch (IOException e) {
			System.out.println("Error occurred in Take Screenshot Method");
			e.printStackTrace();
		}
	}

	public List<WebElement> getTableWebElement(final String tableId) {
		return driver.findElement(By.xpath(tableId)).findElements(By.tagName("tr"));
	}

	public void quitBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
		}
	}

}
