package com.springSeven.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.springSeven.qa.base.testBase;

public class binaryTreePage extends testBase{
	public binaryTreePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//element
	@FindBy(xpath="//h1[@title='BINARY TREE']")
	public WebElement binarytTreePageTitle;

	//action
	public String getBinarytTreePageTitle()
	{
		String getBinarytTreePageTitle = binarytTreePageTitle.getText();
		return getBinarytTreePageTitle;
	}
	
	
}
