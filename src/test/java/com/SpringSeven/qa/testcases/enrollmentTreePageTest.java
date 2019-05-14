package com.SpringSeven.qa.testcases;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.springSeven.qa.pages.initialPage;
import com.springSeven.qa.pages.loginPage;
import com.springSeven.qa.util.testUtil;
import com.springSeven.qa.pages.homePage;
import com.springSeven.qa.base.testBase;
import com.springSeven.qa.pages.enrollmentTreePage;


public class enrollmentTreePageTest extends testBase{
	 initialPage  initialPage;
	 loginPage loginPage; 
	 homePage homePage;
	 enrollmentTreePage enrollmentTreePage;
	testUtil testUtil;

	 
	public enrollmentTreePageTest(){
		super();
	}
		
	
	@BeforeMethod
	public void setUp() throws MalformedURLException
	{
		initialization();		
		testUtil = new testUtil();
		initialPage = new initialPage();
		loginPage = initialPage.loginClick();		
		loadingWait(loginPage.loginButton);
		homePage = loginPage.login("clarence.layba@swapoolabs.com","mksoft_password");
		tryCatch(homePage.loadingElement,homePage.securityQuestionsPromptLater);
		enrollmentTreePage = homePage.clickOnEnrollmentLink();
		loadingWait(enrollmentTreePage.enrollmentTreePageTitle);
	}

	@Test
	public void validateEnrollmentTreePageTitle(){
		String header = enrollmentTreePage.getenrollmentTreePageTitle();
		Assert.assertEquals(header, "ENROLLMENT TREE");
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}


}
