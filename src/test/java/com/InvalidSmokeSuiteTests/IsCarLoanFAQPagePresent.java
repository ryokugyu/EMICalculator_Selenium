package com.InvalidSmokeSuiteTests;

import org.testng.annotations.Test;
import java.util.Properties;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.baseClasses.baseTestClass;
import com.pageClasses.LandingPage;
import com.utilities.ReadPropertiesFile;

public class IsCarLoanFAQPagePresent extends baseTestClass {

	Properties prop = ReadPropertiesFile.readConfiguration();

	/******************* Verify Car Loan FAQ page is present *******************/
	@Test(description = "verify that CarLoan element is present")
	public void isCarLoanElementPresent() {
		LandingPage landingPage;

		System.out.println("******Executing isCarLoanElementPresent Test******");

		logger = report.createTest("EMICalculator: Is carLoan Element Present.");

		invokeBrowser(prop.getProperty("browserName"));
		landingPage = openApplication(prop.getProperty("WebPageURL"));
		landingPage.isCarLoanFAQPagePresent();
		logger.log(Status.PASS, "EMICalculator:  Is carLoan Element Present test passed successfuly");

	}

}
