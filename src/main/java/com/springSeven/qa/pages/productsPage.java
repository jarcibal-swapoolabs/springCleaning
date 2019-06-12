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


	//textbox
	@FindBy(id="PACKAGE_PURCHASE_password")
	public WebElement productsPasswordTextbox;


	//button
	@FindBy(xpath="//a[@class='btn btn-large roboto-medium primary waves-effect waves-light']")
	public WebElement standardProductButton;

	@FindBy(xpath="//span[contains(text(),'CONTINUE')]")
	public WebElement productsContinueButton;
	

	@FindBy(xpath="//span[contains(text(),'CANCEL')]")
	public WebElement productsCancelButton;

	@FindBy(xpath="//span[contains(text(),'CONFIRM')]")
	//@FindBy(xpath="//button[@type='submit']")
	public WebElement productsConfirmPurchaseButton;

	//error
	@FindBy(xpath="//div[@class='helper-text error-message']")
	public WebElement productPasswordTextboxError;

	
	//action
	public String getProductPageTitle()

	{
		loadingWait(productPageTitle);
		String getProductPageTitle = productPageTitle.getText();
		return getProductPageTitle;
	}
	
	//input
	public void inputPassword(String pw) 
	{
		loadingWait(productsPasswordTextbox);
		productsPasswordTextbox.sendKeys(pw);
		productsContinueButton.click();
		}

	//get error
	public String getIncorrectPasswordError()
	{
		loadingWait(productPasswordTextboxError);
		String getIncorrectPasswordError = productPasswordTextboxError.getText();
		return getIncorrectPasswordError;
	}

	//purchase
	public transactionDetailPage purchaseItem(String password)
	{
		clickableWait(standardProductButton);
		standardProductButton.click();
		inputPassword(password);
		clickableWait(productsConfirmPurchaseButton);
		productsConfirmPurchaseButton.click();
		return new transactionDetailPage();
	}
	
	
	//displayed
	public boolean displayed(WebElement element) {
		return element.isDisplayed();
	}
	
	// click
	public void click(WebElement element) {
		element.click();
	}

	
	
	
}
