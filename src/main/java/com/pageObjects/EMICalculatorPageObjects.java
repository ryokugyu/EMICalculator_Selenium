package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;

import com.baseClasses.pageBaseClass;

public class EMICalculatorPageObjects extends pageBaseClass {

	public EMICalculatorPageObjects(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}

	// CarLoan WebElement
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/main[1]/article[1]/div[3]/div[1]/div[1]/div[1]/ul[1]/li[3]/a[1]")
	public static WebElement carLoan;

	// Car loan Amount input WebElement
	@FindBy(xpath = "//input[@id='loanamount']")
	public static WebElement loanAmount;

	// Car loan interest WebElement
	@FindBy(xpath = "//input[@id='loaninterest']")
	public static WebElement loanInterest;

	// Car loan tenure(in years) WebElement
	@FindBy(xpath = "//input[@id='loanterm']")
	public static WebElement loanTerm;

	// EMI in Arrears Options WebElement
	@FindBy(xpath = "//*[@id=\"leschemewrapper\"]/div/div/div/div/label[2]")
	public static WebElement EMIInArrears;

	// Read More WebElement
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/main[1]/article[1]/div[3]/div[1]/div[3]/div[2]/table[1]/tbody[1]/tr[2]/td[1]")
	public static WebElement readMore;

	// Principal Amount for first month WebElement
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/main[1]/article[1]/div[3]/div[1]/div[3]/div[2]/table[1]/tbody[1]/tr[3]/td[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]")
	public static WebElement principalAmount;

	// Interest amount for first month WebElement
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/main[1]/article[1]/div[3]/div[1]/div[3]/div[2]/table[1]/tbody[1]/tr[3]/td[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]")
	public static WebElement interestAmount;

	// Total Payment Amount
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/main[1]/article[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/p[1]/span[1]")
	public static WebElement totalPaymentAmount;

	// Share Link
	@FindBy(xpath = "//*[@id='sharelink']")
	public static WebElement shareLink;

	// Share Link button
	@FindBy(xpath = "//*[@id='ecalprintandshare']/a[2]")
	public static WebElement shareButton;

	// Loan Tenure in-term of Months
	@FindBy(xpath = "//*[@id=\"loanmonths\"]")
	public static WebElement monthButton;

	// First Month
	@FindBy(xpath = "//*[@id=\"loantermsteps\"]/span[2]/span")
	public static WebElement firstMonth;
}
