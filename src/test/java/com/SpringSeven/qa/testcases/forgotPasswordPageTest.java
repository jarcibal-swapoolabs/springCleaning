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
	public void validateBlankOTP(){
		forgotPasswordPage.inputEmail("jhesed.tacadena@swapoolabs.com");
		forgotPasswordPage.click(forgotPasswordPage.btnOtpContinue);
		forgotPasswordPage.inputOTP("");
		String errorMessage = forgotPasswordPage.getError(forgotPasswordPage.fpwErrorMessageOtp);
		Assert.assertEquals(errorMessage, "Please provide a verification code");
	}

//	@Test
//	public void validateUsernameNotEMail(){
//		forgotPasswordPage.inputEmail("beth_logan");
//		String errorMessage = forgotPasswordPage.getError(forgotPasswordPage.fpwErrorMessageEmail);
//		Assert.assertEquals(errorMessage, "Please provide a valid email address format");
//	}
//
//	
//	@Test
//	public void validateWorkingEmail(){
//		//forgotPasswordPage.inputEmail("jericho.arcibal@swapoolabs.com");
//		forgotPasswordPage.inputEmail("jhesed.tacadena@swapoolabs.com");
//		forgotPasswordPage.click(forgotPasswordPage.btnOtpContinue);
//		loadingWait(forgotPasswordPage.btnOtpResend);
//		boolean displayed = forgotPasswordPage.displayed(forgotPasswordPage.btnOtpResend);
//		Assert.assertTrue(displayed);		
//	}
//
//	
//
//	@Test
//	public void validateInvalidOTPOne(){
//		forgotPasswordPage.inputEmail("jhesed.tacadena@swapoolabs.com");
//		forgotPasswordPage.click(forgotPasswordPage.btnOtpContinue);
//		forgotPasswordPage.inputOTP("abc!@#");
//		String errorMessage = forgotPasswordPage.getError(forgotPasswordPage.fpwErrorMessageOtp);
//		Assert.assertEquals(errorMessage, "Please provide a verification code");
//	}
//
//	@Test
//	public void validateInvalidOTPtWO(){
//		forgotPasswordPage.inputEmail("jhesed.tacadena@swapoolabs.com");
//		forgotPasswordPage.click(forgotPasswordPage.btnOtpContinue);
//		forgotPasswordPage.inputOTP("000000");
//		String errorMessage = forgotPasswordPage.getError(forgotPasswordPage.fpwErrorMessageOtp);
//		Assert.assertEquals(errorMessage, "Invalid verification code");
//	}

