package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utlity.BrowserUtility;

public final class LoginPage extends BrowserUtility {

	private static final By EMAIL_TEXT_LOCATOR = By.id("email");
	private static final By PASSWORD_LOCATOR = By.id("passwd");
	private static final By SIGNIN_BUTTON_LOCATOR = By.id("SubmitLogin");

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public MyAccountPage doLoginWithEmailAndPassword(String email, String password) {
		enterText(EMAIL_TEXT_LOCATOR, email);
		enterText(PASSWORD_LOCATOR, password);
		performClick(SIGNIN_BUTTON_LOCATOR);
		MyAccountPage  myAccount = new MyAccountPage(getDriver());
		//myAccount.logout();
		return myAccount;
	}

}
