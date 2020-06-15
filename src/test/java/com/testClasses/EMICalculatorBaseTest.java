package com.testClasses;

import org.testng.annotations.Test;
import java.util.Hashtable;
import java.util.Properties;
import org.testng.annotations.DataProvider;
import com.aventstack.extentreports.Status;

import com.baseClasses.baseTestClass;
import com.pageClasses.LandingPage;
import com.pageClasses.ProductPage;
import com.utilities.ReadPropertiesFile;
import com.utilities.TestDataProvider;

public class EMICalculatorBaseTest extends baseTestClass {
	LandingPage landingPage;
	ProductPage productPage;
	
	@Test(dataProvider="EMICalculatorTestData",description="executes the complete test")
	public void emicalculator(Hashtable<String, String> testData) throws InterruptedException {
		
		Properties prop = ReadPropertiesFile.readConfiguration();
		
		//creating test for logger to record
		logger = report.createTest("EMI_Calculator Test");
		
		//initializing the browser
		invokeBrowser(prop.getProperty("browserName"));
		
		landingPage = openApplication(prop.getProperty("WebPageURL"));
		landingPage.clickCarLoanButton();
		landingPage.enterLoanAmount(testData.get("CarLoanAmount"));
		landingPage.enterLoanInterestRate(testData.get("InterestRate"));
		
		productPage = landingPage.enterLoanTerm(testData.get("LoanTenure"));
		productPage.clickEMIInArrears();
		productPage.clickReadMore();
		productPage.fetchTestResult();
		productPage.writeData();
		
		logger.log(Status.PASS, "EMI Calculator Base Test Pass");
	}
	
	@DataProvider
	public Object[][] EMICalculatorTestData(){
		return TestDataProvider.getTestData("EMICalculatorTestData.xlsx", "LoanDetails", "emiCalculator");
	}
}
