package com.SpringSeven.qa.testcases;


import java.net.MalformedURLException;

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
	String pwStrength;

	@BeforeMethod
	public void setUp() throws MalformedURLException {
		initialization();
		registrationPage = new registrationPage();
//		driver.get("https://d1uu7efqb688sd.cloudfront.net/signup?id=4jxLxJU");
		driver.get("http://192.168.0.1/signup?id=4jxLxJU");
		processing();
}

	@Test
	public void validateRegistrationPageTitle(){
		String header = registrationPage.getRegistrationPageTitle();
		Assert.assertEquals(header, "Register Now!");
	}

	@Test
	public void validateNoEmail() 
	{
		registrationPage.click(registrationPage.emailTextbox);
		registrationPage.click(registrationPage.registerButton);
		errorMessage = registrationPage.getError(registrationPage.emailErrorTwo);
		Assert.assertEquals(errorMessage, "Please provide an email address");
	}

	
	@Test
	public void validateInvalidEmailFormat() 
	{
		registrationPage.inputEmail("jarcibal");
		errorMessage = registrationPage.getError(registrationPage.emailErrorOne);
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
		registrationPage.inputEmail("clarence.layba@swapoolabs.com");
		loadingWait(registrationPage.emailExist);
		errorMessage = registrationPage.getError(registrationPage.emailExist);
		Assert.assertEquals(errorMessage, "This email already exists");
	}	
	
	@Test
	public void validatePasswordMismatch() {
		registrationPage.proper("smileys010@gmail.com", "Ppass", "Pword");
		errorMessage = registrationPage.getError(registrationPage.confirmPasswordErrorOne);
		Assert.assertEquals(errorMessage, "Passwords do not match");
	}

	@Test
	public void validatePasswordBlankOne() {
		registrationPage.proper("smileys010@gmail.com", "", "P@suwarudo01");
		errorMessage = registrationPage.getError(registrationPage.passwordError);
		Assert.assertEquals(errorMessage, "Please provide a password");
	}

	@Test
	public void validatePasswordBlankTwo() {
		registrationPage.proper("smileys010@gmail.com", "", "");
		errorMessage = registrationPage.getError(registrationPage.passwordError);
		Assert.assertEquals(errorMessage, "Please provide a password");
	}

	@Test
	public void validatePasswordBlankThree() {
		registrationPage.proper("smileys010@gmail.com", "", "P@suwarudo01");
		errorMessage = registrationPage.getError(registrationPage.confirmPasswordErrorOne);
		Assert.assertEquals(errorMessage, "Passwords do not match");
	}

	
	@Test
	public void validateConfirmPasswordBlankOne() {
		registrationPage.proper("smileys010@gmail.com", "P@suwarudo01", "");
		errorMessage = registrationPage.getError(registrationPage.confirmPasswordErrorTwo);
		Assert.assertEquals(errorMessage, "Please confirm your password");
	}
	
	@Test
	public void validateConfirmPasswordBlankTwo() {
		registrationPage.proper("smileys010@gmail.com", "", "");
		errorMessage = registrationPage.getError(registrationPage.confirmPasswordErrorTwo);
		Assert.assertEquals(errorMessage, "Please confirm your password");
	}

	
	@Test
	public void validatePWRankingOne(){
		registrationPage.proper("smileys010@gmail.com", "pass", "pass");
		pwStrength = registrationPage.getError(registrationPage.passwordStrength);
		Assert.assertEquals(pwStrength, "WORST");
	}

	@Test
	public void validatePWRankingTwo(){
		registrationPage.proper("smileys010@gmail.com", "pass01", "pass01");
		pwStrength = registrationPage.getError(registrationPage.passwordStrength);
		Assert.assertEquals(pwStrength, "BAD");
	}
	
	@Test
	public void validatePWRankingThree(){
		registrationPage.proper("smileys010@gmail.com", "makatisoft", "makatisoft");
		pwStrength = registrationPage.getError(registrationPage.passwordStrength);
		Assert.assertEquals(pwStrength, "WEAK");
	}

	@Test
	public void validatePWRankingFour(){
		registrationPage.proper("smileys010@gmail.com", "makatisoft01", "makatisoft01");
		pwStrength = registrationPage.getError(registrationPage.passwordStrength);
		Assert.assertEquals(pwStrength, "GOOD");
	}
	
	@Test
	public void validatePWRankingFive(){
		registrationPage.proper("smileys010@gmail.com", "Makatisoft01", "Makatisoft01");
		pwStrength = registrationPage.getError(registrationPage.passwordStrength);
		Assert.assertEquals(pwStrength, "STRONG");
	}

	


	@Test
	public void validateNotVerifiedEmail() {
		registrationPage.proper("smileys010@gmail.com", "P@suwarudo01", "P@suwarudo01");
		errorMessage = registrationPage.getError(registrationPage.emailNotVerifiedError);
		Assert.assertEquals(errorMessage, "The email you are trying to register has not been verified");
	}

	@Test
	public void validateVericationErrorOne() {
		registrationPage.proper("smileys010@gmail.com", "P@suwarudo01", "P@suwarudo01");
		registrationPage.inputVerificationOTP("");
		errorMessage = registrationPage.getError(registrationPage.verificationErrorOne);
		Assert.assertEquals(errorMessage, "Please provide a verification code");
	}

	@Test
	public void validateVericationErrorTwo() {
		registrationPage.proper("smileys010@gmail.com", "P@suwarudo01", "P@suwarudo01");
		registrationPage.inputVerificationOTP("1");
		errorMessage = registrationPage.getError(registrationPage.verificationErrorTwo);
		Assert.assertEquals(errorMessage, "Invalid verification code");
	}
	
	@Test
	public void validateVericationErrorThree() {
		registrationPage.proper("smileys010@gmail.com", "P@suwarudo01", "P@suwarudo01");
		registrationPage.inputVerificationOTP("12345");
		errorMessage = registrationPage.getError(registrationPage.verificationErrorTwo);
		Assert.assertEquals(errorMessage, "Invalid verification code");
	}

	@Test
	public void validateVericationErrorFour() {
		registrationPage.proper("smileys010@gmail.com", "P@suwarudo01", "P@suwarudo01");
		registrationPage.inputVerificationOTP("123456");
		loadingWait(registrationPage.verificationErrorTwo);
		errorMessage = registrationPage.getError(registrationPage.verificationErrorTwo);
		Assert.assertEquals(errorMessage, "Invalid verification code");
	}
	
	@Test
	public void validateVericationErrorFive() {
		registrationPage.proper("smileys010@gmail.com", "P@suwarudo01", "P@suwarudo01");
		registrationPage.inputVerificationOTP("abcdef");
		errorMessage = registrationPage.getError(registrationPage.verificationErrorOne);
		Assert.assertEquals(errorMessage, "Please provide a verification code");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
