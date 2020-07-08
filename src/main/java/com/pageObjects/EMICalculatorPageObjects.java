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
	@FindBy(xpath = "//div[@class='sep row form-group lterm']//label[2]")
	public static WebElement monthButton;

	// First Month
	@FindBy(xpath = "//*[@id=\"loantermsteps\"]/span[2]/span")
	public static WebElement firstMonth;

	// Home Loan Element
	@FindBy(xpath = "//*[@id=\"home-loan\"]/a")
	public static WebElement homeLoan;

	// Slider element
	@FindBy(xpath = "//div[@id='loantermslider']//div[@class='ui-slider-range ui-widget-header ui-corner-all ui-slider-range-min']")
	public static WebElement slider;

	@FindBy(xpath = "//div[@id='loantermslider']//span[@class='ui-slider-handle ui-state-default ui-corner-all']")
	public static WebElement hiddenSlider;

	// FAQ page element
	@FindBy(xpath = "//a[@id='menu-item-dropdown-2207']")
	public static WebElement FAQs;

	// Car Loan FAQ page element
	@FindBy(xpath = "//a[contains(text(),'Car Loan FAQ')]")
	public static WebElement CarFAQs;

	// Car Loan FAQ Title
	@FindBy(xpath = "//h1[contains(text(),'Car Loan FAQ')]")
	public static WebElement CarLoanFAQTitleText;

}
