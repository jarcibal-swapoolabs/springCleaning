package com.springSeven.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.springSeven.qa.base.testBase;

public class registrationPage extends testBase {

	public registrationPage() {
		PageFactory.initElements(driver, this);
	}

	// elements
	// title
	@FindBy(xpath = "//h1[@title='Register Now!']")
	WebElement registrationHeader;

	// textbox
	@FindBy(id = "REGISTRATION_EMAIL_email")
	public WebElement emailTextbox;
	
	@FindBy(id = "REGISTRATION_password")
	WebElement passwordTextbox;

	@FindBy(id = "REGISTRATION_confirmPassword")
	WebElement confirmPasswordTextbox;

	@FindBy(id = "REGISTRATION_EMAIL_verificationCode")
	public WebElement emailOTPTextbox;

	// button
	@FindBy(xpath = "//div[@class='col s12 center-align add-mar-bottom2 add-mar-top']//button[@type='button']")
	public WebElement registerButton;

	@FindBy(xpath = "//button[contains(text(),'SEND VERIFICATION CODE')]")
	WebElement sendVerificationButton;

	@FindBy(xpath = "//button[contains(text(),'VERIFY EMAIL')]")
	WebElement verifyEmailButton;

	//error
	//@FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div/div[2]/form[1]/div[1]/div/div")
	@FindBy(xpath = "//div[contains(text(),'Please provide a valid email address format')]")
	public WebElement emailErrorOne;
	
	@FindBy(xpath = "//div[contains(text(),'Please provide an email address')]")
	public WebElement emailErrorTwo;
	
	//@FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div/div[2]/form[2]/div[1]/div/div")
	@FindBy(xpath = "//div[contains(text(),'Please provide a password')]")
	public WebElement passwordError;
	
	//@FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div/div[2]/form[2]/div[2]/div/div")
	@FindBy(xpath = "//div[contains(text(),'Passwords do not match')]")
	public WebElement confirmPasswordErrorOne;
	
	@FindBy(xpath = "//div[contains(text(),'Please confirm your password')]")
	public WebElement confirmPasswordErrorTwo;


	@FindBy(xpath = "//span[contains(text(),'The email you are trying to register has not been')]")
	public WebElement emailNotVerifiedError;

	@FindBy(xpath = "//div[contains(text(),'This email already exists')]")
	public WebElement emailExist;

	//positive error
	@FindBy(xpath = "//div[@class='helper-text success-message']")
	public WebElement emailIsUnique;

	@FindBy(xpath = "//div[@class='helper-text success-message']")
	public WebElement emailIsVerified;

	//password strength
	@FindBy(xpath = "//div[@class='col s3 m2']")
	public WebElement passwordStrength;
	
	//verification error
	@FindBy(xpath = "//div[contains(text(),'Please provide a verification code')]")
	public WebElement verificationErrorOne;
	
	@FindBy(xpath = "//div[contains(text(),'Invalid verification code')]")
	public WebElement verificationErrorTwo;

	
	// actions
	public String getRegistrationPageTitle() {
		String getRegistrationPageTitle = registrationHeader.getText();
		return getRegistrationPageTitle;
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

	
	//not errormessage
	public String getEmailIsUnique() {
		String getEmailIsUnique = emailIsUnique.getText();
		return getEmailIsUnique;
	}

	public String getEmailIsVerified() {
		String getEmailIsUnique = emailIsUnique.getText();
		return getEmailIsUnique;
	}

	
	// clean
	// input Email
	public void proper(String email, String password, String confirmpw) {
		loadingWait(emailTextbox);
		emailTextbox.sendKeys(email);

		clickableWait(registerButton);
		registerButton.click();
		loadingWait(emailIsUnique);
		
		loadingWait(passwordTextbox);
		passwordTextbox.sendKeys(password);
		clickableWait(registerButton);

		confirmPasswordTextbox.sendKeys(confirmpw);
		clickableWait(registerButton);
		registerButton.click();
	}

	public void inputEmail(String email) {
		emailTextbox.sendKeys(email);
		registerButton.click();
	}


	public void inputVerificationOTP(String otp) {
		sendVerificationButton.click();
		loadingWait(emailOTPTextbox);
		emailOTPTextbox.sendKeys(otp);
		verifyEmailButton.click();
	}


}
