package com.geeta.automation.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.geeta.automation.opencart.base.BasePage;

public class SearchPage extends BasePage{

		
	public SearchPage(WebDriver driver) {
		super(driver);
	}
			
	//CLicks a product from the search results using product name 
	public ProductPage clickProduct(String productName) {
		By product = By.cssSelector("img[alt='"+ productName +"']");
		clickElement(product);				
		return new ProductPage(driver);
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
