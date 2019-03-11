package com.SpringSeven.qa.testcases;

import java.awt.AWTException;
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
	public void setUp() throws InterruptedException, MalformedURLException {
		initialization();		
		testUtil = new testUtil();
		initialPage = new initialPage();
		loginPage = initialPage.loginClick();		
		loadingWait(loginPage.loginButton);
		completeRegistrationPage = loginPage.loginRegister("","");
		processing();
	}

//	@Test
//	public void validateCompleteRegistrationPageTitle() {
//		String header = completeRegistrationPage.getCompleteRegistrationPageTitle();
//		Assert.assertEquals(header, "Register Now!");
//	}
//	
//	@Test
//	public void validateBlankUsername() {
//		completeRegistrationPage.clickContinueOne();
//		errorMessage = completeRegistrationPage.getUsernameError();
//		Assert.assertEquals(errorMessage, "Please provide an username");
//	}
//	
//	@Test
//	public void validateExistingUsername() {
//		completeRegistrationPage.updateUsername("larrydecastro");
//		completeRegistrationPage.clickContinueOne();
//		errorMessage = completeRegistrationPage.getUniqueUsernameError();
//		Assert.assertEquals(errorMessage, "This username is already taken");
//	}
//
//	@Test
//	public void validateWorkingUsername() {
//		completeRegistrationPage.updateUsername("smileys001");
//		completeRegistrationPage.clickContinueOne();
//		textboxcolor = completeRegistrationPage.getUsernameColor();
//		Assert.assertEquals(textboxcolor, "green");
//	}
//
//	@Test
//	public void validateBlankFirstName() {
//		completeRegistrationPage.clickContinueOne();
//		errorMessage = completeRegistrationPage.getFirstNameError();
//		Assert.assertEquals(errorMessage, "Please enter your first username");
//	}
//
//	@Test
//	public void validateWorkingFirstname() {
//		completeRegistrationPage.updateFirstName("ray");
//		completeRegistrationPage.clickContinueOne();
//		textboxcolor = completeRegistrationPage.getFirstNameColor();
//		Assert.assertEquals(textboxcolor, "green");
//	}
//
//	
//	@Test
//	public void validateBlankULastName() {
//		completeRegistrationPage.clickContinueOne();
//		errorMessage = completeRegistrationPage.getLastNameError();
//		Assert.assertEquals(errorMessage, "Please enter your last username");
//	}
//
//	@Test
//	public void validateWorkingLastname() {
//		completeRegistrationPage.updateLastName("arcibal");
//		completeRegistrationPage.clickContinueOne();
//		textboxcolor = completeRegistrationPage.getLastNameColor();
//		Assert.assertEquals(textboxcolor, "green");
//	}
//
//
//	@Test
//	public void validateBlankDOB() {
//		completeRegistrationPage.clickContinueOne();
//		errorMessage = completeRegistrationPage.getDOBError();
//		Assert.assertEquals(errorMessage, "Please enter your birthdate");
//	}
//	
//	@Test
//	public void validateInvalidDOB() {
//		completeRegistrationPage.updateDOB("24/24/24");
//		completeRegistrationPage.clickContinueOne();
//		errorMessage = completeRegistrationPage.getInvalidDOBError();
//		Assert.assertEquals(errorMessage, "Please provide a valid date format (mm/dd/yyyy)");
//	}
//		
//	@Test
//	public void validateBelow18() {
//		completeRegistrationPage.updateDOB("12/24/2015");
//		completeRegistrationPage.clickContinueOne();
//		errorMessage = completeRegistrationPage.getDOBBelowAgeError();
//		Assert.assertEquals(errorMessage, "Sorry, you should be at least 18 years old to register");
//	}
//	
//		
//	@Test
//	public void validateOverage() {
//		completeRegistrationPage.updateDOB("12/24/1916");
//		completeRegistrationPage.clickContinueOne();
//		errorMessage = completeRegistrationPage.getOverageError();
//		Assert.assertEquals(errorMessage, "Please provide a valid date format (mm/dd/yyyy)");
//	}
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
