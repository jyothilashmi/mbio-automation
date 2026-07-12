package com.mbio.mbio_automation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;
import com.mbio.mbio_automation.components.NavigationComponent;
import com.mbio.mbio_automation.components.SpotTradingComponent;
import com.mbio.mbio_automation.utils.ExtentReportUtils;

public class ExplorePage{
	public final SpotTradingComponent spotTrading;
	public final NavigationComponent nav;
	public ExplorePage(WebDriver driver) {
		this.spotTrading = new SpotTradingComponent(driver);
		this.nav=new NavigationComponent(driver);
		
	}

}
