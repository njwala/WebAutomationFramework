package com.ui.dataproviders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojos.TestData;
import com.ui.pojos.User;
import com.utlity.CSVReaderUtility;
import com.utlity.ExcelReaderUtility;

public class LoginDataProvider {

	
	@DataProvider(name="loginTestdataJsonProvider")
	public Iterator<Object[]> loginDataProvider() throws FileNotFoundException {
		Gson gson = new Gson();
		File testDatafile = new File(System.getProperty("user.dir") + "\\testData\\loginTestData.json");
		FileReader fileReader = new FileReader(testDatafile);
		TestData testData = gson.fromJson(fileReader, TestData.class);//deserialization

		List<Object[]> dataToReturn = new ArrayList<Object[]>();
		for (User user : testData.getData()) {
			dataToReturn.add(new Object[] { user });
		}
		return dataToReturn.iterator();

	}
	
	
	
	@DataProvider(name= "LoginCSVDataProvider")
	public Iterator<User> loginCSVDataProvider() {
		return CSVReaderUtility.readCSVFile("loginData.csv");
	}
	
	@DataProvider(name= "LoginExcelDataProvider")
	public Iterator<User> loginExcelDataProvider() {
		return ExcelReaderUtility.readExcelFile("loginData.xlsx");
	}
}
