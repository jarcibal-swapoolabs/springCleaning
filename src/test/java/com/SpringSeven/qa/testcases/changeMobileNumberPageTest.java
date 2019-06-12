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
	 String error;
	 
	public changeMobileNumberPageTest(){
		super();
	}
		
	
	@BeforeMethod
	public void setUp() throws  MalformedURLException
	{
		initialization();		
		testUtil = new testUtil();
		initialPage = new initialPage();
		loginPage = initialPage.loginClick();		
		loadingWait(loginPage.loginButton);

		homePage = loginPage.login("jhesed.tacadena@swapoolabs.com","superstrongpassword");
		tryCatch(homePage.loadingElement,homePage.securityQuestionsPromptLater);
//		homePage = loginPage.login("clarence.layba@swapoolabs.com","mksoft_password");
//		loadingWait(homePage.loadingElement);
		
		homePage.clickOnAccountLink();
		loadingWait(homePage.settingsLink);

		settingsPage = homePage.clickOnSettingsLink();
		loadingWait(settingsPage.settingsPageTitle);
		
		changeMobileNumberPage = settingsPage.clickOnChangeMobileNumberPageLink();
		loadingWait(changeMobileNumberPage.changeMobileNumberPageTitle);
	}
//
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

	
	@Test
	public void validateChangeMobileNumberIncorrectPassword(){
		changeMobileNumberPage.updatePasswordTextbox("wrong");
		loadingWait(changeMobileNumberPage.passwordErrorMessage);
		error = settingsPage.getErrorReportAccountPassword();
		Assert.assertEquals(error, "Password is invalid");
	}

	@Test
	public void validateChangeMobileNumberNoPassword(){
		changeMobileNumberPage.updatePasswordTextbox("");
		error = settingsPage.getErrorReportAccountPassword();
		Assert.assertEquals(error, "Please provide a password");
	}

	@Test
	public void validateChangeMobileNumberBlankOTP(){
//		changeEmailAddressPage.updatePasswordTextbox("mksoft_password");
		changeMobileNumberPage.updatePasswordTextbox("superstrongpassword");
		changeMobileNumberPage.updateotpTextbox("");
		error = settingsPage.getErrorReportAccountPassword();
		Assert.assertEquals(error, "Please provide a verification code");
	}


	@Test
	public void validateChangeMobileNumberInvalidOTPOne(){
//		changeEmailAddressPage.updatePasswordTextbox("mksoft_password");
		changeMobileNumberPage.updatePasswordTextbox("superstrongpassword");
		changeMobileNumberPage.updateotpTextbox("abc!@#");
		error = settingsPage.getErrorReportAccountPassword();
		Assert.assertEquals(error, "Please provide a verification code");
	}

	@Test
	public void validateChangeMobileNumberInvalidOTPtWO(){
//		changeMobileNumberPage.updatePasswordTextbox("mksoft_password");
		changeMobileNumberPage.updatePasswordTextbox("superstrongpassword");
		changeMobileNumberPage.updateotpTextbox("123456");
		error = settingsPage.getErrorReportAccountPassword();
		Assert.assertEquals(error, "Invalid verification code");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}



}
