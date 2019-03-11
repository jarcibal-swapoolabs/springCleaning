package com.SpringSeven.qa.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;


public class draft {
	public WebDriver driver;
	private String baseUrl;

	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		DesiredCapabilities dr = null;
		dr = DesiredCapabilities.firefox();
		dr.setBrowserName("firefox");
		dr.setPlatform(Platform.LINUX);
		driver = new RemoteWebDriver(new URL("http://192.168.99.100:4444/wd/hub"),dr);
		driver.get("https://d1uu7efqb688sd.cloudfront.net/signup?id=KVKcEta");
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	@Test
	public void validateRegistrationPageTitle(){
		WebElement registrationHeader = driver.findElement(By.xpath("//button[@class='primary waves-effect waves-light btn-large Button__button___3vjDD Button__primary___Dv0Je']"));

		Boolean getRegistrationPageTitle = registrationHeader.isDisplayed();
		Assert.assertTrue(getRegistrationPageTitle);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}