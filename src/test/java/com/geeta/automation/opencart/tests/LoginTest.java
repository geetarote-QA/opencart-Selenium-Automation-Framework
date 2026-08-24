package com.geeta.automation.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.geeta.automation.opencart.base.BaseTest;
import com.geeta.automation.opencart.pages.HomePage;
import com.geeta.automation.opencart.pages.LoginPage;

public class LoginTest extends BaseTest {

	
	@Test
	public void loginWithInvalidCredentialsTest() {
		
		HomePage homePage = new HomePage(driver);
		
		// Navigate to Login page and create its page object
		LoginPage loginPage = homePage.goToLogin();
		
		//LoginPage loginPage = new LoginPage (driver);
		loginPage.enterEmail("test@example.com");
		loginPage.enterPassword("Test123");
		loginPage.clickLogin();
		
		Assert.assertTrue(loginPage.isLoginErrorDisplayed(),"Login error message was not displayed.");
	}


	@Test
	
	public void loginWithValidCredentialsTest() {
		
		HomePage homePage = new HomePage (driver);

        // Navigate to Login page and create its page object
		LoginPage loginPage = homePage.goToLogin();
		
		loginPage.enterEmail("GeetaOpenCart2026@gmail.com");
		loginPage.enterPassword("OpenCart@2026");
		loginPage.clickLogin();
		
		//verify successful login
		Assert.assertTrue(loginPage.isLoginSuccessful(), "Login was not successful");
	}
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
