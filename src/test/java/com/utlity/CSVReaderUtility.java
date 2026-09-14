package com.utlity;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojos.User;

public class CSVReaderUtility {

	public static Iterator<User> readCSVFile(String fileName) {
		File csvfile = null;
		FileReader fileReader = null;
		CSVReader csvReader;
		String[] line;
		List<User> userList = null;
		User userData;

		try {
			csvfile = new File(System.getProperty("user.dir") + "\\testData\\" +fileName);
			fileReader = new FileReader(csvfile);
			csvReader = new CSVReader(fileReader);
			csvReader.readNext(); // reading the column name- row1 // keepiing this as i need to skip the column name row
//			csvReader.readNext();// will give data in row2 but ont stored
//			csvReader.readNext();// row3
//			data = csvReader.readNext();  // will give data of row4 if no data is present or we have reached end of file
											// it returns null
			userList = new ArrayList<>();
			
			while ((line = csvReader.readNext()) != null) {
				userData = new User(line[0], line[1]);
				userList.add(userData);
			}
//			for( User userinfo:userList) {
//				System.out.println(userinfo);
//			}
			
		}
		catch (CsvValidationException | IOException e) {
			e.printStackTrace();
		}
      return userList.iterator();
	}
	
}
