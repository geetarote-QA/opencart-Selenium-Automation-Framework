package com.geeta.automation.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.geeta.automation.opencart.base.BasePage;


public class HomePage extends BasePage {
	
	private By searchBox = By.name("search");   
	private By searchButton = By.cssSelector("button.btn.btn-default.btn-lg");

	//two locators for getting loginPage
	private By myAccount = By.cssSelector("a[title='My Account']");
	private By loginLink = By.linkText ("Login");
	
	// Register link from the My Account dropdown
	private By registerLink = By.linkText("Register");
	
	public HomePage(WebDriver driver) {
		
		super (driver);
	}
	public SearchPage searchProduct (String productName) {
		enterText (searchBox,productName);
		clickElement(searchButton);
	
		return new SearchPage(driver);
	}
	  

	public LoginPage goToLogin() {
		  clickElement (myAccount);
		  clickElement (loginLink);    // After clicking Login, the browser is now on the Login page.

		    // Return a LoginPage object so the test can interact with login elements.
		  return new LoginPage(driver);
	  }
	
	public RegisterPage goToRegister() {
		
		clickElement (myAccount);
		clickElement (registerLink);
		return new RegisterPage(driver);
		}
}	
