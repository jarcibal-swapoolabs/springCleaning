package com.SpringSeven.qa.testcases;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.springSeven.qa.base.testBase;
import com.springSeven.qa.pages.completeRegistrationPage;
import com.springSeven.qa.pages.initialPage;
import com.springSeven.qa.pages.loginPage;
import com.springSeven.qa.util.testUtil;

public class completeRegistrationTest  extends testBase {
	initialPage initialPage;
	loginPage loginPage;
	testUtil testUtil;
	completeRegistrationPage completeRegistrationPage;
	String errorMessage;
	String textboxcolor;
	
	public completeRegistrationTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws MalformedURLException {
		initialization();		
		testUtil = new testUtil();
		initialPage = new initialPage();
		loginPage = initialPage.loginClick();
		loadingWait(loginPage.loginButton);
		completeRegistrationPage = loginPage.loginRegister("jericho.arcibal@swapoolabs.com","mksoft_password");
		loadingWait(completeRegistrationPage.completeRegistrationHeader);

		}

	@Test
	public void validateCompleteRegistrationPageTitle() {
		String header = completeRegistrationPage.getCompleteRegistrationPageTitle();
		Assert.assertEquals(header, "Complete Your Profile");
	}
	
	@Test
	public void validateBlankUsername() {
		completeRegistrationPage.click(completeRegistrationPage.continueOneButton);
		errorMessage = completeRegistrationPage.getError(completeRegistrationPage.usernameError);
		Assert.assertEquals(errorMessage, "Please provide a username");
	}
	
	@Test
	public void validateExistingUsername() {
		completeRegistrationPage.sendKeys(completeRegistrationPage.userNameTextbox,"beth_logan");
		completeRegistrationPage.click(completeRegistrationPage.continueOneButton);
		errorMessage = completeRegistrationPage.getError(completeRegistrationPage.uniqueUsernameError);
		Assert.assertEquals(errorMessage, "This username is already taken");
	}

	@Test
	public void validateBlankFirstName() {
		completeRegistrationPage.click(completeRegistrationPage.continueOneButton);
		errorMessage = completeRegistrationPage.getError(completeRegistrationPage.firstNameError);
		Assert.assertEquals(errorMessage, "Please enter your first name");
	}

	@Test
	public void validateBlankLastName() {
		completeRegistrationPage.click(completeRegistrationPage.continueOneButton);
		errorMessage = completeRegistrationPage.getError(completeRegistrationPage.lastNameError);
		Assert.assertEquals(errorMessage, "Please enter your last name");
	}
////	@Test
////	public void validateWorkingUsername() {
////		completeRegistrationPage.updateUsername("smileys001");
////		completeRegistrationPage.clickContinueOne();
////		textboxcolor = completeRegistrationPage.getUsernameColor();
////		Assert.assertEquals(textboxcolor, "green");
////	}
////
//
////	@Test
////	public void validateWorkingFirstname() {
////		completeRegistrationPage.updateFirstName("ray");
////		completeRegistrationPage.clickContinueOne();
////		textboxcolor = completeRegistrationPage.getFirstNameColor();
////		Assert.assertEquals(textboxcolor, "green");
////	}
//
////
////	@Test
////	public void validateWorkingLastname() {
////		completeRegistrationPage.updateLastName("arcibal");
////		completeRegistrationPage.clickContinueOne();
////		textboxcolor = completeRegistrationPage.getLastNameColor();
////		Assert.assertEquals(textboxcolor, "green");
////	}
////
////
	@Test
	public void validateUniqueUsername() {
		completeRegistrationPage.sendKeys(completeRegistrationPage.userNameTextbox,"smileys1990");
		completeRegistrationPage.click(completeRegistrationPage.continueOneButton);
		errorMessage = completeRegistrationPage.getError(completeRegistrationPage.uniqueUsername);
		Assert.assertEquals(errorMessage, "check_circle Username is unique");
	}

	
	@Test
	public void validateBlankDOB() {
		completeRegistrationPage.click(completeRegistrationPage.continueOneButton);
		errorMessage = completeRegistrationPage.getError(completeRegistrationPage.dobError);
		Assert.assertEquals(errorMessage, "Please enter your birthdate");
	}
	
