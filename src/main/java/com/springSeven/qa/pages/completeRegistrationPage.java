package com.springSeven.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.springSeven.qa.base.testBase;

public class completeRegistrationPage extends testBase {

	public completeRegistrationPage() {
		PageFactory.initElements(driver, this);
	}

	// elements
	// title
	@FindBy(xpath = "//h1[@title='Register Now!']")
	WebElement completeRegistrationHeader;

	// textbox
	//txt1
	@FindBy(id ="COMPLETE_REGISTRATION_username")
	WebElement userNameTextbox;

	@FindBy(id="COMPLETE_REGISTRATION_firstName")
	WebElement firstNameTextbox;

	@FindBy(id="COMPLETE_REGISTRATION_middleName")
	WebElement middleNameTextbox;

	@FindBy(id="COMPLETE_REGISTRATION_lastName")
	WebElement lastNameTextbox;
	
	@FindBy(id="COMPLETE_REGISTRATION_dob")
	WebElement dobTextbox;
	
	//txt2
	@FindBy(id="COMPLETE_REGISTRATION_addressLine1")
	WebElement addressLineOneTextbox;
	
	@FindBy(id="COMPLETE_REGISTRATION_addressLine2")
	WebElement addressLineTwoTextbox;

	@FindBy(id="COMPLETE_REGISTRATION_otherCity")
	WebElement cityTextbox;

	@FindBy(id="COMPLETE_REGISTRATION_otherRegion")
	WebElement regionTextbox;

	@FindBy(id="COMPLETE_REGISTRATION_postalCode")
	WebElement postalCodeTextbox;
	
	@FindBy(xpath="//div[contains(text(),'Select Country')]][class='Select-placeholder']")
	WebElement countryDropdown;

	@FindBy(xpath="//div[contains(text(),'Select state')]][class='Select-placeholder']")
	WebElement stateDropdown;

	@FindBy(xpath="//div[contains(text(),'Select city')]][class='Select-placeholder']")
	WebElement cityDropdown;

	
	//txt3
	@FindBy(id="COMPLETE_REGISTRATION_mobileDigit")
	WebElement mobileTextbox;
	
	@FindBy(id="COMPLETE_REGISTRATION_verificationCode")
	WebElement OTPTextbox;
	
	//txt4
	@FindBy(id="COMPLETE_REGISTRATION_password")
	WebElement walletPasswordTextbox;

	@FindBy(id="COMPLETE_REGISTRATION_confirmPassword")
	WebElement walletConfirmPasswordTextbox;

	
	//dropdown
	@FindBy(xpath="//div[@class='Select-placeholder']")
	WebElement idDropdown;	
	
	//upload
	@FindBy(xpath="//div[@class='component-dropzone center-align']")
	WebElement uploadIdFileInput;
	
	//button
	@FindBy(id="profile-form-submit")
	WebElement continueOneButton;

	@FindBy(id="address-form-submit")
	WebElement continueTwoButton;
	
	@FindBy(xpath="//*[contains(text(),'Continue')]")
	WebElement continueThree;
	
	@FindBy(xpath="//*[contains(text(),'Verify Mobile Number')]")
	WebElement verifyMobileOneButton;
	
	@FindBy(xpath="//*[contains(text(),'Verify Mobile')]")
	WebElement verifyMobileTwoButton;
	
	@FindBy(xpath="//*[@type='button']//*[contains(text(),'Complete')]")
	WebElement verifyCompleteButton;
		
	@FindBy(xpath="//span[contains(text(),'Ok')]")
	WebElement OKButton;	   
	 

	   
	   
	//error
	//1
	@FindBy(xpath="//div[contains(text(),'This username is already taken')][class='helper-text error-message']")
	WebElement uniqueUsernameError;
	

	@FindBy(xpath="//div[contains(text(),'Please provide a username')][class='helper-text error-message']")
	WebElement usernameError;

