package com.testClasses;
import org.testng.annotations.Test;
import java.util.Hashtable;
import java.util.Properties;

import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.Status;
import com.baseClasses.baseTestClass;
import com.pageClasses.LandingPage;
import com.utilities.ReadPropertiesFile;
import com.utilities.TestDataProvider;
import com.pageObjects.EMICalculatorPageObjects;

public class EMICalculatorSmokeTests extends baseTestClass {
	
	Properties prop = ReadPropertiesFile.readConfiguration();
	
	
	/******************* Page Title Test*******************/
	@Test(dataProvider="EMICalculatorTestSmokeSuiteDriverTitleData",description="checks the webpage title")
	public void verifyPageTitle(Hashtable<String, String> testData) {
		LandingPage landingPage;
		
		System.out.println("******Executing verifyPageTitle Test******");
		
		//creating test for logger to record
		logger = report.createTest("EMICalculator Page title Test");
		
		//initializing the browser
		invokeBrowser(prop.getProperty("browserName"));
		landingPage = openApplication(prop.getProperty("WebPageURL"));
		landingPage.getTitle(testData.get("title"));
		
		logger.log(Status.PASS, "EMICalculator webpage title test passed successfuly");
	}
	
	
	/******************* Car Loan element present Test*******************/
	@Test(description="verify that CarLoan element is present")
	public void isCarLoanElementPresent() {
		LandingPage landingPage;
		
		System.out.println("******Executing isCarLoanElementPresent Test******");
		
		logger = report.createTest("EMICalculator: Is carLoan Element Present.");
		
		invokeBrowser(prop.getProperty("browserName"));
		landingPage = openApplication(prop.getProperty("WebPageURL"));
		landingPage.veriyElementIsDisplayed(EMICalculatorPageObjects.carLoan);
		logger.log(Status.PASS, "EMICalculator:  Is carLoan Element Present test passed successfuly");
		
	}
	
	
	/*******************Verifying the Total Payment Amount Test*******************/
	@Test(dataProvider="EMICalculatorVerifyTotalPaymentAmountData",description="verify that total payment amount is correct")
	public void isTotalPaymentAmountVerify(Hashtable<String, String> testData) {
		LandingPage landingPage;
		System.out.println("******Executing isTotalPaymentAmountVerify Test******");
		//creating test for logger to record
		logger = report.createTest("Total Payment Amount Verify Test");
		
		//initializing the browser
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
	public Object[][] EMICalculatorTestSmokeSuiteDriverTitleData(){
		return TestDataProvider.getTestData("EMICalculatorTestData.xlsx", "LoanDetails", "driverTitleTestData");
	}
	
	@DataProvider
	public Object[][] EMICalculatorVerifyTotalPaymentAmountData(){
		return TestDataProvider.getTestData("EMICalculatorTestData.xlsx", "LoanDetails", "totalPaymentAmountVerify");
	}

}
