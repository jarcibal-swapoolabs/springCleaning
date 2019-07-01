package com.springCleaning.qa.testcases;


import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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

	@BeforeMethod
	public void setUp() throws MalformedURLException {		
		initialization();
		registrationPage = new registrationPage();
		processing();
}

	@Test
	public void validateRegistrationPageTitle(){
		String header = registrationPage.getRegistrationPageTitle();
		Assert.assertEquals(header, "Register Now!");
	}

	@Test
	public void validateNoEmail() 
	{
		registrationPage.click(registrationPage.emailTextbox);
		registrationPage.click(registrationPage.registerButton);
		errorMessage = registrationPage.getError(registrationPage.emailErrorTwo);
		Assert.assertEquals(errorMessage, "Please provide an email address");
	}

	
	@Test
	public void validateInvalidEmailFormat() 
	{
		registrationPage.inputEmail("jarcibal");
		errorMessage = registrationPage.getError(registrationPage.emailErrorOne);
		Assert.assertEquals(errorMessage, "Please provide a valid email address format");
	}

	@Test
	public void validateValidEmail() 
	{
		registrationPage.inputEmail("smileys010@gmail.com");
		loadingWait(registrationPage.emailIsUnique);
		errorMessage = registrationPage.getEmailIsUnique();
		Assert.assertEquals(errorMessage, "done Email is unique");
	}


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
