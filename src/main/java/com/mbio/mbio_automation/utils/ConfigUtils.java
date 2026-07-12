package com.mbio.mbio_automation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtils{
	private static final Properties prop=new Properties();
	
	static
	{
		try
		{
			String path = System.getProperty("user.dir") + "/resources/config.properties";
			FileInputStream fi=new FileInputStream(path);
			System.out.println("loaded");
			prop.load(fi);
			
		}
		catch(IOException e)
		{
			throw new RuntimeException("Unble to load property file");
		}
	}
	
	public static String getProperty(String key)
	{
		return prop.getProperty(key);
	}
	public static int getInt(String key)
	{
		return Integer.parseInt(prop.getProperty(key));
	}
}
