package com.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestCases extends CommonToTests{

	// read properties


	webElementMethods WM = new webElementMethods();
	
	@Test
	public void login(){
		//Check driver is null.
		try {
			
			WM.clickELement(By.linkText("Menu"), "Menu Link ");
			WM.screenshot();
			
			driver.quit();
		} catch (Exception e) {
		}
	}
	
	//@Test
	public void login1(){
		
		//Check driver is null.
		try {
			WM.clickELement(By.xpath("//button[text()='Log In']"), "Login Button");
		} catch (Exception e) {

		}
	}



}
