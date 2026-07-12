package com.mbio.mbio_automation.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	private static final ThreadLocal<WebDriver>driver=new ThreadLocal<>();
	
	public static void initDriver()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver.set(new ChromeDriver(options));
		getDriver().manage().window().maximize();
	}
	public static WebDriver getDriver()
	{
		return driver.get();
	}
	public static void quitDriver()
	{
		if(driver.get()!=null)
		{
			driver.get().quit();
			driver.remove();
		}
	}
	
}
