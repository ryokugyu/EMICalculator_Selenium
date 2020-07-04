package com.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class TakeScreenshots {
	
	/****************** Capture Screen Shot ***********************/
	public static void takeScreenShotOnFailure(WebDriver driver, ExtentTest logger) {
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		File sourceFile = takeScreenShot.getScreenshotAs(OutputType.FILE);
		String timeStamp = DateUtil.getTimeStamp();
		File destFile = new File(System.getProperty("user.dir") + "//ScreenShots//" + timeStamp + ".png");
		try {
			FileUtils.copyFile(sourceFile, destFile);
			logger.addScreenCaptureFromPath(System.getProperty("user.dir") + "//ScreenShots//" + timeStamp +".png");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
