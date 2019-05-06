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

	// error
	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div/div[2]/form[1]/div[1]/div/div")
	WebElement emailError;

	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div/div[2]/form[2]/div[1]/div/div")
	WebElement passwordError;

	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div/div[2]/form[2]/div[2]/div/div")
	public	WebElement confirmPasswordError;

	@FindBy(xpath = "//span[contains(text(),'The email you are trying to register has not been')]")
	public WebElement emailNotVerifiedError;

	@FindBy(xpath = "//div[contains(text(),'This email already exists')]")
	public WebElement emailExist;

	//positive error
	@FindBy(xpath = "//div[@class='helper-text success-message']")
	public WebElement emailIsUnique;

	@FindBy(xpath = "//div[@class='helper-text success-message']")
	public WebElement emailIsVerified;

	// actions
	public String getRegistrationPageTitle() {
		String getRegistrationPageTitle = registrationHeader.getText();
		return getRegistrationPageTitle;
	}

	// error messages
	public String getEmailError() {
		String getEmailError = emailError.getText();
		return getEmailError;
	}

	public String getPasswordError() {
		String getPasswordError = passwordError.getText();
		return getPasswordError;
	}

	public String getConfirmPasswordError() {
		String getConfirmPasswordError = confirmPasswordError.getText();
		return getConfirmPasswordError;
	}

	public String getEmailNotVerifiedError() {
		String getEmailNotVerifiedError = emailNotVerifiedError.getText();
		return getEmailNotVerifiedError;
	}

	public String getEmailExist() {
		String getEmailExist = emailExist.getText();
		return getEmailExist;
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

	
	// input
	public void updateEmailTextbox(String value) {
		emailTextbox.sendKeys(value);
	}

	public void updatePasswordTextbox(String value) {
		passwordTextbox.sendKeys(value);
	}

	public void updateConfirmTextbox(String value) {
		confirmPasswordTextbox.sendKeys(value);
	}

	public void updateVerificationTextbox(String value) {
		emailOTPTextbox.sendKeys(value);
	}

	// click
	public void click(WebElement element) {
		element.click();
	}


	// clean
	// input Email
	public void proper(String email, String password, String confirmpw) {
		emailTextbox.sendKeys(email);
		registerButton.click();
		loadingWait(emailIsUnique);
		passwordTextbox.sendKeys(password);
		confirmPasswordTextbox.sendKeys(confirmpw);
		clickableWait(registerButton);
		registerButton.click();
	}

	public void inputEmail(String email) {
		emailTextbox.sendKeys(email);
		registerButton.click();
	}
}
