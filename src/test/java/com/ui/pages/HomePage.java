package com.ui.pages;

import static com.constants.Env.QA;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.utlity.BrowserUtility;
import com.utlity.JsonUtility;
import com.utlity.LoggerUtility;

public final class HomePage extends BrowserUtility {

	private static final By SIGNIN_LOCATOR = By.xpath("//a[contains(text(),'Sign in')]");
	Logger logger = LoggerUtility.getLogger(this.getClass());

	public HomePage(Browser browserName,boolean isHeadless) {
		super(browserName,isHeadless);
		//launchBrowser(readPropterty(QA,"URL")); // using properties file
		launchBrowser(JsonUtility.readJson(QA).getUrl()); // using json file
		maximizeBrowser();
	}

	
	public HomePage(WebDriver driver) {
		super(driver);
		launchBrowser(JsonUtility.readJson(QA).getUrl());
	}

	public LoginPage goToLoginInPage() { // Page Functions
		logger.info("Clicking on Signin link");
		performClick(SIGNIN_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}
	
	public void quit() {
		logger.info("Quitting the browser");
		getDriver().quit();
	}

}
