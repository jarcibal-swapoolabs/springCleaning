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
import com.springSeven.qa.util.testUtil;
import com.springSeven.qa.pages.settingsPage;
import com.springSeven.qa.pages.setupSecurityQuestionsPage;

public class setupSecurityQuestionsPageTest extends testBase {
	initialPage initialPage;
	loginPage loginPage;
	testUtil testUtil;
	homePage homePage;
	settingsPage settingsPage;
	setupSecurityQuestionsPage setupSecurityQuestionsPage;

	public setupSecurityQuestionsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws MalformedURLException {
		initialization();
		testUtil = new testUtil();
		initialPage = new initialPage();
		loginPage = initialPage.loginClick();
		loadingWait(loginPage.loginButton);

//		homePage = loginPage.login("clarence.layba@swapoolabs.com","mksoft_password");
		homePage = loginPage.login("jhesed.tacadena@swapoolabs.com","superstrongpassword");
		tryCatch(homePage.loadingElement,homePage.securityQuestionsPromptLater);
		
		homePage.clickOnAccountLink();
		loadingWait(homePage.settingsLink);

		settingsPage = homePage.clickOnSettingsLink();
		loadingWait(settingsPage.settingsPageTitle);
		
		setupSecurityQuestionsPage = settingsPage.setupSecurityQuestionsPageLink();
		loadingWait(setupSecurityQuestionsPage.setupSecurityQuestionsPageTitle);
	}

	@Test
	public void validatesetupSecurityQuestionsPageTitle() {
		String header = setupSecurityQuestionsPage.getSetupSecurityQuestionsPageTitle();
		Assert.assertEquals(header, "Setup Security Questions");
	}

	@Test
	public void validateNotCurrentPW() {
		setupSecurityQuestionsPage.enterPW("");
		loadingWait(setupSecurityQuestionsPage.passwordErrorMessage);
		String errorMessage = setupSecurityQuestionsPage.getErrorCurrentPassword();
		Assert.assertEquals(errorMessage, "Please provide a password");
	}

	@Test
	public void validateIncorrectCurrentPW() {
	setupSecurityQuestionsPage.enterPW("password");
	loadingWait(setupSecurityQuestionsPage.passwordErrorMessage);
	String errorMessage = setupSecurityQuestionsPage.getErrorCurrentPassword();
		Assert.assertEquals(errorMessage, "Password is invalid");
	}

	@Test
	public void validateCorrectCurrentPW() {
		setupSecurityQuestionsPage.enterPW("superstrongpassword");
		loadingWait(setupSecurityQuestionsPage.submitButton);
		boolean submitBtnDisplayed = setupSecurityQuestionsPage.getCorrectCurrentPW();
		Assert.assertTrue(submitBtnDisplayed);
	}

//	@Test
//	public void validateSetupSecurityQuestionsPageWorks() {
//		setupSecurityQuestionsPage.getSuccessfullSetupSecurity("name?", "jericho", "address?", "pasay", "bad or wrong?","bad");
//		String header = settingsPage.getSettingsPageTitle();
//		Assert.assertEquals(header, "Settings");
//
//	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
