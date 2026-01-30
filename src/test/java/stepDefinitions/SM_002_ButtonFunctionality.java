package stepDefinitions;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.asserts.SoftAssert;

import Utilities.CustomActions;
import Utilities.ImageVerification;
import Utilities.WaitUtils;
import commonTestMethods.CommonFunctions;
import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AutospinOptions;
import pageObjects.AutospinPopUp;
import pageObjects.FirstGameScreen;
import pageObjects.GamblePage;
import pageObjects.GameInfoInside;
import pageObjects.HistoryPage;
import pageObjects.LobbyPage;
import pageObjects.PopUpClose;
import pageObjects.SettingsMenu;
import pageObjects.SuribetHome;
import pageObjects.TransferAmountPopUp;

public class SM_002_ButtonFunctionality 
{
	SuribetHome sh;
	TransferAmountPopUp tapu=new TransferAmountPopUp(BaseClass.driver);
	FirstGameScreen fgs;
	SoftAssert sa=new SoftAssert();
	SettingsMenu sm=new SettingsMenu(BaseClass.driver);;
	double initialQuickBet=0.0;
	double currentQuickBet=0.0;
	boolean verified=true;
	@Given("User is on iFrame base Game HUD")
	public void user_is_on_i_frame_base_game_hud()  throws IOException, InterruptedException, AWTException 
	{
		CommonFunctions cf=new CommonFunctions();
		cf.launchGame();
	}

	@When("user opens Settings menu")
	public void user_opens_settings_menu() throws AWTException, InterruptedException, IOException {
	    FirstGameScreen.openSettingsMenu();
	}
	@When("user enables quick spin")
	public void user_enables_quick_spin() throws AWTException, InterruptedException {
	    sm.enable_quickSpin();
	    CommonFunctions.closeSettingsMenu();
	}
	@When("user disables quick spin")
	public void user_disables_quick_spin() throws AWTException, InterruptedException {
	    sm.disable_quickSpin();
	    CommonFunctions.closeSettingsMenu();
	}
	@When("user disables sound")
	public void user_disables_sound() throws AWTException, InterruptedException {
	    sm.disable_Sound();
	    CommonFunctions.closeSettingsMenu();
	}
	@When("user enables sound")
	public void user_enables_sound() throws AWTException, InterruptedException {
	    sm.enable_Sound();
	    CommonFunctions.closeSettingsMenu();
	}
	@When("user clicks on Language dropdown")
	public void user_clicks_on_language_dropdown() {
	    sm.click_languageDrpdwn_btn();
	}
	@Then("all language options should appear")
	public void all_language_options_should_appear() throws AWTException, InterruptedException {
	    boolean isVerified=sm.areLanguagesPresent();
	    sm.click_languageDrpdwn_btn();
	    CommonFunctions.closeSettingsMenu();
	    sa.assertEquals(isVerified, true);
	}
	@When("user clicks on Help option")
	public void user_clicks_on_help_option() throws AWTException, InterruptedException {
	    CustomActions.clickBtn(SettingsMenu.helpbtn);
	}
	@Then("Help page should open")
	public void help_page_should_open() throws InterruptedException, AWTException {
		WaitUtils.safeSleep(1000);
	    boolean isVerified=ImageVerification.verifyImage(SettingsMenu.helpPage);
	    CustomActions.clickBtn(SettingsMenu.helpPageClose_btn);
	    sa.assertEquals(isVerified, true);
	}
	@When("user clicks on History option")
	public void user_clicks_on_history_option() throws InterruptedException {
	    sm.click_history_btn();
	    WaitUtils.safeSleep(10000);
	}
	@Then("History page should appear")
	public void history_page_should_appear() throws IOException {
	    boolean isVerified=HistoryPage.isHistoryPage();
	    HistoryPage.closeHistoryPage();
	    sa.assertEquals(isVerified, true);
	}	

	
	@When("user clicks on Bet Options button")
	public void user_clicks_on_bet_options_button() throws AWTException, InterruptedException {
		CustomActions.clickBtn(FirstGameScreen.betOptions_btn_english);
	}

	@Then("Bet Options HUD should appear on screen")
	public void bet_options_hud_should_appear_on_screen()  throws InterruptedException, AWTException {
	    boolean isVerified=ImageVerification.verifyImage(FirstGameScreen.betOptions_popUp_english);
	    sa.assertEquals(isVerified, true);
	    PopUpClose.clickOnClosePopUp_btn();
	}
	
