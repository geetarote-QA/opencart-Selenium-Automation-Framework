package com.geeta.automation.opencart.tests;


import org.testng.annotations.Test;

import com.geeta.automation.opencart.base.BaseTest;
import com.geeta.automation.opencart.pages.CartPage;
import com.geeta.automation.opencart.pages.CheckoutPage;
import com.geeta.automation.opencart.pages.HomePage;
import com.geeta.automation.opencart.pages.ProductPage;
import com.geeta.automation.opencart.pages.SearchPage;
import com.geeta.automation.opencart.utils.TestDataReader;

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
		checkoutPage.enterFirstName(
				TestDataReader.getTestData("checkout.firstName"));

		checkoutPage.enterLastName(
		        TestDataReader.getTestData("checkout.lastName"));

		checkoutPage.enterEmail(
		        TestDataReader.getTestData("checkout.email"));

		checkoutPage.enterTelephone(
		        TestDataReader.getTestData("checkout.telephone"));

		checkoutPage.enterAddress(
		        TestDataReader.getTestData("checkout.address"));

		checkoutPage.enterCity(
		        TestDataReader.getTestData("checkout.city"));

		checkoutPage.enterPostCode(
		        TestDataReader.getTestData("checkout.postCode"));

		checkoutPage.selectCountry(
		        TestDataReader.getTestData("checkout.country"));

		checkoutPage.selectState(
		        TestDataReader.getTestData("checkout.state"));
		
		//continue billing
		checkoutPage.clickBillingContinue();
		
		
	}

}
