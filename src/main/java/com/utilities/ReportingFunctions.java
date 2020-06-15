package com.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.utilities.TakeScreenshots;

public class ReportingFunctions {
	/**************Reporting Functions*******************/
	
	public static void reportFail(String reportString,WebDriver driver, ExtentTest logger) {
		logger.log(Status.FAIL, reportString);
		TakeScreenshots.takeScreenShotOnFailure(driver, logger);
		Assert.fail(reportString);
	}

	public static void reportPass(String reportString, ExtentTest logger) {
		logger.log(Status.INFO, reportString);
	}
}