	@Then("close the gamble and return to base game")
	public void close_the_gamble_and_return_to_base_game() throws AWTException, InterruptedException {
		WaitUtils.safeSleep(500);
		CustomActions.clickBtn(GamblePage.gambleCollectBtn_English);
	}

	
	@When("user clicks on Autospin button")
	public void user_clicks_on_autospin_button()  throws AWTException, InterruptedException, IOException {
		CommonFunctions.handleFeatureGames();
		if(ImageVerification.verifyImage(FirstGameScreen.takeWin_btn)) 
		{
			CustomActions.clickBtn(FirstGameScreen.takeWin_btn);
		}
		CustomActions.clickBtn(AutospinOptions.autospin_btn);
		//PopUpClose.clickOnClosePopUp_btn();
	}

	@Then("Autospin Options HUD should appear on screen")
	public void autospin_options_hud_should_appear_on_screen()  throws InterruptedException, AWTException {
		boolean isVerified=ImageVerification.verifyImage(AutospinOptions.autospin_popUp_english);
		PopUpClose.clickOnClosePopUp_btn();
		sa.assertEquals(isVerified, true);
	}
	
	@When("user clicks on infinity button")
	public void user_clicks_on_infinity_button() throws AWTException, InterruptedException {
		WaitUtils.safeSleep(1000);
	    CustomActions.clickBtn(AutospinPopUp.autospinInfinite_btn);
	    //CommonFunctions.handleFeatureGames();
	}
	
	@Then("infinite spins should trigger")
	public void infinite_spins_should_trigger() throws InterruptedException, AWTException {
		boolean isVerified=ImageVerification.verifyImageWithTimeout(FirstGameScreen.infiniteSpin_btn, 2, 0.8);
		CustomActions.clickPreviousBtn();
		sa.assertEquals(isVerified, true, "spin button did not change to infinite spins");
		
	}
	
	@When("user clicks on Ten spin count button")
	public void user_clicks_on_ten_spin_count_button() throws AWTException, InterruptedException {
		WaitUtils.safeSleep(1000);
	    CustomActions.clickBtn(AutospinPopUp.autospin10_btn);
	}
	@Then("Ten spins should trigger")
	public void ten_spins_should_trigger() throws InterruptedException, AWTException {
		boolean isVerified=ImageVerification.verifyImageWithTimeout(FirstGameScreen.spin9_btn,2, 0.8);
		CustomActions.clickPreviousBtn();
		sa.assertEquals(isVerified, true, "spin button did not change to 10 spins");
		
	}
	@When("user clicks on Twenty spin count button")
	public void user_clicks_on_twenty_spin_count_button() throws InterruptedException, AWTException {
		
		WaitUtils.safeSleep(1000);
	    CustomActions.clickBtn(AutospinPopUp.autospin20_btn);
	}
	@Then("Twenty spins should trigger")
	public void twenty_spins_should_trigger() throws InterruptedException, AWTException {
		boolean isVerified=ImageVerification.verifyImageWithTimeout(FirstGameScreen.spin19_btn,2, 0.8);
		CustomActions.clickPreviousBtn();
		sa.assertEquals(isVerified, true, "spin button did not change to 20 spins");
		
	}
	@When("user clicks on Hundred spin count button")
	public void user_clicks_on_hundred_spin_count_button() throws InterruptedException, AWTException {
		
		WaitUtils.safeSleep(1000);
	    CustomActions.clickBtn(AutospinPopUp.autospin100_btn);
	}
	@Then("Hundred spins should trigger")
	public void hundred_spins_should_trigger() throws InterruptedException, AWTException {
		boolean isVerified=ImageVerification.verifyImageWithTimeout(FirstGameScreen.spin99_btn,2, 0.8);
		CustomActions.clickPreviousBtn();
		sa.assertEquals(isVerified, true, "spin button did not change to 20 spins");
		
	}
	
	@When("user clicks on info button")
	public void user_clicks_on_info_button()  throws AWTException, InterruptedException, IOException {
		CommonFunctions.handleFeatureGames();
		if(ImageVerification.verifyImage(FirstGameScreen.takeWin_btn)) 
		{
			CustomActions.clickBtn(FirstGameScreen.takeWin_btn);
		}
	    CustomActions.clickBtn(FirstGameScreen.gameInfoInside_btn);
	}

