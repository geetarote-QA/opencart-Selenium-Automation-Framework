package com.geeta.automation.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.geeta.automation.opencart.base.BasePage;


public class CartPage extends BasePage {

	

	// Shopping Cart heading
	private By shoppingCartHeading =
	        By.xpath("//h1[contains(text(), 'Shopping Cart')]");
	
	//Constructor
		public CartPage(WebDriver driver) {
			super(driver);
		}
		
	//verifies that the shopping cart page is displayed
		public boolean isShoppingCartDisplayed() {
		    try {
		        wait.until(ExpectedConditions.visibilityOfElementLocated(shoppingCartHeading));
		        return true;
		    } catch (Exception e) {
		        return false;
		    }
		}

	//Locator for Checkout button
		private By checkoutButton= By.xpath("//a[contains(@href,'route=checkout/checkout')and normalize-space()='Checkout']");
		
		
		
	//Builds the locator for a specific product row in the cart 
		private By getProductRow(String productName) {
		    return By.xpath(
		        "//div[@id='content']//form//table//tr[.//img[@alt='" + productName + "']]"
		    );
		}
		
	//Verifies whether the specified product is displayed in the cart
		public boolean isProductDisplayed(String productName) {
			
			return isElementDisplayed(getProductRow(productName));
		}
		
		
	//Gets the quantity of specified product
		public String getQuantity(String productName) {

		    By quantityField = By.xpath(
		        "//div[@id='content']//form//table//tr[.//img[@alt='"  + productName  + "']]//input[starts-with(@name,'quantity')]" );

		    return getInputValue(quantityField);
		}
		
	//Gets the unit price of specified product
		public String getUnitPrice(String productName) {

		    By unitPrice = By.xpath(
		        "//div[@id='content']//form//table//tr[.//img[@alt='" + productName  + "']]//td[@class='text-right'][1]" );

		    return getText(unitPrice);
		}
		
	public CheckoutPage clickCheckout() {
		
		clickElement(checkoutButton);
		return new CheckoutPage(driver);
	}
}
