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
		loadingWait(productsPage.productPageTitle);
}
	
	@Test
	public void validateProductsPageTitle(){
		waitForPageLoaded();
		header = productsPage.getProductPageTitle();
		Assert.assertEquals(header, "Product Catalog");
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
