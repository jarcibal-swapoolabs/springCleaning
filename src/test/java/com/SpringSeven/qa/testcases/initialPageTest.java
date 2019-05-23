package com.SpringSeven.qa.testcases;

import java.net.MalformedURLException;

//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
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
	public void validateLoginLinkOnLogin(){
//		String linkText = initialPage.getLoginLinkText();
//		Assert.assertEquals(linkText, "LOGIN");
		driver.get("http://localhost:80");
		String header = driver.getTitle();
		System.out.println(header + "title nito ay");
	}
	
	
	
	@Test
	public void validateLoginLinkOnLogin2(){
		driver.get("https://d1uu7efqb688sd.cloudfront.net");
		String header = driver.getTitle();
		System.out.println(header + "title nito ay");

	}

	
	@Test
	public void validateLoginLinkOnLogin3(){
//		String linkText = initialPage.getLoginLinkText();
//		Assert.assertEquals(linkText, "LOGIN");
		driver.get("https://192.168.0.1");
		String header = driver.getTitle();
		System.out.println(header + "title nito ay");
	}
	
	
	
	@Test
	public void validateLoginLinkOnLogin4(){
		driver.get("http://192.168.0.1");
		String header = driver.getTitle();
		System.out.println(header + "title nito ay");
	}

	
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