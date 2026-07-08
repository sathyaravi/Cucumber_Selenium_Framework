Feature:Login Functionality
	
	
	
	Scenario: Login with valid credentials
	
	Given Navigate to the login page
	
	When  enter username "visual_user"
	
	And   enter password "secret_sauce"
	
	And  click the login button
	
	Then Navigate to the home page 



	Scenario: Login with Invalid credentials
	
	Given Navigate to the login page
	
	When  enter username "standard"
	
	And   enter password "wrong-password"
	
	And  click the login button
	
	Then  Display the error message