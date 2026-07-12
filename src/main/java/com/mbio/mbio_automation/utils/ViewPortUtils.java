package com.mbio.mbio_automation.utils;

import org.openqa.selenium.Dimension;

import com.mbio.mbio_automation.base.DriverFactory;

public class ViewPortUtils {
	
	public static void setMobileViewport()
	{
		int width=ConfigUtils.getInt("mobile.width");
		int height=ConfigUtils.getInt("mobile.height");
		DriverFactory.getDriver().manage().window().setSize(new Dimension(width,height));
	}
	public static void setDesktopViewport()
	{
		int width=ConfigUtils.getInt("desktop.width");
		int height=ConfigUtils.getInt("desktop.height");
		DriverFactory.getDriver().manage().window().setSize(new Dimension(width,height));
	}

}
