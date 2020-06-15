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

public class EMICalculatorSmokeTests extends baseTestClass {
	
	LandingPage landingPage;
	Properties prop = ReadPropertiesFile.readConfiguration();
	
	@Test(dataProvider="EMICalculatorTestSmokeSuiteDriverTitleData",description="checks the webpage title")
	public void emicalculator(Hashtable<String, String> testData) {
		
		//creating test for logger to record
		logger = report.createTest("EMICalculator web page test");
		
		//initializing the browser
		invokeBrowser(prop.getProperty("browserName"));
		landingPage = openApplication(testData.get("WebPageURL"));
		landingPage.getTitle(testData.get("title"));
		
		logger.log(Status.PASS, "EMICalculator webpage title test passed successfuly");
	}
	
	@DataProvider
	public Object[][] EMICalculatorTestSmokeSuiteDriverTitleData(){
		return TestDataProvider.getTestData("EMICalculatorTestData.xlsx", "LoanDetails", "driverTitleTestData");
	}

}
