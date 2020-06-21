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

public class VerifyPageTitle extends baseTestClass {

	Properties prop = ReadPropertiesFile.readConfiguration();

	/******************* Page Title Test *******************/
	@Test(dataProvider = "EMICalculatorTestSmokeSuiteDriverTitleData", description = "checks the webpage title")
	public void verifyPageTitle(Hashtable<String, String> testData) {
		LandingPage landingPage;

		System.out.println("******Executing verifyPageTitle Test******");

		// creating test for logger to record
		logger = report.createTest("EMICalculator Page title Test");

		// initializing the browser
		invokeBrowser(prop.getProperty("browserName"));
		landingPage = openApplication(prop.getProperty("WebPageURL"));
		landingPage.getTitle(testData.get("title"));

		logger.log(Status.PASS, "EMICalculator webpage title test passed successfuly");
	}
	
	@DataProvider
	public Object[][] EMICalculatorTestSmokeSuiteDriverTitleData() {
		return TestDataProvider.getTestData("EMICalculatorTestData.xlsx", "SmokeSuiteTestData", "driverTitleTestData");
	}
}
