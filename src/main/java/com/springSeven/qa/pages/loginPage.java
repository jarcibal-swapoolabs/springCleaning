package com.springSeven.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.springSeven.qa.base.testBase;

public class loginPage extends testBase{

	public loginPage()
	{
		PageFactory.initElements(driver, this);
	}

	//Elements
	//header
	@FindBy(xpath="//h1[@title='Sign In']")
	WebElement loginHeader;
	
	//textbox
	@FindBy(id="LOGIN_emailUsername")
	WebElement loginUsername;

	@FindBy(id="LOGIN_password")
	WebElement loginPassword;

	//button
//	@FindBy(css="button[type='button'][class='primary waves-effect waves-light btn-large Button__button___3vjDD Button__primary___Dv0Je']")
//	@FindBy(xpath="//button[contains(text(),'LOGIN)]")
	@FindBy(xpath="//button[@class='primary waves-effect waves-light btn-large Button__button___3vjDD Button__primary___Dv0Je']")
	public WebElement loginButton;
		
	@FindBy(xpath="//a[@class='Login__link___1CSRI']")
	WebElement loginForgotPassword;
	
	@FindBy(linkText="Report Now")
	WebElement loginReportNow;
	
	
	//error
//	@FindBy(xpath="//div[contains(text(),'Please provide an email or username')]")
	@FindBy(xpath="//*[@id=\"app\"]/div/div/div[2]/div/div/div/div/form/div[1]/div/div")
	WebElement usernameError;

//	@FindBy(xpath="//div[contains(text(),'Please provide a password')]")
	@FindBy(xpath="//*[@id=\"app\"]/div/div/div[2]/div/div/div/div/form/div[2]/div/div")
	WebElement passwordError;

//	@FindBy(css="div[class='alert-content-wrapper']")
	@FindBy(xpath="//*[contains(text(),'Please provide a valid email/username and password')]")
	public WebElement loginFailedErrorMessage;
	
	//loading
	@FindBy(xpath="//p[contains(text(),'Page is loading')]")
	public WebElement loadingElement;

	
	//actions
	//sendkeys
	public void updateUsername(String input) {
		loginUsername.sendKeys(input);
	}
	
	public void updatePassword(String input) {
		loginPassword.sendKeys(input);
	}
	

		
	public void inputCredential(String un, String pw) 
	{
		loginUsername.sendKeys(un);
		loginPassword.sendKeys(pw);
		loginButton.click();
		}

	
	public homePage login(String un, String pw) 
	{
		loginUsername.sendKeys(un);
		loginPassword.sendKeys(pw);
		loginButton.click();
		return new homePage();
		}
	
	
	public String validateLoginPageTitle()
	{
		String validateLoginPageTitle = loginHeader.getText();
		return validateLoginPageTitle;
	}

	public String getUsernameError()
	{
		String getUsernameError = usernameError.getText();
		return getUsernameError;
	}

	public String getPasswordError()
	{
		String getPasswordError = passwordError.getText();
		return getPasswordError;
	}
	
	public String getIncorrectCredentialsError()
	{
		String getIncorrectCredentialsError = loginFailedErrorMessage.getText();
		return getIncorrectCredentialsError;
	}
	
	//click
	public void loginClick() 
	{
		loginButton.click();
		
	}

	public forgotPasswordPage fpwClick()
	{
		loginForgotPassword.click();
		return new forgotPasswordPage();
	}
	
	//displayed
	public boolean redirectLogin() {
		return loginButton.isDisplayed();
	}
	
	

	
}
