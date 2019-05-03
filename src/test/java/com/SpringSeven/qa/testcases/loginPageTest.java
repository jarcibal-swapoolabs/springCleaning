package com.SpringSeven.qa.testcases;


import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import com.springSeven.qa.pages.loginPage;
import com.springSeven.qa.base.testBase;
import com.springSeven.qa.pages.homePage;
import com.springSeven.qa.pages.initialPage;
import com.springSeven.qa.util.testUtil;



public class loginPageTest extends testBase{
	loginPage loginPage;
	homePage homePage;
	String errorMessage;
	initialPage initialPage;
	testUtil testUtil;
	
	
	String sheetName = "users";
	
	public loginPageTest(){
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
	}
	

	@Test
	public void validateLoginPageTitle(){
		String header = loginPage.validateLoginPageTitle();
		Assert.assertEquals(header, "Sign In");
	}
	
	@Test
	public void validateFailedLoginIncorrectUN()
	{
		loginPage.inputCredential("smileys009@yahoo.com","mksoft_password");
		loadingWait(loginPage.loginFailedErrorMessage);
		errorMessage = loginPage.getIncorrectCredentialsError();
		Assert.assertEquals(errorMessage, "Please provide a valid email/username and password");
	}

	
	@Test
	public void validateFailedLoginIncorrectPWOne() 
	{
		loginPage.inputCredential("clarence.layba@swapoolabs.com","pass");
		loadingWait(loginPage.loginFailedErrorMessage);
		errorMessage = loginPage.getIncorrectCredentialsError();
		Assert.assertEquals(errorMessage, "Please provide a valid email/username and password");
	}

	public void validateFailedLoginIncorrectPWTwo() 
	{
		loginPage.inputCredential("beth_logan","pass");
		loadingWait(loginPage.loginFailedErrorMessage);
		errorMessage = loginPage.getIncorrectCredentialsError();
		Assert.assertEquals(errorMessage, "Please provide a valid email/username and password");
	}

	@Test
	public void validateLoginWorksOne() {
		//homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage = loginPage.login("clarence.layba@swapoolabs.com","mksoft_password");
		loadingWait(homePage.logoutLink);
		Assert.assertTrue(homePage.logoutDisplayed());
	}
	
	@Test
	public void validateLoginWorksTwo() {
		homePage = loginPage.login("beth_logan","mksoft_password");
		loadingWait(homePage.logoutLink);
		Assert.assertTrue(homePage.logoutDisplayed());
	}

	//not in testcase
	@Test
	public void validateLoginErrorMessageBlankUsernameOne(){
		loginPage.inputCredential("","");
		errorMessage = loginPage.getUsernameError();
		Assert.assertEquals(errorMessage, "Please provide an email or username");
	}
	
	public void validateLoginErrorMessageBlankUsernameTwo(){
		loginPage.inputCredential("","mksoft_password");
		errorMessage = loginPage.getUsernameError();
		Assert.assertEquals(errorMessage, "Please provide an email or username");
	}
	
	@Test
	public void validateLoginErrorMessageBlankPasswordOne(){
		loginPage.inputCredential("","");
		errorMessage = loginPage.getPasswordError();
		Assert.assertEquals(errorMessage, "Please provide a password");
	}
	
	@Test
	public void validateLoginErrorMessageBlankPasswordTwo(){
		loginPage.inputCredential("clarence.layba@swapoolabs.com","");
		errorMessage = loginPage.getPasswordError();
		Assert.assertEquals(errorMessage, "Please provide a password");
	}

	@Test
	public void validateLoginErrorMessageBlankPasswordThree(){
		loginPage.inputCredential("beth_logan","");
		errorMessage = loginPage.getPasswordError();
		Assert.assertEquals(errorMessage, "Please provide a password");
	}

	@Test
	public void validateFailedLoginWorks() 
	{
		loginPage.inputCredential("jabroni@yahoo.com","pass");
		loadingWait(loginPage.loginFailedErrorMessage);
		errorMessage = loginPage.getIncorrectCredentialsError();
		Assert.assertEquals(errorMessage, "Please provide a valid email/username and password");
	}



	
//	@DataProvider
//	public Object[][] getTestData(){
//		Object data[][] = testUtil.getTestData(sheetName);
//		return data;
//	}
//	
//	@Test(dataProvider="getTestData")
//	public void jabroni(String username, String password)
//	{
//		loginPage.updateUsername(username);
//		loginPage.updatePassword(password);	
//		loginPage.loginClick();
//		errorMessage = loginPage.getPasswordError();
//		Assert.assertEquals(errorMessage, "Please provide a password");
//	}

	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}  
