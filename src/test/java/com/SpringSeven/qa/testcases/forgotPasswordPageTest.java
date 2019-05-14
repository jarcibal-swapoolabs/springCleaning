package com.SpringSeven.qa.testcases;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.springSeven.qa.base.testBase;
import com.springSeven.qa.pages.forgotPasswordPage;
import com.springSeven.qa.pages.initialPage;
import com.springSeven.qa.pages.loginPage;

public class forgotPasswordPageTest extends testBase{
	initialPage initialPage;
	loginPage loginPage;
	forgotPasswordPage forgotPasswordPage;

	public forgotPasswordPageTest(){
		super();
	}


	@BeforeMethod
	public void setUp() throws MalformedURLException
	{
		initialization();		
		initialPage = new initialPage();
		loginPage = initialPage.loginClick();		
		loadingWait(loginPage.loginButton);
		forgotPasswordPage = loginPage.fpwClick();
		loadingWait(forgotPasswordPage.btnContinue);
}
	
	
	@Test
	public void validateFpwPageTitle(){
		String header = forgotPasswordPage.getForgotPasswordPageTitle();
		Assert.assertEquals(header, "Forgot Password");
	}
	
	@Test
	public void validateNonExistingEmail() {
		forgotPasswordPage.inputEmail("smileys009@yahoo.com");
		loadingWait(forgotPasswordPage.fpwErrorMessageEmail);
		String errorMessage = forgotPasswordPage.getfpwErrorWrongEmail();
		Assert.assertEquals(errorMessage, "This email cannot be recognized");
	}

	@Test
	public void validateNoEmail(){
		forgotPasswordPage.inputEmail("");
		String errorMessage = forgotPasswordPage.getfpwErrorWrongEmail();
		Assert.assertEquals(errorMessage, "Please provide an email address");
	}

	@Test
	public void validateIncorrectFormat(){
		forgotPasswordPage.inputEmail("jericho-yahoo.com");
		String errorMessage = forgotPasswordPage.getfpwErrorWrongEmail();
		Assert.assertEquals(errorMessage, "Please provide a valid email address format");
	}

	@Test
	public void validateUsernameNotEMail(){
		forgotPasswordPage.inputEmail("beth_logan");
		String errorMessage = forgotPasswordPage.getfpwErrorWrongEmail();
		Assert.assertEquals(errorMessage, "Please provide an email address");
	}

	
	@Test
	public void validateWorkingEmail(){
		forgotPasswordPage.inputEmail("jericho.arcibal@swapoolabs.com");
		loadingWait(forgotPasswordPage.btnOtpResend);
		boolean displayed = forgotPasswordPage.resendOTPDisplayed();
		Assert.assertTrue(displayed);		
	}

	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