	@Then("info page HUD should appear on screen")
	public void info_page_hud_should_appear_on_screen()  throws InterruptedException, AWTException {
		boolean isVerified=ImageVerification.verifyImage(GameInfoInside.infoPage_popUp_english);
		PopUpClose.clickOnClosePopUp_btn();
		sa.assertEquals(isVerified, true);
		
	}

	@When("user clicks on Spin button")
	public void user_clicks_on_spin_button()  throws AWTException, InterruptedException, IOException {
		CommonFunctions.extractBalanceAmount();
		FirstGameScreen.clickSpin_btn();
		CommonFunctions.handleFeatureGames();
	}

	@Then("balance should get updated")
	public void balance_should_get_updated()  throws AWTException, InterruptedException, IOException {
		WaitUtils.safeSleep(2000);
		if(ImageVerification.verifyImage(FirstGameScreen.takeWin_btn)) 
			CustomActions.clickBtn(FirstGameScreen.takeWin_btn);
		boolean isVerified=CommonFunctions.calculateBalanceAfterSpin();
		sa.assertEquals(isVerified, true);
		
	}
	
	@When("user clicks on Quick Bet button")
	public void user_clicks_on_quick_bet_button() throws AWTException, InterruptedException {
	    CustomActions.clickBtn(FirstGameScreen.selectedQuickBet_btn_english);
	    
	}
	
	@Then("the play text should change to stop")
	public void the_play_text_should_change_to_stop() {
		boolean isVerified=ImageVerification.verifyImage(FirstGameScreen.quickBetBtn_stopTxt);
		sa.assertEquals(isVerified, true);
	}
	@Then("quick bet button should consist of the currency type")
	public void quick_bet_button_should_consist_of_the_currency_type() {
		boolean isVerified=ImageVerification.verifyImage(FirstGameScreen.quickBetBtn_currencyName);
		sa.assertEquals(isVerified, true);
	}
	
	@Then("spin button should change to stop btn")
	public void spin_button_should_change_to_stop_btn() throws InterruptedException, AWTException, IOException {
		boolean isVerified=ImageVerification.verifyImage(FirstGameScreen.stop_btn);
		CommonFunctions.handleFeatureGames();
		sa.assertEquals(isVerified, true);
	}
	
	
	@When("user clicks on Settings button")
	public void user_clicks_on_settings_button()  throws AWTException, InterruptedException {
	   CustomActions.clickBtn(FirstGameScreen.settings_btn);
	}

	@Then("Settings HUD should appear on screen")
	public void settings_hud_should_appear_on_screen()  throws InterruptedException, AWTException {
		boolean isVerified=ImageVerification.verifyImage(SettingsMenu.settings_popUP_english);
		CommonFunctions.closeSettingsMenu();
		sa.assertEquals(isVerified, true);
		
	}
	
	@When("user clicks on Sound button")
	public void user_clicks_on_sound_button()  throws AWTException, InterruptedException {
	    CustomActions.clickBtn(FirstGameScreen.soundOn_btn);
	    CommonFunctions.moveMouseAway();
	}

	@Then("sound button should get changed to disabled")
	public void sound_button_should_get_changed_to_disabled()  throws InterruptedException {
		boolean isVerified=ImageVerification.verifyImage(FirstGameScreen.soundOff_btn);
		sa.assertEquals(isVerified, true);
		
	}

	@When("user clicks on Sound button again")
	public void user_clicks_on_sound_button_again()  throws AWTException, InterruptedException {
	    CustomActions.clickBtn(FirstGameScreen.soundOff_btn);
	    CommonFunctions.moveMouseAway();
	}

	@Then("sound button should get changed to enabled")
	public void sound_button_should_get_changed_to_enabled()  throws InterruptedException {
		boolean isVerified=ImageVerification.verifyImage(FirstGameScreen.soundOn_btn);
		sa.assertEquals(isVerified, true);
		
	}
	
	@When("user clicks on Turbo button")
	public void user_clicks_on_turbo_button()  throws AWTException, InterruptedException {
		CustomActions.clickBtn(FirstGameScreen.turboOff_btn);
	    CommonFunctions.moveMouseAway();
	}

	@Then("Turbo button should get changed to enabled")
	public void turbo_button_should_get_changed_to_enabled()  throws InterruptedException {
		boolean isVerified=ImageVerification.verifyImage(FirstGameScreen.turboOn_btn);
		sa.assertEquals(isVerified, true);
		
	}

	@When("user clicks on Turbo button again")
	public void user_clicks_on_turbo_button_again()  throws AWTException, InterruptedException {
		CustomActions.clickBtn(FirstGameScreen.turboOn_btn);
	    CommonFunctions.moveMouseAway();
	}

