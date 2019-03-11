package com.springSeven.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.springSeven.qa.base.testBase;

public class setupSecurityQuestionsPage extends testBase{
	public setupSecurityQuestionsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//title
	@FindBy(xpath="//h1[@title='Change Security Questions']")
	public WebElement setupSecurityQuestionsPageTitle;

	//textbox
	@FindBy(id="CHANGE_SECURITY_QUESTIONS_password")
	WebElement passwordTextBox;
	
	@FindBy(id="CHANGE_SECURITY_QUESTIONS_securityQuestion1")
	WebElement questionOneTextbox;

	@FindBy(id="CHANGE_SECURITY_QUESTIONS_securityQuestion2")
	WebElement questionTwoTextbox;

	@FindBy(id="CHANGE_SECURITY_QUESTIONS_securityQuestion3")
	WebElement questionThreeTextbox;

	@FindBy(id="CHANGE_SECURITY_QUESTIONS_securityAnswer1")
	WebElement answerOneTextbox;

	@FindBy(id="CHANGE_SECURITY_QUESTIONS_securityAnswer2")
	WebElement answerTwoTextbox;

	@FindBy(id="CHANGE_SECURITY_QUESTIONS_securityAnswer3")
	WebElement answerThreeTextbox;

	@FindBy(xpath="//*[@id=\"app\"]/div[2]/div/div[2]/div/div/div/div[2]/div[2]/div/div/form/div[1]/div[1]/div")
	WebElement errorMessageQuestionOneTextbox;

	@FindBy(xpath="//*[@id=\"app\"]/div[2]/div/div[2]/div/div/div/div[2]/div[2]/div/div/form/div[1]/div[2]/div")
	WebElement errorMessageQuestionTwoTextbox;

	@FindBy(xpath="//*[@id=\"app\"]/div[2]/div/div[2]/div/div/div/div[2]/div[2]/div/div/form/div[1]/div[3]/div")
	WebElement errorMessageQuestionThreeTextbox;

	@FindBy(xpath="//*[@id=\"app\"]/div[2]/div/div[2]/div/div/div/div[2]/div[2]/div/div/form/div[1]/div[4]/div")
	WebElement errorMessageAnswerOneTextbox;

	@FindBy(xpath="//*[@id=\"app\"]/div[2]/div/div[2]/div/div/div/div[2]/div[2]/div/div/form/div[1]/div[5]/div")
	WebElement errorMessageAnswerTwoTextbox;

	@FindBy(xpath="//*[@id=\"app\"]/div[2]/div/div[2]/div/div/div/div[2]/div[2]/div/div/form/div[1]/div[6]/div")
	WebElement errorMessageAnswerThreeTextbox;
	
	//button
	@FindBy(xpath="//span[text()='CONTINUE']")
	WebElement continueButton;
		
	@FindBy(xpath="//span[contains(text(),'SUBMIT')]")
	WebElement submitButton;

	@FindBy(xpath="//span[text()='OK']")
	WebElement successOkButton;

	//error
	@FindBy(xpath="//div[@class='helper-text error-message']")
	public WebElement passwordErrorMessage;

	@FindBy(xpath="//div[@class='modal-icon-success valign-wrapper']")
	WebElement successIcon;

	
	


	public boolean getCorrectCurrentPW()
	{
		return submitButton.isDisplayed();
	}

	public void getSuccessfullSetupSecurity(String question1, String question2, String question3, String answer1, String answer2, String answer3)
	{
		passwordTextBox.sendKeys("Makatisoft01!");
		continueButton.click();
		questionOneTextbox.sendKeys(question1);
		answerOneTextbox.sendKeys(answer1);
		questionTwoTextbox.sendKeys(question2);
		answerTwoTextbox.sendKeys(answer2);
		questionThreeTextbox.sendKeys(question3);
		answerThreeTextbox.sendKeys(answer3);
		successOkButton.click();	

	}

	//action
	public void enterPW(String pw)
	{
		passwordTextBox.sendKeys(pw);
		continueButton.click();

	}
	
	public String getSetupSecurityQuestionsPageTitle()
	{
		String getSetupSecurityQuestionsPageTitle = setupSecurityQuestionsPageTitle.getText();
		return getSetupSecurityQuestionsPageTitle;
	}
	
	public String getErrorCurrentPassword()
	{
		String getErrorCurrentPassword = passwordErrorMessage.getText();
		return getErrorCurrentPassword;
	}
	
}
