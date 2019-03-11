package com.SpringSeven.qa.testcases;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class trash {

WebDriver driver;
	
	@BeforeMethod

	void setUpMethod() 
	{ 
		System.setProperty("webdriver.chrome.driver", "C:\\qa\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
		
	@Test
	void logintest()  
	{
		//part 1 : open url	
		driver.get("http://d2jijyuf3kzrzu.cloudfront.net/"); //access url
		driver.findElement(By.xpath("//i[contains(text(),'power_settings_new')]")).click();		
		driver.findElement(By.id("LOGIN_emailUsername")).sendKeys("");
		driver.findElement(By.id("LOGIN_password")).sendKeys("Makatisoft01");
		driver.findElement(By.cssSelector("button[type='button'][class='primary waves-effect waves-light btn-large Button__button___3vjDD Button__primary___Dv0Je']")).click();
			
//		WebDriverWait wait = new WebDriverWait(driver, 6);
//		wait.until(ExpectedConditions.elementToBeClickable(By.id("passwordNext")));
//		driver.findElement(By.id("passwordNext")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='helper-text error-message']")).isDisplayed());

		
		}
	 	
	@AfterMethod
	void tearDownMethod() { 
		driver.quit();
	}

	
 
}
