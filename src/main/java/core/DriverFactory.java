package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	private static WebDriver driver;

	 public static WebDriver initDriver(String browser) {


	        if(browser.equalsIgnoreCase("chrome")) {

	            WebDriverManager.chromedriver().setup();

	            driver = new ChromeDriver();

	        }
	        else {

	            throw new RuntimeException(
	                "Browser not supported: " + browser
	            );

	        }
	        
	        driver.manage().window().maximize();


	        return driver;
	        
	 }
	 
	 public static WebDriver getDriver() {

	        return driver;
	 }
	 
	 public static void quitDriver() {

	        if(driver != null) {

	            driver.quit();

	        }
	 }
}
