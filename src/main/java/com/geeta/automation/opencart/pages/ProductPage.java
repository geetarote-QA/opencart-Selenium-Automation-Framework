package com.geeta.automation.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.geeta.automation.opencart.base.BasePage;

public class ProductPage extends BasePage{

	private By addToCartButton = By.id("button-cart"); //Locator for add to cart button
	
	
	// Locator for the Shopping Cart button
	private By cartButton =
	        By.xpath("//span[@id='cart-total']/parent::button");   
	
	//Locator for view cart button
	private By viewCartLink= By.xpath("//a[contains(@href,'route=checkout/cart')]");
	
	//Constructor initializes the ProductPage with the WebDriver
	public ProductPage(WebDriver driver) {
		super(driver);
	}
	
	//Clicks the Add to Cart button
	public void clickAddToCart() {
		
		clickElement(addToCartButton);
		
		//wait for shopping cart button to become visible 
		//this gives the website time to update the cart
		waitForElementVisible(cartButton);
	}
	
	// Cart button opens a dropdown; click "View Cart" to navigate to the Shopping Cart page.
	public CartPage goToCart() {
			clickElement (cartButton);
			clickElement (viewCartLink);
		return new CartPage(driver); //return a new CartPage object because we are now on the cart page
	}
	
}
