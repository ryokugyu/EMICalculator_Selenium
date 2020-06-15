package com.baseClasses;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

public class pageBaseClass extends baseTestClass {

	public pageBaseClass(WebDriver driver, ExtentTest logger) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.logger = logger;
	}

}
