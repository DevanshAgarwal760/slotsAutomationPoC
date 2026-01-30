Feature: Language Dropdown

		
		Background: 
			Given User is on iFrame base Game HUD

		Scenario: Verify that Language dropdown consists all languages
			When user navigates to Language dropdown
			Then all language options should be present
			
		Scenario: Verify English language updates in all the areas
			When user selects English
			Then English language should get updated in Settings
			Then English language should get updated in Help
			Then English language should get updated in Info page
			Then English language should get updated in Bet pop up
			Then English language should get updated in Autoplay pop up
			Then English language should get updated in Base Game HUD
			Then English language should get updated in History Page
			Then English language should get updated in JP index
			Then English language should get updated in Gamble page
			#Then English language should get updated in Jackpot
			
		Scenario: Verify Bulgarian language updates in all the areas
			When user selects Bulgarian
			Then Bulgarian language should get updated in Settings
			Then Bulgarian language should get updated in Help
			Then Bulgarian language should get updated in Info page
			Then Bulgarian language should get updated in Bet pop up
			Then Bulgarian language should get updated in Autoplay pop up
			Then Bulgarian language should get updated in Base Game HUD
			Then Bulgarian language should get updated in History Page
			Then Bulgarian language should get updated in JP index
			Then Bulgarian language should get updated in Gamble page
			#Then Bulgarian language should get updated in Jackpot
			
		Scenario: Verify French language updates in all the areas
			When user selects French
			Then French language should get updated in Settings
			Then French language should get updated in Help
			Then French language should get updated in Info page
			Then French language should get updated in Bet pop up
			Then French language should get updated in Autoplay pop up
			Then French language should get updated in Base Game HUD
			Then French language should get updated in History Page
			Then French language should get updated in JP index
			Then French language should get updated in Gamble page
			#Then French language should get updated in Jackpot
			
		Scenario: Verify Portuguese language updates in all the areas
			When user selects Portuguese
			Then Portuguese language should get updated in Settings
			Then Portuguese language should get updated in Help
			Then Portuguese language should get updated in Info page
			Then Portuguese language should get updated in Bet pop up
			Then Portuguese language should get updated in Autoplay pop up
			Then Portuguese language should get updated in Base Game HUD
			Then Portuguese language should get updated in History Page
			Then Portuguese language should get updated in JP index
			Then Portuguese language should get updated in Gamble page
			#Then Portuguese language should get updated in Jackpot
			
		Scenario: Verify Spanish language updates in all the areas
			When user selects Spanish
			Then Spanish language should get updated in Settings
			Then Spanish language should get updated in Help
			Then Spanish language should get updated in Info page
			Then Spanish language should get updated in Bet pop up
			Then Spanish language should get updated in Autoplay pop up
			Then Spanish language should get updated in Base Game HUD
			Then Spanish language should get updated in History Page
			Then Spanish language should get updated in JP index
			Then Spanish language should get updated in Gamble page
			#Then Spanish language should get updated in Jackpot
