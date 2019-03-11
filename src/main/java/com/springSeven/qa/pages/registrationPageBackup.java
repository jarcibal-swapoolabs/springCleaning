package com.springSeven.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.springSeven.qa.base.testBase;

public class registrationPageBackup extends testBase {

	public registrationPageBackup() {
		PageFactory.initElements(driver, this);
	}

	// elements
	// title
	@FindBy(xpath = "//h1[@title='Register Now!']")
	WebElement registrationHeader;

	// textbox
	@FindBy(id ="REGISTRATION_EMAIL_email")
	public WebElement emailTextbox;

	@FindBy(id="REGISTRATION_password")
	WebElement passwordTextbox;

	@FindBy(id="REGISTRATION_confirmPassword")
	WebElement confirmPasswordTextbox;

	@FindBy(id="REGISTRATION_EMAIL_verificationCode")
	WebElement emailOTPTextbox;
	

	// button
	@FindBy(xpath="//div[@class='col s12 center-align add-mar-bottom2 add-mar-top']//button[@type='button']")
	public WebElement registerButton;

	@FindBy(xpath = "//button[contains(text(),'Send verification Code')]")
	WebElement sendVerificationButton;
	
	@FindBy(xpath = "//button[contains(text(),'Verify Email')]")
	WebElement verifyEmailButton;


	// error
	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div/div[2]/form[1]/div[1]/div/div")
	WebElement emailError;

	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div/div[2]/form[2]/div[1]/div/div")
	WebElement passwordError;

	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div/div[2]/form[2]/div[2]/div/div")
	WebElement confirmPasswordError;

	@FindBy(xpath = "//span[contains(text(),'The email you are trying to register has not been')]")
	WebElement emailNotVerifiedError;
	
	@FindBy(xpath = "//div[@class='helper-text success-message']")
	WebElement emailIsUnique;
	
	@FindBy(xpath = "//div[contains(text(),'This email already exists')]")
	WebElement emailExist;
	


	// actions
	public String getRegistrationPageTitle() {
		String getRegistrationPageTitle = registrationHeader.getText();
		return getRegistrationPageTitle;
	}

	// error messages
	public String getEmailError()
	{
		String getEmailError = emailError.getText();
		return getEmailError;
	}

//	public String getEmailIsUnique(int timeout)
//	{
//		new WebDriverWait(driver,timeout).until(ExpectedConditions.visibilityOf(emailError));
//		String getEmailIsUnique = emailIsUnique.getText();
//		return getEmailIsUnique;
//	}

	public String getEmailIsUnique() {
		String getEmailIsUnique = emailIsUnique.getText();
		return getEmailIsUnique;
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
	
	
	
	

	//input
	public void updateEmailTextbox(int timeout, String value)
	{
		new WebDriverWait(driver,timeout).until(ExpectedConditions.elementToBeClickable(emailTextbox));
		emailTextbox.sendKeys(value);
	}

	public void updatePasswordTextbox(int timeout, String value)
	{
		new WebDriverWait(driver,timeout).until(ExpectedConditions.elementToBeClickable(passwordTextbox));
		passwordTextbox.sendKeys(value);
	}

	public void updateConfirmTextbox(int timeout, String value)
	{
		new WebDriverWait(driver,timeout).until(ExpectedConditions.elementToBeClickable(confirmPasswordTextbox));
		confirmPasswordTextbox.sendKeys(value);
	}

	public void updateVerificationTextbox(int timeout, String value)
	{
		new WebDriverWait(driver,timeout).until(ExpectedConditions.elementToBeClickable(emailOTPTextbox));
		emailOTPTextbox.sendKeys(value);
	}
	
	
	//click
	public void clickRegister(int timeout)
	{
		new WebDriverWait(driver,timeout).until(ExpectedConditions.elementToBeClickable(registerButton));
		registerButton.click();
	}

	public void clicksendVerification(int timeout)
	{
		new WebDriverWait(driver,timeout).until(ExpectedConditions.elementToBeClickable(sendVerificationButton));
		sendVerificationButton.click();
	}

	public void clickVerifyEmail(int timeout)
	{
		new WebDriverWait(driver,timeout).until(ExpectedConditions.elementToBeClickable(verifyEmailButton));
		verifyEmailButton.click();
	}

	
	

}
