package com.pageClasses;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.baseClasses.pageBaseClass;
import com.pageClasses.ProductPage;
import com.pageObjects.EMICalculatorPageObjects;
import com.utilities.ReportingFunctions;

public class LandingPage extends pageBaseClass {

	public EMICalculatorPageObjects amountcalculator;
	public ProductPage productPage;

	public LandingPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);

		amountcalculator = new EMICalculatorPageObjects(driver, logger);
		PageFactory.initElements(driver, amountcalculator);
	}

	public void clickCarLoanButton() {
		EMICalculatorPageObjects.carLoan.click();
		logger.log(Status.INFO, "Car Loan Option Selected succesfully");
	}

	public void enterLoanAmount(String Amount) {
		EMICalculatorPageObjects.loanAmount.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		EMICalculatorPageObjects.loanAmount.sendKeys(Keys.BACK_SPACE);
		EMICalculatorPageObjects.loanAmount.sendKeys(Amount);

		logger.log(Status.INFO, "Loan amount entered into the input box succesfully.");
	}

	public void enterLoanInterestRate(String interestRate) {

		EMICalculatorPageObjects.loanInterest.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		EMICalculatorPageObjects.loanInterest.sendKeys(Keys.BACK_SPACE);
		EMICalculatorPageObjects.loanInterest.sendKeys(interestRate);

		logger.log(Status.INFO, "Loan interest rate entered into the input box succesfully.");

	}

	public ProductPage enterLoanTerm(String loanPeriod) {

		EMICalculatorPageObjects.loanTerm.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		EMICalculatorPageObjects.loanTerm.sendKeys(Keys.BACK_SPACE);
		EMICalculatorPageObjects.loanTerm.sendKeys(loanPeriod);
		logger.log(Status.INFO, "Loan Tenure(in Years) entered into the input box succesfully.");

		productPage = new ProductPage(driver, logger);
		PageFactory.initElements(driver, productPage);

		return productPage;

	}

	/****************** Get Page Title ***********************/
	public void getTitle(String expectedTitle) {
		try {
			Assert.assertEquals(driver.getTitle(), expectedTitle);
			ReportingFunctions.reportPass(
					"Actual Title : " + driver.getTitle() + " - equals to Expected Title : " + expectedTitle, logger);
		} catch (AssertionError e) {
			ReportingFunctions.reportFail(e.getMessage(), driver, logger);
		}
	}

}
