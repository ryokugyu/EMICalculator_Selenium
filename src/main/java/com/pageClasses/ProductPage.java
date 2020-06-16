package com.pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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
	
	public static String principalAmountMonth1;
	public static String interestAmountMonth1;

	public void clickReadMore() {
		EMICalculatorPageObjects.readMore.click();
		logger.log(Status.INFO, "All details of 2020 displayed succesfully.");
	}

	public void fetchTestResult() {
		principalAmountMonth1 = EMICalculatorPageObjects.principalAmount.getText();
		interestAmountMonth1 = EMICalculatorPageObjects.interestAmount.getText();
	}
	
	public void share() {
		EMICalculatorPageObjects.shareButton.click();
		logger.log(Status.INFO, "Shared Link button is pressed successfully");
		String sharelink = EMICalculatorPageObjects.shareLink.getAttribute("value");
		Assert.assertEquals(sharelink, "https://ecal.in/");
		logger.log(Status.INFO, "Shared Link is created successfully");
		
	}

	public void writeData() {
		String name = WriteResultsToExcel.writeData(principalAmountMonth1, interestAmountMonth1);
		logger.log(Status.INFO, "Data written in excel sheet- "+name);
	}
}
