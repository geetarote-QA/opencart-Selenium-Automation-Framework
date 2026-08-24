package com.geeta.automation.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.geeta.automation.opencart.base.BasePage;

public class SearchPage extends BasePage{

	private By macBookProduct = By.cssSelector("img[alt='MacBook']");//Locator for a MacBook product link
	
	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	//clicks the MacBook product from search results
	public ProductPage clickMacBook() {
		clickElement (macBookProduct);
		return new ProductPage (driver);//returns ProductPage because clicking MacBook navigates to the product page
	}
		
	public boolean isProductDisplayed(String productName) {
		By product = By.cssSelector("img[alt='" + productName + "']");
		return isElementDisplayed (product);
			
	}
	// Checks whether the "no product matches" message is displayed --Negative testing
    public boolean isNoResultsMessageDisplayed() {

        By noResultMessage =
                By.xpath("//p[text()='There is no product that matches the search criteria.']");

        return isElementDisplayed(noResultMessage);
    }

		
	
}
