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

	//textbox
	//	@FindBy(xpath="//span[text()='Edit']")
	@FindBy(xpath="//a[@class='edit-profile-link right valign-wrapper']")
	public WebElement editProfileLink;

	//button
	@FindBy(id="clipboard-btn")
	public WebElement copyButon;

	//loading
	@FindBy(xpath="//p[contains(text(),'Page is loading')]")
	public WebElement loadingElement;
	
	
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


}
