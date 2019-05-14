package com.springSeven.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.springSeven.qa.base.testBase;

public class payoutsPage extends testBase{
	public payoutsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//element
	@FindBy(xpath="//h1[@title='ENROLLMENT TREE']")
	public WebElement payoutsPageTitle;

	//action
	public String getPayoutsPageTitle()
	{
		String getPayoutsPageTitle = payoutsPageTitle.getText();
		return getPayoutsPageTitle;
	}
	
	
}
