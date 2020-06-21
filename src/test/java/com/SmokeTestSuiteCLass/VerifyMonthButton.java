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

public class VerifyMonthButton extends baseTestClass {
	Properties prop = ReadPropertiesFile.readConfiguration();

	/*******************
	 * Verifying the functionality of Month option
	 *******************/

	@Test(dataProvider = "EMICalculatorVerifyMonthButtonTestData", description = "verify month button functionality ")
	public void verifyMonthButton(Hashtable<String, String> testData) {
		LandingPage landingPage;

		// creating test for logger to record
		logger = report.createTest("EMI_Calculator Fourth Test");

		// initializing the browser
		invokeBrowser(prop.getProperty("browserName"));

		landingPage = openApplication(prop.getProperty("WebPageURL"));
		landingPage.clickCarLoanButton();
		landingPage.enterLoanAmount(testData.get("CarLoanAmount"));
		landingPage.enterLoanInterestRate(testData.get("InterestRate"));
		landingPage.enterLoanTerm(testData.get("LoanTenure"));
		landingPage.verifyLoanTenureMonth();
		logger.log(Status.PASS, "EMI Calculator verify Month button Test Pass");
	}

	@DataProvider
	public Object[][] EMICalculatorVerifyMonthButtonTestData() {
		return TestDataProvider.getTestData("EMICalculatorTestData.xlsx", "SmokeSuiteTestData", "verifyMonthButton");
	}
}
