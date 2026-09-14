package com.ui.listerners;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.tests.TestBase;
import com.utlity.BrowserUtility;
import com.utlity.ExtentReportUtility;
import com.utlity.LoggerUtility;

public class TestListener implements ITestListener {
	Logger logger = LoggerUtility.getLogger(this.getClass());
	ExtentSparkReporter sparkReporter;
	ExtentReports extentReports ;
    ExtentTest extentTest;

	public void onTestStart(ITestResult result) {
		logger.info(result.getMethod().getMethodName());
		logger.info(result.getMethod().getDescription());
		logger.info(Arrays.toString(result.getMethod().getGroups()));
		ExtentReportUtility.createExtentTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		logger.info(result.getMethod().getMethodName() + " is passed");
		ExtentReportUtility.getTest().log(Status.PASS,result.getMethod().getMethodName() + " is passed");
	}

	public void onTestFailure(ITestResult result) {
		logger.error(result.getMethod().getMethodName() + " is failed");
		logger.error(result.getThrowable().getMessage());
		ExtentReportUtility.getTest().log(Status.FAIL,result.getMethod().getMethodName() + " is failed");
		ExtentReportUtility.getTest().log(Status.FAIL,result.getThrowable().getMessage());
		Object testclass=result.getInstance();
		
		BrowserUtility browserUtility=((TestBase)testclass).getInstance();
		logger.info("capturing screenshot...");
		
		String screenshotpath=browserUtility.takeScreenshot(result.getMethod().getMethodName());
		logger.info("attaching screenshot to the report...");
		
		ExtentReportUtility.getTest().addScreenCaptureFromPath(screenshotpath);
	}

	public void onTestSkipped(ITestResult result) {
		logger.warn(result.getMethod().getMethodName() + " is skipped");
		ExtentReportUtility.getTest().log(Status.SKIP,result.getMethod().getMethodName() + " is skipped");
		ExtentReportUtility.getTest().log(Status.SKIP,result.getThrowable().getMessage());
	}

	public void onStart(ITestContext context) {
		logger.error("Test suite execution started");
		ExtentReportUtility.setupSparkReporter("report.html");
	}

	public void onFinish(ITestContext context) {
		logger.error("Test suite execution finished");
		ExtentReportUtility.flushReport();// generate the report
	}

}

/*

the above approach of extent report is not thread safe, ie. if we run the tests in parallel, the excution order of the tests will get mixed up and 
the report will not be generated properly. To make it thread safe, we can use ThreadLocal<ExtentTest> to store the extentTest object for each thread.
thread-safe = ThreadLocal= isolation of data between threads. Each thread will have its own copy of the variable and will not be able to access the variable of other threads.


*/