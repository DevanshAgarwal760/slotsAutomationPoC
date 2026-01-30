Feature: Verify the shortcut keys in the game 

		Background:
			Given User is on iFrame base Game HUD

		Scenario: Verify Space Key for Spin
			When user presses Space Key
			Then balance should get updated
		
		Scenario: Verify i Key for info
			When user presses i Key
			Then info page HUD should appear on screen
		
		Scenario: Verify S key for disabling sound
			When user presses s Key
			Then sound button should get changed to disabled
			When user presses s Key
		    Then sound button should get changed to enabled
		
		Scenario: Verify down arrow Key for take
			When win is triggered
			When user presses down arrow Key for take
			Then balance should get updated
		
		Scenario: Verify up arrow key for gamble 
			Given The Gamble game has triggered
			When user presses up arrow key for gamble
			Then The gamble gameplay page should open
		
		Scenario: Verify h for home key
			When user presses h key
			Then Home page should appear on screen