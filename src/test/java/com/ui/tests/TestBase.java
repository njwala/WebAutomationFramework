package com.ui.tests;

import static com.constants.Browser.CHROME;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utlity.BrowserUtility;
import com.utlity.LambdaTestUtility;
import com.utlity.LoggerUtility;

public class TestBase {
	
	protected HomePage homePage;
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private boolean isLambdaTest ;//= true; // Set this to true if you want to run tests on LambdaTest
//	private boolean isHeadless = true; // Set this to true if you want to run tests in headless mode
	
	
	
	
	@Parameters({"browser", "isLambdaTest", "isHeadless"})
	@BeforeMethod(description = "Loading the home page")
	public void setup(
			@Optional("chrome")String browserName, 
			@Optional("false") boolean islambdaTest, 
			@Optional("true")boolean isHeadless, 
			ITestResult result) {
		
		this.isLambdaTest = islambdaTest;
		
		WebDriver remoteLambdaDriver ;
		if(isLambdaTest) {
			remoteLambdaDriver=LambdaTestUtility.initializeLambdaTestDriver(browserName, result.getMethod().getMethodName());
			homePage = new HomePage(remoteLambdaDriver);
		}
		else {
			logger.info("Running tests on local machine");
			//homePage = new HomePage(CHROME,isHeadless);
			homePage = new HomePage(Browser.valueOf(browserName.toUpperCase()),isHeadless);
		}
		// Home page(click signin)-> login page(login) -> myaccount page(landing page)
		homePage = new HomePage(CHROME,true);
		assert homePage.getDriver()!=null;
		logger.info("Homepage is loaded");	
		logger.info("Setup called, homePage = " + homePage);
	}
	
	public BrowserUtility getInstance() {
		return homePage;
	}
	
	
	@AfterMethod(description = "Quitting the browser")
	public void tearDown() {
		if(isLambdaTest) {
			LambdaTestUtility.quitLambdaTestDriver(); //quit cloud session
		}
		else {
			homePage.quit(); //quit local browser session
		}
	}
}
