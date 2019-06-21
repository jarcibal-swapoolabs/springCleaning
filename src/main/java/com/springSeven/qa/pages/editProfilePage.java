package com.springSeven.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.springSeven.qa.base.testBase;

public class editProfilePage extends testBase{
	public editProfilePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//title
	@FindBy(xpath="//h1[@title='Edit Profile']")
	public WebElement editProfilePageTitle;

	//textbox
	@FindBy(id="EDIT_PROFILE_username")
	public WebElement usernameTextbox;

	@FindBy(id="EDIT_PROFILE_firstName")
	public WebElement firstnameTextbox;

	@FindBy(id="EDIT_PROFILE_middleName")
	public WebElement middleNameTextbox;

	@FindBy(id="EDIT_PROFILE_lastName")
	public WebElement lastNameTextbox;

	@FindBy(id="EDIT_PROFILE_dob")
	public WebElement birthDateTextbox;

	@FindBy(id="EDIT_PROFILE_addressLine1")
	public WebElement addressLineOneTextbox;

	@FindBy(id="EDIT_PROFILE_addressLine2")
	public WebElement addressLineTwoTextbox;

	@FindBy(id="EDIT_PROFILE_otherRegion")
	public WebElement regionTextbox;

	@FindBy(id="EDIT_PROFILE_otherCity")
	public WebElement cityTextbox;

	@FindBy(id="EDIT_PROFILE_postalCode")
	public WebElement zipCodeTextbox;
	
	@FindBy(id="EDIT_PROFILE_countryCode")
	public WebElement countryDropDown;

	@FindBy(id="EDIT_PROFILE_regionCode")
	public WebElement regionDropDown;

	@FindBy(id="EDIT_PROFILE_cityId")
	public WebElement cityDropDown;

//	@FindBy(id="EDIT_PROFILE_idType")
	@FindBy(xpath="//div[@class='Select-placeholder']")
	public WebElement uploadIdDropDown;

//	@FindBy(xpath="//input[aria-activedescendant='react-select-5--option-0']")
	@FindBy(xpath="//div[@class='Select-menu-outer']")
	public WebElement uploadIdDropDownPassport;

	//working
	@FindBy(xpath="//div[@class='component-dropzone center-align']")
	public WebElement uploadIdFileInput;
	
	@FindBy(xpath="//div[@class='component-dropzone center-align']//div")
	public WebElement uploadAvatarInput;

	@FindBy(xpath="//input[@type='file']")
	public WebElement dropZone;
	
	//button
	@FindBy(xpath="//button[@id='submitUpdateProfile']")
	public WebElement updateButton;

	@FindBy(xpath="//a[@href='/profile']")
	//@FindBy(xpath="//a[@href='modal-close waves-effect waves-green btn-flat active']")
	public WebElement okButton;
	
	@FindBy(xpath="//i[text()='file_upload']")
	public WebElement changeAvatarButton;	
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement updateAvatarButton;	
	

	
	//error
	@FindBy(xpath="//div[@class='helper-text error-message']")
	public WebElement errorGen;

	
	@FindBy(xpath="//div[text()='Please provide a username']")
	public WebElement usernameError;

	
	@FindBy(xpath="//div[text()='Please enter your first name']")
	public WebElement firstnameError;

	
	@FindBy(xpath="//div[text()='Please enter your last name']")
	public WebElement lastNameError;

	@FindBy(xpath="//div[text()='Please enter your birthdate']")
	public WebElement birthdateError;

	@FindBy(xpath="//div[text()='Please select your region']")
	public WebElement regionDropdownError;
	
	@FindBy(xpath="//div[text()='Please select your city']")
	public WebElement cityDropdownError;
	
	@FindBy(xpath="//div[text()='Please enter your address']")
	public WebElement addressOneError;
	
	//tab
	@FindBy(xpath="//span[@class='select-avatar']")
	public WebElement selectAvatarTab;

	//avatar
	@FindBy(xpath="//img[@src='https://s3-ap-southeast-1.amazonaws.com/makatisoft-assets-kamekyo-sg-dev-be/default_avatars/Steve.png']")
	public WebElement defaultAvatar;

	@FindBy(xpath="//div[@style='background-image: url(\"https://s3-ap-southeast-1.amazonaws.com/makatisoft-assets-kamekyo-sg-dev-be/default_avatars/Steve.png\");']")
	public WebElement EditprofileAvatar;
	
	//get title
	public String getEditProfilePageTitle()
	{
		String getEditProfilePageTitle = editProfilePageTitle.getText();
		return getEditProfilePageTitle;
	}
	
	//input textbox
	public void updateTextbox(WebElement element, String input) 
	{
		element.clear();
		element.sendKeys(input);
	}

	
	public void updateTextbox(WebElement element1, WebElement element2,String input) 
	{
		element1.clear();
		element1.sendKeys(input);
		element2.clear();
		element2.sendKeys(input);
	}

	
	//error messages
	public String getErrorAddressoneTextbox()
	{
		String getErrorAddressoneTextbox = addressOneError.getText();
		return getErrorAddressoneTextbox;
	}

	public String getErrorRegionDropdown()
	{
		String getErrorRegionDropdown = regionDropdownError.getText();
		return getErrorRegionDropdown;
	}

	public String getErrorCityDropdown()
	{
		String getErrorCityDropdown = cityDropdownError.getText();
		return getErrorCityDropdown;
	}


	
	//click buttons
	public void click(WebElement element)
	{
		clickableWait(element);
		element.click();
	}

	
	//displayed
	public boolean avatarIsDisplayed() {
		return EditprofileAvatar.isDisplayed();
	}
}
