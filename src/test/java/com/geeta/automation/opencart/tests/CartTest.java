package com.geeta.automation.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.geeta.automation.opencart.base.BaseTest;
import com.geeta.automation.opencart.pages.CartPage;
import com.geeta.automation.opencart.pages.HomePage;
import com.geeta.automation.opencart.pages.ProductPage;
import com.geeta.automation.opencart.pages.SearchPage;

public class CartTest extends BaseTest{
	
	
	@Test
	public void addProductToCartTest() {
		
		String productName="MacBook";
		HomePage homepage = new HomePage(driver);
		
		SearchPage searchPage = homepage.searchProduct(productName);
		ProductPage productPage = searchPage.clickProduct(productName);
		productPage.clickAddToCart();
		
		CartPage cartPage = productPage.goToCart();
		//Verify that shopping cart is displayed
		Assert.assertTrue(cartPage.isShoppingCartDisplayed(), " Shopping cart page is not displayed ");
		
		// Verify product is displayed
		Assert.assertTrue(cartPage.isProductDisplayed(productName), productName+ " is not displayed in the cart. ");

		//Verify quantity
		Assert.assertEquals(cartPage.getQuantity(productName),"1",productName+ " quantity is incorrect ");
		
		//Verify unit price
		Assert.assertEquals(cartPage.getUnitPrice(productName),"$602.00", productName + " unit price is incorrect ");
		
	
	
	}

}
