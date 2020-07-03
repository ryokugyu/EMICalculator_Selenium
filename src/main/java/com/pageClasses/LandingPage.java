package com.pageClasses;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

	/******************* Select Car Loan option *******************/
	public void clickCarLoanButton() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(EMICalculatorPageObjects.carLoan));
			EMICalculatorPageObjects.carLoan.click();
			logger.log(Status.INFO, "Car Loan Option Selected succesfully");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/******************* Input the Loan Amount *******************/
	public void enterLoanAmount(String Amount) {
		EMICalculatorPageObjects.loanAmount.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		EMICalculatorPageObjects.loanAmount.sendKeys(Keys.BACK_SPACE);
		EMICalculatorPageObjects.loanAmount.sendKeys(Amount);

		logger.log(Status.INFO, "Loan amount entered into the input box succesfully.");
	}

	/******************* Input the Loan Interest Rate *******************/
	public void enterLoanInterestRate(String interestRate) {
		EMICalculatorPageObjects.loanInterest.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		EMICalculatorPageObjects.loanInterest.sendKeys(Keys.BACK_SPACE);
		EMICalculatorPageObjects.loanInterest.sendKeys(interestRate);

		logger.log(Status.INFO, "Loan interest rate entered into the input box succesfully.");

	}

	/******************* Input the Loan Period(in years) *******************/
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

	/****************** Verify Element is Present ***********************/
	public void veriyElementIsDisplayed(WebElement carLoan) {
		try {
			if (carLoan.isDisplayed()) {
				ReportingFunctions.reportPass("Car Loan Button is Displayed", logger);
			} else {
				ReportingFunctions.reportFail("Car Loan Button not appeared", driver, logger);
			}

		} catch (Exception e) {
			ReportingFunctions.reportFail(e.getMessage(), driver, logger);
		}

	}

	/****************** Verify Total Payment Amount ***********************/
	public void verifyTotalPaymentAmount(String expectedTotalPaymentAmount) {
		String amount = EMICalculatorPageObjects.totalPaymentAmount.getText();
		amount = amount.replaceAll(",", "");
		amount = amount + ".0";
		try {
			Assert.assertEquals(amount, expectedTotalPaymentAmount);
			ReportingFunctions.reportPass("Actual Total Payment Amount : " + amount
					+ " - equals to Expected Total payment amount : " + expectedTotalPaymentAmount, logger);
		} catch (AssertionError e) {
			ReportingFunctions.reportFail(e.getMessage(), driver, logger);
		}

	}

	/*****************
	 * Verify Total payment amount for the loan
	 *********************/
	public void verifyCarLoanAmountInput(String expectedTotalPaymentAmount) {
		String amount = EMICalculatorPageObjects.totalPaymentAmount.getText();
		amount = amount.replaceAll(",", "");
		amount = amount + ".0";
		try {
			Assert.assertEquals(amount, expectedTotalPaymentAmount);
			ReportingFunctions.reportPass("Actual Total Payment Amount : " + amount
					+ " - equals to Expected Total payment amount : " + expectedTotalPaymentAmount, logger);
		} catch (AssertionError e) {
			ReportingFunctions.reportFail(e.getMessage(), driver, logger);
		}
	}

	/*****************
	 * Verifying response when syntactical data entered
	 *********************/
	public void defaultValues() {
		String carLoanAmount = EMICalculatorPageObjects.loanAmount.getText();
		String interestRate = EMICalculatorPageObjects.interestAmount.getText();
		String loanTenure = EMICalculatorPageObjects.loanTerm.getText();
		try {
			try {
				Assert.assertEquals(carLoanAmount, "");
				logger.log(Status.INFO, "Invalid value of Car Loan Amount converted to Default mentioned value");
			} catch (AssertionError e) {
				ReportingFunctions.reportFail(e.getMessage(), driver, logger);
			}
			try {
				Assert.assertEquals(interestRate, "");
				logger.log(Status.INFO, "Invalid value of Interest Rate converted to Default mentioned value");
			} catch (AssertionError e) {
				ReportingFunctions.reportFail(e.getMessage(), driver, logger);
			}
			try {
				Assert.assertEquals(loanTenure, "");
				logger.log(Status.INFO, "Invalid value of Loan Tenure converted to Default mentioned value");
			} catch (AssertionError e) {
				ReportingFunctions.reportFail(e.getMessage(), driver, logger);
			}
		} catch (Exception e) {
			ReportingFunctions.reportFail(e.getMessage(), driver, logger);
		}

	}
}
