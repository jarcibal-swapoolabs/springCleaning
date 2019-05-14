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
	
	//elements
	@FindBy(xpath="//h1[text()='PURCHASE HISTORY']")
	WebElement purchaseHistoryPageTitle;
	
	//button
	@FindBy(xpath="//a[href='/products']")
	WebElement purchaseButton;


	
	//action
	public String getpurchaseHistoryPageTitle()
	{
		String getpurchaseHistoryPageTitle = purchaseHistoryPageTitle.getText();
		return getpurchaseHistoryPageTitle;
	}
	



}
