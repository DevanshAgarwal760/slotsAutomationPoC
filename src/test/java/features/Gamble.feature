Feature: Gamble Gameplay functionality

	Background:
		Given The Gamble game has triggered
		When User clicks on gamble button
		
	Scenario: Verify the Gamble Resume functionality
		Then The gamble gameplay page should open
		When user clicks on Red button once
		When user wins gamble for Red
		When user closes the game
		When user relaunches the game
		Then gamble game session should resume

	Scenario: Verify  the Gamble gameplay 
		Then The gamble gameplay page should open
		When user clicks on Red button
		Then user gets a win or loses gamble
		
	Scenario: Verify  the Collect button in the Gamble gameplay 
		Then The gamble gameplay page should open
		When user clicks on Red button once
		When user wins gamble for Red
		When user clicks on collect button
		Then User comes back to iFrame base Game HUD
		Then balance should get updated
		
	Scenario: Verify  the Attempts for correct guess in the Gamble gameplay 
		Then The gamble gameplay page should open
		Then The page should consist Attempts field
		When user clicks on Red button once
		When user wins gamble for Red
		Then attempts should decrease by one
		
	Scenario: Verify  the Attempts for incorrect guess in the Gamble gameplay 
		Then The gamble gameplay page should open
		Then The page should consist Attempts field
		When user clicks on Red button once
		When user loses
		Then attempts should become zero
		
	Scenario: Verify the Red color option win in the Gamble gameplay 
		When The gamble gameplay page open
		When user clicks on Red button once
		When user wins gamble for Red
		Then gamble amount should double
		
	Scenario: Verify the Black color option win in the Gamble gameplay
		When The gamble gameplay page open
		When user clicks on Black button once
		When user wins gamble for Black
		Then gamble amount should double
	
	Scenario: Verify the Red color option loss in the Gamble gameplay	
		When The gamble gameplay page open
		When user clicks on Red button once
		When user loses for Red
		Then gamble amount becomes 0
		Then win amount in base game becomes 0
		
	Scenario: Verify the Black color option loss in the Gamble gameplay	
		When The gamble gameplay page open
		When user clicks on Black button once
		When user loses for Black
		Then gamble amount becomes 0
		Then win amount in base game becomes 0
		
	Scenario: Verify the Diamond Suit win in the Gamble gameplay	
		When The gamble gameplay page open
		When user clicks on Diamond button once
		When user wins gamble for Diamond
		Then gamble amount should quadruple
	
	Scenario: Verify the Diamond Suit loss in the Gamble gameplay	
		When The gamble gameplay page open
		When user clicks on Diamond button once
		When user loses for Diamond
		Then gamble amount becomes 0
		Then win amount in base game becomes 0
		
	Scenario: Verify the Spades Suit win in the Gamble gameplay	
		When The gamble gameplay page open
		When user clicks on Spades button once
		When user wins gamble for Spades
		Then gamble amount should quadruple
		
	Scenario: Verify the Spades Suit loss in the Gamble gameplay	
		When The gamble gameplay page open
		When user clicks on Spades button once
		When user loses for Spades
		Then gamble amount becomes 0
		Then win amount in base game becomes 0
	
	Scenario: Verify the Clubs Suit win in the Gamble gameplay	
		When The gamble gameplay page open
		When user clicks on Clubs button once
		When user wins gamble for Clubs
		Then gamble amount should quadruple
		
	Scenario: Verify the Clubs Suit loss in the Gamble gameplay	
		When The gamble gameplay page open
		When user clicks on Clubs button once
		When user loses for Clubs
		Then gamble amount becomes 0
		Then win amount in base game becomes 0
		
	Scenario: Verify the Hearts Suit win in the Gamble gameplay	
		When The gamble gameplay page open
		When user clicks on Hearts button once
		When user wins gamble for Hearts
		Then gamble amount should quadruple
	
	Scenario: Verify the Hearts Suit loss in the Gamble gameplay	
		When The gamble gameplay page open
		When user clicks on Hearts button once
		When user loses for Hearts
		Then gamble amount becomes 0
		Then win amount in base game becomes 0
		
	Scenario: Verify that win amount is blank after losing the Gamble game 
		Then The gamble gameplay page should open
		When user clicks on Red button once
		When user loses for Red
		Then win field should be blank
		
	
		
		
	