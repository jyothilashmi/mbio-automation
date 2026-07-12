package com.mbio.mbio_automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage{
	private final WebDriver driver;
	private static final By MARKETING_BANNER = By.xpath("//h3[contains(text(),'Crypto for everyone')]");
	    private static final By DOWNLOADAPPLINK = By.xpath("//a[contains(text(),'Download the app')");

	    public HomePage(WebDriver driver) {
	        this.driver=driver;
	    }
	    
	    public boolean isMarketingSectionVisible()
	    {
	        try {
	            return driver.findElement(MARKETING_BANNER).isDisplayed();
	        } catch (Exception e) {
	            return false;
	        }
	    }
	    
	    public String checkMobileAppDownloadLink() {
	    	try {
	            return driver.findElement(DOWNLOADAPPLINK).getAttribute("href");
	        } catch (Exception e) {
	            return null;
	        }
	    
	    }
}
