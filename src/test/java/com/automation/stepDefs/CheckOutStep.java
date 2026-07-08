package com.automation.stepDefs;

import org.testng.Assert;

import com.automation.pages.CartPage;
import com.automation.pages.CheckoutPage;
import com.automation.pages.OverviewPage;
import com.automation.pages.ProductPage;
import com.automation.pages.ReceiptPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckOutStep {
	
	ProductPage productPage;
	
	CartPage cartPage;
	
	OverviewPage overviewPage;
	
	CheckoutPage checkoutPage;
	
	ReceiptPage receiptPage;
	
	@When("I add products to cart")
	public void i_add_products_to_cart() {
		
		productPage = LoginSteps.productPage;
		productPage.product1();
		productPage.product2();
		productPage.product3();
		
		}
	
	@And("I go to cart")
	public void i_go_to_cart() {
		
		cartPage = productPage.shoppingCart();
		
	}
	
	@Then("cart should have {int} items")
	public void cart_should_have_items(int count) {
		
		Assert.assertEquals(cartPage.getCartItemCount(),count);
	}
	
	
	@When("I click Checkout")
	public void i_click_checkout() {
		checkoutPage = cartPage.clickCheckOutButton();
	}
	
	@And("I enter checkdetails {string} {string} {string}")
	public void i_enter_checkdetails(String firstname,String lastname,String postalcode) {
		
		checkoutPage.enterFirstName(firstname);
		checkoutPage.enterLastName(lastname);
		checkoutPage.enterPostalCode(postalcode);
				
	}
	
	@When("I click Continue")
	public void i_click_continue() {
		
		overviewPage = checkoutPage.clickcontinueCheckout();
	}
	
	@Then("I should see overview page")
	public void overview_page() {
		Assert.assertEquals(overviewPage.getPageTitle(), "Checkout: Overview");
	}
	
	@When("I click finish")
	public void i_click_finish() {
		
		receiptPage = overviewPage.clickFinish();
	}
	
	@Then("I should see confirmation message {string}")
	public void confirmation_message(String message) {
		Assert.assertTrue(receiptPage.isOrderComplete());
		
		Assert.assertEquals(receiptPage.getConfirmationHeader(),message);
	}
	
	@When("I click generate PDF button")
	public void i_click_generate_PDF_button() {
		receiptPage.clickGeneratePDF();
	}
	
	@Then("PDF Receipt should be downloaded successfully")
	public void pdf_receipt_should_be_downloaded_successfully() throws InterruptedException {
		Assert.assertTrue(receiptPage.isPDFDownloaded(),"Pdf was not downloaded");
		
		System.out.println("PDF Was downloaded successfully");
	}
}
