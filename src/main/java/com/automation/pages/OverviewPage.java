package com.automation.pages;

import org.openqa.selenium.By;

import com.automation.utils.BaseClass;

public class OverviewPage extends BaseClass{
	
	private By pageTitle = By.className("title");
	
	private By totalPrice = By.className("summary_total_label");
	
	private By finish = By.id("finish");
	
	
	public String getPageTitle() {
		
		return driver.findElement(pageTitle).getText();
	}
	
	public String getTotalPrice() {
		
		return driver.findElement(totalPrice).getText();
	}
	
	public ReceiptPage clickFinish() {
		
		driver.findElement(finish).click();
		
		return new ReceiptPage();
	}

}
