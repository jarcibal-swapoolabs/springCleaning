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
import com.springSeven.qa.pages.settingsPage;
import com.springSeven.qa.util.testUtil;

public class settingsPageTest extends testBase{
	 initialPage  initialPage;
	 loginPage loginPage; 
	 homePage homePage;
	 settingsPage settingsPage;
	 testUtil testUtil;
	 
	public settingsPageTest(){
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
	}
	
	@Test
	public void validateSettingsPageTitle(){
		String header = settingsPage.getSettingsPageTitle();
		Assert.assertEquals(header, "SETTINGS");
	}

	@Test
	public void validateReportAccountBlankPassword(){
		settingsPage.inputPassword("");
		String error = settingsPage.getErrorReportAccountPassword();
		Assert.assertEquals(error, "This field is required");

	}

	@Test
	public void validateReportAccountIncorrectPassword(){
		settingsPage.inputPassword("wrong");
		loadingWait(settingsPage.reportPasswordError);
		String error = settingsPage.getErrorReportAccountPassword();
		Assert.assertEquals(error, "Password is invalid");
	}

//	@Test
//	public void validateReportAccountCorrectPassword() {
//		settingsPage.inputPassword("mksoft_password");
//		loadingWait(settingsPage.confirmIcon);
//		settingsPage.clickReportConfirm();
//		loadingWait(settingsPage.reportAccountOk);
//		settingsPage.clickReportOk();
//		String header = settingsPage.getSettingsPageTitle();
//		Assert.assertEquals(header, "SETTINGS");
//	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}


}
