package pageClasses;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClasses.pageBaseClass;
import com.pageObjects.EMICalculatorPageObjects;

//import utilities.WriteResultsToExcel;
import pageClasses.ProductPage;

public class LandingPage extends pageBaseClass {
	
	public EMICalculatorPageObjects amountcalculator;
	public ProductPage productPage;

	public LandingPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		
		amountcalculator = new EMICalculatorPageObjects(driver, logger);
		PageFactory.initElements(driver,amountcalculator);
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

/*
	
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
	*/
}

