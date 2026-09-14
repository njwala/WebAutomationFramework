package com.utlity;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.constants.Browser;

public abstract class BrowserUtility {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();// instance variable- heap memory ; default value= null
	Logger logger = LoggerUtility.getLogger(this.getClass());

	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
		logger.info("BrowserUtility initialized with WebDriver instance");
	}

	public BrowserUtility(Browser browserName, boolean isHeadless) {
		logger.info("Initializing the browser: " + browserName);
		
		if (browserName == Browser.CHROME ) {
			
			if(isHeadless) {
			ChromeOptions options= new ChromeOptions();
			options.addArguments("--headless=old");//headless mode for chrome
			options.addArguments("--window-size=1920,1080");//set window size for headless mode
			driver.set( new ChromeDriver(options));
			logger.info("Driver set in thread: " + Thread.currentThread().getId());
			}
			else {
				driver.set( new ChromeDriver());
				logger.info("Driver set in thread: " + Thread.currentThread().getId());
			}
			
		 } else if (browserName == Browser.EDGE) {
			 if(isHeadless) {
					EdgeOptions options= new EdgeOptions();
					options.addArguments("--headless=old");//headless mode for chrome
					options.addArguments("--disabled-gpu");//disable gpu for headless mode
					driver.set( new EdgeDriver(options));
					logger.info("Driver set in thread: " + Thread.currentThread().getId());
			 }
			 else {
				 driver.set( new EdgeDriver());
				 logger.info("Driver set in thread: " + Thread.currentThread().getId());
			 }
			
		} else if (browserName == Browser.FIREFOX) {
               if(isHeadless) {
				   FirefoxOptions options = new FirefoxOptions();
				   options.addArguments("--headless");//headless mode for firefox
				   driver.set(new FirefoxDriver(options));
				   logger.info("Driver set in thread: " + Thread.currentThread().getId());
			   }
			   else {
			       driver .set(new FirefoxDriver());
                   logger.info("Driver set in thread: " + Thread.currentThread().getId());
			   }
		}
		logger.info("Browser initialized successfully: " + browserName);
	}

	public void launchBrowser(String url) {
		logger.info("Launching the browser with URL: " + url);
		driver.get().get(url);
	}

	public void maximizeBrowser() {
		logger.info("Maximizing the browser window");
		driver.get().manage().window().maximize();
	}

	public void performClick(By byLocator) {
		logger.info("Clicking on element located");
		WebElement signInElement = driver.get().findElement(byLocator);
		signInElement.click();
		logger.info("Clicked on element");
	}

	public void enterText(By byLocator, String text) {
		WebElement email = driver.get().findElement(byLocator);
		logger.info("Entering text: " + text);
		email.sendKeys(text);
		logger.info("Entered text: " + text);
	}

	public String getVisibleText(By locator) {
		WebElement textElement = driver.get().findElement(locator);
		logger.info("Getting visible text from element located");
		return textElement.getText();
	}
	
	public String takeScreenshot(String name) {
		TakesScreenshot screenshot =  (TakesScreenshot)driver.get();
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		Date  date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		String timestamp =  formatter.format(date);
		String path = System.getProperty("user.dir")+ "//screenshots//"+ "-" + timestamp + "-" +name+".png";
		File screenshotFile= new File(path);
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
}
