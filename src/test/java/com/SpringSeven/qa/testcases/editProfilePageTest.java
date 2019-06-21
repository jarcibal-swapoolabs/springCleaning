package com.SpringSeven.qa.testcases;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.springSeven.qa.pages.homePage;
import com.springSeven.qa.pages.initialPage;
import com.springSeven.qa.pages.loginPage;
import com.springSeven.qa.pages.profilePage;
import com.springSeven.qa.base.testBase;
import com.springSeven.qa.pages.editProfilePage;
import com.springSeven.qa.util.testUtil;

public class editProfilePageTest extends testBase {
	initialPage initialPage;
	loginPage loginPage;
	homePage homePage;
	profilePage profilePage;
	editProfilePage editProfilePage;
	testUtil testUtil;

	public editProfilePageTest() {
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
//		loadingWait(homePage.loadingElement);
		homePage = loginPage.login("jhesed.tacadena@swapoolabs.com","superstrongpassword");
		tryCatch(homePage.loadingElement,homePage.securityQuestionsPromptLater);

		homePage.clickOnAccountLink();
		loadingWait(homePage.profileLink);
		
		profilePage = homePage.clickOnProfileLink();
		loadingWait(profilePage.profilePageTitle);

		editProfilePage = profilePage.clickonEditProfileLink();
		loadingWait(editProfilePage.editProfilePageTitle);
	}

//	@Test
//	public void validateEditProfilePageTitle() 
//	{
//		String header = editProfilePage.getEditProfilePageTitle();
//		Assert.assertEquals(header, "Edit Profile");
//	}
//
	@Test
	public void validateEditProfileUpdateName() {
		editProfilePage.updateTextbox(editProfilePage.firstnameTextbox,"Jheseds");
		editProfilePage.updateTextbox(editProfilePage.lastNameTextbox,"Tacadenas");

		editProfilePage.click(editProfilePage.uploadIdDropDown);
		editProfilePage.click(editProfilePage.uploadIdDropDownPassport);
		
		testUtil.uploadImage(editProfilePage.dropZone,"screenshot.png");
		editProfilePage.click(editProfilePage.updateButton);
		editProfilePage.click(editProfilePage.updateButton);
		editProfilePage.click(editProfilePage.okButton);

		String header = profilePage.getProfilePageTitle();
		Assert.assertEquals(header, "Profile");
	}
//	
//	
	@Test
	public void tenMBupload() {
		editProfilePage.updateTextbox(editProfilePage.firstnameTextbox,"Jheseds");
		editProfilePage.updateTextbox(editProfilePage.lastNameTextbox,"Tacadenas");

		editProfilePage.click(editProfilePage.uploadIdDropDown);
		editProfilePage.click(editProfilePage.uploadIdDropDownPassport);
			
		testUtil.uploadImage(editProfilePage.dropZone,"tenmb.jpg");

		editProfilePage.click(editProfilePage.updateButton);
		String errorGen = testUtil.getError(editProfilePage.errorGen);
		Assert.assertEquals(errorGen, "Please choose an image no greater than 5MB");
	}
//
//	@Test
//	public void validateUpdateBirthDate() 
//	{
//		//10/24/1985 is the original date
//		editProfilePage.updateTextbox(editProfilePage.birthDateTextbox,"07/19/1990");
//		editProfilePage.click(editProfilePage.uploadIdDropDown);
//		editProfilePage.click(editProfilePage.uploadIdDropDownPassport);
//		
//		testUtil.uploadImage(editProfilePage.dropZone,"screenshot.png");
//		
//		editProfilePage.click(editProfilePage.updateButton);
//		editProfilePage.click(editProfilePage.updateButton);
//
//		editProfilePage.click(editProfilePage.okButton);
//
//		String header = profilePage.getProfilePageTitle();
//		Assert.assertEquals(header, "Profile");
//	}
//
//	@Test
//	public void validateUpdateAddressLineOneWorks() {
//		//Brgy Malaking itlog old data
//		editProfilePage.updateTextbox(editProfilePage.addressLineOneTextbox,"Brgy Malaking itlog");
//		editProfilePage.click(editProfilePage.updateButton);
//		editProfilePage.click(editProfilePage.okButton);
//
//		String header = profilePage.getProfilePageTitle();
//		Assert.assertEquals(header, "Profile");
//	}
//
//	@Test
//	public void validateUpdateAddressLineTwoWorks() {
//		//blank old data
//		editProfilePage.updateTextbox(editProfilePage.addressLineTwoTextbox,"Pasayeno");
//		editProfilePage.click(editProfilePage.updateButton);
//		editProfilePage.click(editProfilePage.okButton);
//
//		String header = profilePage.getProfilePageTitle();
//		Assert.assertEquals(header, "Profile");
//	}
//	@Test
//	public void validateEditProfileAddressLineOneBlankError() {
//		editProfilePage.updateTextbox(editProfilePage.addressLineOneTextbox,"");
//		editProfilePage.click(editProfilePage.updateButton);
//		String error = testUtil.getError(editProfilePage.addressOneError);
//		Assert.assertEquals(error, "Please enter your address");
//	}
//
//
//	@Test
//	public void validateEditProfileUpdateAddressLineTwoWorksBlank() {
//		editProfilePage.updateTextbox(editProfilePage.addressLineTwoTextbox,"");
//		editProfilePage.click(editProfilePage.updateButton);
//		String header = profilePage.getProfilePageTitle();
//		Assert.assertEquals(header, "Profile");
//	}
//	
//	@Test
//	public void validateEditProfileUsernameBlankError() {
//		editProfilePage.updateTextbox(editProfilePage.usernameTextbox,"");
//		editProfilePage.click(editProfilePage.updateButton);
//		String error = testUtil.getError(editProfilePage.usernameError);
//		Assert.assertEquals(error, "Please provide a username");
//	}
//	
//	@Test
//	public void validateEditProfileFirstNameBlankError() {
//		editProfilePage.updateTextbox(editProfilePage.firstnameTextbox,"");
//		editProfilePage.click(editProfilePage.updateButton);
//		String error = testUtil.getError(editProfilePage.firstnameError);
//		Assert.assertEquals(error, "Please enter your first name");
//	}
//
//	@Test
//	public void validateEditProfileLastNameBlankError() {
//		editProfilePage.updateTextbox(editProfilePage.lastNameTextbox,"");
//		editProfilePage.click(editProfilePage.updateButton);
//		String error = testUtil.getError(editProfilePage.lastNameError);
//		Assert.assertEquals(error, "Please enter your last name");
//	}
//
//	@Test
//	public void validateEditProfileBdayBlankError() {
//		editProfilePage.updateTextbox(editProfilePage.birthDateTextbox,"");
//		editProfilePage.click(editProfilePage.updateButton);
//		String error = testUtil.getError(editProfilePage.birthdateError);
//		Assert.assertEquals(error, "Please enter your birthdate");
//	}

//	
	//stop here
//	@Test
//	public void validateChangeCountryUnsuccessfullOne() {
//		editProfilePage.updateCountryDropdown("Panama");
//		editProfilePage.updateRegionDropdown("");
//		editProfilePage.updateCityDropdown("");
//		editProfilePage.clickUpdate();
//		String error = editProfilePage.getErrorRegionDropdown();
//		Assert.assertEquals(error, "Please select your region");
//	}
//
//	@Test
//	public void validateChangeCountryUnsuccessfullTwo() {
//		editProfilePage.updateCountryDropdown("Panama");
//		editProfilePage.updateRegionDropdown("");
//		editProfilePage.updateCityDropdown("");
//		editProfilePage.clickUpdate();
//		String error = editProfilePage.getErrorCityDropdown();
//		Assert.assertEquals(error, "Please select your city");
//	}
//
//	@Test
//	public void validateChangeCountrySuccess() {
//		editProfilePage.updateCountryDropdown("Panama");
//		editProfilePage.updateRegionDropdown("Cocle");
//		editProfilePage.updateCityDropdown("Barrero");
//		editProfilePage.clickUpdate();
//		editProfilePage.clickOK();
//
//		String header = profilePage.getProfilePageTitle();
//		Assert.assertEquals(header, "Profile");
//	}
//
//	@Test
//	public void validateChangeRegionUnsuccessfully() {
//		editProfilePage.updateCountryDropdown("Panama");
//		editProfilePage.updateRegionDropdown("Cocle");
//		editProfilePage.updateCityDropdown("");
//		editProfilePage.clickUpdate();
//		editProfilePage.clickOK();
//		String error = editProfilePage.getErrorCityDropdown();
//		Assert.assertEquals(error, "Please select your city");
//
//	}
//
//	@Test
//	public void validateChangeRegionSuccessfully() {
//		editProfilePage.updateCountryDropdown("Panama");
//		editProfilePage.updateRegionDropdown("Cocle");
//		editProfilePage.updateCityDropdown("Caballero");
//		editProfilePage.clickUpdate();
//		editProfilePage.clickOK();
//
//		String header = profilePage.getProfilePageTitle();
//		Assert.assertEquals(header, "Profile");
//	}
//
//	@Test
//	public void validateChangeCityUnsuccessfully() {
//		editProfilePage.updateCountryDropdown("Panama");
//		editProfilePage.updateRegionDropdown("Cocle");
//		editProfilePage.updateCityDropdown("");
//		editProfilePage.clickUpdate();
//		editProfilePage.clickOK();
//		String error = editProfilePage.getErrorCityDropdown();
//		Assert.assertEquals(error, "Please select your city");
//
//	}
//
//	@Test
//	public void validateChangeCitySuccessfully() {
//		editProfilePage.updateCountryDropdown("United Kingdom");
//		editProfilePage.updateRegionDropdown("Barnet");
//		editProfilePage.updateCityDropdown("Hendon");
//		editProfilePage.clickUpdate();
//		editProfilePage.clickOK();
//
//		String header = profilePage.getProfilePageTitle();
//		Assert.assertEquals(header, "Profile");
//	}
//
//	@Test
//	public void validateUpdateAllAddressFieldsWorks() {
//		editProfilePage.updateAddressLineOne("Manila");
//		editProfilePage.updateAddressLineTwo("Manila");
//		editProfilePage.updateCountryDropdown("Philippines");
//		editProfilePage.updateRegionDropdown("Others (Please Specify)");
//		editProfilePage.updateRegionTextbox("Manila");
//		editProfilePage.updateCityDropdown("Others (Please Specify)");
//		editProfilePage.updateCityTextbox("Manila");
//		editProfilePage.updateCityTextbox("1300");
//		editProfilePage.clickUpdate();
//		editProfilePage.clickOK();
//		String header = profilePage.getProfilePageTitle();
//		Assert.assertEquals(header, "Profile");
//	}
	
//	//hard as fuck
//	@Test
//	public void validateChangeAvatarNewImage() {
//		editProfilePage.clickchangeAvatar();
//		editProfilePage.clickAvatarInput();
//		editProfilePage.clickUpdateAvatar();
//		editProfilePage.clickOK();
//		String header = profilePage.getProfilePageTitle();
//		Assert.assertEquals(header, "Profile");
//	}
//
//
//	@Test
//	public void validateChangeAvatarDefault() {
//		editProfilePage.clickchangeAvatar();
//		testUtil.JSClick(editProfilePage.selectAvatarTab);
//		loadingWait(editProfilePage.defaultAvatar);
//		testUtil.JSClick(editProfilePage.defaultAvatar);
//		loadingWait(editProfilePage.updateAvatarButton);
//		editProfilePage.clickUpdateAvatar();		
//		loadingWait(editProfilePage.editProfilePageTitle);
//		Assert.assertTrue(editProfilePage.avatarIsDisrplayed());
//}
//
//	

	@AfterMethod
	public void tearDown() {
		try
		{
			
		}
		finally
		{
		driver.quit();
	}
	}
}
