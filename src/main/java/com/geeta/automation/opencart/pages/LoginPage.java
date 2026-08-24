package com.geeta.automation.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.geeta.automation.opencart.base.BasePage;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		}
	
	private By emailField = By.id("input-email"); 
	private By passwordField = By.id("input-password");
	private By loginButton = By.cssSelector("input[value= 'Login']");

	//locator of error message after entering invalid credentials
	private By loginError = By .cssSelector(".alert.alert-danger");
	
	//Account link is displayed after successful login
	private By accountLink = By.linkText ("Account");
	
	
	public void enterEmail (String email) {
		enterText (emailField, email);
		}
	
	public void enterPassword (String password) {
		
		enterText (passwordField, password);
	}
	
	public void clickLogin() {
		
		clickElement(loginButton);
	}
	
	
	// Verify invalid login shows an error message
	public boolean isLoginErrorDisplayed() {
		return isElementDisplayed (loginError);
		
	}
	
	//verify successful login by checking the account link
	public boolean isLoginSuccessful() {
		
		return isElementDisplayed(accountLink);
	}
	
}
