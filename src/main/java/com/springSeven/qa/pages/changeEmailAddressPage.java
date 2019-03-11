package com.springSeven.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.springSeven.qa.base.testBase;

public class changeEmailAddressPage extends testBase{
	public changeEmailAddressPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//title
	@FindBy(xpath="//h1[@title='Change Email Address']")
	public WebElement changeEmailAddressPageTitle;

	//textbox
	@FindBy(id="ACCOUNT_PASSWORD_password")
	WebElement passwordTextbox;
	
	@FindBy(id="ONE_TIME_PASSWORD_verificationCode")
	WebElement otpTextbox;
	
	@FindBy(xpath="//div[@class='Select-value']")
	WebElement countryCodeTextbox;

	@FindBy(id="NEW_MOBILE_mobileNumber")
	WebElement newMobileTextbox;

	@FindBy(id="ONE_TIME_PASSWORD_NEW_verificationCode")
	WebElement otpNewTextbox;

	//button
	@FindBy(xpath="//span[contains(text(),'Continue')]")
	WebElement continueButton;
		
	@FindBy(xpath="//button[text()='Resend']")
	WebElement resendOTPButton;
	
	@FindBy(xpath="//span[text()='Submit']")
	WebElement submitButton;
	

	//error
	@FindBy(xpath="//div[@class='helper-text error-message']")
	WebElement passwordErrorMessage;


	//actions
	public String getchangeEmailAddressPageTitle()
	{
		String getchangeEmailAddressPageTitle = changeEmailAddressPageTitle.getText();
		return getchangeEmailAddressPageTitle;
	}
	
	//click
	public void clickContinue()
	{
		continueButton.click();
	}
	
	public void clickResendOTP()
	{
		resendOTPButton.click();
	}

	public void clickSubmit()
	{
		submitButton.click();
	}

	//input
	public void updatePasswordTextbox(String input) 
	{
		passwordTextbox.sendKeys(input);
	}

	public void updateotpTextbox(String input) 
	{
		otpTextbox.sendKeys(input);
	}

	public void updateCountryCodeTextbox(String input) 
	{
		countryCodeTextbox.sendKeys(input);
	}

	public void updateNewMobileTextbox(String input) 
	{
		newMobileTextbox.sendKeys(input);
	}

	public void updateotpNewTextbox(String input) 
	{
		otpNewTextbox.sendKeys(input);
	}
	
	
	//error messages

	public String getPasswordTextboxError()
	{
		String getPasswordTextboxError = passwordErrorMessage.getText();
		return getPasswordTextboxError;
	}

	//get title
	public String getChangeEmailPageTitle()
	{
		String getChangeEmailPageTitle = changeEmailAddressPageTitle.getText();
		return getChangeEmailPageTitle;
	}

}
