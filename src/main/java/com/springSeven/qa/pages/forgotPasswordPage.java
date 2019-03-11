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
	
	//button
	@FindBy(id="submitBtn")
	public WebElement btnContinue;

	@FindBy(xpath="//a[@class='waves-effect waves-dark btn grey back-btn Button__button___3vjDD']")
	public WebElement btnCancel;

	//error
	@FindBy(xpath="//div[@class='helper-text error-message']")
	public WebElement fpwErrorMessageEmail;

	//actions
	public String getForgotPasswordPageTitle()
	{
		String getForgotPasswordPageTitle = fpwHeader.getText();
		return getForgotPasswordPageTitle;
	}
	
	public void btnContinueClick()
	{
		btnContinue.click();
	}
	
	
	public void btnCancelClick()
	{
		btnCancel.click();
	}
	
	public String getfpwErrorWrongEmail()
	{
		
		String getfpwErrorWrongEmail = fpwErrorMessageEmail.getText();
		return getfpwErrorWrongEmail;
	}
	
	
	//input Email
	public void inputEmail(String mail)
	{
		fpwTextbox.sendKeys(mail);
		btnContinue.click();
	}

	
	
}
