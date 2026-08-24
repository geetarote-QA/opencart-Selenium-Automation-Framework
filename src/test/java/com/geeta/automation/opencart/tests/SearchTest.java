package com.geeta.automation.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.geeta.automation.opencart.base.BaseTest;
import com.geeta.automation.opencart.pages.HomePage;
import com.geeta.automation.opencart.pages.SearchPage;

public class SearchTest  extends BaseTest{
	@Test
	public void  searchProductTest() {
		
		HomePage homePage = new HomePage (driver);
		
		SearchPage searchPage= homePage.searchProduct("MacBook");
		
		//SearchPage searchPage = new SearchPage (driver);
	 
		Assert.assertTrue(searchPage.isProductDisplayed("MacBook"), "Macbook was not displayed in search results.");
	
	
	}
	 @Test
	 public void searchInvalidProductTest() {
		 
		 HomePage homepage = new HomePage (driver);
		 
		 SearchPage searchPage = homepage.searchProduct("abcdefg");
		 
		 Assert.assertTrue(
				 searchPage.isNoResultsMessageDisplayed(),"Expected no-results message was not displayed."
				 );
		 
		 
		 
	 }
	
}
