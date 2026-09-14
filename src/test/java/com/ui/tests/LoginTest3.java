package com.ui.tests;

import static com.constants.Browser.CHROME;
import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojos.User;
import com.utlity.LoggerUtility;

@Listeners(com.ui.listerners.TestListener.class)
public class LoginTest3 extends TestBase {

	//HomePage homePage;
	Logger logger = LoggerUtility.getLogger(this.getClass());


	
	
//	
//	@Test(description = "login with email and password with properties file")
//	public void loginTest(User user) {
//		assertEquals(
//				homePage.goToLoginInPage().doLoginWithEmailAndPassword("tester@test.com", "tester").getLoggedInUser(),
//				"Tester test"); // 2nd creds- admin@admin.com/admin ;
//	}

	
	
	
	
//	@Test(description = "login data from json file", groups = { "e2e",
//			"sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "loginTestdataJsonProvider")
//	public void loginJsonTest(User user) {
//		assertEquals(homePage.goToLoginInPage().doLoginWithEmailAndPassword(user.getEmail(), user.getPassword())
//				.getLoggedInUser(), "Tester test");
//	}

	
	
	
//	
//	@Test(description = "logs in with email and password from csv file", groups = { "e2e",
//			"sanity" }, dataProviderClass =com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginCSVDataProvider")
//	public void loginCSVTest(User user) {
//		assertEquals(homePage.goToLoginInPage().doLoginWithEmailAndPassword(user.getEmail(), user.getPassword())
//				.getLoggedInUser(), "Tester test");
//	}

	
	
	
	
	@Test(description = "logs in with email and password from csv file", groups = { "e2e",
			"sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginExcelDataProvider", retryAnalyzer = com.ui.listerners.MyRetryAnalyzer.class)
	public void logonExcelTest(User user) {
		// Logger logger=LoggerUtility.getLogger(this.getClass());
		assertEquals(homePage.goToLoginInPage().doLoginWithEmailAndPassword(user.getEmail(), user.getPassword())
				.getLoggedInUser(), "Tester test");
	}
}

/*
 * 
 * // chaining of methods- line 23 // with all methods have different return
 * type, look at the last method- it // returns string clean code- 1] test
 * methods should be small 2] you cannot have conditional statements,loops,try
 * catch in your test method. test methos should only contain the test and no
 * logic 3] test scripts should follow test steps 4] reduce the use of local
 * variables 5] Atleast one assertion 6]
 * 
 */