package com.utlity;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojos.User;

public class ExcelReaderUtility {

	public static Iterator<User> readExcelFile(String filename) {
		// XLSX file
		File excelfile = new File(System.getProperty("user.dir") + "//testData//" + filename);
		XSSFWorkbook workbook = null;
		XSSFSheet sheet;
		Iterator<Row> rowIterator;
		Row row;
		Cell emailCell;
		Cell passwordCell;
		List<User> userList=null;
		User user;
		try {
			workbook = new XSSFWorkbook(excelfile);
			userList = new ArrayList<>();
			sheet = workbook.getSheet("login_testdata");
			rowIterator = sheet.iterator();
			rowIterator.next(); // Skip the header row
			while (rowIterator.hasNext()) {
				row = rowIterator.next();
				emailCell = row.getCell(0);
				passwordCell = row.getCell(1);
				user = new User(emailCell.getStringCellValue(), passwordCell.getStringCellValue());
				userList.add(user);
				workbook.close();
			}

		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userList.iterator();

		// System.out.println(firstCell.getStringCellValue() + " " +
		// secondCell.getStringCellValue());
	}

}
