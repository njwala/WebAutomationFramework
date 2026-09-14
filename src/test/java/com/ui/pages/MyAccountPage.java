package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utlity.BrowserUtility;

public final class MyAccountPage extends BrowserUtility {

	private static final By USERNAME_LOCATOR = By.xpath("//a[@title='View my customer account']/span");
	private static final By LOGOUT_LOCATOR = By.xpath("//a[@title='Log me out']/text()");

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	public String getLoggedInUser() {
		return getVisibleText(USERNAME_LOCATOR);
	}

	public LoginPage logout() {
		performClick(LOGOUT_LOCATOR);
		return new LoginPage(getDriver());
	}
}