	@Test
	public void validateInvalidDOBOne() {
	completeRegistrationPage.sendKeys(completeRegistrationPage.dobTextbox,"24/24/24");
	completeRegistrationPage.click(completeRegistrationPage.continueOneButton);
	errorMessage = completeRegistrationPage.getError(completeRegistrationPage.invaliddobError);
	Assert.assertEquals(errorMessage, "Please provide a valid date format (mm/dd/yyyy)");
	}

	@Test
	public void validateInvalidDOBTwo() {
	completeRegistrationPage.sendKeys(completeRegistrationPage.dobTextbox,"aa/bb/cc");
	completeRegistrationPage.click(completeRegistrationPage.continueOneButton);
	errorMessage = completeRegistrationPage.getError(completeRegistrationPage.invaliddobError);
	Assert.assertEquals(errorMessage, "Please provide a valid date format (mm/dd/yyyy)");
	}

	
	@Test
	public void validateInvalidDOBThree() {
	completeRegistrationPage.sendKeys(completeRegistrationPage.dobTextbox,"May 10 2018");
	completeRegistrationPage.click(completeRegistrationPage.continueOneButton);
	errorMessage = completeRegistrationPage.getError(completeRegistrationPage.invaliddobError);
	Assert.assertEquals(errorMessage, "Please provide a valid date format (mm/dd/yyyy)");
	}

	@Test
	public void validateBelow18() {
		completeRegistrationPage.sendKeys(completeRegistrationPage.dobTextbox,"12/24/2015");
		completeRegistrationPage.click(completeRegistrationPage.continueOneButton);
		errorMessage = completeRegistrationPage.getError(completeRegistrationPage.belowDOBAgeEDrror);
		Assert.assertEquals(errorMessage, "Sorry, you should be at least 18 years old to register");
	}
	
		
	@Test
	public void validateOverage() {
		completeRegistrationPage.sendKeys(completeRegistrationPage.dobTextbox,"12/24/1900");
		completeRegistrationPage.click(completeRegistrationPage.continueOneButton);
		errorMessage = completeRegistrationPage.getError(completeRegistrationPage.overAgeError);
		Assert.assertEquals(errorMessage, "Date out of range. Please provide a valid date");
	}
	
	@Test
	public void validateBlankIDType() {
		completeRegistrationPage.click(completeRegistrationPage.continueOneButton);
		errorMessage = completeRegistrationPage.getError(completeRegistrationPage.idError);
		Assert.assertEquals(errorMessage, "Please select an ID type");
	}
	
	@Test
	public void validateBlankImage() {
		completeRegistrationPage.click(completeRegistrationPage.continueOneButton);
		errorMessage = completeRegistrationPage.getError(completeRegistrationPage.imageError);
		Assert.assertEquals(errorMessage, "Please choose a valid image");
	}
	
