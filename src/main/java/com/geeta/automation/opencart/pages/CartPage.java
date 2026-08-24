package com.geeta.automation.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.geeta.automation.opencart.base.BasePage;


public class CartPage extends BasePage {

	

	// Shopping Cart heading
	private By shoppingCartHeading =
	        By.xpath("//h1[contains(text(), 'Shopping Cart')]");

	//  Locate MacBook within the cart row to avoid hidden duplicate elements.
	private By macBookProduct =
	        By.xpath("//tr[.//td[@class='text-left' and normalize-space()='Product 16']]//a[normalize-space()='MacBook']");

	// Quantity
	private By quantityField =
	        By.xpath("//tr[.//td[@class='text-left' and normalize-space()='Product 16']]//input[starts-with(@name,'quantity')]");

	
	// Gets the first right-aligned cell in the MacBook cart row, which is the unit price.
	private By unitPrice =
	        By.xpath("//tr[.//td[@class='text-left' and normalize-space()='Product 16']]//td[@class='text-right'][1]");
	
	//Locator for Checkout button
	private By checkoutButton= By.xpath("//a[contains(@href,'route=checkout/checkout')and normalize-space()='Checkout']");
	
	//Constructor
	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	//verifies that the shopping cart page is displayed
	public boolean isShoppingCartDisplayed() {
		return isElementDisplayed(shoppingCartHeading);
	}
	
		
	public boolean isMacBookDisplayed() {
	    return isElementDisplayed(macBookProduct);
	}
	
	public String getQuantity() {
	    return getInputValue(quantityField);
	}

	public String getUnitPrice() {
	    return getText(unitPrice);
	}
	
	public CheckoutPage clickCheckout() {
		
		clickElement(checkoutButton);
		return new CheckoutPage(driver);
	}
}
