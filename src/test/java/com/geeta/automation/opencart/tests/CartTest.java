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
	public void addMacBookToCartTest() {
		
		HomePage homePage= new HomePage(driver);//create HomePage object
		
		SearchPage searchPage = homePage.searchProduct("MacBook"); // search for MacBook
		
		ProductPage productPage = searchPage.clickMacBook(); //click MacBook from search results
		
		productPage.clickAddToCart(); //Click add to cart button
		
		CartPage cartPage= productPage.goToCart(); //Navigate to shopping cart
		
		//Verify that shopping cart page is displayed
		Assert.assertTrue(cartPage.isShoppingCartDisplayed(), "Shopping cart page is not displayed");
		
		//Verify MacBook is displayed
		Assert.assertTrue (cartPage.isMacBookDisplayed(), "MacBook is not displayed in the cart");
		
		//Verify quantity
		Assert.assertEquals(cartPage.getQuantity(), "1", "MacBook quantity is incorrect");
		
		//Verify unit value
		Assert.assertEquals(cartPage.getUnitPrice(), "$602.00", "MacBook unit price is incorrect");
			
		
	}

}
