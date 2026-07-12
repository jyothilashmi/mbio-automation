package com.mbio.mbio_automation.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	   private static ExtentReports extent;
	public static ExtentReports getInstance()
	{
		if(extent==null)
		{
			String path=ConfigUtils.getProperty("extent.report.path");
			ExtentSparkReporter report=new ExtentSparkReporter(path);
			report.config().setReportName("MBIO Automation Execution Report");
			report.config().setReportName("MBIO Automation Test Report");
			extent=new ExtentReports();
			extent.attachReporter(report);
		}
		return extent;
	}

}
