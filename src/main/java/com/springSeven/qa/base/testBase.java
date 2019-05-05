package com.springSeven.qa.base;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.springSeven.qa.util.webEventListener;

public class testBase {
	
	public static WebDriver driver;
	
	public static Properties prop;

	public static EventFiringWebDriver e_driver;
	public static WebDriverEventListener eventListener;
	

	public static void initialization() throws MalformedURLException{
//		String browserName = prop.getProperty("browser");
//		String browserName = "FF";
//		
//		if(browserName.equals("chrome")){
//			System.setProperty("webdriver.chrome.driver", "C:\\qa\\chromedriver\\chromedriver.exe");	
//			driver = new ChromeDriver(); 
//		}
//		else if(browserName.equals("FF")){
//			System.setProperty("webdriver.gecko.driver", "/home/jarcibal/Downloads/geckodriver");	
//			driver = new FirefoxDriver(); 		
//		}
//		else if(browserName.equals("linuxFirefox")){
//		testBase.dockerf();
//		}		
//		else if(browserName.equals("linuxChrome")){
//		testBase.dockerc();
//		}
//		
//		
		 if(System.getProperty("BROWSER") != null &&
	                System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
				testBase.dockerf();
	        }else{
	    		testBase.dockerc();
	        }
		
		

		
		
		
		
		
		
		
		
		
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new webEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		//driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.get(prop.getProperty("url"));
		driver.get("https://d1uu7efqb688sd.cloudfront.net");
	} 
	
	
	
	
	//docker 
    public static void dockerf() throws MalformedURLException {
		DesiredCapabilities dr = null;
		dr = DesiredCapabilities.firefox();
		dr.setBrowserName("firefox");
		dr.setPlatform(Platform.LINUX);
	    String host = "localhost";

		if(System.getProperty("HUB_HOST") != null){
	            host = System.getProperty("HUB_HOST");
	        }
		 String completeUrl = "http://" + host + ":4444/wd/hub";

		driver = new RemoteWebDriver(new URL(completeUrl),dr);

		
//		driver = new RemoteWebDriver(new URL("http://192.168.99.100:4444/wd/hub"),dr);

    	
//    	Capabilities firefoxCapabilities = DesiredCapabilities.firefox();	
//		driver = new RemoteWebDriver(new URL("http://192.168.99.100:4446/wd/hub"),firefoxCapabilities);
    }
	

    public static void dockerc() throws MalformedURLException {
		DesiredCapabilities dr = null;
		dr = DesiredCapabilities.chrome();
		dr.setBrowserName("chrome");
		dr.setPlatform(Platform.LINUX);
	    String host = "localhost";
		if(System.getProperty("HUB_HOST") != null){
	            host = System.getProperty("HUB_HOST");
	        }
		 String completeUrl = "http://" + host + ":4444/wd/hub";

		 driver = new RemoteWebDriver(new URL(completeUrl),dr);
		 //driver = new RemoteWebDriver(new URL("http://192.168.99.100:4444/wd/hub"),dr);


		
		
		
//		DesiredCapabilities dr = null;
//		dr = DesiredCapabilities.chrome();
//		dr.setBrowserName("chrome");
//		dr.setPlatform(Platform.LINUX);
//		System.setProperty("webdriver.chrome.driver", "C:\\qa\\chromedriver\\chromedriver.exe");	
//		driver = new RemoteWebDriver(new URL("http://192.168.99.100:4446/wd/hub"),dr);
		
//		Capabilities chromeCapabilities = DesiredCapabilities.chrome();
//		driver = new RemoteWebDriver(new URL("http://192.168.99.100:4446/wd/hub"),chromeCapabilities);
    }

    
    
	//life saver but bad
    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }
    
    
    //loading method
	public static void loadingWait(WebElement element) {
	    WebDriverWait wait = new WebDriverWait(driver, 15);
	    wait.until(ExpectedConditions.visibilityOf(element)); // wait for loader to disappear
	}
		
	//clickable
	public static void clickableWait(WebElement element) {
	    WebDriverWait wait = new WebDriverWait(driver, 15);
	    wait.until(ExpectedConditions.elementToBeClickable(element)); // wait for loader to disappear
	}

	//explicit wait which is better
	public static void processing(){ 
		try {
	    WebDriverWait wait = new WebDriverWait(driver, 15);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Page is loading')]")));
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//p[contains(text(),'Page is loading')]")));
	    wait.ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class); 
		}
		catch (Exception e) {	
		}
	}
	

	public static void tryCatch(WebElement element1,WebElement element2){ 
		try {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(
			      ExpectedConditions.and(
			           ExpectedConditions.visibilityOf(element1),
			           ExpectedConditions.visibilityOf(element2)
			      )
			  );	
			}
		catch (Exception e) {	
		}
		element2.click();
	}

}
