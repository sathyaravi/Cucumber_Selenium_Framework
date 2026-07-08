package com.automation.stepDefs;

import org.testng.Assert;
import com.automation.pages.LoginPage;
import com.automation.pages.ProductPage;
import com.automation.utils.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	
	LoginPage login = new LoginPage();
	
	 public static ProductPage productPage;
	
	
	@Before
	public void setUp() {
		
		
		BaseClass.initDriver();

	}
	
	@Given("Navigate to the login page")
	public void navigate_to_Login_page() {
		
		login.navigateToLoginPage();

	}
	
	@When("enter username {string}")
	public void enterUsername(String username) {
		
		login.enterUsername(username);
	}
	
	@And("enter password {string}")
	public void enterPassword(String password) {
		
		login.enterPassword(password);
	}
	
	@And("click the login button")
	public void click_the_login_button() {
		
		 productPage = login.clickLoginButton();
		
	}
	
	@Then("Navigate to the home page")
	public void Navigate_to_the_home_() {
				
		Assert.assertTrue(login.getCurrentUrl().contains("inventory"));

	} 
	
	
	@Then("Display the error message")
	
	public void Display_the_error_message() {
		
		Assert.assertTrue(login.getErrorMessage()
				.contains("Username and password do not match"));

	}
	
	@After
	public void tearDown() {
		
		BaseClass.quitDriver();
	}
	
	
}
