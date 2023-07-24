Feature: To check for NewSMSCampaign Menu and logging out


 Background:
 	Given  User enter the userName and password from configuration
 	Then 	user clicks on Login_button
 	
 	Scenario: 	Validate that NewSMSCampaign menu is present 
 	
 	Given User click on Campaigns 
 	When User sees table with NewSMSCampaign 
 	Then user logs out