//start here
//	@Test
//	public void validateWorkingOTP(){
//		forgotPasswordPage.inputEmail("jhesed.tacadena@swapoolabs.com");
//		forgotPasswordPage.click(forgotPasswordPage.btnOtpContinue);
//		forgotPasswordPage.inputOTP("111111");
//		boolean displayed = forgotPasswordPage.displayed(forgotPasswordPage.fpwPasswordTextbox);
//		Assert.assertTrue(displayed);		
//	}
//
//	@Test
//	public void validatePasswordMismatch() {
//		forgotPasswordPage.inputEmail("jhesed.tacadena@swapoolabs.com");
//		forgotPasswordPage.click(forgotPasswordPage.btnOtpContinue);
//		forgotPasswordPage.inputOTP("111111");
//		forgotPasswordPage.inputPassword("tinapay","lugaw");
//		String errorMessage = forgotPasswordPage.getError(forgotPasswordPage.confirmPasswordErrorOne);
//		Assert.assertEquals(errorMessage, "Passwords do not match");
//	}
//
//	@Test
//	public void validatePasswordBlankOne() {
//		forgotPasswordPage.inputEmail("jhesed.tacadena@swapoolabs.com");
//		forgotPasswordPage.click(forgotPasswordPage.btnOtpContinue);
//		forgotPasswordPage.inputOTP("111111");
//		forgotPasswordPage.inputPassword("","P@suwarudo01");
//		String errorMessage = forgotPasswordPage.getError(forgotPasswordPage.passwordErrorOne);
//		Assert.assertEquals(errorMessage, "Please provide a password");
//	}
//
//	@Test
//	public void validatePasswordBlankTwo() {
//		forgotPasswordPage.inputEmail("jhesed.tacadena@swapoolabs.com");
//		forgotPasswordPage.click(forgotPasswordPage.btnOtpContinue);
//		forgotPasswordPage.inputOTP("111111");
//		forgotPasswordPage.inputPassword("","");
//		String errorMessage = forgotPasswordPage.getError(forgotPasswordPage.passwordErrorOne);
//		Assert.assertEquals(errorMessage, "Please provide a password");
//	}
//
//	@Test
//	public void validatePasswordBlankThree() {
//		forgotPasswordPage.inputEmail("jhesed.tacadena@swapoolabs.com");
//		forgotPasswordPage.click(forgotPasswordPage.btnOtpContinue);
//		forgotPasswordPage.inputOTP("111111");
//		forgotPasswordPage.inputPassword("","P@suwarudo01");
//		String errorMessage = forgotPasswordPage.getError(forgotPasswordPage.confirmPasswordErrorOne);
//		Assert.assertEquals(errorMessage, "Passwords do not match");
//	}
//
//	
//	@Test
//	public void validateConfirmPasswordBlankOne() {
//		forgotPasswordPage.inputEmail("jhesed.tacadena@swapoolabs.com");
//		forgotPasswordPage.click(forgotPasswordPage.btnOtpContinue);
//		forgotPasswordPage.inputOTP("111111");
//		forgotPasswordPage.inputPassword("P@suwarudo01","");
//		String errorMessage = forgotPasswordPage.getError(forgotPasswordPage.confirmPasswordErrorTwo);
//		Assert.assertEquals(errorMessage, "Please confirm your password");
//	}
//	
//	@Test
//	public void validateConfirmPasswordBlankTwo() {
//		forgotPasswordPage.inputEmail("jhesed.tacadena@swapoolabs.com");
//		forgotPasswordPage.click(forgotPasswordPage.btnOtpContinue);
//		forgotPasswordPage.inputOTP("111111");
//		forgotPasswordPage.inputPassword("","");
//		String errorMessage = forgotPasswordPage.getError(forgotPasswordPage.confirmPasswordErrorTwo);
//		Assert.assertEquals(errorMessage, "Please confirm your password");
//	}
//
//
//	@Test
//	public void validatePWRankingOne(){
//		forgotPasswordPage.inputEmail("jericho.arcibal@swapoolabs.com");
//		forgotPasswordPage.inputOTP("111111");
//		forgotPasswordPage.inputPassword("p","");
//		String pwStrength = forgotPasswordPage.getError(forgotPasswordPage.fpwPasswordRanking);
//		Assert.assertEquals(pwStrength, "WORST");
//	}
//
//	@Test
//	public void validatePWRankingTwo(){
//		forgotPasswordPage.inputEmail("jericho.arcibal@swapoolabs.com");
//		forgotPasswordPage.inputOTP("111111");
//		forgotPasswordPage.inputPassword("p","");
//		String pwStrength = forgotPasswordPage.getError(forgotPasswordPage.fpwPasswordRanking);
//		Assert.assertEquals(pwStrength, "BAD");
//	}
//	
//	@Test
//	public void validatePWRankingThree(){
//		forgotPasswordPage.inputEmail("jericho.arcibal@swapoolabs.com");
//		forgotPasswordPage.inputOTP("111111");
//		forgotPasswordPage.inputPassword("makatisoft","");
//		String pwStrength = forgotPasswordPage.getError(forgotPasswordPage.fpwPasswordRanking);
//		Assert.assertEquals(pwStrength, "WEAK");
//	}
//
//	@Test
//	public void validatePWRankingFour(){
//		forgotPasswordPage.inputEmail("jericho.arcibal@swapoolabs.com");
//		forgotPasswordPage.inputOTP("111111");
//		forgotPasswordPage.inputPassword("makatisoft01","");
//		String pwStrength = forgotPasswordPage.getError(forgotPasswordPage.fpwPasswordRanking);
//		Assert.assertEquals(pwStrength, "GOOD");
//	}
//	
//	@Test
//	public void validatePWRankingFive(){
//		forgotPasswordPage.inputEmail("jericho.arcibal@swapoolabs.com");
//		forgotPasswordPage.inputOTP("111111");
//		forgotPasswordPage.inputPassword("makatisoft01","");
//		String pwStrength = forgotPasswordPage.getError(forgotPasswordPage.fpwPasswordRanking);
//		Assert.assertEquals(pwStrength, "STRONG");
//	}

	
//	@Test
//	public void validateWorkingChangePassword(){
//		forgotPasswordPage.inputEmail("jericho.arcibal@swapoolabs.com");
//		forgotPasswordPage.inputOTP("111111");
//		forgotPasswordPage.inputPassword("mksoft_password","mksoft_password");
//	}

	
	
	@AfterMethod
	public void tearDown(){
		try
		{
			driver.quit();
			
		}
		catch(Exception e)
		{
			driver.quit();
		}
	}
}
