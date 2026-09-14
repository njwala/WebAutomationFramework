package com.utlity;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LambdaTestUtility { // to run the tests on cloud
	public static final String HUB_URL = "https://hub.lambdatest.com/wd/hub";
	private static ThreadLocal<WebDriver>  driverLocal = new ThreadLocal<>(); ;
	private static ThreadLocal<DesiredCapabilities> capabilitiesLocal = new ThreadLocal<>();
	
	
	public static WebDriver  initializeLambdaTestDriver(String browserName,String testName) {
		 DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability("browserName", browserName);
	        capabilities.setCapability("browserVersion", "latest");
	        Map<String, Object> ltOptions = new HashMap<>();
	        ltOptions.put("user", "njwala101");//System.getenv("LT_USERNAME"));
	        ltOptions.put("accessKey", "LT_HJWOp1DXy8jJogIviIJLzPVVTSFcsHmODdL4iFA2pkJp9yB");//System.getenv("LT_ACCESS_KEY"));
	        ltOptions.put("build", "Selenium 4");
	        ltOptions.put("name", testName);
	        ltOptions.put("platformName", "Windows 10");
	        ltOptions.put("seCdp", true);
	        ltOptions.put("selenium_version", "latest");
	        capabilities.setCapability("LT:Options", ltOptions);
	        capabilitiesLocal.set(capabilities);
	        WebDriver driver=null;
            try {
				 driver = new RemoteWebDriver(new URL(HUB_URL), capabilitiesLocal.get());
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
            driverLocal.set(driver);
            return driverLocal.get();
	}
	
	
	public static void quitLambdaTestDriver() {
		if(driverLocal.get()!=null) {
			driverLocal.get().quit();
			driverLocal.remove();
		}
	}
}