	@Then("Turbo button should get changed to disabled")
	public void turbo_button_should_get_changed_to_disabled()  throws InterruptedException {
		boolean isVerified=ImageVerification.verifyImage(FirstGameScreen.turboOff_btn);
		sa.assertEquals(isVerified, true);
		
	}
	
	@When("user clicks on Fullscreen button")
	public void user_clicks_on_fullscreen_button() throws AWTException, InterruptedException {
	    CustomActions.clickBtn(FirstGameScreen.fullscreen_btn);
	}
	
	@Then("Game should switch to Fullscreen mode")
	public void game_should_switch_to_fullscreen_mode() throws InterruptedException, AWTException {
		boolean isVerified=ImageVerification.verifyImageWithTimeout(FirstGameScreen.fullscreenHUD_firstScreen, 5, 0.8);
		sa.assertEquals(isVerified, true);
		
	}
	
	@When("user clicks on Windowed mode button")
	public void user_clicks_on_windowed_mode_button() throws AWTException, InterruptedException {
		WaitUtils.safeSleep(1000);
		CustomActions.clickBtn(FirstGameScreen.windowMode_btn);
	}
	
	@Then("Game should switch to Windowed mode")
	public void game_should_switch_to_windowed_mode() throws InterruptedException {
		boolean isVerified=ImageVerification.verifyImageWithTimeout(FirstGameScreen.firstScreen_HUD, 5, 0.8);
		sa.assertEquals(isVerified, true);
		
	}
	
	@When("user clicks on right arrow button")
	public void user_clicks_on_right_arrow_button() throws InterruptedException, AWTException, IOException {
		int i=0;
		initialQuickBet=CommonFunctions.extractBetAmount();
		while(ImageVerification.verifyImageWithTimeout(FirstGameScreen.rightArrow_btn, 3, 0.95)) 
	    {
	    	CustomActions.clickBtn(FirstGameScreen.rightArrow_btn);
	    	WaitUtils.safeSleep(500);
	    	currentQuickBet=CommonFunctions.extractBetAmount();
	    	System.out.println("Initial Bet amount: " + initialQuickBet);
	    	if(currentQuickBet<initialQuickBet) 
	    	{
	    		verified=false; 
	    		break;
    		}
	    	initialQuickBet=currentQuickBet;
	    	i++;
	    	if(i>9) break;
	    }
	}
	
	@Then("quick bet values should increase")
	public void quick_bet_values_should_increase() {
		if(verified==true) sa.assertTrue(true);
	    else sa.assertTrue(false);
		
	}
	
	@When("user clicks on Left arrow button")
	public void user_clicks_on_left_arrow_button() throws AWTException, InterruptedException, IOException {
		int i=0;
		initialQuickBet=CommonFunctions.extractBetAmount();
	    while(ImageVerification.verifyImageWithTimeout(FirstGameScreen.leftArrow_btn, 3, 0.95)) 
	    {
	    	CustomActions.clickBtn(FirstGameScreen.leftArrow_btn);
	    	WaitUtils.safeSleep(500);
	    	currentQuickBet=CommonFunctions.extractBetAmount();
	    	System.out.println("Initial Bet amount: " + initialQuickBet);
	    	if(currentQuickBet>initialQuickBet) 
	    	{
		    	verified=false; 
		    	break;
	    	}
	    	initialQuickBet=currentQuickBet;
	    	i++;
	    	if(i>9) break;
	    }
	    
	}
	
	@Then("quick bet values should decrease")
	public void quick_bet_values_should_decrease() {
	    if(verified==true) sa.assertTrue(true);
	    else sa.assertTrue(false); 
	    
	}
	
	@When("user clicks on Home button")
	public void user_clicks_on_home_button()  throws AWTException, InterruptedException {
		CustomActions.clickBtn(FirstGameScreen.home_btn);
		//WaitUtils.safeSleep(8000);
	}

	@Then("Home page should appear on screen")
	public void home_page_should_appear_on_screen()  throws InterruptedException {
		
		if(ImageVerification.verifyImageWithTimeout(LobbyPage.lobbyPage_screen,16,0.85)) 
		{
			sa.assertTrue(true);
		}
		else 
		{
			String websiteHome=sh.getText_logOff_btn();
			sa.assertEquals(websiteHome, "Log Off");
		}
		sa.assertAll();
	}
		
}
