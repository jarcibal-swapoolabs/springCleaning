package com.SpringSeven.qa.testcases;

import java.net.MalformedURLException;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.springSeven.qa.base.testBase;
import com.springSeven.qa.pages.homePage;
import com.springSeven.qa.pages.initialPage;
import com.springSeven.qa.pages.loginPage;
import com.springSeven.qa.pages.binaryTreePage;
import com.springSeven.qa.util.testUtil;



public class binaryTreePageTest extends testBase{
	 initialPage  initialPage;
	 loginPage loginPage; 
	 homePage homePage;
	 testUtil testUtil;
	 String header;
	 binaryTreePage binaryTreePage;
	 
	public binaryTreePageTest(){
		super();
	}
		
	
	@BeforeMethod
	public void setUp() throws MalformedURLException
	{
		initialization();		
		testUtil = new testUtil();
		initialPage = new initialPage();
		loginPage = initialPage.loginClick();		
		loadingWait(loginPage.loginButton);

		homePage = loginPage.login("clarence.layba@swapoolabs.com","mksoft_password");
		tryCatch(homePage.loadingElement,homePage.securityQuestionsPromptLater);

		binaryTreePage = homePage.clickOnBinaryTreeLink();
		loadingWait(binaryTreePage.binarytTreePageTitle);
	}
	
	@Test
	public void validateBinaryTreePageTitle(){
		header = binaryTreePage.getBinarytTreePageTitle();
		Assert.assertEquals(header, "BINARY TREE");
	}

	@Test
	public void validateBinaryTreeUsername(){
		header = binaryTreePage.getUsername();
		Assert.assertEquals(header, "beth_logan");
	}

	
	@Test
	public void validateBlankTextonAdd(){
		binaryTreePage.binaryAddButton.click();
		String error = binaryTreePage.getBinaryTreeError();
		Assert.assertEquals(error, "This field is required");
	}

	@Test
	public void validateAddaMemberPromptAppear(){
		binaryTreePage.memberdropdown.click();
		binaryTreePage.memberdropdown.sendKeys(Keys.ENTER);
		binaryTreePage.binaryAddButton.click();
		loadingWait(binaryTreePage.confirmTetxbox);
		String error = binaryTreePage.getBinaryTreeError();
		Assert.assertEquals(error, "This field is required");
	}

	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}


}
