package com.springSeven.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.springSeven.qa.base.testBase;

public class homePage extends testBase{

	

	public homePage()
	{
		PageFactory.initElements(driver, this);
	}

	//elements
	@FindBy(xpath="//h1[@class='Banner__welcome___8TBlX']")
	public WebElement swapooHeader;

	@FindBy(xpath="//div[@class='main']")
	public WebElement swapooIconGetName;
	
	@FindBy(xpath="//div[@class='NavBarButton__label___1z5t0 NavBarButton__swapoo-label___2vAYg']")
	public WebElement swapooLinkHeader;
		
	@FindBy(xpath="//button[@class='waves-effect waves-light btn btn-large btn-floating']")
	public WebElement swapooLinkFooter;

	//security questions prompt
	@FindBy(xpath="//a[@href='/settings/setup-security-qeustions']")
	public WebElement securityQuestionsPromptOK;
	
	@FindBy(xpath="//button[@class='waves-effect waves-green btn-flat']")
	public WebElement securityQuestionsPromptLater;

	
	//link
	@FindBy(xpath="//span[contains(text(),'PRODUCTS')]")
	public	WebElement productsLink;

	@FindBy(xpath="//span[contains(text(),'TEAM')]")
	public WebElement teamLink;

	@FindBy(xpath="//span[contains(text(),'ACCOUNT')]")
	public WebElement accountLink;

	@FindBy(xpath="//span[contains(text(),'LOGOUT')]")
	public WebElement logoutLink;
	
	@FindBy(xpath="//i[contains(text(),'notifications_active')]")
	public WebElement notificationsLink;

	@FindBy(xpath="//div[text()='ENROLLMENT TREE']")
	public WebElement enrollmentTreeLink;

//	@FindBy(xpath="//class[contains(text(),'PROFILE')]")
	@FindBy(xpath="//i[contains(text(),'perm_identity')]")
	public	WebElement profileLink;

	
	@FindBy(xpath="//div[text()='SETTINGS']")
	public WebElement settingsLink;

	//loading
	@FindBy(xpath="//p[contains(text(),'Page is loading')]")
	public WebElement loadingElement;

	
	//action
	public String getHeader() {
		loadingWait(swapooHeader);
		return swapooHeader.getText();
	}

	
	public String validateSwapooHomepage(WebElement element) {
		loadingWait(swapooLinkHeader);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		loadingWait(swapooIconGetName);
		return swapooIconGetName.getText();
	}


	//action / pages
	public void clickOnAccountLink(){
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", accountLink);
	}

	public profilePage clickOnProfileLink(){
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", profileLink);
		return new profilePage();
	}


	public productsPage clickOnProductsLink(){
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", productsLink);
		return new productsPage();
		
	}
	
	public enrollmentTreePage clickOnEnrollmentLink(){
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", teamLink);
		executor.executeScript("arguments[0].click();", enrollmentTreeLink);
		return new enrollmentTreePage();
	}
	

	public settingsPage clickOnSettingsLink(){
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", settingsLink);
		return new settingsPage();
	}


	public void clickOnLogoutLink(){
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", logoutLink);
		processing();

	}
	
	//displayed
	public boolean logoutDisplayed() {
		return logoutLink.isDisplayed();
	}



	
	
}


