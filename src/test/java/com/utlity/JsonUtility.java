package com.utlity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.constants.Env;
import com.google.gson.Gson;
import com.ui.pojos.Config;
import com.ui.pojos.Environment;

public class JsonUtility {

	public static Environment readJson(Env env) {
		Gson gson = new Gson();
		File jsonFile = new File(System.getProperty("user.dir") + "\\config\\config.json");
		FileReader filereader = null;
		try {
			filereader = new FileReader(jsonFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Config config = gson.fromJson(filereader, Config.class);
		Environment environment = config.getEnvironments().get("QA");
		return environment;
	}
}