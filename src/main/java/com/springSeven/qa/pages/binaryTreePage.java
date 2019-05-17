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

	@FindBy(xpath="//div[@class='BinaryTreeBreadCrumbs__bread-crumb-label___18sHe']")
	public WebElement binarytTreeUsername;
	

	//textbox
	@FindBy(xpath="//span[@id='react-select-10--value']")
	public WebElement searchUsernameTextbox;


	@FindBy(id = "BINARY_TREE_CONFIRMATION_confirmationCode")
	public WebElement confirmTetxbox;

	
	//error
	@FindBy(xpath="//div[@class='helper-text error-message RenderSelect__helper-text___2J_a0 RenderSelect__error-message___18k9D']")
	public WebElement binaryTreeError;	

	@FindBy(xpath="//div[@class='helper-text error-message']")
	public WebElement confirmError;	
	

	//dropdown
	@FindBy(xpath="//button[@class='btn primary waves-effect waves-light BinaryNodeForm__add-btn___1U0bT']")
	public WebElement selectMemberDropdown;
	
	
	//button
	@FindBy(xpath="//button[@class='btn primary waves-effect waves-light BinaryNodeForm__add-btn___1U0bT']")
	public WebElement binaryAddButton;


	@FindBy(xpath="//button[@type='submit']")
	public WebElement submitConfirmButton;

	//dropdown
	@FindBy(xpath="//span[@id='react-select-3--value']")
	public WebElement memberdropdown;

	//action
	public String getBinarytTreePageTitle()
	{
		loadingWait(binarytTreePageTitle);
		String getBinarytTreePageTitle = binarytTreePageTitle.getText();
		return getBinarytTreePageTitle;
	}
	
	public String getUsername()
	{
		loadingWait(binarytTreeUsername);
		String getUsername = binarytTreeUsername.getText();
		return getUsername;
	}
	
	public String getBinaryTreeError()
	{
		loadingWait(binaryTreeError);
		String getBinaryTreeError = binaryTreeError.getText();
		return getBinaryTreeError;
	}

}
