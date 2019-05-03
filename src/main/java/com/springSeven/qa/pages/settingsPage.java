package com.springSeven.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.springSeven.qa.base.testBase;

public class settingsPage extends testBase{
	
	public settingsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[@title='SETTINGS']")
	public WebElement settingsPageTitle;
	
	@FindBy(id="ACCOUNT_PASSWORD_password")
	WebElement reportPassword;

	@FindBy(xpath="//a[contains(@href,'/settings/change-mobile-number')]")
	WebElement changeMobileNumberLink;

	@FindBy(xpath="//a[contains(@href,'/settings/change-email-address')]")
	WebElement changeEmailLink;

	@FindBy(xpath="//a[contains(@href,'/settings/change-account-password')]")
	WebElement changePasswordLink;

	@FindBy(xpath="//a[contains(@href,'settings/setup-security-questions')]")
	WebElement setupSecurityQuestionsLink;

	//link
	@FindBy(xpath="//text()[.='My Account is Compromised']/ancestor::a[1]")
	public WebElement reportAccountLink;

	@FindBy(xpath="//span[text()='VERIFY']")
	public WebElement reportAccountVerify;
	
	@FindBy(xpath="//span[text()='CANCEL']")
	public WebElement reportAccountCancel;
	
	//buton
	@FindBy(xpath="//span[text()='CONFIRM']")
	//@FindBy(xpath="//button[@type='submit']")
	public WebElement reportAccountConfirm;
	
	@FindBy(xpath="//span[text()='Ok']")
	public WebElement reportAccountOk;
	
	//error
	@FindBy(xpath="//div[@class='helper-text error-message']")
	public WebElement reportPasswordError;
	

	//icon
	@FindBy(xpath="//i[text()='warning']")
	public WebElement confirmIcon;


	public void updateReportAccountTextbox(String input) 
	{
		reportPassword.sendKeys(input);
	}

	public String getErrorReportAccountPassword()
	{
		String getErrorReportAccountPassword = reportPasswordError.getText();
		return getErrorReportAccountPassword;
	}
	

	public String getSettingsPageTitle()
	{
		String getSettingsPageTitle = settingsPageTitle.getText();
		return getSettingsPageTitle;
	}

	//redirect
	public changeMobileNumberPage clickOnChangeMobileNumberPageLink(){
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", changeMobileNumberLink);
		return new changeMobileNumberPage();
	}

	public changeEmailAddressPage clickOnchangeEmailAddressPageLink(){
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", changeEmailLink);
		return new changeEmailAddressPage();
	}

	public changePasswordPage changePasswordPageLink(){
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", changePasswordLink);
		return new changePasswordPage();
	}

	public setupSecurityQuestionsPage setupSecurityQuestionsPageLink(){
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", setupSecurityQuestionsLink);
		return new setupSecurityQuestionsPage();
	}

	public void clickReportConfirm()
	{
		reportAccountConfirm.click();
//		JavascriptExecutor executor = (JavascriptExecutor)driver;
//		executor.executeScript("arguments[0].click();", reportAccountConfirm);
	}
	
	public void clickReportOk()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", reportAccountOk);
	}

	
	//clean
	//input Email
	public void inputPassword(String pass)
	{
		reportAccountLink.click();
		reportPassword.sendKeys(pass);
		reportAccountVerify.click();
	}

	
}
