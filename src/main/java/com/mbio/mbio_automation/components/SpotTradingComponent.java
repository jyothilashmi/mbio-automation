package com.mbio.mbio_automation.components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;
import com.mbio.mbio_automation.utils.ExtentReportUtils;

public class SpotTradingComponent {

	private final WebDriver driver;
	private static final By TRADINGCATEGORY = By.cssSelector("div.flex.items-center.gap-2 button");
	private static final By TRADINGSECTION = By.cssSelector("section.bg-dark.flex.flex-co");
	    public static final By ROW = By.cssSelector("div.flex.items-center.justify-between.p-2.rounded-lg.bg-card");
	    public static final By INSTRUMENT = By.cssSelector("div.text-sm.font-semibold");
	    private static final By NAME = By.cssSelector("div.text-xs.text-gray-400");
	    public static final By PRICE = By.cssSelector("div.text-base.font-semibold");
	    private static final By SPARKLINE = By.cssSelector("svg");
	    
	    
	    public SpotTradingComponent(WebDriver driver) {
	        this.driver = driver;
	    }

	    public boolean checkSpotTradingVisible() {
	        return driver.findElement(TRADINGSECTION).isDisplayed();
	    }
	    public boolean categoryValidation() {
	    	try
	    	{
	    		List<WebElement> tradingCategory=driver.findElements(TRADINGCATEGORY);
	    		int count= tradingCategory.size();
	    		if(count==0)
	    		{
	    			ExtentReportUtils.getTest().log(Status.FAIL, "No category of trades has been found.");
	    			return false;
	    		}
	    		else
	    		{
	    			ExtentReportUtils.getTest().log(Status.PASS, "Trade category has been found.");
	    			return true;
	    		}
	    	}
	    	catch(Exception e)
	    	{ExtentReportUtils.getTest().log(Status.FAIL, "Error validating categories.");
			return false;
	    		
	    	}
	    }
	   
	    public boolean validateCategoryPairs() {
	    	try
	    	{
	    		List<WebElement>rows=driver.findElements(ROW);
	    		int count= rows.size();
	    		if(count==0)
	    		{
	    			ExtentReportUtils.getTest().log(Status.FAIL, "No trading pairs found!!!!");
	    			return false;
	    		}
	    		else
	    		{
	    			ExtentReportUtils.getTest().log(Status.INFO, "Trade pairs have been found.");
	    		
	    		
	    		
	    		for(WebElement row:rows)
	    		{
	    			WebElement symbol=row.findElement(INSTRUMENT);
	    					WebElement tradeName=row.findElement(NAME);
	    					WebElement price=row.findElement(PRICE);
	    					WebElement line=row.findElement(SPARKLINE);
	    				     ExtentReportUtils.getTest().log(Status.PASS,
	    			                    "Symbol: " + symbol.getText() +
	    			                    ", Name: " + tradeName.getText() +
	    			                    ", Price: " + price.getText()+
	    			                    ", Line: "+ line.getText());
	    		}
	    		return true;
	    		}
	    	}
	    	catch(Exception e)
	    	{ExtentReportUtils.getTest().log(Status.FAIL, "Error validating pairs.");
			return false;
	    		
	    	}
	    	
	    }
	    
	}

