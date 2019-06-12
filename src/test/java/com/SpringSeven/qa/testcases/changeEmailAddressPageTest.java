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
	 String errorMessage;
	 
	public changeEmailAddressPageTest(){
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
		
		homePage = loginPage.login("jhesed.tacadena@swapoolabs.com","superstrongpassword");
		tryCatch(homePage.loadingElement,homePage.securityQuestionsPromptLater);
//		homePage = loginPage.login("clarence.layba@swapoolabs.com","mksoft_password");
//		loadingWait(homePage.loadingElement);
		
		homePage.clickOnAccountLink();
		loadingWait(homePage.settingsLink);

		settingsPage = homePage.clickOnSettingsLink();
		loadingWait(settingsPage.settingsPageTitle);
		
		changeEmailAddressPage = settingsPage.clickOnchangeEmailAddressPageLink();
		loadingWait(changeEmailAddressPage.changeEmailAddressPageTitle);
	}


	@Test
	public void validateChangeEmailPageTitle() {
		String header = changeEmailAddressPage.getChangeEmailPageTitle();
		Assert.assertEquals(header, "Change Email Address");
	}

	@Test
	public void validateChangeEmailBlankPassword(){
		changeEmailAddressPage.updatePasswordTextbox("");
		errorMessage = changeEmailAddressPage.getError(changeEmailAddressPage.passwordErrorMessage);
		Assert.assertEquals(errorMessage, "Please provide a password");
	}


	@Test
	public void validateChangeEmailInvalidPasswordOne(){
		changeEmailAddressPage.updatePasswordTextbox("invalidpassword");
		errorMessage = changeEmailAddressPage.getError(changeEmailAddressPage.passwordErrorMessage);
		Assert.assertEquals(errorMessage, "Password is invalid");
	}

	@Test
	public void validateChangeEmailBlankOTP(){
//		changeEmailAddressPage.updatePasswordTextbox("mksoft_password");
		changeEmailAddressPage.updatePasswordTextbox("superstrongpassword");
		changeEmailAddressPage.updateotpTextbox("");
		errorMessage = changeEmailAddressPage.getError(changeEmailAddressPage.otpErrorMessage);
		Assert.assertEquals(errorMessage, "Please provide a verification code");
	}


	@Test
	public void validateChangeEmailInvalidOTPOne(){
//		changeEmailAddressPage.updatePasswordTextbox("mksoft_password");
		changeEmailAddressPage.updatePasswordTextbox("superstrongpassword");
		changeEmailAddressPage.updateotpTextbox("abc!@#");
		errorMessage = changeEmailAddressPage.getError(changeEmailAddressPage.otpErrorMessage);
		Assert.assertEquals(errorMessage, "Please provide a verification code");
	}

	@Test
	public void validateChangeEmailInvalidOTPtWO(){
//		changeEmailAddressPage.updatePasswordTextbox("mksoft_password");
		changeEmailAddressPage.updatePasswordTextbox("superstrongpassword");
		changeEmailAddressPage.updateotpTextbox("000002");
		errorMessage = changeEmailAddressPage.getError(changeEmailAddressPage.otpErrorMessage);
		Assert.assertEquals(errorMessage, "Invalid verification code");
	}


	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
