package com.springSeven.qa.pages;

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
	@FindBy(xpath="//div[text()='clarence layba']")
	public WebElement swapooIconGetName;
	
	@FindBy(xpath="//div[@class='NavBarButton__label___1z5t0 NavBarButton__swapoo-label___2vAYg']")
	public WebElement swapooLinkHeader;
		

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
	public String validateSwapooHomepage(){
		swapooLinkHeader.click();
		return swapooIconGetName.getText();
	}
	

	//action / pages
	public void clickOnAccountLink(){
		accountLink.click();
	}

	public profilePage clickOnProfileLink(){
		profileLink.click();
		return new profilePage();
	}


	public productsPage clickOnProductsLink(){
		productsLink.click();
		return new productsPage();
	}
	
	public enrollmentTreePage clickOnEnrollmentLink(){
		teamLink.click();
		enrollmentTreeLink.click();
//		JavascriptExecutor executor = (JavascriptExecutor)driver;
//		executor.executeScript("arguments[0].click();", teamLink);
//		executor.executeScript("arguments[0].click();", enrollmentTreeLink);
		return new enrollmentTreePage();
	}
	

	public settingsPage clickOnSettingsLink(){
		settingsLink.click();
		return new settingsPage();
	}

	
	//displayed
	public boolean logoutDisplayed() {
		return logoutLink.isDisplayed();
	}

	
	
}


