package com.geeta.automation.opencart.tests;


import org.testng.annotations.Test;

import com.geeta.automation.opencart.base.BaseTest;
import com.geeta.automation.opencart.pages.CartPage;
import com.geeta.automation.opencart.pages.CheckoutPage;
import com.geeta.automation.opencart.pages.HomePage;
import com.geeta.automation.opencart.pages.ProductPage;
import com.geeta.automation.opencart.pages.SearchPage;

public class CheckoutTest extends BaseTest{
	
	
	@Test
	public void checkoutBillingDetails() {
		//Search for product
		HomePage homePage= new HomePage(driver);
		SearchPage searchPage= homePage.searchProduct("MacBook");
		
		ProductPage productPage = searchPage.clickProduct("MacBook");
		
		//add product to cart
		productPage.clickAddToCart();
		
		CartPage cartPage = productPage.goToCart();
		
		//Go to Checkout
		CheckoutPage checkoutPage= cartPage.clickCheckout();
		
		checkoutPage.selectGuestCheckout();
		checkoutPage.clickContinue();
		
		//Enter Billing details 
		checkoutPage.enterFirstName("Geeta");
		checkoutPage.enterLastName("Rane");
		checkoutPage.enterEmail("abc@gmail.com");
		checkoutPage.enterTelephone("6354723575");
		checkoutPage.enterAddress("123 Main street");
		checkoutPage.enterCity("Parker");
		checkoutPage.enterPostCode("80134");
		
		//Select country and state
		checkoutPage.selectCountry("United States");
		checkoutPage.selectState("Colorado");
		
		//continue billing
		checkoutPage.clickBillingContinue();
		
		
	}

}
