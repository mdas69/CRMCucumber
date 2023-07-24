@ReadingfromConfigAndFeature
Feature: Login Feature of the application
  
	
	
	
Scenario: verfiying the title of the application
  Given the application is loaded and launched
  Then The title of the application should be "Free CRM - CRM software for customer relationship management, sales, and support."
		
		
	Scenario: Verifying the menus available on the login page
		Given the application is loaded and launched
    Then The available menus on the page 
  		|Home|Sign Up|Pricing|Features|Customers|Contact|
  
		
  
 

  	Scenario: To login to the application
  	Given the application is loaded and launched
 		When  User enter the userName and password from configuration
 		And 	user clicks on Login_button
 		Then 	lands on Accounts page has title "CRMPRO"
 			
			
  
