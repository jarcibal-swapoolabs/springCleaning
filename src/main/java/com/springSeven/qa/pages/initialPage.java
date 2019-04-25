package com.springSeven.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.springSeven.qa.base.testBase;


public class initialPage extends testBase{
	
	
	
	@FindBy(xpath="//span[contains(text(),'LOGIN.')]")
	WebElement loginLinktext;

	
	public initialPage()
	{
		PageFactory.initElements(driver, this);
	}

	public String getLoginLinkText()
	{
		String loginLinkText = loginLinktext.getText();
		return loginLinkText;
	}

	
	public loginPage loginClick() 
	{
		loginLinktext.click();
		return new loginPage();
	}
	
	
	
	//displayed
	public boolean initialPageLoginDisplayed() {
		return loginLinktext.isDisplayed();
			}


}

