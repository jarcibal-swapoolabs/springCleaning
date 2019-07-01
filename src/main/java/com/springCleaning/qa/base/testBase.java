package com.springCleaning.qa.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testBase {

	//public static WebDriver driver;
	public static RemoteWebDriver driver;
	public static Properties prop;

	public static EventFiringWebDriver e_driver;
	public static WebDriverEventListener eventListener;

	public static void initialization() throws MalformedURLException {
		if (System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
			testBase.dockerf();
		} else {
			testBase.dockerc();
		}


		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://d34doyrhrdwlg4.cloudfront.net/signup?id=xCX3Kdt");
		//driver.get("http://192.168.0.1");
	}

	// docker
	public static void dockerf() throws MalformedURLException {
		DesiredCapabilities dr = null;
		dr = DesiredCapabilities.firefox();
		dr.setBrowserName("firefox");
		dr.setPlatform(Platform.LINUX);
		String host = "localhost";

		if (System.getProperty("HUB_HOST") != null) {
			host = System.getProperty("HUB_HOST");
		}
		String completeUrl = "http://" + host + ":4444/wd/hub";

		driver = new RemoteWebDriver(new URL(completeUrl), dr);
	}

	public static void dockerc() throws MalformedURLException {
		DesiredCapabilities dr = null;
		dr = DesiredCapabilities.chrome();
		dr.setBrowserName("chrome");
		dr.setPlatform(Platform.LINUX);
		String host = "localhost";
		if (System.getProperty("HUB_HOST") != null) {
			host = System.getProperty("HUB_HOST");
		}
		String completeUrl = "http://" + host + ":4444/wd/hub";

		driver = new RemoteWebDriver(new URL(completeUrl), dr);
		//driver.setFileDetector(new LocalFileDetector());
        }



	// loading method
	public static void loadingWait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element)); // wait for loader to disappear
	}

	// clickable
	public static void clickableWait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(element)); // wait for loader to disappear
	}

	// explicit wait which is better
	public static void processing() {
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

	public static void tryCatch(WebElement element1, WebElement element2) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.and(ExpectedConditions.visibilityOf(element1),
					ExpectedConditions.visibilityOf(element2)));
		} catch (Exception e) {
		}
		element2.click();
	}

}
