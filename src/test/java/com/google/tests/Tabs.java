package com.google.tests;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tabs {

	public static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Testleaf\\Softwares\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://toolsqa.wpengine.com/automation-practice-switch-windows/");
		driver.findElement(By.xpath("//*[@id=\"content\"]/p[4]/button")).click();
		String mainWindow = driver.getWindowHandle();
		String titleText = driver.getTitle();
		System.out.println(titleText);
		Set<String> allwindow = driver.getWindowHandles();
		for (String string : allwindow) {
			if (!string.equalsIgnoreCase(mainWindow)) {
				driver.switchTo().window(string);
				String a = driver.getTitle();
				System.out.println(a);
				System.out.println(string + "is going to be closed");
				driver.close();
			}
		}
		System.out.println("Main Window going to be closed");
		driver.quit();
	}
}
