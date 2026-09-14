package com.ui.listerners;

import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.constants.Env;
import com.utlity.JsonUtility;
import com.utlity.LoggerUtility;

public class MyRetryAnalyzer implements IRetryAnalyzer {
	//private static final int MAX_ATTEMPTS = Integer.parseInt(PropertiesUtil.readPropterty(Env.DEV, "MAX_ATTEMPTS"));
	private static final int MAX_ATTEMPTS= JsonUtility.readJson(Env.DEV).getMaxAttempts();
	private static int currentAttempt = 1;
	Logger logger = LoggerUtility.getLogger(this.getClass());

	@Override
	public boolean retry(ITestResult result) {
		logger.info("Retrying test " + result.getMethod().getMethodName() + " with status "
				 + " for the " + currentAttempt + " time(s).");
		if (currentAttempt <= MAX_ATTEMPTS) {
			currentAttempt++;
			return true;
		}
		return false;
	}
}