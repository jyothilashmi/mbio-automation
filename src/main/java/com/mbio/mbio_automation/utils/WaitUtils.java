package com.mbio.mbio_automation.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	  private final WebDriverWait wait;

	    public WaitUtils(WebDriver driver) {
	        int timeout = ConfigUtils.getInt("explicit.wait");
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	    }
	    
	    public WebElement visible(WebElement element)
	    {
	    	return wait.until(ExpectedConditions.visibilityOf(element));
	    }
	    public void urlContains(String partialUrl) {
	        wait.until(ExpectedConditions.urlContains(partialUrl.toLowerCase()));
	    }

	    public void clickable(WebElement element) {
	        wait.until(ExpectedConditions.elementToBeClickable(element));
	    }
}
