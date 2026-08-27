package com.geeta.automation.opencart.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.geeta.automation.opencart.base.BasePage;

public class CheckoutPage extends BasePage {

	//Locator for Guest Checkout option
	private By guestCheckout= By.xpath("//input[@name='account'and @value='guest']");
	
	//Locator for Continue Button
	private By continueButton = By.id("button-account");
	
	//Billing Locators details:
	// Billing Details locators
	private By firstNameField = By.id("input-payment-firstname");
	private By lastNameField = By.id("input-payment-lastname");
	private By emailField = By.id("input-payment-email");
	private By telephoneField = By.id("input-payment-telephone");
	private By addressField = By.id("input-payment-address-1");
	private By cityField = By.id("input-payment-city");
	private By postCodeField = By.id("input-payment-postcode");
	private By countryDropdown = By.id("input-payment-country");
	private By stateDropdown = By.id("input-payment-zone");
	private By billingContinueButton= By.id("button-guest");
	private By cookieBanner = By.cssSelector("div.cc-window[aria-label='cookieconsent']");
	private By cookieDismissButton = By.cssSelector(".cc-btn.cc-dismiss");
	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	
	//Select Guest Checkout
	public void selectGuestCheckout() {
		
		clickElement(guestCheckout);
	}
	
	//CLicks Continue
	public void clickContinue() {
		clickElement(continueButton);
		
	}	
	
	public void enterFirstName(String firstName) {
		
		enterText(firstNameField, firstName);
		}
	public void enterLastName(String lastName) {
		
		enterText(lastNameField,lastName);
	}
	public void enterEmail(String email) {
		
		enterText(emailField,email);
	}
	public void enterTelephone(String telephone) {
	    enterText(telephoneField, telephone);
	}

	public void enterAddress(String address) {
	    enterText(addressField, address);
	}

	public void enterCity(String city) {
	    enterText(cityField, city);
	}

	public void enterPostCode(String postCode) {
	    enterText(postCodeField, postCode);
	}
	
	public void selectCountry(String country) {
		waitForElementVisible(countryDropdown);
		Select select = new Select(driver.findElement(countryDropdown));
		select.selectByVisibleText(country);
	}
	
	
	public void selectState(String state) {
		wait.until(ExpectedConditions.
				textToBePresentInElementLocated
				(By.id("input-payment-zone"),state));
		Select select = new Select (driver.findElement(stateDropdown));
		select.selectByVisibleText(state);
	}
	
	private void closeCookieBannerIfPresent() {
	    try {
	        WebElement dismissButton = driver.findElement(cookieDismissButton);

	        if (dismissButton.isDisplayed()) {
	            dismissButton.click();

	            wait.until(ExpectedConditions.invisibilityOfElementLocated(cookieBanner));
	        }

	    } catch (Exception e) {
	        // Cookie banner is not present
	    }
	}public void clickBillingContinue() {
	    closeCookieBannerIfPresent();

	    waitForElementVisible(billingContinueButton);
	    clickElement(billingContinueButton);

	    wait.until(driver -> {
	        try {
	            String value = driver.findElement(billingContinueButton)
	                    .getAttribute("value");

	            return value != null && !value.equalsIgnoreCase("Loading...");
	        } catch (Exception e) {
	            return false;
	        }
	    });
	}
	
	
}
