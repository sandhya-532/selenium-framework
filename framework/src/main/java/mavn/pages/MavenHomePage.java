package mavn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.LogStatus;
import com.tests.CommonToTests;

public class MavenHomePage {
	
	
	WebDriver driver;
		
	WebElementMethods WM = new WebElementMethods();
	
	public MavenHomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void searchAndClickDepen() {
		
		driver.findElement(By.name("q")).sendKeys("selenium");
		WM.clickELement(By.name("q"), "Selenium text is entered");
		CommonToTests.test.log(LogStatus.PASS, "search and click function works");
		//driver.findElement(By.name("q")).sendKeys("selenium");
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		try {
			driver.findElement(By.linkText("Selenium Java")).isDisplayed();
		} catch(Exception ee) {
			System.out.println("Selenium Java is not present");
		}
	}

}
