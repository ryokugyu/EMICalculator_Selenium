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

public class TotalPaymentAmountVerify extends baseTestClass {
	Properties prop = ReadPropertiesFile.readConfiguration();

	/*******************
	 * Verifying the Total Payment Amount
	 *******************/
	@Test(dataProvider = "EMICalculatorVerifyTotalPaymentAmountData", description = "verify that total payment amount is correct")
	public void isTotalPaymentAmountVerify(Hashtable<String, String> testData) {
		LandingPage landingPage;
		System.out.println("******Executing isTotalPaymentAmountVerify Test******");
		// creating test for logger to record
		logger = report.createTest("Total Payment Amount Verify Test");

		// initializing the browser
		invokeBrowser(prop.getProperty("browserName"));

		landingPage = openApplication(prop.getProperty("WebPageURL"));
		landingPage.clickCarLoanButton();
		landingPage.enterLoanAmount(testData.get("CarLoanAmount"));
		landingPage.enterLoanInterestRate(testData.get("InterestRate"));
		landingPage.enterLoanTerm(testData.get("LoanTenure"));
		landingPage.verifyTotalPaymentAmount(testData.get("expectedTotalAmount"));

		logger.log(Status.PASS, "EMICalculator:  Is carLoan Element Present test passed successfuly");

	}

	@DataProvider
	public Object[][] EMICalculatorVerifyTotalPaymentAmountData() {
		return TestDataProvider.getTestData("EMICalculatorTestData.xlsx", "LoanDetails", "totalPaymentAmountVerify");
	}

}
