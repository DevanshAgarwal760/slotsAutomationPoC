Feature: HUD and Game Buttons  
	
	Background: 
		Given User is on iFrame base Game HUD
	
	Scenario: Test
		When user clicks on Quick Bet button 
		Then the play text should change to stop
		Then quick bet button should consist of the currency type