	@FindBy(xpath="//div[contains(text(),'Please enter your first name')][class='helper-text error-message']")
	WebElement firstNameError;

	
	@FindBy(xpath="//div[contains(text(),'Please enter your last name')][class='helper-text error-message']")
	WebElement lastNameError;

	@FindBy(xpath="//div[contains(text(),'Please enter your birthdate')][class='helper-text error-message']")
	WebElement dobError;
	
	@FindBy(xpath="//div[contains(text(),'Please select an ID type')][class='helper-text error-message']")
	WebElement idError;

	@FindBy(xpath="//div[contains(text(),'Please choose a valid image')][class='helper-text error-message']")
	WebElement imageError;

	@FindBy(xpath="//div[contains(text(),'Please provide a valid date format (mm/dd/yyyy)')][class='helper-text error-message']")
	WebElement invaliddobError;
	
	@FindBy(xpath="//div[contains(text(),'Sorry, you should be at least 18 years old to register')][class='helper-text error-message']")
	WebElement belowDOBAgeEDrror;
	
	@FindBy(xpath="//div[contains(text(),'Date out of range. Please provide a valid date')][class='helper-text error-message']")
	WebElement overAgeError;
	
	//2
	//if code above does not work use this format
	//@FindBy(xpath="//*[contains(text(),'Please enter your address')]")
	@FindBy(xpath="//div[class='helper-text error-message']")
	WebElement addressOneError;

	@FindBy(xpath="//div[class='helper-text error-message RenderSelect__helper-text___2J_a0 RenderSelect__error-message___18k9D']")
	WebElement countryError;
	
	@FindBy(xpath="//*[contains(text(),'Please select your region')]")
	WebElement stateDropdownError;

	@FindBy(xpath="//*[contains(text(),'Please select your city')]")
	WebElement cityDropdownError;
	
	//3
	@FindBy(xpath="//*[contains(text(),'This mobile number already exists')]")
	WebElement mobileErrorExist;
	
	@FindBy(xpath="//*[contains(text(),'Your mobile number has been verified')]")
	WebElement mobileWorks;
	
	//4
	@FindBy(xpath="//*[contains(text(),'Please provide a password')]")
	WebElement walletPasswordError;
	
	@FindBy(xpath="//*[contains(text(),'Please confirm your password')]")
	WebElement walletConfirmPasswordError;
	
	
	//action
	//get title
	public String getCompleteRegistrationPageTitle()
	{
		String getCompleteRegistrationPageTitle = completeRegistrationHeader.getText();
		return getCompleteRegistrationPageTitle;
	}
	
	//send text
	public void updateUsername(String input) {
		userNameTextbox.sendKeys(input);
	}

	public void updateFirstName(String input) {
		firstNameTextbox.sendKeys(input);
	}

	public void updateMiddleName(String input) {
		middleNameTextbox.sendKeys(input);
	}

	public void updateLastName(String input) {
		lastNameTextbox.sendKeys(input);
	}

	public void updateDOB(String input) {
		dobTextbox.sendKeys(input);
	}

	public void updateID(String input) {
		idDropdown.sendKeys(input);
	}
	
	public void updatecountryDropdown(String input) {
		countryDropdown.sendKeys(input);
	}
	
	public void updateAdressLineOne(String input) {
		addressLineOneTextbox.sendKeys(input);		
	}

	public void updateStateDropdown(String input) {
		stateDropdown.sendKeys(input);
	}

	public void updateCityDropdown(String input) {
		cityDropdown.sendKeys(input);
	}

	public void updateMobile(String input) {
		mobileTextbox.sendKeys(input);
	}
	
	public void updateOTP(String input) {
		OTPTextbox.sendKeys(input);
	}

	public void updateWalletPassword(String input) {
		walletPasswordTextbox.sendKeys(input);
	}
	
	public void updateWalletConfirmPasswordTextbox(String input) {
		walletConfirmPasswordTextbox.sendKeys(input);
	}
	

