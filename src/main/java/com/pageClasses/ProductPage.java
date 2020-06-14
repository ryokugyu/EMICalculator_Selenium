package com.pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.pageObjects.EMICalculatorPageObjects;

import com.baseClasses.pageBaseClass;
import com.utilities.WriteResultsToExcel;

public class ProductPage extends pageBaseClass {
	
	public EMICalculatorPageObjects amountcalculator;
	
	public ProductPage(WebDriver driver, ExtentTest logger) {
		// TODO Auto-generated constructor stub
		super(driver,logger);
		
		amountcalculator = new EMICalculatorPageObjects(driver, logger);
		PageFactory.initElements(driver,amountcalculator);
	}

	public void clickEMIInArrears() {
		EMICalculatorPageObjects.EMIInArrears.click();
		logger.log(Status.INFO, "EMI in Arrears Option selected succesfully.");
	}
	


	public void clickReadMore() {
		EMICalculatorPageObjects.readMore.click();
		logger.log(Status.INFO, "ALl details of 2020 displayed succesfully.");
	}

	public static String principalAmountMonth1;
	public static String interestAmountMonth1;

	public void fetchTestResult() {
		principalAmountMonth1 = EMICalculatorPageObjects.principalAmount.getText();
		interestAmountMonth1 = EMICalculatorPageObjects.interestAmount.getText();
	}

	public void writeData() {
		String name = WriteResultsToExcel.writeData(principalAmountMonth1, interestAmountMonth1);
		logger.log(Status.INFO, "Data written in excel sheet- "+name);
	}
}
