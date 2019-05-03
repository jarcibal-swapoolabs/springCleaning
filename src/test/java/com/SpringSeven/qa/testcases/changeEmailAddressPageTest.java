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
import com.springSeven.qa.pages.changeEmailAddressPage;

public class changeEmailAddressPageTest extends testBase
{
	 initialPage  initialPage;
	 loginPage loginPage; 
	 homePage homePage;
	 settingsPage settingsPage;
	 changeEmailAddressPage changeEmailAddressPage;
	 testUtil testUtil;
	 
	public changeEmailAddressPageTest(){
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
		
		changeEmailAddressPage = settingsPage.clickOnchangeEmailAddressPageLink();
		loadingWait(changeEmailAddressPage.changeEmailAddressPageTitle);
	}

//	@Test
//	public void validateChangeAvatarNewImage() {
//		changeEmailAddressPage.updatePasswordTextbox("Makatisoft01!");
//		changeEmailAddressPage.clickContinue();
//		changeEmailAddressPage.updateotpTextbox("111111");
//		changeEmailAddressPage.clickContinue();
//		changeEmailAddressPage.updateNewMobileTextbox("9260445992");
//		changeEmailAddressPage.clickContinue();
//		changeEmailAddressPage.updateotpNewTextbox("111111");
//		changeEmailAddressPage.clickSubmit();
//	}

	@Test
	public void validateChangeEmailPageTitle() {
		String header = changeEmailAddressPage.getChangeEmailPageTitle();
		Assert.assertEquals(header, "Change Email Address");
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
