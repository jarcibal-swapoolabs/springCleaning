package com.springCleaning.qa.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.springCleaning.qa.base.testBase;
import com.springCleaning.qa.pages.registrationPage;
import com.springCleaning.qa.util.testUtil;

public class registrationPageTest extends testBase {

	registrationPage registrationPage;
	String errorMessage;
	String pwStrength;
	testUtil testUtil;

	public registrationPageTest() {
		super();
	}

	@Test
	public void validateRegistrationPageTitle() {
		registrationPage = new registrationPage(driver);
		processing();
		String header = registrationPage.getRegistrationPageTitle();
		Assert.assertEquals(header, "Register Now!");
	}


	@Test
	public void validateInvalidEmailFormat() 
	{
		registrationPage = new registrationPage(driver);
		processing();
		registrationPage.inputEmail("jarcibal");
		errorMessage = registrationPage.getError(registrationPage.emailErrorOne);
		Assert.assertEquals(errorMessage, "Please provide a valid email address format");
	}
	
	@Test
	public void validateNoEmail() 
	{
		registrationPage = new registrationPage(driver);
		processing();
		registrationPage.click(registrationPage.emailTextbox);
		registrationPage.click(registrationPage.registerButton);
		errorMessage = registrationPage.getError(registrationPage.emailErrorTwo);
		Assert.assertEquals(errorMessage, "Please provide an email address");
	}

	
	@Test
	public void validateValidEmail() 
	{
		registrationPage = new registrationPage(driver);
		processing();
		registrationPage.inputEmail("smileys010@gmail.com");
		loadingWait(registrationPage.emailIsUnique);
		errorMessage = registrationPage.getEmailIsUnique();
		Assert.assertEquals(errorMessage, "done Email is unique");
	}
	
}
