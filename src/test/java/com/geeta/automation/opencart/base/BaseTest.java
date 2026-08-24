package com.geeta.automation.opencart.base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.geeta.automation.opencart.core.DriverFactory;
import com.geeta.automation.opencart.utils.ConfigReader;
import com.geeta.automation.opencart.utils.ScreenshotUtil;

public class BaseTest {
	
	protected WebDriver driver; // Driver is protected so test classes can use it.
	
	
	@BeforeMethod
	public void setUp() {
	
		ConfigReader.loadProperties();//Load browser and URL configuration
		String url = ConfigReader.getProperty("url"); // Read application URL from config.properties
		driver = DriverFactory.initDriver();//Create a fresh browser for every test method
		driver.get(url); //Open Application		
		
		//print URL and title for debugging
		System.out.println("URL: " + driver.getCurrentUrl());
		System.out.println("TITLE: " + driver.getTitle());	
	}
		
@AfterMethod
	public void tearDown(ITestResult result) {
		if (result.getStatus()== ITestResult.FAILURE) {
			
			ScreenshotUtil.takeScreenshot(driver, result.getName());
		}
		DriverFactory.quitDriver();//close the browser after each test
		driver=null; //clear the test-level driver reference
	}
}
