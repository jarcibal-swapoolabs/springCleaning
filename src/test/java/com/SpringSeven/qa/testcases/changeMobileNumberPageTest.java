package com.SpringSeven.qa.testcases;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.springSeven.qa.pages.homePage;
import com.springSeven.qa.pages.initialPage;
import com.springSeven.qa.pages.loginPage;
import com.springSeven.qa.pages.settingsPage;
import com.springSeven.qa.util.testUtil;
import com.springSeven.qa.base.testBase;
import com.springSeven.qa.pages.changeMobileNumberPage;

public class changeMobileNumberPageTest extends testBase
{
	 initialPage  initialPage;
	 loginPage loginPage; 
	 homePage homePage;
	 settingsPage settingsPage;
	 changeMobileNumberPage changeMobileNumberPage;
	 testUtil testUtil;
	 
	public changeMobileNumberPageTest(){
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
		loadingWait(homePage.settingsLink);

		settingsPage = homePage.clickOnSettingsLink();
		loadingWait(settingsPage.settingsPageTitle);
		
		changeMobileNumberPage = settingsPage.clickOnChangeMobileNumberPageLink();
		loadingWait(changeMobileNumberPage.changeMobileNumberPageTitle);
	}

//	@Test
//	public void validateChangeNumber() {
//		changeMobileNumberPage.updatePasswordTextbox("Makatisoft01!");
//		changeMobileNumberPage.clickContinue();
//		changeMobileNumberPage.updateotpTextbox("111111");
//		changeMobileNumberPage.clickContinue();
//		changeMobileNumberPage.updateNewMobileTextbox("9260445992");
//		changeMobileNumberPage.clickContinue();
//		changeMobileNumberPage.updateotpNewTextbox("111111");
//		changeMobileNumberPage.clickSubmit();
//	}


	@Test
	public void validateChangeMobilePageTitle() {
		String header = changeMobileNumberPage.getChangeMobilePageTitle();
		Assert.assertEquals(header, "Change Mobile Number");
	}

	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}



}
