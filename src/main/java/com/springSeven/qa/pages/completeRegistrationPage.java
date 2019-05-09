package com.springSeven.qa.pages;

import org.openqa.selenium.Keys;
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
	@FindBy(xpath = "//h1[@title='Complete Your Profile']")
	public WebElement completeRegistrationHeader;

	// textbox
	//txt1
	@FindBy(id ="COMPLETE_REGISTRATION_username")
	public WebElement userNameTextbox;

	@FindBy(id="COMPLETE_REGISTRATION_firstName")
	public WebElement firstNameTextbox;

	@FindBy(id="COMPLETE_REGISTRATION_middleName")
	public WebElement middleNameTextbox;

	@FindBy(id="COMPLETE_REGISTRATION_lastName")
	public WebElement lastNameTextbox;
	
	@FindBy(id="COMPLETE_REGISTRATION_dob")
	public WebElement dobTextbox;
	
	//dropdown
	@FindBy(id="COMPLETE_REGISTRATION_idType")
	public WebElement idDropdown;

	//txt2
	@FindBy(id="COMPLETE_REGISTRATION_addressLine1")
	public WebElement addressLineOneTextbox;
	
	@FindBy(id="COMPLETE_REGISTRATION_addressLine2")
	public WebElement addressLineTwoTextbox;

	@FindBy(id="COMPLETE_REGISTRATION_otherCity")
	public WebElement cityTextbox;

	@FindBy(id="COMPLETE_REGISTRATION_otherRegion")
	public WebElement regionTextbox;

	@FindBy(id="COMPLETE_REGISTRATION_postalCode")
	public WebElement postalCodeTextbox;
	
	@FindBy(xpath="//div[contains(text(),'Select Country')]][class='Select-placeholder']")
	public WebElement countryDropdown;

	@FindBy(xpath="//div[contains(text(),'Select state')]][class='Select-placeholder']")
	public WebElement stateDropdown;

	@FindBy(xpath="//div[contains(text(),'Select city')]][class='Select-placeholder']")
	public WebElement cityDropdown;

	
	//txt3
	@FindBy(id="COMPLETE_REGISTRATION_mobileDigit")
	public WebElement mobileTextbox;
	
	@FindBy(id="COMPLETE_REGISTRATION_verificationCode")
	public WebElement OTPTextbox;
	
	//txt4
	@FindBy(id="COMPLETE_REGISTRATION_password")
	public WebElement walletPasswordTextbox;

	@FindBy(id="COMPLETE_REGISTRATION_confirmPassword")
	public WebElement walletConfirmPasswordTextbox;

	
	
	//upload
	@FindBy(xpath="//div[@class='component-dropzone center-align']")
	public WebElement uploadIdFileInput;
	
	//button
	@FindBy(id="profile-form-submit")
	public WebElement continueOneButton;

	@FindBy(id="address-form-submit")
	public WebElement continueTwoButton;
	
	@FindBy(xpath="//*[contains(text(),'Continue')]")
	public WebElement continueThree;
	
	@FindBy(xpath="//*[contains(text(),'Verify Mobile Number')]")
	public WebElement verifyMobileOneButton;
	
	@FindBy(xpath="//*[contains(text(),'Verify Mobile')]")
	public WebElement verifyMobileTwoButton;
	
	@FindBy(xpath="//*[@type='button']//*[contains(text(),'Complete')]")
	public WebElement verifyCompleteButton;
		
	@FindBy(xpath="//span[contains(text(),'Ok')]")
	public WebElement OKButton;	   
	 

	   
	   
	//not error
	@FindBy(xpath="//div[contains(text(),'Username is unique')]")
	public WebElement uniqueUsername;
	
	//error
	//1
	@FindBy(xpath="//div[contains(text(),'This username is already taken')]")
	public WebElement uniqueUsernameError;
	
	@FindBy(xpath="//div[contains(text(),'Please provide a username')]")
	public WebElement usernameError;

	@FindBy(xpath="//div[contains(text(),'Please enter your first name')]")
	public WebElement firstNameError;


	@FindBy(xpath="//div[contains(text(),'Please enter your last name')]")
	public WebElement lastNameError;

	@FindBy(xpath="//div[contains(text(),'Please enter your birthdate')]")
	public WebElement dobError;
	
	@FindBy(xpath="//div[contains(text(),'Please select an ID type')]")
	public WebElement idError;

	@FindBy(xpath="//div[contains(text(),'Please choose a valid image')]")
	public WebElement imageError;

	@FindBy(xpath="//div[contains(text(),'Please provide a valid date format (mm/dd/yyyy)')]")
	public WebElement invaliddobError;
	
	@FindBy(xpath="//div[contains(text(),'Sorry, you should be at least 18 years old to register')]")
	public WebElement belowDOBAgeEDrror;
	
	@FindBy(xpath="//div[contains(text(),'Date out of range. Please provide a valid date')]")
	public WebElement overAgeError;
	
	//2
	//if code above does not work use this format
	//@FindBy(xpath="//*[contains(text(),'Please enter your address')]")
	@FindBy(xpath="//div[class='helper-text error-message']")
	public WebElement addressOneError;

	@FindBy(xpath="//div[class='helper-text error-message RenderSelect__helper-text___2J_a0 RenderSelect__error-message___18k9D']")
	public WebElement countryError;
	
	@FindBy(xpath="//*[contains(text(),'Please select your region')]")
	public WebElement stateDropdownError;

	@FindBy(xpath="//*[contains(text(),'Please select your city')]")
	public WebElement cityDropdownError;
	
	//3
	@FindBy(xpath="//*[contains(text(),'This mobile number already exists')]")
	public WebElement mobileErrorExist;
	
	@FindBy(xpath="//*[contains(text(),'Your mobile number has been verified')]")
	public WebElement mobileWorks;
	
	//4
	@FindBy(xpath="//*[contains(text(),'Please provide a password')]")
	public WebElement walletPasswordError;
	
	@FindBy(xpath="//*[contains(text(),'Please confirm your password')]")
	public WebElement walletConfirmPasswordError;
	
	
	//action
	//get title
	public String getCompleteRegistrationPageTitle()
	{
		String getCompleteRegistrationPageTitle = completeRegistrationHeader.getText();
		return getCompleteRegistrationPageTitle;
	}
	

	//sendKeys
	public void sendKeys(WebElement element,String string) {
		element.sendKeys(string);
	}

	// error messages
		public String getError(WebElement element) {
		loadingWait(element);
		String getError = element.getText();
		return getError;
	}

	// click
	public void click(WebElement element) {
		clickableWait(element);
		element.click();
	}

	// get color
	public String getColor(WebElement element) {
		String getColor = element.getCssValue("background-color");
		return getColor;
}
	
	public void properInfoOne(String username, String firstname, String middlename,String lastname,
		String birthdate, String idtype){
		userNameTextbox.sendKeys(username);
		firstNameTextbox.sendKeys(firstname);
		middleNameTextbox.sendKeys(middlename);
		lastNameTextbox.sendKeys(lastname);
		dobTextbox.sendKeys(birthdate);
		idDropdown.sendKeys(idtype);
		idDropdown.sendKeys(Keys.ENTER);

//		emailTextbox.sendKeys(idtype);		
//		loadingWait(emailIsUnique);
//		clickableWait(registerButton);
//		registerButton.click();
	}


	

}
