package com.SpringSeven.qa.testcases;


import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.springSeven.qa.base.testBase;
import com.springSeven.qa.pages.registrationPage;

public class registrationPageTest extends testBase {

	public registrationPageTest() {
		super();
	}

	registrationPage registrationPage;
	String errorMessage;
	WebElement emailTextbox;

	@BeforeMethod
	public void setUp() throws MalformedURLException {
		initialization();
		registrationPage = new registrationPage();
		driver.get("https://d1uu7efqb688sd.cloudfront.net/signup?id=KVKcEta");
		processing();
}

	@Test
	public void validateRegistrationPageTitle(){
		String header = registrationPage.getRegistrationPageTitle();
		Assert.assertEquals(header, "Register Now!");
	}

	@Test
	public void validateInvalidEmailFormat() 
	{
		registrationPage.inputEmail("jarcibal");
		errorMessage = registrationPage.getEmailError();
		Assert.assertEquals(errorMessage, "Please provide a valid email address format");
	}

	@Test
	public void validateValidEmail() 
	{
		registrationPage.inputEmail("smileys010@gmail.com");
		loadingWait(registrationPage.emailIsUnique);
		errorMessage = registrationPage.getEmailIsUnique();
		Assert.assertEquals(errorMessage, "done Email is unique");
	}

	@Test
	public void validateExistingEmail()
	{
		registrationPage.inputEmail("jhesed.tacadena@swapoolabs.com");
		loadingWait(registrationPage.emailExist);
		errorMessage = registrationPage.getEmailExist();
		Assert.assertEquals(errorMessage, "This email already exists");
	}	
	
	@Test
	public void validatePasswordMismatch() {
		registrationPage.inputEmail("smileys010@gmail.com");
		loadingWait(registrationPage.emailIsUnique);
		registrationPage.updatePasswordTextbox("word");
		registrationPage.updateConfirmTextbox("pass");
		registrationPage.clickRegister();
		errorMessage = registrationPage.getConfirmPasswordError();
		Assert.assertEquals(errorMessage, "Passwords do not match");
	}

	@Test
	public void validateNotVerifiedEmail() {
		registrationPage.inputEmail("smileys010@gmail.com");
		loadingWait(registrationPage.emailIsUnique);
		registrationPage.updatePasswordTextbox("Pasuwarudo01");
		registrationPage.updateConfirmTextbox("Pasuwarudo01");
		registrationPage.clickRegister();
		errorMessage = registrationPage.getEmailNotVerifiedError();
		Assert.assertEquals(errorMessage, "The email you are trying to register has not been verified");
	}

	
//email otp
//	@Test
//	public void validateNRegistrationWorks() {
//		registrationPage.inputEmail("smileys010@gmail.com");
//		loadingWait(registrationPage.emailIsUnique);
//		registrationPage.clicksendVerification();
//		loadingWait(registrationPage.emailOTPTextbox);
////		insert otp code here
//		registrationPage.updateVerificationTextbox("111111");
//		registrationPage.clickVerifyEmail();
//		errorMessage = registrationPage.getEmailIsVerified();
//		Assert.assertEquals(errorMessage, "done Your email address has been verified");
//	
//		
//		
//		
////		registrationPage.updatePasswordTextbox("Pasuwarudo01");
////		registrationPage.updateConfirmTextbox("Pasuwarudo01");
////		registrationPage.clickRegister();
////		insert assert here
//
//		registrationPage.clicksendVerification();
//		waitForPageLoaded();
//		registrationPage.updatePasswordTextbox("Pasuwarudo01");
//		registrationPage.updateConfirmTextbox("Pasuwarudo01");
//		registrationPage.clickRegister();
//	}

	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
