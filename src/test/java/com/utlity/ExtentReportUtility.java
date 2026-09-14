package com.utlity;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {

	private static ExtentReports extentReports;// heavy lifting/dumping-add data to html file - create the report, add
												//test cases, add logs, add screenshots, generate the report

	private static ThreadLocal< ExtentTest> extentTest = new ThreadLocal<>();;// store the test case information and logs for each test case

	public static void setupSparkReporter(String reportName) {
		ExtentSparkReporter sparkReporter;// purpose- provide functionality to create the report and configure it[look,style]
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//reports//"+ reportName);// create the report file in the reports folder
		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter);// tell extent report to use this reporter to generate the report
	}
	
	public static void createExtentTest(String testName) {
		ExtentTest test= extentReports.createTest(testName);
		extentTest.set(test);//
	}

	public static ExtentTest getTest() {
		return extentTest.get();
	}
	
	public static void flushReport() {
		extentReports.flush();
	}
}
