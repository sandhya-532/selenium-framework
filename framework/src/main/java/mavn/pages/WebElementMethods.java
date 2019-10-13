package mavn.pages;

import static org.testng.Assert.fail;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.MarkerManager.Log4jMarker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;
import com.tests.CommonToTests;

public class WebElementMethods extends CommonToTests{

	
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
		
	//send keys
	
	public void  sendkeys_method(By locator,String key,String reprtstp){
		try{
			WebDriverWait wait = new WebDriverWait(driver,driver_Timeout);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			driver.findElement(locator).sendKeys(key);
			test.log(LogStatus.PASS, "send keys  "+ reprtstp,test.addScreenCapture(screenshot()));
		}catch(Exception e){
		Assert.fail();
		test.log(LogStatus.FAIL, "send keys not working");
		
		}
	}
	
	//javascript click
	public void javascript_click(By locator,String reportingstp){
		WebDriverWait wait = new WebDriverWait(driver,driver_Timeout);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
		WebElement element = driver.findElement(locator);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		
	}
	//select class
	
	public void selectElement(By locator,String value){
		try{
		Select selobj = new Select(driver.findElement(locator));
		selobj.selectByValue(value);
		test.log(LogStatus.PASS, "value selected is"+ value);
		}
		catch(Exception e){
			Assert.fail();
			test.log(LogStatus.FAIL, "value is not selected"+ value );
		}
	}
	
	//Action class
	
	public void actionElement(){
		 Actions actnobj = new Actions(driver);
	}
}
