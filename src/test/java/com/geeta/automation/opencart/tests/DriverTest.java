package com.geeta.automation.opencart.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import core.DriverFactory;

public class DriverTest {
	
	@Test
	public void openBrowserTest() {
		
		WebDriver driver = DriverFactory.initDriver("Chrome");
		
		driver.get("https://demo.opencart.com/");
		
		System.out.println(driver.getTitle());
		
		DriverFactory.quitDriver();
		
	}

}
