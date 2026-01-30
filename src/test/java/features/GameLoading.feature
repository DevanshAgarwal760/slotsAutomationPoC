Feature: Launch the game
	
	Scenario: Verify that game is available in the demo site and testable 
		Given User is logged in to demo web site
		When User searches and launches the game
	    Then User should be able to see the Base game HUD