package com.automation.pages;

import org.openqa.selenium.By;

import com.automation.utils.BaseClass;

public class LoginPage extends BaseClass {
	
	
	private By userNameField = By.id("user-name");
	
	private By passwordField = By.id("password");
	
	private By LoginButton = By.id("login-button");
	
	private By errorMessage = By.cssSelector("[data-test='error']");
	
	
	public LoginPage navigateToLoginPage() {
		driver.get("https://www.saucedemo.com");
		return this;
	}
	
	public LoginPage enterUsername(String username) {
		
		driver.findElement(userNameField).sendKeys(username);
		return this;
	}
	
	public LoginPage enterPassword(String password) {
		
		driver.findElement(passwordField).sendKeys(password);
		return this;
	}
	
	public ProductPage clickLoginButton() {
		
		driver.findElement(LoginButton).click();
		BaseClass.dismissPasswordDialog();
		return new ProductPage();
	}
	
	
	public String getErrorMessage() {
		return driver.findElement(errorMessage).getText();
	}
	
	
	public String getCurrentUrl() {
		
		return driver.getCurrentUrl();

	}
	

}
