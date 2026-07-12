				package com.mbio.mbio_automation.tests;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.mbio.mbio_automation.base.DriverFactory;
import com.mbio.mbio_automation.utils.ConfigUtils;
import com.mbio.mbio_automation.utils.ExtentReportUtils;

public abstract class BaseTest {
	protected WebDriver driver;
	
	@BeforeMethod
	public void setUp(Method method)
	{
		DriverFactory.initDriver();
		driver=DriverFactory.getDriver();
		driver.get(ConfigUtils.getProperty("base.url"));
		ExtentReportUtils.startTest(method.getName(), "Execution starts:"+method.getName());
	}
	  @AfterMethod(alwaysRun = true)
	    public void tearDown(ITestResult result) {
		  
		
		  if(result.getStatus()==ITestResult.SUCCESS)
		  {
			  ExtentReportUtils.getTest().log(Status.PASS, "Test Passed");
		  }
		  else if(result.getStatus()==ITestResult.FAILURE)
		  {ExtentReportUtils.getTest().log(Status.FAIL, result.getThrowable());
			  
		  }
		  else
		  {
			  ExtentReportUtils.getTest().log(Status.INFO, "Test No Result");
		  }
	        DriverFactory.quitDriver();
	        ExtentReportUtils.endTest();
	    }

}
