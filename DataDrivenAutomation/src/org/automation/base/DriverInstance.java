package org.automation.base;

import org.automation.datadriven.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class DriverInstance {
	
	public WebDriver driver;
	@BeforeMethod
	public void initiateDriverinstance() throws Exception
	{
		if(Utility.fetchPropertyValue("browsername").toString().equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./DataDrivenAutomation/Driver/ChromeDriver/chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		else if(Utility.fetchPropertyValue("browsername").toString().equalsIgnoreCase("FireFox"))
		{
			System.setProperty("webdriver.geckodriver.driver", "./DataDrivenAutomation/Driver/Geiko Driver/geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		else if(Utility.fetchPropertyValue("browsername").toString().equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "./DataDrivenAutomation/Driver/internetexplorerdriver.exe");
			driver = new InternetExplorerDriver();
			
		}
		else 
		{
			System.setProperty("webdriver.chrome.driver", "./DataDrivenAutomation/Driver/ChromeDriver/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		driver.get(Utility.fetchPropertyValue("applocationURL").toString());
}
	@AfterMethod
	public void closeDriverinstance()
	{
		driver.quit();
	}
}
	

