package com.ui.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utlity.BrowserUtility;

public class LoginTest{
	
	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();// Loose coupling
		
//		BrowserUtility browserUtility;
//		browserUtility.launchBrowser("http://www.automationpractice.pl/index.php");
//		browserUtility.maximizeBrowser();
//		
//		By signInLocator= By.xpath("//a[contains(text(),'Sign in')]");
//	    browserUtility.performClick(signInLocator);
//		
//		By emailAddressLocator=By.id("email");
//		browserUtility.enterText(emailAddressLocator,"jntest@gmail.com");
//		
//		By passwordLocator=By.id("passwd");
//	    browserUtility.enterText(passwordLocator, "testadmin");
//		
//		By signInButtonLocator=By.id("SubmitLogin");
//		browserUtility.performClick(signInButtonLocator);
		

		/*
		 * problem with above code
		 * 1. hard coding of the urls
		 * 2. test data attached to the tests
		 * 3. code duplicacy
		 * 4. no exception handling
		 * 5. synchronization
		 * driver.findElement<- not preferrable to used, instead use explicit/fluent waits
		 * 6. no assertion
		 * 7. no abstraction
		 */
	}

}
