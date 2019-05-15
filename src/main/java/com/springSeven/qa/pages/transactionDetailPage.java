package com.springSeven.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.springSeven.qa.base.testBase;

public class transactionDetailPage extends testBase{
	public transactionDetailPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//element
	@FindBy(xpath="//div[@class='thank-you-message']")
	public WebElement transactionDetailPageTitle;

	//action
	public String getTransactionDetailPageTitle()
	{
		String getTransactionDetailPageTitle = transactionDetailPageTitle.getText();
		return getTransactionDetailPageTitle;
	}
	
	
}
