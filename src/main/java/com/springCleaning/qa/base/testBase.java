package com.springCleaning.qa.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class testBase {
	protected WebDriver driver;

	@BeforeMethod
	public void setupDriver(ITestContext ctx) throws MalformedURLException {
		//String browserName = "FF";
		String host = "localhost";
		DesiredCapabilities dc;
		
//		if(browserName.equals("chrome")){
//			System.setProperty("webdriver.chrome.driver", "C:\\qa\\chromedriver\\chromedriver.exe");	
//			driver = new ChromeDriver(); 
//		}
//		else if(browserName.equals("FF")){
//			System.setProperty("webdriver.gecko.driver", "/home/jarcibal/Downloads/geckodriver");	
//			driver = new FirefoxDriver(); 		
//		}
		

		if (System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
			dc = DesiredCapabilities.firefox();
		} else {
			dc = DesiredCapabilities.chrome();
		}

		if (System.getProperty("HUB_HOST") != null) {
			host = System.getProperty("HUB_HOST");
		}

		String testName = ctx.getCurrentXmlTest().getName();

		String completeUrl = "http://" + host + ":4444/wd/hub";
		dc.setCapability("name", testName);
		this.driver = new RemoteWebDriver(new URL(completeUrl), dc);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://d34doyrhrdwlg4.cloudfront.net/signup?id=xCX3Kdt");
		System.out.println("REGISTER PLS");

	}

	@AfterMethod
	public void quitDriver() {
		driver.quit();
	}
	
	

	// loading method
	public void loadingWait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element)); // wait for loader to disappear
	}

	// clickable
	public void clickableWait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(element)); // wait for loader to disappear
	}

	// explicit wait which is better
	public void processing() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Page is loading')]")));
			wait.until(ExpectedConditions
					.invisibilityOfElementLocated(By.xpath("//p[contains(text(),'Page is loading')]")));
			wait.ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class);
		} catch (Exception e) {
		}
	}

	public void tryCatch(WebElement element1, WebElement element2) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.and(ExpectedConditions.visibilityOf(element1),
					ExpectedConditions.visibilityOf(element2)));
		} catch (Exception e) {
		}
		element2.click();
	}

}
