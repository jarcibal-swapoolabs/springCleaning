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
import com.springSeven.qa.pages.profilePage;
import com.springSeven.qa.util.testUtil;

public class profilePageTest extends testBase{
	 initialPage  initialPage;
	 loginPage loginPage; 
	 homePage homePage;
	 profilePage profilePage;
	 testUtil testUtil;
	 
	public profilePageTest(){
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
		
//		homePage = loginPage.login("clarence.layba@swapoolabs.com","mksoft_password");
//		loadingWait(homePage.loadingElement);
		homePage = loginPage.login("jhesed.tacadena@swapoolabs.com","superstrongpassword");
		tryCatch(homePage.loadingElement,homePage.securityQuestionsPromptLater);
		
		homePage.clickOnAccountLink();
		loadingWait(homePage.profileLink);
		
		profilePage = homePage.clickOnProfileLink();
		loadingWait(profilePage.profilePageTitle);
	}

	@Test
	public void validateProfilePageTitle() {
		String header = profilePage.getProfilePageTitle();
		Assert.assertEquals(header, "Profile");
	}
	
	
	@Test
	public void validateReferralLinkIncorrectFormat(){
		profilePage.inputEmail("jericho-yahoo.com");
		String errorMessage = profilePage.getEmailError();
		Assert.assertEquals(errorMessage, "Please provide a valid email address format");
	}

	@Test
	public void validateReferralLinkDuplicateEmail(){
		profilePage.inputEmail("smileys001@yahoo.com,smileys001@yahoo.com");
		String errorMessage = profilePage.getEmailError();
		Assert.assertEquals(errorMessage, "Duplicate emails found");
	}

	
	@Test
	public void validateReferralLinkElevenEmail(){
		profilePage.inputEmail("smileys001@yahoo.com,smileys002@yahoo.com,smileys003@yahoo.com,smileys004@yahoo.com,smileys005@yahoo.com,smileys006@yahoo.com,smileys007@yahoo.com,smileys008@yahoo.com,smileys009@yahoo.com,smileys010@yahoo.com,smileys011@yahoo.com");
		loadingWait(profilePage.emailError);
		String errorMessage = profilePage.getEmailError();
		Assert.assertEquals(errorMessage, "Provide only up to ten emails");
	}

	
	@Test
	public void validateReferralOwnEmail(){
		profilePage.inputEmail("clarence.layba@swapoolabs.com");
		profilePage.inputEmail("jhesed.tacadena@swapoolabs.com");
		String errorMessage = profilePage.getEmailError();
		Assert.assertEquals(errorMessage, "Cannot send email to self");
	}

	
	@Test
	public void validateReferralExistingEmail(){
		profilePage.inputEmail("marvin.labrador@swapoolabs.com");
		String errorMessage = profilePage.getEmailError();
		Assert.assertEquals(errorMessage, "This email already exists");
	}
	
	@Test
	public void validateReferralLinkNoEmail(){
		String errorMessage = profilePage.getBlankError();
		Assert.assertEquals(errorMessage, "");
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}


}
