package com.mbio.mbio_automation.tests;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.mbio.mbio_automation.components.NavigationComponent;
import com.mbio.mbio_automation.utils.ExtentReportUtils;
import com.mbio.mbio_automation.utils.RetryAnalyzer;
import com.mbio.mbio_automation.utils.ViewPortUtils;

public class NavigationTests extends BaseTest{

	@Test(groups = {"smoke","regression"},retryAnalyzer = RetryAnalyzer.class)
	public void verifyNavigationDesktopView()
	{
		ViewPortUtils.setDesktopViewport();
		 NavigationComponent nav = new NavigationComponent(driver);
		List<String>items=nav.getNavigationLinksTexts();
		if(items.size()<0)
		{
			ExtentReportUtils.getTest().log(Status.FAIL,"Failed to get Menu texts");
		}
		else
		{
			ExtentReportUtils.getTest().log(Status.PASS,"Menus are present.!!!");
		}
		
	}
	  @Test(groups = {"smoke","regression"},retryAnalyzer = RetryAnalyzer.class)
	    public void setMobileViewport() {
		  ViewPortUtils.setMobileViewport();

		    NavigationComponent nav = new NavigationComponent(driver);

		    Assert.assertTrue(nav.isHamburgerVisible(), "Hamburger should be visible");

		    nav.openMobileMenu();

		    List<String> items = nav.getMobileNavLinksTexts();

		    Assert.assertTrue(items.size() > 0, "Mobile navigation links should be visible");
	    }
	  
	 @Test(groups = {"smoke"},retryAnalyzer = RetryAnalyzer.class,dataProvider = "navigationData")
	public void verifyHeaderNavigation(String menu,String expectedUrl)
	{
		 NavigationComponent nav = new NavigationComponent(driver);
			/*
			 * Assert.assertTrue(nav.validateNavigationLinks("Explore", "explore"));
			 * Assert.assertTrue(nav.validateNavigationLinks("Features", "features"));
			 * Assert.assertTrue(nav.validateNavigationLinks("OTC Desk",
			 * "/features/otc-desk"));
			 * Assert.assertTrue(nav.validateNavigationLinks("Company", "company"));
			 * Assert.assertTrue(nav.validateNavigationLinks("Support", "support"));
			 * Assert.assertTrue(nav.validateNavigationLinks("$MBG", "token"));
			 */
			Assert.assertTrue(nav.validateNavigationLinks(menu, expectedUrl));
			Assert.assertTrue(nav.validateNavigationLinks(menu, expectedUrl));
			Assert.assertTrue(nav.validateNavigationLinks(menu, expectedUrl));
			Assert.assertTrue(nav.validateNavigationLinks(menu, expectedUrl));
			Assert.assertTrue(nav.validateNavigationLinks(menu, expectedUrl));
			Assert.assertTrue(nav.validateNavigationLinks(menu, expectedUrl));
		
	}
	
	 
}
