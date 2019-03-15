package com.SpringSeven.qa.testcases;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.springSeven.qa.base.testBase;
import com.springSeven.qa.pages.initialPage;
import com.springSeven.qa.pages.loginPage;
import com.springSeven.qa.util.testUtil;


public class initialPageTest extends testBase{
	 initialPage  initialPage;
	 loginPage loginPage; 
	 testUtil testUtil;


	public initialPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws MalformedURLException 
	{
		
		initialization();
		initialPage = new initialPage();
	}
	
	@Test
	public void tester(){
		driver.get("http://127.0.0.1:80");
		String value = driver.findElement(By.tagName("h1")).getText();
		System.out.println(value);
		}

//	@Test
//	public void validateLoginLinkOnLogin(){
//		String linkText = initialPage.getLoginLinkText();
//		Assert.assertEquals(linkText, "LOGIN");
//	}
//	
//	@Test
//	public void validateCorrectPageForLogin(){
//		loginPage = initialPage.loginClick();
//		loadingWait(loginPage.loginButton);
//		String header = loginPage.validateLoginPageTitle();
//		Assert.assertEquals(header, "Sign In");
//
//	}

	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}