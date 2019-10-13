package com.tests;


import mavn.pages.MavenHomePage;
import mavn.pages.WebElementMethods;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestCases extends CommonToTests{

	// read properties
	WebElementMethods WM = new WebElementMethods();
	
	
	//Search
	@Test
	public void searchDepen() {
		MavenHomePage objManHmPage = new MavenHomePage(driver);
		objManHmPage.searchAndClickDepen();
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
