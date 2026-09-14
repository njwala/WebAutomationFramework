package com.utlity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constants.Env;

public class PropertiesUtil {
	// read properties file

	public static String readPropterty(Env env, String propertyName) {
		File propfile = new File(System.getProperty("user.dir") + "\\config\\" +env+".properties");
		FileReader readFile = null;
		Properties properties = new Properties();
		try {
			readFile = new FileReader(propfile);
			properties.load(readFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String value = properties.getProperty(propertyName.toUpperCase() );
		return value;
	}
}