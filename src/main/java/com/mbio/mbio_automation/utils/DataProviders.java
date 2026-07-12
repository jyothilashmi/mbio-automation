package com.mbio.mbio_automation.utils;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name="navigationTestData")
	public Object[][] getNavigationTestData()
	{
		return DataReader.readData("NavigationTests");
	}

}
