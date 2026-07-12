package com.mbio.mbio_automation.utils;

import com.aventstack.extentreports.ExtentTest;

public class ExtentReportUtils {
	
    private static final ThreadLocal<ExtentTest> extent = new ThreadLocal<>();
	public static final void startTest(String name,String description)
	{
		ExtentTest extenttest=ExtentManager.getInstance().createTest(name,description);
		extent.set(extenttest);
	}
	public static ExtentTest getTest()
	{
		return extent.get();
	}
public static void endTest()
{
	ExtentManager.getInstance().flush();
}

}
