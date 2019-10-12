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
	public static String search="";
	public static WebDriver driver;
	public static ExtentTest test;
	public static ExtentReports report;

	@BeforeSuite
	public void beforeSuiteActivities () {

		//Step1: Properties reading
		try {
			globalDataProperties = new Properties();
			FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\applictionGlobalData.properties");									
			globalDataProperties.load(objfile);

			sURL = globalDataProperties.getProperty("URL");
			sBrowser = globalDataProperties.getProperty("Browser");
			search =globalDataProperties.getProperty("search_text");
		} catch (Exception ee) {
			System.out.println("Properties file reading failed.");
		}



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
	@BeforeTest
	public void beforeTest(){

		report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
		test = report.startTest("Extentreport");

	}


	@AfterTest
	public void endTest()

	{

		report.endTest(test);

		report.flush();


	}

}