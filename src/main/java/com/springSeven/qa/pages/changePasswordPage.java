package com.springSeven.qa.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.springSeven.qa.base.testBase;

public class changePasswordPage extends testBase{
	public changePasswordPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//elements
	@FindBy(xpath="//h1[@title='Change Password']")
	public WebElement changePasswordPageTitle;

	@FindBy(xpath="//div[@class='modal-content']//div[@class='modal-icon-success valign-wrapper']")
	WebElement changePWIcon;
	

	//textbox
	@FindBy(id="ACCOUNT_PASSWORD_oldPassword")
	WebElement oldPasswordTextbox;
	
	@FindBy(id="NEW_PASSWORD_newPassword")
	WebElement newPasswordTextbox;

	@FindBy(id="NEW_PASSWORD_newConfirmPassword")
	WebElement confirmPasswordTextbox;

	
	//button
	@FindBy(id="submit-btn")
	WebElement verifyButton;
	
	@FindBy(xpath="//text()[.='CANCEL']/ancestor::a[1]")
	WebElement cancelButton;

//	@FindBy(xpath="//text()[.='PREVIOUS']/ancestor::button[1]")
	@FindBy(xpath="//button[contains(text(),'PREVIOUS')]")
	WebElement previousButton;

	
	//@FindBy(xpath="//text()[.='SUBMIT']/ancestor::button[1]")
	@FindBy(xpath="//button[contains(text(),'SUBMIT')]")
	public WebElement submitButton;
	
	//@FindBy(xpath="//span[contains(text(),'Ok')]")
	@FindBy(xpath="//a[@class='modal-action modal-close waves-effect waves-green btn-flat active']")
	public WebElement changePWOkButton;
	
	

	//error
	@FindBy(xpath="//div[@class='helper-text error-message']")
	public List<WebElement> oldPasswordErrorList;
	
	
	@FindBy(xpath="//div[@class='helper-text error-message']")
	public WebElement oldPasswordError;
	
	@FindBy(xpath="//div[contains(text(),'Please provide a password')]")
	WebElement newPasswordError;

	@FindBy(xpath="//div[contains(text(),'Please confirm your password')]")
	WebElement confirmPasswordError;
		
	@FindBy(xpath="//div[contains(text(),'Passwords do not match')]")
	public WebElement confirmPasswordNotMatch;
	
	@FindBy(xpath="//div[@class='col s3 m2']")
	public WebElement newPasswordRanking;
	
	
	
	//actions
	public String getchangePasswordPageTitle()
	{
		String getchangePasswordPageTitle = changePasswordPageTitle.getText();
		return getchangePasswordPageTitle;
	}
	
	//enter password
	public void enterPW(String pw)
	{
		oldPasswordTextbox.sendKeys(pw);
		verifyButton.click();		
	}
	
	public void enterPW(String newPw, String confirmPw)
	{
		newPasswordTextbox.sendKeys(newPw);
		confirmPasswordTextbox.sendKeys(confirmPw);
		newPasswordTextbox.click();
		clickableWait(verifyButton);
		verifyButton.click();		
	}

	//get error
	public String getErrorCurrentPassword()
	{
		String getErrorCurrentPassword = oldPasswordError.getText();
		return getErrorCurrentPassword;
	}
	
	
	public String getErrorNewPassword()
	{
		String getErrorCurrentPassword = newPasswordError.getText();
		return getErrorCurrentPassword;
	}
	
	public String getErrorConfirmPassword()
	{
		String getErrorCurrentPassword = confirmPasswordError.getText();
		return getErrorCurrentPassword;
	}
	
	public String getErrorNoNewPassword()
	{
		String getErrorNewPassword = confirmPasswordNotMatch.getText();
		return getErrorNewPassword;
	}

	//password ranking
	public String getNewPasswordRanking()
	{
		String getNewPasswordRanking = newPasswordRanking.getText();
		return getNewPasswordRanking;
	}

	//success change
	public void getSuccessfullChangePW(String oldPassword, String newPassword, String confirmPassword)
	{
		oldPasswordTextbox.sendKeys(oldPassword);
		verifyButton.click();
		newPasswordTextbox.sendKeys(newPassword);
		confirmPasswordTextbox.sendKeys(confirmPassword);
		submitButton.click();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", changePWOkButton);
	}
	
	
	
	
}
