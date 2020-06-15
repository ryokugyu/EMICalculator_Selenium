package com.baseClasses;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.utilities.TakeScreenshot;

public class pageBaseClass extends baseTestClass {

	public pageBaseClass(WebDriver driver, ExtentTest logger) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.logger = logger;
	}

	/****************** Get Page Title ***********************/
	public void getTitle(String expectedTitle) {
		try {
			Assert.assertEquals(driver.getTitle(), expectedTitle);
			reportPass("Actual Title : " + driver.getTitle() + " - equals to Expected Title : " + expectedTitle);
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	/****************** Reporting Functions ***********************/
	public void reportFail(String reportString) {
		logger.log(Status.FAIL, reportString);
		TakeScreenshot.takeScreenShotOnFailure(driver, logger);
		Assert.fail(reportString);
	}


	public void reportPass(String reportString) {
		logger.log(Status.PASS, reportString);
	}
}
