package com.geeta.automation.opencart.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {
	
	public static void takeScreenshot(WebDriver driver, String testName) {
		
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		String path = "test-output/screenshots/" + testName+".png";
		
		try {
			FileUtils.copyFile(source, new File(path));
			System.out.println("Screenshot saved: "+path);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	} 

}
