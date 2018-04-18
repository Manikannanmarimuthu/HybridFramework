package com.google.tests;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeSwitchWindow {

	public static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Testleaf\\Softwares\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://toolsqa.wpengine.com/automation-practice-switch-windows/");
		String handle = driver.getWindowHandle();
		driver.findElement(By.xpath("//*[@id=\"content\"]/p[3]/button")).click();
		Set<String> handles = driver.getWindowHandles();
		for (String handle1 : handles) {
			driver.switchTo().window(handle1);
			if (!handle1.equalsIgnoreCase(handle)) {
				System.out.println("Going to close : " + handle1 + "  Because it's not a Parent window");
				driver.close();
			}
		}
		driver.quit();
	}
}