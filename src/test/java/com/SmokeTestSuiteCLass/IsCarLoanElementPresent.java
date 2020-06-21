package com.SmokeTestSuiteCLass;

import java.util.Properties;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.baseClasses.baseTestClass;
import com.pageClasses.LandingPage;
import com.pageObjects.EMICalculatorPageObjects;
import com.utilities.ReadPropertiesFile;

public class IsCarLoanElementPresent extends baseTestClass {
	Properties prop = ReadPropertiesFile.readConfiguration();

	/******************* Car Loan element present Test *******************/
	@Test(description = "verify that CarLoan element is present")
	public void isCarLoanElementPresent() {
		LandingPage landingPage;

		System.out.println("******Executing isCarLoanElementPresent Test******");

		logger = report.createTest("EMICalculator: Is carLoan Element Present.");

		invokeBrowser(prop.getProperty("browserName"));
		landingPage = openApplication(prop.getProperty("WebPageURL"));
		landingPage.veriyElementIsDisplayed(EMICalculatorPageObjects.carLoan);
		logger.log(Status.PASS, "EMICalculator:  Is carLoan Element Present test passed successfuly");

	}
}
