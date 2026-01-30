Feature: Spin Button Count

	Scenario: Verify Hundred spin button count
		Given User is on iFrame base Game HUD
		When user clicks on Autospin button
		When user clicks on Hundred spin count button
		Then Reels should spin from ninety nine to one
		
	Scenario: Verify Twenty spin button count
		Given User is on iFrame base Game HUD
		When user clicks on Autospin button
		When user clicks on Twenty spin count button
		Then Reels should spin from nineteen to one
		
	Scenario: Verify Ten spin button count
		Given User is on iFrame base Game HUD
		When user clicks on Autospin button
		When user clicks on Ten spin count button
		Then Reels should spin from nine to one