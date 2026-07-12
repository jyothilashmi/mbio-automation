package com.mbio.mbio_automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.mbio.mbio_automation.components.NavigationComponent;
import com.mbio.mbio_automation.pages.AboutUsPage;
import com.mbio.mbio_automation.utils.ExtentReportUtils;
import com.mbio.mbio_automation.utils.RetryAnalyzer;

public class AboutUsPageTests extends BaseTest{
	 @Test(groups = {"regression"},retryAnalyzer = RetryAnalyzer.class)
	public void validateAboutUsPageContent()
	{
		NavigationComponent nav = new NavigationComponent(driver);
		nav.clickMenu("Company");
		AboutUsPage aboutus=new AboutUsPage(driver);
		
		Assert.assertTrue(aboutus.isHeroSectionVisible(), "Hero heading missing");
        Assert.assertTrue(aboutus.areStatsVisible(), "Stats not visible");
        Assert.assertTrue(aboutus.isLeadershipSectionVisible(), "Leadership section missing");
        Assert.assertTrue(aboutus.isInnovationSectionVisible(), "Innovation section missing");
        Assert.assertTrue(aboutus.isIntegritySectionVisible(), "Integrity section missing");
        Assert.assertTrue(aboutus.areStrengthCardsVisible(), "Strength cards missing");
        Assert.assertTrue(aboutus.areCommunityCardsVisible(), "Community cards missing");

        ExtentReportUtils.getTest().log(Status.PASS, "All AboutUs page components render correctly");
	}

}
