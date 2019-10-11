package com.tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;

public class webElementMethods extends CommonToTests{

	
	//Click Element
	
	public void clickELement(By locator, String ReportingStep) {
		try {
			driver.findElement(locator).click();
			//Reporter.log("Clicked on " + ReportingStep);
			test.log(LogStatus.PASS, "clicked on "+ ReportingStep,test.addScreenCapture(screenshot()));
		} catch(Exception ee) {
			Reporter.log("Not clicked on " + ReportingStep);
			Assert.fail();
			//Reporter.log(ee.getMessage());
			test.log(LogStatus.FAIL, "Test Failed",test.addScreenCapture(screenshot()));
			
			driver.quit();
		}

	}
	
	
	//wrtite capturing screenshot method.
	
	public String screenshot() {
		try{
			String destpath="C:\\Users\\BAK\\Documents\\Raja\\SeleniumLearning\\framework\\test-output\\testresult.png";
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(screenshotFile, new File(destpath));
		 	return destpath;	
		 
		}
	catch(Exception e){
		System.out.println(e);
		
	}
		return "";
	}
		
		
		
}
