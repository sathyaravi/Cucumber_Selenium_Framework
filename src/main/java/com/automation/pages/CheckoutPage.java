package com.automation.pages;

import org.openqa.selenium.By;

import com.automation.utils.BaseClass;

public class CheckoutPage extends BaseClass{
	
	
	private By firstName = By.id("first-name");
	
	private By lastName = By.id("last-name");
	
	private By postalCode = By.id("postal-code");
	
	private By continueCheckout = By.id("continue");
	
	private By pageTitle = By.className("title");
	
	
	public String getPageTitle() {
		return driver.findElement(pageTitle).getText();
	}
	
	
	public CheckoutPage enterFirstName(String firstname) {
		
		driver.findElement(firstName).sendKeys(firstname);
		
		return this;
	}
	
	public CheckoutPage enterLastName(String lastname) {
		
		driver.findElement(lastName).sendKeys(lastname);
		
		return this;
	}
	
	public CheckoutPage enterPostalCode(String postalCode) {
		
		driver.findElement(this.postalCode).sendKeys(postalCode);
		
		return this;
	}
	
	 public OverviewPage clickcontinueCheckout() {
		 
		 driver.findElement(continueCheckout).click();
		 
		 return new OverviewPage();
	 }

}