	@Test
	public void validateProperInfoOne() throws Exception  {
		completeRegistrationPage.properInfoOne("smileys001", "jeric", "", "arcibal", "07/19/1990", "Passport");
		completeRegistrationPage.click(completeRegistrationPage.uploadIdFileInput);
		testUtil.uploadFile();
		completeRegistrationPage.click(completeRegistrationPage.continueOneButton);
//		errorMessage = completeRegistrationPage.getError(completeRegistrationPage.imageError);
//		Assert.assertEquals(errorMessage, "Please choose a valid image");
	}

	
	//	
//	@Test
//	public void validateUploadID() throws AWTException, InterruptedException{
//		completeRegistrationPage.updateUsername("smileys001");
//		completeRegistrationPage.updateFirstName("Jeric");
//		completeRegistrationPage.updateLastName("Arcibal");
//		completeRegistrationPage.updateDOB("04/09/1990");
//		completeRegistrationPage.updateID("Passport");
//		completeRegistrationPage.clickUploadID();
//		testUtil.uploadFile();
//		completeRegistrationPage.clickContinueOne();
//	
//		//insert test here
//		String header = completeRegistrationPage.getCompleteRegistrationPageTitle();
//		Assert.assertEquals(header, "Profile");
//
//	}
//
//	@Test
//	public void validateValidCountry() throws AWTException, InterruptedException {
//		completeRegistrationPage.updateUsername("smileys001");
//		completeRegistrationPage.updateFirstName("Jeric");
//		completeRegistrationPage.updateLastName("Arcibal");
//		completeRegistrationPage.updateDOB("04/09/1990");
//		completeRegistrationPage.updateID("Passport");
//		completeRegistrationPage.clickUploadID();
//		testUtil.uploadFile();
//		completeRegistrationPage.clickContinueOne();
//		completeRegistrationPage.updateAdressLineOne("malibay pasayeno");
//		completeRegistrationPage.updatecountryDropdown("Australia");
//		completeRegistrationPage.clickContinueTwo();
//
//		textboxcolor = completeRegistrationPage.getcountryDropdownColor();
//		Assert.assertEquals(textboxcolor, "green");
//	}
//
//	@Test
//	public void validateValidAddress() throws AWTException, InterruptedException {
//		completeRegistrationPage.updateUsername("smileys001");
//		completeRegistrationPage.updateFirstName("Jeric");
//		completeRegistrationPage.updateLastName("Arcibal");
//		completeRegistrationPage.updateDOB("04/09/1990");
//		completeRegistrationPage.updateID("Passport");
//		completeRegistrationPage.clickUploadID();
//		testUtil.uploadFile();
//		completeRegistrationPage.clickContinueOne();
//		completeRegistrationPage.updateAdressLineOne("malibay pasayeno");
//		completeRegistrationPage.clickContinueTwo();
//
//		textboxcolor = completeRegistrationPage.getaddressLineOneTextboxColor();
//		Assert.assertEquals(textboxcolor, "green");
//	}
//
//	
//	
//	@Test
//	public void validateBlankState() throws AWTException, InterruptedException{
//		completeRegistrationPage.updateUsername("smileys001");
//		completeRegistrationPage.updateFirstName("Jeric");
//		completeRegistrationPage.updateLastName("Arcibal");
//		completeRegistrationPage.updateDOB("04/09/1990");
//		completeRegistrationPage.updateID("Passport");
//		completeRegistrationPage.clickUploadID();
//		testUtil.uploadFile();
//		completeRegistrationPage.clickContinueOne();
//		completeRegistrationPage.updatecountryDropdown("Australia");
//		completeRegistrationPage.clickContinueTwo();
//		
//		errorMessage = completeRegistrationPage.getStateDropdownError();
//		Assert.assertEquals(errorMessage, "Please select your region");
//
//	}
//
//	@Test
//	public void validateState() throws AWTException, InterruptedException {
//		completeRegistrationPage.updateUsername("smileys001");
//		completeRegistrationPage.updateFirstName("Jeric");
//		completeRegistrationPage.updateLastName("Arcibal");
//		completeRegistrationPage.updateDOB("04/09/1990");
//		completeRegistrationPage.updateID("Passport");
//		completeRegistrationPage.clickUploadID();
//		testUtil.uploadFile();
//		completeRegistrationPage.clickContinueOne();
//		completeRegistrationPage.updateAdressLineOne("malibay pasayeno");
//		completeRegistrationPage.updatecountryDropdown("Australia");
//		completeRegistrationPage.updateStateDropdown("Victoria");
//		completeRegistrationPage.clickContinueTwo();
//
//		textboxcolor = completeRegistrationPage.getStateDropdownColor();
//		Assert.assertEquals(textboxcolor, "green");
//	}
//
//	
//	@Test
//	public void validateBlankCity() throws AWTException, InterruptedException{
//		completeRegistrationPage.updateUsername("smileys001");
//		completeRegistrationPage.updateFirstName("Jeric");
//		completeRegistrationPage.updateLastName("Arcibal");
//		completeRegistrationPage.updateDOB("04/09/1990");
//		completeRegistrationPage.updateID("Passport");
//		completeRegistrationPage.clickUploadID();
//		testUtil.uploadFile();
//		completeRegistrationPage.clickContinueOne();
//		completeRegistrationPage.clickContinueTwo();
//		
//		errorMessage = completeRegistrationPage.getCityDropdownError();
//		Assert.assertEquals(errorMessage, "Please select your city");
//
//	}
//	
//	
//	@Test
//	public void validateCity() throws AWTException, InterruptedException {
//		completeRegistrationPage.updateUsername("smileys001");
//		completeRegistrationPage.updateFirstName("Jeric");
//		completeRegistrationPage.updateLastName("Arcibal");
//		completeRegistrationPage.updateDOB("04/09/1990");
//		completeRegistrationPage.updateID("Passport");
//		completeRegistrationPage.clickUploadID();
//		testUtil.uploadFile();
//		completeRegistrationPage.clickContinueOne();
//		completeRegistrationPage.updateAdressLineOne("malibay pasayeno");
//		completeRegistrationPage.updatecountryDropdown("Philippines");
//		completeRegistrationPage.updateStateDropdown("Pasay");
//		completeRegistrationPage.updateCityDropdown("Malibay");
//		completeRegistrationPage.clickContinueTwo();
//
//		textboxcolor = completeRegistrationPage.getCityDropdownColor();
//		Assert.assertEquals(textboxcolor, "green");
//	}
//
//	@Test
//	public void validateInvalidPhoneContact() throws AWTException, InterruptedException {
//		completeRegistrationPage.updateUsername("smileys001");
//		completeRegistrationPage.updateFirstName("Jeric");
//		completeRegistrationPage.updateLastName("Arcibal");
//		completeRegistrationPage.updateDOB("04/09/1990");
//		completeRegistrationPage.updateID("Passport");
//		completeRegistrationPage.clickUploadID();
//		testUtil.uploadFile();
//		completeRegistrationPage.clickContinueOne();
//		
//		completeRegistrationPage.updateAdressLineOne("malibay pasayeno");
//		completeRegistrationPage.updatecountryDropdown("Philippines");
//		completeRegistrationPage.updateStateDropdown("Pasay");
//		completeRegistrationPage.updateCityDropdown("Malibay");
//		completeRegistrationPage.clickContinueTwo();
//		
//		completeRegistrationPage.updateMobile("9171791045");		
//		completeRegistrationPage.clickVerifyMobileOne();
//		completeRegistrationPage.updateOTP("111111");
//		completeRegistrationPage.clickVerifyMobileTwo();
//		errorMessage = completeRegistrationPage.getExistingMobileError();
//		Assert.assertEquals(errorMessage, "This mobile number already exists");
//
//	}
//
//	
//	@Test
//	public void validateValidPhoneContact() throws AWTException, InterruptedException {
//		completeRegistrationPage.updateUsername("smileys001");
//		completeRegistrationPage.updateFirstName("Jeric");
//		completeRegistrationPage.updateLastName("Arcibal");
//		completeRegistrationPage.updateDOB("04/09/1990");
//		completeRegistrationPage.updateID("Passport");
//		completeRegistrationPage.clickUploadID();
//		testUtil.uploadFile();
//		completeRegistrationPage.clickContinueOne();
//		completeRegistrationPage.updateAdressLineOne("malibay pasayeno");
//		completeRegistrationPage.updatecountryDropdown("Philippines");
//		completeRegistrationPage.updateStateDropdown("Pasay");
//		completeRegistrationPage.updateCityDropdown("Malibay");
//		completeRegistrationPage.clickContinueTwo();
//		completeRegistrationPage.updateMobile("9260445992");		
//		completeRegistrationPage.clickVerifyMobileOne();
//		completeRegistrationPage.updateOTP("111111");
//		completeRegistrationPage.clickVerifyMobileTwo();
//		errorMessage = completeRegistrationPage.getMobileWorks();
//		Assert.assertEquals(errorMessage, "Your mobile number has been verified");
//	}
//	
//	
//	
//	@Test
//	public void validateMismatchedPasswordWalletOne () throws AWTException, InterruptedException
//	{
//		completeRegistrationPage.updateUsername("smileys001");
//		completeRegistrationPage.updateFirstName("Jeric");
//		completeRegistrationPage.updateLastName("Arcibal");
//		completeRegistrationPage.updateDOB("04/09/1990");
//		completeRegistrationPage.updateID("Passport");
//		completeRegistrationPage.clickUploadID();
//		testUtil.uploadFile();
//		completeRegistrationPage.clickContinueOne();
//		completeRegistrationPage.updateAdressLineOne("malibay pasayeno");
//		completeRegistrationPage.updatecountryDropdown("Philippines");
//		completeRegistrationPage.updateStateDropdown("Pasay");
//		completeRegistrationPage.updateCityDropdown("Malibay");
//		completeRegistrationPage.clickContinueTwo();
//		completeRegistrationPage.updateMobile("9260445992");		
//		completeRegistrationPage.clickVerifyMobileOne();
//		completeRegistrationPage.updateOTP("111111");
//		completeRegistrationPage.clickVerifyMobileTwo();
//		completeRegistrationPage.clickContinueThree();
//		completeRegistrationPage.clickComplete();
//		
//		errorMessage = completeRegistrationPage.getWalletPasswordError();
//		Assert.assertEquals(errorMessage, "Please provide a password");		
//	}
//	
//	
//	@Test
//	public void validateMismatchedPasswordWalletTwo () throws AWTException, InterruptedException
//	{
//		completeRegistrationPage.updateUsername("smileys001");
//		completeRegistrationPage.updateFirstName("Jeric");
//		completeRegistrationPage.updateLastName("Arcibal");
//		completeRegistrationPage.updateDOB("04/09/1990");
//		completeRegistrationPage.updateID("Passport");
//		completeRegistrationPage.clickUploadID();
//		testUtil.uploadFile();
//		completeRegistrationPage.clickContinueOne();
//		completeRegistrationPage.updateAdressLineOne("malibay pasayeno");
//		completeRegistrationPage.updatecountryDropdown("Philippines");
//		completeRegistrationPage.updateStateDropdown("Pasay");
//		completeRegistrationPage.updateCityDropdown("Malibay");
//		completeRegistrationPage.clickContinueTwo();
//		completeRegistrationPage.updateMobile("9260445992");		
//		completeRegistrationPage.clickVerifyMobileOne();
//		completeRegistrationPage.updateOTP("111111");
//		completeRegistrationPage.clickVerifyMobileTwo();
//		completeRegistrationPage.clickContinueThree();
//		completeRegistrationPage.clickComplete();
//		
//		errorMessage = completeRegistrationPage.getConfirmWalletPasswordError();
//		Assert.assertEquals(errorMessage, "Please confirm your password");		
//	}
//	
//	
//	@Test
//	public void validateValidPasswordWallet () throws AWTException, InterruptedException
//	{
//		completeRegistrationPage.updateUsername("smileys001");
//		completeRegistrationPage.updateFirstName("Jeric");
//		completeRegistrationPage.updateLastName("Arcibal");
//		completeRegistrationPage.updateDOB("04/09/1990");
//		completeRegistrationPage.updateID("Passport");
//		completeRegistrationPage.clickUploadID();
//		testUtil.uploadFile();
//		completeRegistrationPage.clickContinueOne();
//		completeRegistrationPage.updateAdressLineOne("malibay pasayeno");
//		completeRegistrationPage.updatecountryDropdown("Philippines");
//		completeRegistrationPage.updateStateDropdown("Pasay");
//		completeRegistrationPage.updateCityDropdown("Malibay");
//		completeRegistrationPage.clickContinueTwo();
//		completeRegistrationPage.updateMobile("9260445992");		
//		completeRegistrationPage.clickVerifyMobileOne();
//		completeRegistrationPage.updateOTP("111111");
//		completeRegistrationPage.clickVerifyMobileTwo();
//		completeRegistrationPage.clickContinueThree();
//		completeRegistrationPage.updateWalletPassword("Pasuwarudo01");
//		completeRegistrationPage.updateWalletConfirmPasswordTextbox("Pasuwarudo01");
//		completeRegistrationPage.clickComplete();
//		completeRegistrationPage.clickOK();
//		
//		String name = homePage.validateSwapooHomepage();
//		Assert.assertEquals(name, "jeric arcibal");	
//}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
