package com.SmokeTestSuiteCLass;

import java.util.Hashtable;
import java.util.Properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.baseClasses.baseTestClass;
import com.pageClasses.LandingPage;
import com.utilities.ReadPropertiesFile;
import com.utilities.TestDataProvider;

public class InvalidValueBehaviour extends baseTestClass {

	Properties prop = ReadPropertiesFile.readConfiguration();

	/*******************
	 * Verifying input text behavior when invalid input is provided
	 *******************/
	@Test(dataProvider = "EMICalculatorVerifyIncorrectValuesBehaviour", description = "valid input test")
	public void verifyDataCredibility(Hashtable<String, String> testData) throws InterruptedException {
		LandingPage landingPage;

		System.out.println("******Executing EMICalculator Valid Input Test******");
		// creating test for logger to record
		logger = report.createTest("EMICalculator Valid Input Test");

		// initializing the browser
		invokeBrowser(prop.getProperty("browserName"));

		landingPage = openApplication(prop.getProperty("WebPageURL"));
		landingPage.clickCarLoanButton();
		landingPage.enterLoanAmount(testData.get("CarLoanAmount"));
		landingPage.enterLoanInterestRate(testData.get("InterestRate"));
		landingPage.enterLoanTerm(testData.get("LoanTenure"));
		landingPage.defaultValues();
		logger.log(Status.PASS, "EMI Calculator Valid Input Test Pass");

	}

	@DataProvider
	public Object[][] EMICalculatorVerifyIncorrectValuesBehaviour() {
		return TestDataProvider.getTestData("EMICalculatorTestData.xlsx", "SmokeSuiteTestData", "verifyDataValues");
	}

}
