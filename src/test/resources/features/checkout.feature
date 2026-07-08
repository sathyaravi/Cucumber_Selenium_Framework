Feature:Complete End to End Flow

	A user wants to complete purchase on Saucedemo application
	
	
	@smoke
	Scenario: Complete end to end checkout flow
	
	Given Navigate to the login page
	
	When  enter username "visual_user"
	
	And   enter password "secret_sauce"
	
	And  click the login button
	
	When I add products to cart
	
	And I go to cart
	
	Then cart should have 3 items
	
	When I click Checkout
	
	And I enter checkdetails "John" "Doe" "12345"
	
	And I click Continue
	
	Then I should see overview page
	
	When I click finish 
		
	Then I should see confirmation message "Thank you for your order!"

	
	@pdf
	
	Scenario: Complete end to end checkout flow and generate PDF receipt after completion
	
	Given Navigate to the login page
	
	When  enter username "visual_user"
	
	And   enter password "secret_sauce"
	
	And  click the login button 
	
	When I add products to cart
	
	And I go to cart
	
	Then cart should have 3 items
	
	When I click Checkout
	
	And I enter checkdetails "John" "Doe" "12345"
	
	And I click Continue
	
	Then I should see overview page
	
	When I click finish 
		
	When I click generate PDF button
	
	Then PDF Receipt should be downloaded successfully