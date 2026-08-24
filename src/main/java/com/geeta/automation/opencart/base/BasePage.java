 package com.geeta.automation.opencart.base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	protected WebDriver driver;
	protected WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver= driver;
		this.wait = new WebDriverWait (driver, Duration.ofSeconds(10));

	}
	
	protected void clickElement (By locator) {
		
		 wait.until(ExpectedConditions.elementToBeClickable(locator)).click();;
	}

	protected void waitForElementVisible(By locator) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
		
	protected void enterText (By locator,String text) {
	waitForElementVisible(locator);
	
	WebElement element = driver.findElement(locator);
	element.clear();
	element.sendKeys(text);
	}
	
	protected String getText (By locator) {
		waitForElementVisible(locator);
		return driver.findElement(locator).getText();
	}
	
	protected boolean isElementDisplayed(By locator) {
		
		
		try {
			waitForElementVisible(locator);
			return driver.findElement(locator).isDisplayed();
			
		}
		catch (Exception e) {
		return false;
		}
	}	
		
		// Returns the value currently entered in an input field
		protected String getInputValue(By locator) {

		    // Wait until the input field is visible
		    waitForElementVisible(locator);

		    // Find the input element
		    WebElement element = driver.findElement(locator);

		    // Input fields store their entered value in the "value" attribute
		    return element.getAttribute("value");
		}
	}
	
	
	
		

