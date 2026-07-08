package com.automation.pages;

import org.openqa.selenium.By;

import com.automation.utils.BaseClass;

public class ProductPage extends BaseClass{
	
	private By  product1 = By.id("add-to-cart-sauce-labs-backpack");
	
	private By product2 = By.id("add-to-cart-sauce-labs-bike-light");
	
	private By product3 = By.id("add-to-cart-sauce-labs-fleece-jacket");
	
	private By shoppingcartlink = By.className("shopping_cart_link");
	
	private By pageTitle = By.className("title");
	
	
	public String getPageTitle() {
		return driver.findElement(pageTitle).getText();
	}
	
	public  ProductPage product1() {
		
		driver.findElement(product1).click();
		
		return this;
		
	}
	
	public ProductPage product2() {
		
		driver.findElement(product2).click();
		
		return this;
	}
	
	public ProductPage product3() {
		
		driver.findElement(product3).click();
		
		return this;

	}
	
	public CartPage shoppingCart() {
		
		driver.findElement(shoppingcartlink).click();
		
		return new CartPage();

	}
	

}
