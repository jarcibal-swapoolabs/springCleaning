package com.SpringSeven.qa.testcases;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.springSeven.qa.base.testBase;
import com.springSeven.qa.pages.homePage;
import com.springSeven.qa.pages.loginPage;
import com.springSeven.qa.pages.initialPage;
import com.springSeven.qa.pages.productsPage;
import com.springSeven.qa.util.testUtil;



public class homePageTest extends testBase{
	initialPage initialPage;
	loginPage loginPage;
	homePage homePage;
	productsPage productsPage;
	testUtil testUtil;
	
	public homePageTest(){
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
		processing();	
}
	
	
	@Test
	public void verifyLogout(){
		testUtil.JSClick(homePage.logoutLink);
		processing();
		boolean displayed = initialPage.initialPageLoginDisplayed();
		Assert.assertTrue(displayed);		
	}
	
	@Test
	public void verifySwapooHomepage() {
		String name = homePage.validateSwapooHomepage();
		Assert.assertEquals(name, "Ricardo Dalisay");	
	    }

	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
