package com.automation.pages;

import org.openqa.selenium.By;

import com.automation.utils.BaseClass;

public class CartPage extends BaseClass {
	
	
	private By checkoutButton = By.id("checkout");
	
	private By cartItems = By.className("cart_item"); 
	
	private By pageTitle = By.className("title");
	
	
	public String getPageTitle() {
		return driver.findElement(pageTitle).getText();
	}
	
	
	
	public int getCartItemCount() {
		
		return driver.findElements(cartItems).size();
		
		
	}
	
	public CheckoutPage clickCheckOutButton() {
		
		driver.findElement(checkoutButton).click();
		
		return new CheckoutPage();

	}

}
