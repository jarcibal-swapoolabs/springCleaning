package com.springSeven.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.springSeven.qa.base.testBase;

public class productsPage extends testBase{
	public productsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//element
	@FindBy(xpath="//h1[@title='Product Catalog']")
	public WebElement productPageTitle;

	//action
	public String getProductPageTitle()

	{
		String getProductPageTitle = productPageTitle.getText();
		return getProductPageTitle;
	}
	
	
}
