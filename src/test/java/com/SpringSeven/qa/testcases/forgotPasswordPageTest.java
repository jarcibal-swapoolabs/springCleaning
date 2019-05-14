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
		String errorMessage = forgotPasswordPage.getError(forgotPasswordPage.fpwErrorMessageEmail);
		Assert.assertEquals(errorMessage, "This email cannot be recognized");
	}

	@Test
	public void validateNoEmail(){
		forgotPasswordPage.inputEmail("");
		String errorMessage = forgotPasswordPage.getError(forgotPasswordPage.fpwErrorMessageEmail);
		Assert.assertEquals(errorMessage, "Please provide an email address");
	}

	@Test
	public void validateIncorrectFormat(){
		forgotPasswordPage.inputEmail("jericho-yahoo.com");
		String errorMessage = forgotPasswordPage.getError(forgotPasswordPage.fpwErrorMessageEmail);
		Assert.assertEquals(errorMessage, "Please provide a valid email address format");
	}

	@Test
	public void validateUsernameNotEMail(){
		forgotPasswordPage.inputEmail("beth_logan");
		String errorMessage = forgotPasswordPage.getError(forgotPasswordPage.fpwErrorMessageEmail);
		Assert.assertEquals(errorMessage, "Please provide a valid email address format");
	}

	
	@Test
	public void validateWorkingEmail(){
		forgotPasswordPage.inputEmail("jericho.arcibal@swapoolabs.com");
		loadingWait(forgotPasswordPage.btnOtpResend);
		boolean displayed = forgotPasswordPage.displayed(forgotPasswordPage.btnOtpResend);
		Assert.assertTrue(displayed);		
	}

	
	@Test
	public void validateBlankOTP(){
		forgotPasswordPage.inputEmail("jericho.arcibal@swapoolabs.com");
		forgotPasswordPage.inputOTP("");
		String errorMessage = forgotPasswordPage.getError(forgotPasswordPage.fpwErrorMessageOtp);
		Assert.assertEquals(errorMessage, "Please provide a verification code");
	}

	@Test
	public void validateInvalidOTPOne(){
		forgotPasswordPage.inputEmail("jericho.arcibal@swapoolabs.com");
		forgotPasswordPage.inputOTP("abc!@#");
		String errorMessage = forgotPasswordPage.getError(forgotPasswordPage.fpwErrorMessageOtp);
		Assert.assertEquals(errorMessage, "Please provide a verification code");
	}

	@Test
	public void validateInvalidOTPtWO(){
		forgotPasswordPage.inputEmail("jericho.arcibal@swapoolabs.com");
		forgotPasswordPage.inputOTP("000000");
		String errorMessage = forgotPasswordPage.getError(forgotPasswordPage.fpwErrorMessageOtp);
		Assert.assertEquals(errorMessage, "Invalid verification code");
	}

//start here
//	@Test
//	public void validateWorkingOTP(){
//		forgotPasswordPage.inputEmail("jericho.arcibal@swapoolabs.com");
//		forgotPasswordPage.inputOTP("111111");
//		boolean displayed = forgotPasswordPage.displayed(forgotPasswordPage.fpwPasswordTextbox);
//		Assert.assertTrue(displayed);		
//	}
//
//	@Test
//	public void validatePasswordMismatch() {
//		forgotPasswordPage.inputEmail("jericho.arcibal@swapoolabs.com");
//		forgotPasswordPage.inputOTP("111111");
//		forgotPasswordPage.inputPassword("tinapay","lugaw");
//		String errorMessage = forgotPasswordPage.getError(forgotPasswordPage.confirmPasswordErrorOne);
//		Assert.assertEquals(errorMessage, "Passwords do not match");
//	}
//
//	@Test
//	public void validatePasswordBlankOne() {
//		forgotPasswordPage.inputEmail("jericho.arcibal@swapoolabs.com");
//		forgotPasswordPage.inputOTP("111111");
//		forgotPasswordPage.inputPassword("","P@suwarudo01");
//		String errorMessage = forgotPasswordPage.getError(forgotPasswordPage.passwordErrorOne);
//		Assert.assertEquals(errorMessage, "Please provide a password");
//	}
//
//	@Test
//	public void validatePasswordBlankTwo() {
//		forgotPasswordPage.inputEmail("jericho.arcibal@swapoolabs.com");
//		forgotPasswordPage.inputOTP("111111");
//		forgotPasswordPage.inputPassword("","");
//		String errorMessage = forgotPasswordPage.getError(forgotPasswordPage.passwordErrorOne);
//		Assert.assertEquals(errorMessage, "Please provide a password");
//	}
//
//	@Test
//	public void validatePasswordBlankThree() {
//		forgotPasswordPage.inputEmail("jericho.arcibal@swapoolabs.com");
//		forgotPasswordPage.inputOTP("111111");
//		forgotPasswordPage.inputPassword("","P@suwarudo01");
//		String errorMessage = forgotPasswordPage.getError(forgotPasswordPage.confirmPasswordErrorOne);
//		Assert.assertEquals(errorMessage, "Passwords do not match");
//	}
//
//	
//	@Test
//	public void validateConfirmPasswordBlankOne() {
//		forgotPasswordPage.inputEmail("jericho.arcibal@swapoolabs.com");
//		forgotPasswordPage.inputOTP("111111");
//		forgotPasswordPage.inputPassword("P@suwarudo01","");
//		String errorMessage = forgotPasswordPage.getError(forgotPasswordPage.confirmPasswordErrorTwo);
//		Assert.assertEquals(errorMessage, "Please confirm your password");
//	}
//	
//	@Test
//	public void validateConfirmPasswordBlankTwo() {
//		forgotPasswordPage.inputEmail("jericho.arcibal@swapoolabs.com");
//		forgotPasswordPage.inputOTP("111111");
//		forgotPasswordPage.inputPassword("","");
//		String errorMessage = forgotPasswordPage.getError(forgotPasswordPage.confirmPasswordErrorTwo);
//		Assert.assertEquals(errorMessage, "Please confirm your password");
//	}
//
//	may issue
//	@Test
//	public void validatePWRankingOne(){
//		registrationPage.proper("smileys010@gmail.com", "pass", "pass");
//		pwStrength = registrationPage.getError(registrationPage.passwordStrength);
//		Assert.assertEquals(pwStrength, "WORST");
//	}
//
//	@Test
//	public void validatePWRankingTwo(){
//		registrationPage.proper("smileys010@gmail.com", "pass01", "pass01");
//		pwStrength = registrationPage.getError(registrationPage.passwordStrength);
//		Assert.assertEquals(pwStrength, "BAD");
//	}
//	
//	@Test
//	public void validatePWRankingThree(){
//		registrationPage.proper("smileys010@gmail.com", "makatisoft", "makatisoft");
//		pwStrength = registrationPage.getError(registrationPage.passwordStrength);
//		Assert.assertEquals(pwStrength, "WEAK");
//	}
//
//	@Test
//	public void validatePWRankingFour(){
//		registrationPage.proper("smileys010@gmail.com", "makatisoft01", "makatisoft01");
//		pwStrength = registrationPage.getError(registrationPage.passwordStrength);
//		Assert.assertEquals(pwStrength, "GOOD");
//	}
//	
//	@Test
//	public void validatePWRankingFive(){
//		registrationPage.proper("smileys010@gmail.com", "Makatisoft01", "Makatisoft01");
//		pwStrength = registrationPage.getError(registrationPage.passwordStrength);
//		Assert.assertEquals(pwStrength, "STRONG");
//	}
//
//	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
