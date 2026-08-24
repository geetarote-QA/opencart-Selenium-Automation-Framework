package com.geeta.automation.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.geeta.automation.opencart.base.BasePage;

public class RegisterPage extends BasePage{
	
	//Registration form fields
	 
	private By firstNameField = By.id("input-firstname");
	private By lastNameField= By.id("input-lastname");
	private By emailField = By.id("input-email");
	private By telephoneField = By.id("input-telephone");
	private By passwordField = By.id("input-password");
	private By confirmPasswordField = By.id("input-confirm");
	
	//registration form controls
	private By privacyPolicyCheckBox= By.cssSelector("input[name='agree']");
	private By continueButton= By.cssSelector("input[type='submit'][value='Continue']");
	
	//Registration success message
	private By registrationSuccessMessage = By.xpath("//h1[text()='Your Account Has Been Created!']");
			

	//Locates the validation message displayed when LastName is left bank
	private By lastNameError = By.cssSelector("#input-lastname + .text-danger");
	
	
	public RegisterPage(WebDriver driver) {
				
			super(driver);
			
		}
	
	//Enter first name in the registration form
	public void enterFirstName(String firstName) {
		enterText (firstNameField, firstName);				
	}
	//Enter last name in the registration form
	public void enterLastName (String lastName) {
		enterText (lastNameField, lastName);		
	}
	//Enter email in the registration form
	public void enterEmail(String email) {
		enterText(emailField,email);		
	}

	//Enter telephone number to registration form
	public void enterTelephone(String telephone) {
		enterText (telephoneField,telephone);
	}
	//Enter password in the registration form
	public void enterPassword (String password) {
		enterText (passwordField,password);
	}
	
	//Enter password confirmation in registration form
	public void enterConfirmPassword(String confirmPassword) {
		enterText (confirmPasswordField,confirmPassword);
		
	}
	//Accept privacy policy
	public void acceptPrivacyPolicy() {
		clickElement(privacyPolicyCheckBox);		
	}
	//Submit the registration form
	public void clickContinue() {
		clickElement(continueButton);
		
	}
	
	//Verify successful account registration
	public boolean isRegistrationSuccessful() {
		
		return isElementDisplayed(registrationSuccessMessage);
	}
	
	//checks whether the Last Name validation error is displayed
	public boolean isLastNameErrorDisplayed() {
		return isElementDisplayed(lastNameError);
		
	}
	
	
}
