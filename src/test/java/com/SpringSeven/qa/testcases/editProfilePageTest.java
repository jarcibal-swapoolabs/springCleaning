package com.SpringSeven.qa.testcases;

import java.awt.AWTException;
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
//	public void validateEditProfilePageTitle() {
//		String header = editProfilePage.getEditProfilePageTitle();
//		Assert.assertEquals(header, "Edit Profile");
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
//		Assert.assertTrue(editProfilePage.avatarIsDisplayed());
//}
//
//	
	@Test
	public void validateUpdateName() throws AWTException, InterruptedException{
		editProfilePage.updateFirstnameTextbox("s");
		editProfilePage.updateLastNameTextbox("s");
		loadingWait(editProfilePage.uploadIdDropDown);
		
		editProfilePage.uploadIdDropDown.click();
		loadingWait(editProfilePage.uploadIdDropDownPassport);
		editProfilePage.uploadIdDropDownPassport.click();
		
		editProfilePage.clickUploadIdFileInput();
		testUtil.uploadFile();

		editProfilePage.clickUpdate();
		editProfilePage.clickUpdate();

		clickableWait(editProfilePage.okButton);
		editProfilePage.clickOK();
		loadingWait(profilePage.profilePageTitle);
		String header = profilePage.getProfilePageTitle();
		Assert.assertEquals(header, "Profile");
	}

	@Test
	public void validateUpdateBirthDate() throws AWTException, InterruptedException
	{
		//10/24/1985 is the original date
		editProfilePage.updateBirthdateTextbox("07/19/1990");
		editProfilePage.updateUploadIdDropDown("Driver's license");
		loadingWait(editProfilePage.uploadIdDropDown);
		
		editProfilePage.uploadIdDropDown.click();
		loadingWait(editProfilePage.uploadIdDropDownPassport);
		editProfilePage.uploadIdDropDownPassport.click();
		
		editProfilePage.clickUploadIdFileInput();
		testUtil.uploadFile();

		editProfilePage.clickUpdate();
		editProfilePage.clickUpdate();

		clickableWait(editProfilePage.okButton);
		editProfilePage.clickOK();
		loadingWait(profilePage.profilePageTitle);
		String header = profilePage.getProfilePageTitle();
		Assert.assertEquals(header, "Profile");		
	}

	@Test
	public void validateUpdateAddressLineOneBlankError() {
		editProfilePage.updateAddressLineOne("");
		editProfilePage.clickUpdate();
		String error = editProfilePage.getErrorAddressoneTextbox();
		Assert.assertEquals(error, "Please enter your address");

	}

	@Test
	public void validateUpdateAddressLineOneWorks() {
		editProfilePage.updateAddressLineOne("Maynila");
		editProfilePage.clickUpdate();
		String header = profilePage.getProfilePageTitle();
		Assert.assertEquals(header, "Profile");
	}

	@Test
	public void validateUpdateAddressLineTwoWorksBlank() {
		editProfilePage.updateAddressLineTwo("");
		editProfilePage.clickUpdate();
		String header = profilePage.getProfilePageTitle();
		Assert.assertEquals(header, "Profile");
	}

//	@Test
//	public void validateUpdateAddressLineTwoWorks() {
//		editProfilePage.updateAddressLineTwo("Maynila");
//		editProfilePage.clickUpdate();
//		String header = profilePage.getProfilePageTitle();
//		Assert.assertEquals(header, "Profile");
//	}
//
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

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
