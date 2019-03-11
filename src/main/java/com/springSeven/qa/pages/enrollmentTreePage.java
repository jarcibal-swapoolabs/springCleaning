package com.springSeven.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.springSeven.qa.base.testBase;

public class enrollmentTreePage extends testBase{
	public enrollmentTreePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//element
	@FindBy(xpath="//h1[@title='ENROLLMENT TREE']")
	public WebElement enrollmentTreePageTitle;

	//action
	public String getenrollmentTreePageTitle()
	{
		String getenrollmentTreePageTitle = enrollmentTreePageTitle.getText();
		return getenrollmentTreePageTitle;
	}
	
	
}
