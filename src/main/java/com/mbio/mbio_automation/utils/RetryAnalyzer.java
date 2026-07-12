package com.mbio.mbio_automation.utils;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

	public class RetryAnalyzer implements IRetryAnalyzer {

	    private int retryCount = 0;
	    private final int maxRetryCount = ConfigUtils.getInt("retry.count");

	    @Override
	    public boolean retry(ITestResult result) {
	        if (retryCount < maxRetryCount) {
	            retryCount++;
	            return true;
	        }
	        return false;
	    }
	}


