package com.mbio.mbio_automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mbio.mbio_automation.pages.HomePage;
import com.mbio.mbio_automation.utils.RetryAnalyzer;

public class HomepageTests extends BaseTest{
	
	 @Test(groups = {"smoke","regression"},retryAnalyzer = RetryAnalyzer.class)
	public void verifyMarketingBanner() {
	    HomePage home = new HomePage(driver);
	    Assert.assertTrue(home.isMarketingSectionVisible(),
	            "Marketing banner should be visible");
	}

	 @Test(groups = {"smoke","regression"},retryAnalyzer = RetryAnalyzer.class)
	public void verifyAppDownloadLinks() {
	    HomePage home = new HomePage(driver);

	    String appStore = home.checkMobileAppDownloadLink();


	    Assert.assertTrue(appStore.contains("apple.com"), 
	            "App Store link is incorrect");
	}

}
