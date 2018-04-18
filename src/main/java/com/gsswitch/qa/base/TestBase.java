package com.gsswitch.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.gsswitch.qa.util.TestUtil;
import com.gsswitch.qa.util.webEventListener;

public class TestBase {
	public static WebDriver driver;
	public static EventFiringWebDriver e_driver;
	public static webEventListener eventListener;
	public static Properties prop;
	public static String driverPath = "D:\\Testleaf\\Softwares\\drivers\\";

	public TestBase() {
		try {
			prop = load(
					"C:\\Users\\Manikannan\\eclipse-workspace\\selenium.gsrps\\src\\main\\java\\com\\gsswitch\\qa\\config\\config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Properties load(final String path) throws FileNotFoundException, IOException {
		final Properties property = new Properties();
		body: try (InputStream stream = getInputStream(path)) {
			if (stream == null) {
				System.out.println();
				break body;
			}
			try (final InputStreamReader isr = new InputStreamReader(stream, StandardCharsets.UTF_8)) {
				property.load(isr);
			}
		}
		return property;
	}

	private InputStream getInputStream(final String fileName) throws FileNotFoundException {
		final File file = new File(fileName);
		InputStream stream = null;
		if (file.exists()) {
			stream = new FileInputStream(file);
		} else {
			stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
		}
		return stream;
	}

	public static void initialization() {
		String brwoserName = prop.getProperty("browser");
		if (brwoserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
			driver = new ChromeDriver();
		} else if (brwoserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");
			driver = new FirefoxDriver();
		}
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListenerHandler to register it with
		// EventFiringWebDriver
		eventListener = new webEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
}
