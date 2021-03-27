package org.automation.pages;

import java.io.IOException;

import org.automation.datadriven.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void enterUsername (String uname) throws Exception
	{
		driver.findElement(By.id(Utility.fetchLocatorValue("login_username_id"))).sendKeys(uname);
	}
	
	public void enterPassword (String pass) throws Exception
	{
		driver.findElement(By.id(Utility.fetchLocatorValue("login_password_id"))).sendKeys(pass);
	}
	public void ClickSignIn() throws Exception
	{
		driver.findElement(By.xpath(Utility.fetchLocatorValue("login_signin_xpath"))).click();
	}
}
