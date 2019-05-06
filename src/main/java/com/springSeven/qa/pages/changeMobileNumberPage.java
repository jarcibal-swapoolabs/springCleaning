package com.springSeven.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.springSeven.qa.base.testBase;

public class changeMobileNumberPage extends testBase {
	public changeMobileNumberPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//title
	@FindBy(xpath="//h1[@title='Change Mobile Number']")
	public WebElement changeMobileNumberPageTitle;

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
//	@FindBy(xpath="//span[contains(text(),'Continue')]")
	@FindBy(xpath="//span[text()='CONTINUE']")
	WebElement continueButton;
		
	@FindBy(xpath="//button[text()='Resend']")
	WebElement resendOTPButton;
	
	@FindBy(xpath="//span[text()='Submit']")
	WebElement submitButton;
	

	//error
	@FindBy(xpath="//div[@class='helper-text error-message']")
	public WebElement passwordErrorMessage;


	//actions
	public String getchangeMobileNumberPageTitle()
	{
		String getchangeMobileNumberPageTitle = changeMobileNumberPageTitle.getText();
		return getchangeMobileNumberPageTitle;
	}
	
	//input
	public void updatePasswordTextbox(String input) 
	{
		passwordTextbox.sendKeys(input);
		continueButton.click();
	}

	public void updateotpTextbox(String input) 
	{
		otpTextbox.sendKeys(input);
		continueButton.click();
	}

	public void updateCountryCodeTextbox(String input) 
	{
		countryCodeTextbox.sendKeys(input);
		continueButton.click();
	}

	public void updateNewMobileTextbox(String input) 
	{
		newMobileTextbox.sendKeys(input);
		continueButton.click();
	}

	public void updateotpNewTextbox(String input) 
	{
		otpNewTextbox.sendKeys(input);
		continueButton.click();
	}
	
	
	//error messages

	public String getPasswordTextboxError()
	{
		String getPasswordTextboxError = passwordErrorMessage.getText();
		return getPasswordTextboxError;
	}
	
	//get title
	public String getChangeMobilePageTitle()
	{
		String getChangeMobilePageTitle = changeMobileNumberPageTitle.getText();
		return getChangeMobilePageTitle;
	}

}
