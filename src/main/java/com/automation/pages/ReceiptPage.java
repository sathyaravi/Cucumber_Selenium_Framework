package com.automation.pages;

import java.io.File;

import org.openqa.selenium.By;

import com.automation.utils.BaseClass;

public class ReceiptPage extends BaseClass {
	
	private By confirmationHeader = By.className("complete-header");
	
	private By confirmationMessage = By.className("complete-text");
	
	private By backHomeButton = By.id("back-to-products");
	
	private By generatePDFButton = By.id("generate-pdf-order");
	
	
	public String getConfirmationHeader() {
		
		return driver.findElement(confirmationHeader).getText();
	}
	
	public String getConfirmationMessage() {
		
		return driver.findElement(confirmationMessage).getText();
	}
	
	public boolean isOrderComplete() {
        return driver.findElement(confirmationHeader)
               .getText()
               .contains("Thank you for your order");
    }
	
	
	public ReceiptPage clickGeneratePDF() {
		
		driver.findElement(generatePDFButton).click();
		
		return this;
	}
	
	public boolean isPDFDownloaded() throws InterruptedException{
		
		Thread.sleep(1000);
		
		String downloadPath = System.getProperty("user.home")+"/Downloads";
		
		File[] files = new File(downloadPath).listFiles();
		
		if(files!=null) {
			for(File file:files) {
				
				if(file.getName().endsWith(".pdf")) {
					
					return true;
				}
			}
		}
		
		
		return false;
		
	}
	public ProductPage clickBack() {
		
		driver.findElement(backHomeButton).click();
		
		return new ProductPage();
	}

}