	//click
	public void clickContinueOne()
	{
		continueOneButton.click();
		
	}
	
	public void clickUploadID()	
	{
		uploadIdFileInput.click();
	}
	
	public void clickContinueTwo()
	{
		continueTwoButton.click();		
	}
	
	
	public void clickContinueThree()
	{
		continueThree.click();		
	}
	
	public void clickVerifyMobileOne()
	{
		verifyMobileOneButton.click();		
	}
	
	public void clickVerifyMobileTwo()
	{
		verifyMobileTwoButton.click();		
	}
	
	public void clickComplete()
	{
		verifyCompleteButton.click();		
	}
	
	public void clickOK() {
		OKButton.click();		
	}

	
	
	//get error
	public String getUniqueUsernameError()
	{
		String getUniqueUsernameError = uniqueUsernameError.getText();
		return getUniqueUsernameError;
	}

	public String getUsernameError()
	{
		String getUsernameError = usernameError.getText();
		return getUsernameError;
	}

	public String getFirstNameError()
	{
		String getFirstNameError = firstNameError.getText();
		return getFirstNameError;
	}

	
	public String getLastNameError()
	{
		String getLastNameError = lastNameError.getText();
		return getLastNameError;
	}

	public String getDOBError()
	{
		String getDOBError = dobError.getText();
		return getDOBError;
	}
	
	public String getInvalidDOBError()
	{
		String getInvalidDOBError = invaliddobError.getText();
		return getInvalidDOBError;
	}
	
	public String getDOBBelowAgeError()
	{
		String getDOBBelowAgeError = belowDOBAgeEDrror.getText();
		return getDOBBelowAgeError;
	}
	
	
	public String getOverageError()
	{
		String getDOBBelowAgeError = overAgeError.getText();
		return getDOBBelowAgeError;
	}

	public String getStateDropdownError() {
		String getStateDropdownError = stateDropdownError.getText();
		return getStateDropdownError;
	}

	public String getCityDropdownError() {
		String getCityDropdownError = cityDropdownError.getText();
		return getCityDropdownError;
	}
	
	public String getExistingMobileError() {
		String getStateDropdownError = mobileErrorExist.getText();
		return getStateDropdownError;
	}

	public String getMobileWorks() {
		String getCityDropdownError = mobileWorks.getText();
		return getCityDropdownError;
	}
	
	
	public String getWalletPasswordError() {
		String getStateDropdownError = walletPasswordError.getText();
		return getStateDropdownError;
	}

	public String getConfirmWalletPasswordError() {
		String getCityDropdownError = walletConfirmPasswordError.getText();
		return getCityDropdownError;
	}

	
	
	
	//get color
	public String getUsernameColor()
	{
		String getUsernameColor = userNameTextbox.getCssValue("background-color");
		return getUsernameColor;
	}

	public String getFirstNameColor()
	{
		String getFirstNameColor = firstNameTextbox.getCssValue("background-color");
		return getFirstNameColor;
	}

	
	public String getLastNameColor()
	{
		String getLastNameColor = lastNameTextbox.getCssValue("background-color");
		return getLastNameColor;
	}

	public String getDOBColor()
	{
		String getDOBColor = dobTextbox.getCssValue("background-color");
		return getDOBColor;
	}
	
	public String getaddressLineOneTextboxColor() {
		String getaddressLineOneTextboxColor = addressLineOneTextbox.getCssValue("background-color");
		return getaddressLineOneTextboxColor;
	}
	
	public String getcountryDropdownColor() {
		String getcountryDropdownColor = countryDropdown.getCssValue("background-color");
		return getcountryDropdownColor;
	}
	
	
	public String getStateDropdownColor() {
		String getStateDropdownColor = stateDropdown.getCssValue("background-color");
		return getStateDropdownColor;
	}
	
	public String getCityDropdownColor() {
		String getCityDropdownColor = cityDropdown.getCssValue("background-color");
		return getCityDropdownColor;
	}


	

	

}
