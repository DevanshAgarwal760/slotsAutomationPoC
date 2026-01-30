Feature: HUD and Game Buttons  
	
	Background: 
		Given User is on iFrame base Game HUD
	
	Scenario: User is able to access the Buttons 
		When user opens Settings menu
		When user enables quick spin
		Then Turbo button should get changed to enabled 
		When user opens Settings menu
		When user disables quick spin
		Then Turbo button should get changed to disabled
		When user opens Settings menu
		When user disables sound
		Then sound button should get changed to disabled
		When user opens Settings menu
		When user enables sound
		Then sound button should get changed to enabled
		When user opens Settings menu
		When user clicks on Language dropdown
		Then all language options should appear
		When user opens Settings menu
		When user clicks on Help option
		Then Help page should open
		When user opens Settings menu
		When user clicks on History option
		Then History page should appear
		
		
		When user clicks on Bet Options button 
		Then Bet Options HUD should appear on screen
		
		#For Spin, Stop, and Take Win button
		When user clicks on Spin button 
		Then balance should get updated
		
		When user clicks on Quick Bet button 
		Then spin button should change to stop btn
		
		When user clicks on Quick Bet button 
		Then the play text should change to stop
		Then quick bet button should consist of the currency type
		
		Given The Gamble game has triggered
		When User clicks on gamble button
		Then The gamble gameplay page should open
		Then close the gamble and return to base game
		
		When user clicks on Autospin button 
		Then Autospin Options HUD should appear on screen
		
		When user clicks on Autospin button 
		And user clicks on infinity button
		Then infinite spins should trigger
		
		When user clicks on Autospin button 
		And user clicks on Ten spin count button
		Then Ten spins should trigger
		
		When user clicks on Autospin button 
		And user clicks on Twenty spin count button
		Then Twenty spins should trigger
		
		When user clicks on Autospin button 
		And user clicks on Hundred spin count button
		Then Hundred spins should trigger
		
		#For info and window close btn
		When user clicks on info button 
		Then info page HUD should appear on screen
		
		When user clicks on Settings button 
		Then Settings HUD should appear on screen
		
		When user clicks on Sound button 
		Then sound button should get changed to disabled
		When user clicks on Sound button again
		Then sound button should get changed to enabled
		
		When user clicks on Turbo button 
		Then Turbo button should get changed to enabled
		When user clicks on Turbo button again
		Then Turbo button should get changed to disabled
		
		When user clicks on Fullscreen button 
		Then Game should switch to Fullscreen mode
		
		When user clicks on Windowed mode button 
		Then Game should switch to Windowed mode
		
		When user clicks on right arrow button 
		Then quick bet values should increase
		
		When user clicks on Left arrow button 
		Then quick bet values should decrease
		
		When user clicks on Home button 
		Then Home page should appear on screen
		
		
		
	
		