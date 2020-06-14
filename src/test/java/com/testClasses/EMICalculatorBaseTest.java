package com.testClasses;

import java.util.Hashtable;
import java.util.Properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import baseClasses.baseTestClass;
import pageClasses.LandingPage;
import utilities.ReadPropertiesFile;
import utilities.TestDataProvider;

public class EMICalculatorBaseTest extends baseTestClass {
	LandingPage landingPage;
	//ProductPage productPage;
	
	@Test(dataProvider="EMICalculatorTestData",description="executes the complete test")
	public void emicalculator(Hashtable<String, String> testData) {
		
		Properties prop = ReadPropertiesFile.readConfiguration();
		
		logger = report.createTest("EMI_Calculator Test");
		
		invokeBrowser(prop.getProperty("browserName"));
		landingPage = openApplication(testData.get("WebPageURL"));
		landingPage.clickCarLoanButton();
		
		String CarLoanAmount = testData.get("CarLoanAmount");
		//System.out.println(CarLoanAmount);
		landingPage.enterLoanAmount(CarLoanAmount);
		
		String InterestRate = testData.get("InterestRate");
		//System.out.println(InterestRate);
		landingPage.enterLoanInterestRate(InterestRate);
		
		String LoanTenure = testData.get("LoanTenure");
		//System.out.println(LoanTenure);
		landingPage.enterLoanTerm(LoanTenure);
		
		landingPage.clickEMIInArrears();
		landingPage.clickReadMore();
		landingPage.fetchTestResult();
		landingPage.writeData();
		logger.log(Status.PASS, "EMI Calculator Base Test Pass");
	}
	
	@DataProvider
	public Object[][] EMICalculatorTestData(){
		return TestDataProvider.getTestData("EMICalculatorTestData.xlsx", "LoanDetails", "emiCalculator");
	}
}
