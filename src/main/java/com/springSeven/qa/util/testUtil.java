package com.springSeven.qa.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.springSeven.qa.base.testBase;

public class testUtil extends testBase{
	public static long PAGE_LOAD_TIMEOUT = 60;
	public static long IMPLICIT_WAIT = 60;
	public static String TESTDATA_SHEET_PATH = "C:\\Users\\jarcibal\\eclipse-workspace\\springSevenWebsite\\src\\main\\java\\com\\springSeven\\qa\\testdata\\springSevenWebsiteData.xlsx";	
	
	static Workbook book;
	static Sheet sheet;
	
	
	//switch frame
	public void switchToFrame() {
		//driver.switchTo().frame("a-qws0ssavx4eg");		
		//driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='recaptcha challenge']")));
		driver.switchTo().frame(driver.findElement(By.xpath("/html/body/div[4]/div[2]/iframe")));
		//driver.switchTo().frame(1);
		//driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
	}
	
	//upload file
	public void uploadFile() throws AWTException, InterruptedException {
		StringSelection ss = new StringSelection("C:\\Users\\jarcibal\\Pictures\\Saved Pictures\\jabroni.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		// Ctrl + v
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	//excel
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
	//screenshot
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

	
	//JS Scroll
	public void JSScroll(){
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
//		executor.executeScript("windows.scrollTo(0,document.body.scrollHeight)");
		executor.executeScript("window.scrollBy(0,200)");}
	}
	
	//JS click
	public void JSClick(WebElement click){
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", click);
	}
	}
	
	//wait
	public void waitload(){
	{
		new WebDriverWait(driver, 20).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//p[contains(text(),'Page is loading')]")));
	}

	
	}

}