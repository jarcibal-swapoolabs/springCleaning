package com.SpringSeven.qa.testcases;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.springSeven.qa.base.testBase;
import com.springSeven.qa.pages.homePage;
import com.springSeven.qa.pages.initialPage;
import com.springSeven.qa.pages.loginPage;
import com.springSeven.qa.pages.productsPage;
import com.springSeven.qa.util.testUtil;


public class productsPageTest extends testBase{
	initialPage initialPage;
	loginPage loginPage;
	homePage homePage;
	productsPage productsPage;
	String header;
	testUtil testUtil;
	String errorMessage;
	
	
	public productsPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException, MalformedURLException
	{
		initialization();		
		testUtil = new testUtil();
		initialPage = new initialPage();
		loginPage = initialPage.loginClick();		
		loadingWait(loginPage.loginButton);
		homePage = loginPage.login("clarence.layba@swapoolabs.com","mksoft_password");
		tryCatch(homePage.loadingElement,homePage.securityQuestionsPromptLater);
		productsPage = homePage.clickOnProductsLink();
		clickableWait(productsPage.standardProductButton);
}
	
	@Test
	public void validateProductsPageTitle(){
		header = productsPage.getProductPageTitle();
		Assert.assertEquals(header, "Product Catalog");
	}
	
	
	@Test
	public void validateProductsPageBlankPassword(){
		productsPage.standardProductButton.click();
		productsPage.inputPassword("");
		errorMessage = productsPage.getIncorrectPasswordError();
		Assert.assertEquals(errorMessage, "Please provide a password");}


//	@Test
//	public void validateProductsPageIncorrectPassword(){
//		clickableWait(productsPage.standardProductButton);
//		productsPage.standardProductButton.click();
//		productsPage.inputPassword("pass");
//		errorMessage = productsPage.getIncorrectPasswordError();
//		Assert.assertEquals(errorMessage, "Please provide a password");
//		}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
