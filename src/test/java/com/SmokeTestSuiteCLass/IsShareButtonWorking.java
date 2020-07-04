package com.SmokeTestSuiteCLass;

import org.testng.annotations.Test;
import java.util.Hashtable;
import java.util.Properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.baseClasses.baseTestClass;
import com.pageClasses.LandingPage;
import com.pageClasses.ProductPage;
import com.utilities.ReadPropertiesFile;
import com.utilities.TestDataProvider;

public class IsShareButtonWorking extends baseTestClass {

	Properties prop = ReadPropertiesFile.readConfiguration();

	/*******************
	 * Verifying the functionality of Share button
	 *******************/
	@Test(dataProvider = "EMICalculatorTestData", description = "verify that share button is working properly")
	public void isShareButtonWorking(Hashtable<String, String> testData) {
		LandingPage landingPage;
		ProductPage productPage;

		logger = report.createTest("Share Button Functionality Test");

		// initializing the browser
		invokeBrowser(prop.getProperty("browserName"));

		landingPage = openApplication(prop.getProperty("WebPageURL"));
		landingPage.clickCarLoanButton();
		landingPage.enterLoanAmount(testData.get("CarLoanAmount"));
		landingPage.enterLoanInterestRate(testData.get("InterestRate"));
		productPage = landingPage.enterLoanTerm(testData.get("LoanTenure"));
		productPage.clickReadMore();
		productPage.share();
		logger.log(Status.PASS, "Share Button Functionality Test passed successfuly.");

	}

	@DataProvider
	public Object[][] EMICalculatorTestData() {
		return TestDataProvider.getTestData("EMICalculatorTestData.xlsx", "SmokeSuiteTestData", "emiCalculator");
	}

}
