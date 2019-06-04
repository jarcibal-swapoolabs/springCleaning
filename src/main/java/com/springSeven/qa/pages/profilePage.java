package com.springSeven.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.springSeven.qa.base.testBase;

public class profilePage extends testBase{
	public profilePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//elements	
	@FindBy(xpath="//h1[@title='Profile']")
	public WebElement profilePageTitle;

	//	@FindBy(xpath="//span[text()='Edit']")
	@FindBy(xpath="//a[@class='edit-profile-link right valign-wrapper']")
	public WebElement editProfileLink;
	
	//textbox
	@FindBy(id="SEND_REFERRAL_EMAIL_FORM_tempEmails")
	public WebElement shareEmailTextbox;

	@FindBy(xpath="//div[@class='floating-blocker']")
	public WebElement signupLinkTextbox;
	
	
	//button
	@FindBy(id="clipboard-btn")
	public WebElement copyButon;

	@FindBy(xpath="//button[@class='waves-effect waves-light btn right Button__button___3vjDD Button__primary___Dv0Je']")
	public WebElement sendEmailButton;

	//loading
	@FindBy(xpath="//p[contains(text(),'Page is loading')]")
	public WebElement loadingElement;
		
	//error
	@FindBy(xpath="//div[@class='helper-text error-message']")
	public WebElement emailError;

	@FindBy(xpath="//div[contains(text(),'This field is required')][2]")
//	@FindBy(xpath="//div[@class='helper-text error-message']")
	public WebElement blankError;
	
	//action
	public String getProfilePageTitle()
	{
		String getProfilePageTitle = profilePageTitle.getText();
		return getProfilePageTitle;
	}
	
	public editProfilePage clickonEditProfileLink(){
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", editProfileLink);
		return new editProfilePage();
	}

	//input Email
	public void inputEmail(String mail)
	{
		shareEmailTextbox.sendKeys(mail);
		sendEmailButton.click();
		loadingWait(emailError);

	}

	public void copyLink()
	{
		loadingWait(signupLinkTextbox);
		String signupLink = signupLinkTextbox.getText();
		driver.get(signupLink);
	}

	
	
	//get error
	public String getEmailError()
	{
		
		String getEmailError = emailError.getText();
		return getEmailError;
	}

	public String getBlankError()
	{
		sendEmailButton.click();
		String getEmailError = blankError.getText();
		return getEmailError;
	}
	
}
