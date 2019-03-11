package com.SpringSeven.qa.testcases;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.springSeven.qa.pages.homePage;
import com.springSeven.qa.pages.initialPage;
import com.springSeven.qa.pages.loginPage;
import com.springSeven.qa.pages.settingsPage;
import com.springSeven.qa.util.testUtil;
import com.springSeven.qa.base.testBase;
import com.springSeven.qa.pages.changePasswordPage;

public class changePasswordPageTest extends testBase {
	initialPage initialPage;
	loginPage loginPage;
	homePage homePage;
	settingsPage settingsPage;
	changePasswordPage changePasswordPage;
	testUtil testUtil;

	public changePasswordPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException, MalformedURLException {
		initialization();
		testUtil = new testUtil();
		initialPage = new initialPage();
		loginPage = initialPage.loginClick();
		loadingWait(loginPage.loginButton);

		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		processing();
		
		homePage.clickOnAccountLink();
		loadingWait(homePage.settingsLink);

		settingsPage = homePage.clickOnSettingsLink();
		loadingWait(settingsPage.settingsPageTitle);
		
		changePasswordPage = settingsPage.changePasswordPageLink();
		loadingWait(changePasswordPage.changePasswordPageTitle);

	}

	@Test
	public void validateChangePasswordTitle(){
		String header = changePasswordPage.getchangePasswordPageTitle();
		Assert.assertEquals(header, "Change Password");
	}
	
	@Test
	public void validateIncorrectCurrentPW(){
		changePasswordPage.enterPW("password");
		loadingWait(changePasswordPage.oldPasswordError);
		String errorMessage = changePasswordPage.getErrorCurrentPassword();
		Assert.assertEquals(errorMessage, "Password is invalid");
	}

	@Test
	public void validateNoCurrentPW() {
		changePasswordPage.enterPW("");
		loadingWait(changePasswordPage.oldPasswordError);
		String errorMessage = changePasswordPage.getErrorCurrentPassword();
		Assert.assertEquals(errorMessage, "Please provide a password");
	}

	@Test
	public void validateNoNewPW() {
		changePasswordPage.enterPW("mksoft_password");
		loadingWait(changePasswordPage.submitButton);
		changePasswordPage.enterPW("","");
		String errorMessage = changePasswordPage.getErrorNewPassword();
		Assert.assertEquals(errorMessage, "Please provide a password");
	}

	@Test
	public void validateNoNewPWTwo(){
		changePasswordPage.enterPW("mksoft_password");
		loadingWait(changePasswordPage.submitButton);
		changePasswordPage.enterPW("","password");
		String errorMessage = changePasswordPage.getErrorNewPassword();
		Assert.assertEquals(errorMessage, "Please provide a password");
	}

	@Test
	public void validateNoConfirmPW(){
		changePasswordPage.enterPW("mksoft_password");
		loadingWait(changePasswordPage.submitButton);
		changePasswordPage.enterPW("","");
		String errorMessage = changePasswordPage.getErrorConfirmPassword();
		Assert.assertEquals(errorMessage, "Please confirm your password");
	}
	
	@Test
	public void validateNoConfirmPWTwo(){
		changePasswordPage.enterPW("mksoft_password");
		loadingWait(changePasswordPage.submitButton);
		changePasswordPage.enterPW("password","");
		String errorMessage = changePasswordPage.getErrorConfirmPassword();
		Assert.assertEquals(errorMessage, "Please confirm your password");
	}

	@Test
	public void validateNoNewPassword() {
		changePasswordPage.enterPW("mksoft_password");
		loadingWait(changePasswordPage.submitButton);
		changePasswordPage.enterPW("", "password");
		String errorMessage = changePasswordPage.getErrorNoNewPassword();
		Assert.assertEquals(errorMessage, "Passwords do not match");
	}

	@Test
	public void validateIncorrectNewCurrentPW() {
		changePasswordPage.enterPW("mksoft_password");
		loadingWait(changePasswordPage.submitButton);
		changePasswordPage.enterPW("pass", "password");
		loadingWait(changePasswordPage.confirmPasswordNotMatch);
		String errorMessage = changePasswordPage.getErrorNoNewPassword();
		Assert.assertEquals(errorMessage, "Passwords do not match");
	}
	
	
	@Test
	public void validatePWRankingBad(){
		changePasswordPage.enterPW("mksoft_password");
		loadingWait(changePasswordPage.submitButton);
		changePasswordPage.enterPW("makati","");
		loadingWait(changePasswordPage.newPasswordRanking);
		String ranking = changePasswordPage.getNewPasswordRanking();
		Assert.assertEquals(ranking, "BAD");
	}

	@Test
	public void validatePWRankingWorst(){
		changePasswordPage.enterPW("mksoft_password");
		loadingWait(changePasswordPage.submitButton);
		changePasswordPage.enterPW("makatisoft","");
		loadingWait(changePasswordPage.newPasswordRanking);
		String ranking = changePasswordPage.getNewPasswordRanking();
		Assert.assertEquals(ranking, "WEAK");
	}

	@Test
	public void validatePWRankinGood(){
	changePasswordPage.enterPW("mksoft_password");
	loadingWait(changePasswordPage.submitButton);
	changePasswordPage.enterPW("makatisoft0","");
	loadingWait(changePasswordPage.newPasswordRanking);
	String ranking = changePasswordPage.getNewPasswordRanking();
	Assert.assertEquals(ranking, "GOOD");
	}

	@Test
	public void validatePWRankinStrong(){
		changePasswordPage.enterPW("mksoft_password");
		loadingWait(changePasswordPage.submitButton);
		changePasswordPage.enterPW("makatisoft02","");
		loadingWait(changePasswordPage.newPasswordRanking);
		String ranking = changePasswordPage.getNewPasswordRanking();
		Assert.assertEquals(ranking, "STRONG");
	}

//	need better logic and separate account
//	@Test
//	public void validateChangePasswordWorks(){
//		changePasswordPage.enterPW("mksoft_password");
//		loadingWait(changePasswordPage.submitButton);
//		changePasswordPage.enterPW("makatisoft02","makatisoft02");
//		loadingWait(changePasswordPage.changePWOkButton);
//		changePasswordPage.changePWOkButton.click();
//		loadingWait(settingsPage.settingsPageTitle);
//		String header = settingsPage.getSettingsPageTitle();
//		Assert.assertEquals(header, "SETTINGS");
//		}
//
//		need better logic and separate account
//	@Test
//	public void validateChangePasswordWorksTwo(){
//		changePasswordPage.enterPW("makatisoft02");
//		loadingWait(changePasswordPage.submitButton);
//		changePasswordPage.enterPW("mksoft_password","mksoft_password");
//		loadingWait(changePasswordPage.changePWOkButton);
//		changePasswordPage.changePWOkButton.click();
//		loadingWait(settingsPage.settingsPageTitle);
//		String header = settingsPage.getSettingsPageTitle();
//		Assert.assertEquals(header, "SETTINGS");
//	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
