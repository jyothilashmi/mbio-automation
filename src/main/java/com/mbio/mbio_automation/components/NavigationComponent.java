package com.mbio.mbio_automation.components;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;
import com.mbio.mbio_automation.utils.ExtentReportUtils;
import com.mbio.mbio_automation.utils.WaitUtils;

public class NavigationComponent {
	private final WebDriver driver;
	private final WaitUtils waitUtils;
	private String originalWindow;

	
	private static final By NAVLISTS = By.cssSelector("nav[aria-label='Main'] a");
	private static final By HAMBURGER = By.cssSelector("button[aria-label='Open menu']");
	private static final By MOBILE_NAV_LINKS = By.cssSelector("nav.flex.flex-col a");


	//Actions/------------------/
    
	public void saveOriginalWindows()
	{
		originalWindow=driver.getWindowHandle();
	}
	
	public void switchToNewTab() {
		
		for(String newTab:driver.getWindowHandles())
		{
			if(!newTab.equalsIgnoreCase(originalWindow))
			{
				driver.switchTo().window(newTab);
				 ExtentReportUtils.getTest().log(Status.INFO, "Switched to new window!!");
		            break;
			}
		}
	 
	}
	public void switchBackToMainWindow()
	{
		try
		 {
			 driver.switchTo().window(originalWindow);
			 ExtentReportUtils.getTest().log(Status.INFO, "Switched back to original window");
		 }
		 catch(Exception e)
		 {
			 ExtentReportUtils.getTest().log(Status.FAIL,
		                "Failed to switch back: " + e.getMessage());
		 }
	}
		
	
    public NavigationComponent(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }
    public List<WebElement> returnLinks(By element)
    {
    	List<WebElement>navLists=new ArrayList<>();
    	try
    	{
    		navLists=driver.findElements(element);
    		
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	return navLists;
    }
    public List<String> getNavigationLinksTexts()
	{
    	
		List<String>linkTexts=new ArrayList<>();
		for(WebElement e:returnLinks(NAVLISTS))
		{
			String getLinkText=e.getText().trim();
			linkTexts.add(getLinkText);
		}
		return linkTexts;
	}
	public boolean clickAndVerifyLinks(String linkText)
	{
		try
		{
			if(returnLinks(NAVLISTS).size()==0)
			{
				ExtentReportUtils.getTest().log(Status.FAIL,"No header links found.");
				return false;
			}
			for(WebElement e:returnLinks(NAVLISTS))
			{
				if(e.getText().trim().equalsIgnoreCase(linkText))
					{
					e.click();
					ExtentReportUtils.getTest().log(Status.PASS,"Clicked on the menu:: "+linkText);
					return true;
					}
			}
			ExtentReportUtils.getTest().log(Status.FAIL,"No header links found.");
			return false;
			}
			
			 catch (Exception e) {
				 ExtentReportUtils.getTest().log(Status.FAIL,
		                    "Error clicking navigation item: " + e.getMessage());
		            return false;
			 }
		}
	
	public boolean clickMenu(String text) {
        try {
            List<WebElement> items = returnLinks(NAVLISTS);

            for (WebElement item : items) {
                if (item.getText().trim().equalsIgnoreCase(text)) {
                	waitUtils.clickable(item);
                    item.click();
                    ExtentReportUtils.getTest().log(Status.PASS,
                            "Clicked menu: " + text);
                    return true;
                }
            }

            ExtentReportUtils.getTest().log(Status.FAIL,
                    "Menu not found: " + text);
            return false;

        } catch (Exception e) {
            ExtentReportUtils.getTest().log(Status.FAIL,
                    "Error clicking menu: " + e.getMessage());
            return false;
        }
    }
	public boolean validateNavigationLinks(String menu,String url)
	{
		try
		{
			saveOriginalWindows();
			
			if(!clickAndVerifyLinks(menu))
			{
				return false;
			}
			if(menu.equalsIgnoreCase("$MBG"))
			{
				switchToNewTab();
				waitUtils.urlContains("token");
				waitUtils.urlContains("mb");
				String getUrl=driver.getCurrentUrl().toLowerCase();
				boolean status=getUrl.contains("token")&&getUrl.contains("mb");
				   if (status) {
		                ExtentReportUtils.getTest().log(Status.PASS,
		                        "$MBG navigated correctly → " + getUrl);
		            } else {
		                ExtentReportUtils.getTest().log(Status.FAIL,
		                        "$MBG navigated incorrectly → " + getUrl);
		            }
				
			}
			waitUtils.urlContains(url);
			String getUrl=driver.getCurrentUrl().toLowerCase();
			boolean status=getUrl.contains(url.toLowerCase());
			if(status)
			{
				ExtentReportUtils.getTest().log(Status.PASS,
	                   menu+ " navigated to correct location "+getUrl);
				
			}
			else
			{

				ExtentReportUtils.getTest().log(Status.FAIL,
	                   menu+ " navigated to not correct location "+getUrl);
				
			}
			if (menu.equalsIgnoreCase("$MBG")) {
				switchBackToMainWindow();
	        }
			return status;
			
		}
		catch(Exception e)
		{
			ExtentReportUtils.getTest().log(Status.FAIL,
                    "Error navigation item: " + e.getMessage());
            return false;
		}
	}
    public boolean isHamburgerVisible() {
        try {
            return driver.findElement(HAMBURGER).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public List<WebElement> getDesktopNavLinks() {
        return driver.findElements(NAVLISTS);
    }
    public void openMobileMenu() {
        try {
            driver.findElement(HAMBURGER).click();
            ExtentReportUtils.getTest().log(Status.PASS, "Hamburger menu clicked");
        } catch (Exception e) {
            ExtentReportUtils.getTest().log(Status.FAIL,
                    "Hamburger menu not found: " + e.getMessage());
        }
    }

    public List<WebElement> getMobileNavLinks() {
        return driver.findElements(By.cssSelector(".mobile-menu a"));
    }
    public List<String> getMobileNavLinksTexts() {
        List<String> linkTexts = new ArrayList<>();

        try {
            List<WebElement> links = driver.findElements(MOBILE_NAV_LINKS);

            for (WebElement link : links) {
                linkTexts.add(link.getText().trim());
            }

            ExtentReportUtils.getTest().log(Status.PASS,
                    "Mobile navigation links found: " + linkTexts);

        } catch (Exception e) {
            ExtentReportUtils.getTest().log(Status.FAIL,
                    "Error getting mobile navigation links: " + e.getMessage());
        }

        return linkTexts;
    }


}
