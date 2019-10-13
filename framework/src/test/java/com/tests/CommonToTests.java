package com.tests;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class CommonToTests {

	public static Properties globalDataProperties;

	public static String sURL = "";
	public static String sBrowser = "";
	public  Long driver_Timeout;
	public static WebDriver driver;
	public static ExtentTest test;
	public static ExtentReports report;
	public static WebDriver wait;

	@BeforeSuite
	public void beforeSuiteActivities () {

		//Step1: Properties reading
		try {
			globalDataProperties = new Properties();
			FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\applictionGlobalData.properties");									
			globalDataProperties.load(objfile);

			sURL = globalDataProperties.getProperty("URL");
			sBrowser = globalDataProperties.getProperty("Browser");
			driver_Timeout =Long.parseLong(globalDataProperties.getProperty("Timeout"));
		} catch (Exception ee) {
			System.out.println("Properties file reading failed.");
		}



	}
	
	@BeforeTest
	public void beforeTest(){
		report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
		test = report.startTest("Extentreport");
	}



	@BeforeMethod
	public void createDriver() {
		//Step2: Browser creation
		try{
			if(sBrowser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				test.log(LogStatus.PASS, "chrome Browser initiated");
				System.out.println("driver created");
				driver.get(sURL);
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	
	

	@AfterTest
	public void endTest()

	{

		report.endTest(test);

		report.flush();


	}

}