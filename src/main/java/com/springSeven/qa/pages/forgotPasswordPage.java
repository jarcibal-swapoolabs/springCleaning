package com.springSeven.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.springSeven.qa.base.testBase;

public class forgotPasswordPage extends testBase{

	
	public forgotPasswordPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//elements
	@FindBy(xpath="//h1[@title='Forgot Password']")
	public WebElement fpwHeader;
	
	//textbox
	@FindBy(id="FORGOT_PASSWORD_accountEmail")
	public WebElement fpwTextbox;
	
	
	@FindBy(id="FORGOT_PASSWORD_verificationCode")
	public WebElement fpwOTPTextbox;


	@FindBy(id="FORGOT_PASSWORD_newPassword")
	public WebElement fpwPasswordTextbox;
	
	
	@FindBy(id="FORGOT_PASSWORD_confirmNewPassword")
	public WebElement fpwConfirmPasswordTextbox;

	//button
	@FindBy(id="submitBtn")
	public WebElement btnContinue;

	@FindBy(xpath="//a[@class='waves-effect waves-dark btn grey back-btn Button__button___3vjDD']")
	public WebElement btnCancel;
	
	@FindBy(id="continueButton")
	public WebElement btnOtpContinue;
	
	@FindBy(id="previousButton")
	public WebElement btnOtpPrevious;

	@FindBy(xpath="//button[@class='btn-link-text Button__text___3O8GS Button__link___3KyiJ']")
	public WebElement btnOtpResend;

	//error
	@FindBy(xpath="//div[@class='helper-text error-message']")
	public WebElement fpwErrorMessageEmail;

	@FindBy(xpath="//div[@class='helper-text error-message']")
	public WebElement fpwErrorMessageOtp;
	
	@FindBy(xpath = "//div[contains(text(),'Please provide a password')]")
	public WebElement passwordErrorOne;

	@FindBy(xpath = "//div[contains(text(),'Passwords do not match')]")
	public WebElement confirmPasswordErrorOne;
	
	@FindBy(xpath = "//div[contains(text(),'Please confirm your password')]")
	public WebElement confirmPasswordErrorTwo;

	@FindBy(xpath="//div[@class='col s3 m2']")
	public WebElement fpwPasswordRanking;

	//actions
	public String getForgotPasswordPageTitle()
	{
		String getForgotPasswordPageTitle = fpwHeader.getText();
		return getForgotPasswordPageTitle;
	}
	
	//input Email
	public void inputEmail(String mail)
	{
		fpwTextbox.sendKeys(mail);
		btnContinue.click();
	}
	
	public void inputOTP(String otp)
	{
		loadingWait(fpwOTPTextbox);
		fpwOTPTextbox.sendKeys(otp);
		btnOtpContinue.click();
	}

	public void inputPassword(String password, String confirmPassword)
	{
		loadingWait(fpwPasswordTextbox);
		fpwPasswordTextbox.sendKeys(password);
		clickableWait(btnOtpContinue);
		fpwConfirmPasswordTextbox.sendKeys(confirmPassword);
		clickableWait(btnOtpContinue);
		btnOtpContinue.click();
	}

	// error messages
	public String getError(WebElement element) {
		loadingWait(element);
		String getError = element.getText();
		return getError;
	}

	// click
	public void click(WebElement element) {
		loadingWait(element);
		element.click();
	}

	//displayed
	public boolean displayed(WebElement element) {
		return element.isDisplayed();
	}

	
}
