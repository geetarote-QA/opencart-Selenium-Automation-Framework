package com.geeta.automation.opencart.tests;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.geeta.automation.opencart.base.BaseTest;
import com.geeta.automation.opencart.pages.HomePage;
import com.geeta.automation.opencart.pages.RegisterPage;

public class RegisterTest extends BaseTest{
	
	//Generate unique email address so the test does not fail because of duplicate email
	private String generateUniqueEmail() {
		
		return "Geeta.OpenCart" + System.currentTimeMillis()+ "@gmail.com";
	}
	
	@DataProvider(name = "registrationData")
	public Object[][] registrationData() {

	    return new Object[][] {
	        {"Geeta", "Automation", "3035550101", "Test@123"},
	        {"Rahul", "Tester", "3035550102", "Test@456"}
	    };
	}
	
	@Test(dataProvider = "registrationData")
	public void registerNewUserTest(
			String firstName,
			String lastName,
			String telephone,
			String password)  {
	
		HomePage homepage = new HomePage (driver);
	
		//navigate to register page
		RegisterPage registerPage = homepage.goToRegister();
		
		String email = generateUniqueEmail();
		
		registerPage.enterFirstName(firstName);
		registerPage.enterLastName(lastName);
		registerPage.enterEmail(email);
		registerPage.enterTelephone(telephone);
		registerPage.enterPassword(password);
		registerPage.enterConfirmPassword(password);
		
        //Accept Privacy Policy and Submit registration
		registerPage.acceptPrivacyPolicy();
		registerPage.clickContinue();
		
		  
        //Verify account was created successfully
        Assert.assertTrue(registerPage.isRegistrationSuccessful(), "Registration was not successful");
	}

	
	@Test
	public void registrationWithMissingLastName() {
		HomePage homePage = new HomePage(driver); // create HomePage object using Webdriver provided by BaseTest
		
		RegisterPage registerPage = homePage.goToRegister(); //Navigate from Homepage to registration page
		
		registerPage.enterFirstName("Geeta");// enter a valid first name
		//registerPage.enterLastName(...);  //Intentionally leave Last Name blank to verify validation 
		registerPage.enterEmail(generateUniqueEmail()); // Generate a unique email for this registration attempt
		registerPage.enterTelephone("4345354557"); //Enter a valid telephone number
		registerPage.enterPassword("Test@123");
		registerPage.enterConfirmPassword("Test@123");
		
		registerPage.acceptPrivacyPolicy();// Accept a Privacy Policy before submitting the form
		registerPage.clickContinue(); //SUbmit Registration form


    //Verify thet the expected Last Name validation message is displayed 
    Assert.assertTrue(
    		registerPage.isLastNameErrorDisplayed(),"Last Name validation error was not displayed.");
	

	}
}
