package com.mbio.mbio_automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.mbio.mbio_automation.components.NavigationComponent;
import com.mbio.mbio_automation.pages.ExplorePage;
import com.mbio.mbio_automation.utils.ExtentReportUtils;
import com.mbio.mbio_automation.utils.RetryAnalyzer;

public class TradingTests extends BaseTest{
	 @Test(groups = {"smoke","regression"},retryAnalyzer = RetryAnalyzer.class)
	public void verifySpotTradingSection() {
		NavigationComponent nav = new NavigationComponent(driver);
		nav.clickMenu("Explore");
	    ExplorePage explore = new ExplorePage(driver);
boolean isSpotTrade=explore.spotTrading.checkSpotTradingVisible();
if(!isSpotTrade)
{

	            ExtentReportUtils.getTest().log(Status.FAIL,"Failed to check Spot trading and section should be visible!!");
	            

}
Assert.assertTrue(isSpotTrade, "Spot trading section is not visible!");
	}
	
	
	

	 @Test(groups = {"smoke","regression"},retryAnalyzer = RetryAnalyzer.class)
	public void verifyTradingCategories() {
		NavigationComponent nav = new NavigationComponent(driver);
		nav.clickMenu("Explore");
	    ExplorePage explore = new ExplorePage(driver);
		boolean isCategory=explore.spotTrading.categoryValidation();
		if(!isCategory)
		{

			            ExtentReportUtils.getTest().log(Status.FAIL,"Failed to check category validation!!");
			            

		}
	    Assert.assertTrue(isCategory, "Trading categories validation failed");
	}

}
