package com.springSeven.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.springSeven.qa.base.testBase;

public class purchaseHistoryPage extends testBase{
	public purchaseHistoryPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//h1[text()='Purchase History']")
	WebElement purchaseHistoryPageTitle;
	
	public String getpurchaseHistoryPageTitle()
	{
		String getpurchaseHistoryPageTitle = purchaseHistoryPageTitle.getText();
		return getpurchaseHistoryPageTitle;
	}
	



}
