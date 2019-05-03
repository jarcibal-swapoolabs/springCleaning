package com.SpringSeven.qa.testcases;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.springSeven.qa.base.testBase;
import com.springSeven.qa.pages.homePage;
import com.springSeven.qa.pages.initialPage;
import com.springSeven.qa.pages.loginPage;
import com.springSeven.qa.pages.profilePage;
import com.springSeven.qa.util.testUtil;

public class profilePageTest extends testBase{
	 initialPage  initialPage;
	 loginPage loginPage; 
	 homePage homePage;
	 profilePage profilePage;
	 testUtil testUtil;
	 
	public profilePageTest(){
		super();
	}
		
	
	@BeforeMethod
	public void setUp() throws InterruptedException, MalformedURLException
	{
		initialization();		
		testUtil = new testUtil();
		initialPage = new initialPage();
		loginPage = initialPage.loginClick();		
		loadingWait(loginPage.loginButton);
		
		homePage = loginPage.login("clarence.layba@swapoolabs.com","mksoft_password");
		tryCatch(homePage.loadingElement,homePage.securityQuestionsPromptLater);
		
		homePage.clickOnAccountLink();
		loadingWait(homePage.profileLink);
		
		profilePage = homePage.clickOnProfileLink();
		loadingWait(profilePage.profilePageTitle);
	}

	@Test
	public void validateProfilePageTitle() {
		String header = profilePage.getProfilePageTitle();
		Assert.assertEquals(header, "Profile");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}


}
