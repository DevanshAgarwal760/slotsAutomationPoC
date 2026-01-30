package stepDefinitions;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;

import Utilities.CustomActions;
import Utilities.ImageVerification;
import Utilities.WaitUtils;
import commonTestMethods.CommonFunctions;
import factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AutospinOptions;
import pageObjects.FirstGameScreen;
import pageObjects.GamblePage;
import pageObjects.GameInfoInside;
import pageObjects.HistoryPage;
import pageObjects.PopUpClose;
import pageObjects.SettingsMenu;

public class TC_LanguageDropdown 
{
	SettingsMenu sm;
	
	@When("user navigates to Language dropdown")
	public void user_navigates_to_language_dropdown() throws AWTException, InterruptedException {
		BaseClass.driver.switchTo().defaultContent();
		BaseClass.driver.switchTo().defaultContent();
		sm=new SettingsMenu(BaseClass.driver);
		WaitUtils.safeSleep(2000);
		CustomActions.clickBtn(FirstGameScreen.settings_btn);
		sm.clickLangDropdown();
	}
	@Then("all language options should be present")
	public void all_language_options_should_be_present() throws AWTException, InterruptedException {
		WaitUtils.safeSleep(1000);
	    boolean isVerified=sm.areLanguagesPresent();
	    Assert.assertEquals(isVerified, true);
	    CommonFunctions.closeSettingsMenu();
	    WaitUtils.safeSleep(1000);
	}
	
	@When("user selects English")
	public void user_selects_english() throws AWTException, InterruptedException, IOException {
	    CommonFunctions.changeLangToEnglish();
	}
	@Then("English language should get updated in Settings")
	public void english_language_should_get_updated_in_settings() throws AWTException, InterruptedException {
		WaitUtils.safeSleep(1000);
		CustomActions.clickBtn(FirstGameScreen.settings_btn);
		boolean isVerified=ImageVerification.verifyImage(SettingsMenu.settingsMenu_English);
		Assert.assertEquals(isVerified, true);
		CommonFunctions.closeSettingsMenu();
		WaitUtils.safeSleep(1000);
	}
	@Then("English language should get updated in Help")
	public void english_language_should_get_updated_in_help() throws AWTException, InterruptedException {
		WaitUtils.safeSleep(1000);
	    SettingsMenu.click_help_btn();
	    boolean isVerified=ImageVerification.verifyImage(SettingsMenu.helpPage);
	    Assert.assertEquals(isVerified,true);
	    PopUpClose.clickOnClosePopUp_btn();
	    WaitUtils.safeSleep(1000);
	}
	@Then("English language should get updated in Info page")
	public void english_language_should_get_updated_in_info_page() throws AWTException, InterruptedException {
		WaitUtils.safeSleep(1000);
		CustomActions.clickBtn(FirstGameScreen.gameInfoInside_btn);
		boolean isVerified=ImageVerification.verifyImage(GameInfoInside.infoPage_popUp_english);
		Assert.assertEquals(isVerified,true);
		PopUpClose.clickOnClosePopUp_btn();
		WaitUtils.safeSleep(1000);
	}
	@Then("English language should get updated in Bet pop up")
	public void english_language_should_get_updated_in_bet_pop_up() throws AWTException, InterruptedException {
		WaitUtils.safeSleep(1000);
		CustomActions.clickBtn(FirstGameScreen.betOptions_btn);
		boolean isVerified=ImageVerification.verifyImage(FirstGameScreen.betOptions_popUp_english);
		Assert.assertEquals(isVerified,true);
		PopUpClose.clickOnClosePopUp_btn();
		WaitUtils.safeSleep(1000);
	}
	@Then("English language should get updated in Autoplay pop up")
	public void english_language_should_get_updated_in_autoplay_pop_up() throws AWTException, InterruptedException {
		CustomActions.clickBtn(FirstGameScreen.autospinOptions_btn);
		WaitUtils.safeSleep(1000);
		boolean isVerified=ImageVerification.verifyImage(AutospinOptions.autospin_popUp_english);
		Assert.assertEquals(isVerified,true);
		PopUpClose.clickOnClosePopUp_btn();
		WaitUtils.safeSleep(1000);
	}
	@Then("English language should get updated in Base Game HUD")
	public void english_language_should_get_updated_in_base_game_hud() {
		WaitUtils.safeSleep(1000);
		boolean isVerified=ImageVerification.verifyImage(FirstGameScreen.baseGame_English);
		Assert.assertEquals(isVerified,true);
		WaitUtils.safeSleep(1000);
	}
	@Then("English language should get updated in History Page")
	public void english_language_should_get_updated_in_history_page() throws AWTException, InterruptedException, IOException {
		
		CustomActions.clickBtn(FirstGameScreen.settings_btn);
		WaitUtils.safeSleep(1000);
		new SettingsMenu(BaseClass.getDriver()).click_history_btn();
		//WaitUtils.safeSleep(10000);
		boolean isVerified=ImageVerification.verifyImageWithTimeout(HistoryPage.historyPage_English, 20, 0.9);
		Assert.assertEquals(isVerified,true);
		HistoryPage.switchToHistoryPage();
		HistoryPage.closeHistoryPage();
		CommonFunctions.closeSettingsMenu();
		WaitUtils.safeSleep(1000);
	}
	@Then("English language should get updated in JP index")
	public void english_language_should_get_updated_in_jp_index() {
		
		CustomActions.hoverMouse(FirstGameScreen.sapphireJackpotIndex);
		WaitUtils.safeSleep(1000);
		if(ImageVerification.verifyImage(FirstGameScreen.lastWinner_JPindex) &&
				ImageVerification.verifyImage(FirstGameScreen.biggestWinner_JPindex) &&
					ImageVerification.verifyImage(FirstGameScreen.numberOfWinners_JPindex)) Assert.assertTrue(true);
		else Assert.assertTrue(false);
		WaitUtils.safeSleep(1000);
	}
	@Then("English language should get updated in Gamble page")
	public void english_language_should_get_updated_in_gamble_page() throws AWTException, InterruptedException, IOException {
		WaitUtils.safeSleep(1000);
		CommonFunctions.triggerGamble();
		CustomActions.clickBtn(FirstGameScreen.gambleEnabled_btn);
		boolean isVerified=GamblePage.checkGambleLoc_English();
		Assert.assertEquals(isVerified,true);
		WaitUtils.safeSleep(1000);
	}
	@Then("English language should get updated in Jackpot")
	public void english_language_should_get_updated_in_jackpot() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@When("user selects French")
	public void user_selects_french() throws AWTException, InterruptedException, IOException {
		CommonFunctions.changeLangToFrench();
	}
	@Then("French language should get updated in Settings")
	public void french_language_should_get_updated_in_settings() throws AWTException, InterruptedException {
		WaitUtils.safeSleep(1000);
		CustomActions.clickBtn(FirstGameScreen.settings_btn);
		boolean isVerified=ImageVerification.verifyImage(SettingsMenu.settingsMenu_French);
		Assert.assertEquals(isVerified, true);
		CommonFunctions.closeSettingsMenu();
		WaitUtils.safeSleep(1000);
	}
	@Then("French language should get updated in Help")
	public void french_language_should_get_updated_in_help() throws AWTException, InterruptedException {
		WaitUtils.safeSleep(1000);
	    SettingsMenu.click_help_btn();
	    boolean isVerified=ImageVerification.verifyImage(SettingsMenu.helpPage_French);
	    Assert.assertEquals(isVerified,true);
	    PopUpClose.clickOnClosePopUp_btn();
	    WaitUtils.safeSleep(1000);
	}
	@Then("French language should get updated in Info page")
	public void french_language_should_get_updated_in_info_page() throws AWTException, InterruptedException {
		WaitUtils.safeSleep(1000);
		CustomActions.clickBtn(FirstGameScreen.gameInfoInside_btn);
		boolean isVerified=ImageVerification.verifyImage(GameInfoInside.infoPage_popUp_french);
		Assert.assertEquals(isVerified,true);
		PopUpClose.clickOnClosePopUp_btn();
		WaitUtils.safeSleep(1000);
	}
	@Then("French language should get updated in Bet pop up")
	public void french_language_should_get_updated_in_bet_pop_up() throws AWTException, InterruptedException {
		WaitUtils.safeSleep(1000);
		CustomActions.clickBtn(FirstGameScreen.betOptions_btn);
		boolean isVerified=ImageVerification.verifyImage(FirstGameScreen.betOptions_popUp_french);
		Assert.assertEquals(isVerified,true);
		PopUpClose.clickOnClosePopUp_btn();
		WaitUtils.safeSleep(1000);
	}
	@Then("French language should get updated in Autoplay pop up")
	public void french_language_should_get_updated_in_autoplay_pop_up() throws AWTException, InterruptedException {
		CustomActions.clickBtn(FirstGameScreen.autospinOptions_btn);
		WaitUtils.safeSleep(1000);
		boolean isVerified=ImageVerification.verifyImage(AutospinOptions.autospin_popUp_english);
		Assert.assertEquals(isVerified,true);
		PopUpClose.clickOnClosePopUp_btn();
		WaitUtils.safeSleep(1000);
	}
	@Then("French language should get updated in Base Game HUD")
	public void french_language_should_get_updated_in_base_game_hud() {
		WaitUtils.safeSleep(1000);
		boolean isVerified=ImageVerification.verifyImage(FirstGameScreen.baseGame_French);
		Assert.assertEquals(isVerified,true);
		WaitUtils.safeSleep(1000);
	}
	@Then("French language should get updated in History Page")
	public void french_language_should_get_updated_in_history_page() throws AWTException, InterruptedException, IOException {
		CustomActions.clickBtn(FirstGameScreen.settings_btn);
		WaitUtils.safeSleep(1000);
		new SettingsMenu(BaseClass.getDriver()).click_history_btn();
		//WaitUtils.safeSleep(10000);
	    boolean isVerified=ImageVerification.verifyImageWithTimeout(HistoryPage.historyPage_French, 20, 0.9);
		Assert.assertEquals(isVerified,true);
		HistoryPage.switchToHistoryPage();
		HistoryPage.closeHistoryPage();
		CommonFunctions.closeSettingsMenu();
		WaitUtils.safeSleep(1000);
	}
	@Then("French language should get updated in JP index")
	public void french_language_should_get_updated_in_jp_index() {
		CustomActions.hoverMouse(FirstGameScreen.sapphireJackpotIndex);
		WaitUtils.safeSleep(1000);
		if(ImageVerification.verifyImage(FirstGameScreen.lastWinner_JPindex_French) &&
				ImageVerification.verifyImage(FirstGameScreen.numberOfWinners_JPindex_French) &&
					ImageVerification.verifyImage(FirstGameScreen.biggestWinner_JPindex_French)) Assert.assertTrue(true);
		else Assert.assertTrue(false);
		WaitUtils.safeSleep(1000);
	}
	@Then("French language should get updated in Gamble page")
	public void french_language_should_get_updated_in_gamble_page() throws AWTException, InterruptedException, IOException {
		WaitUtils.safeSleep(1000);
		CommonFunctions.triggerGamble();
		CustomActions.clickBtn(FirstGameScreen.gambleEnabled_btn);
		boolean isVerified=GamblePage.checkGambleLoc_French();
		Assert.assertEquals(isVerified,true);
		WaitUtils.safeSleep(1000);
	}
	@Then("French language should get updated in Jackpot")
	public void french_language_should_get_updated_in_jackpot() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@When("user selects Portuguese")
	public void user_selects_portuguese() throws AWTException, InterruptedException, IOException {
		CommonFunctions.changeLangToPortuguese();
	}
	@Then("Portuguese language should get updated in Settings")
	public void portuguese_language_should_get_updated_in_settings() throws AWTException, InterruptedException {
		WaitUtils.safeSleep(1000);
		CustomActions.clickBtn(FirstGameScreen.settings_btn);
		boolean isVerified=ImageVerification.verifyImage(SettingsMenu.settingsMenu_Portuguese);
		Assert.assertEquals(isVerified, true);
		CommonFunctions.closeSettingsMenu();
		WaitUtils.safeSleep(1000);
	}
	@Then("Portuguese language should get updated in Help")
	public void portuguese_language_should_get_updated_in_help() throws AWTException, InterruptedException {
		WaitUtils.safeSleep(1000);
	    SettingsMenu.click_help_btn();
	    boolean isVerified=ImageVerification.verifyImage(SettingsMenu.helpPage_Portuguese);
	    Assert.assertEquals(isVerified,true);
	    PopUpClose.clickOnClosePopUp_btn();
	    WaitUtils.safeSleep(1000);
	}
	@Then("Portuguese language should get updated in Info page")
	public void portuguese_language_should_get_updated_in_info_page() throws AWTException, InterruptedException {
		WaitUtils.safeSleep(1000);
		CustomActions.clickBtn(FirstGameScreen.gameInfoInside_btn);
		boolean isVerified=ImageVerification.verifyImage(GameInfoInside.infoPage_popUp_portuguese);
		Assert.assertEquals(isVerified,true);
		PopUpClose.clickOnClosePopUp_btn();
		WaitUtils.safeSleep(1000);
	}
	@Then("Portuguese language should get updated in Bet pop up")
	public void portuguese_language_should_get_updated_in_bet_pop_up() throws AWTException, InterruptedException {
		WaitUtils.safeSleep(1000);
		CustomActions.clickBtn(FirstGameScreen.betOptions_btn);
		boolean isVerified=ImageVerification.verifyImage(FirstGameScreen.betOptions_popUp_portuguese);
		Assert.assertEquals(isVerified,true);
		PopUpClose.clickOnClosePopUp_btn();
		WaitUtils.safeSleep(1000);
	}
	@Then("Portuguese language should get updated in Autoplay pop up")
	public void portuguese_language_should_get_updated_in_autoplay_pop_up() throws AWTException, InterruptedException {
		CustomActions.clickBtn(FirstGameScreen.autospinOptions_btn);
		WaitUtils.safeSleep(1000);
		boolean isVerified=ImageVerification.verifyImage(AutospinOptions.autospin_popUp_portuguese);
		Assert.assertEquals(isVerified,true);
		PopUpClose.clickOnClosePopUp_btn();
		WaitUtils.safeSleep(1000);
	}
	@Then("Portuguese language should get updated in Base Game HUD")
	public void portuguese_language_should_get_updated_in_base_game_hud() {
		WaitUtils.safeSleep(1000);
		boolean isVerified=ImageVerification.verifyImage(FirstGameScreen.baseGame_Portuguese);
		Assert.assertEquals(isVerified,true);
		WaitUtils.safeSleep(1000);
	}
	@Then("Portuguese language should get updated in History Page")
	public void portuguese_language_should_get_updated_in_history_page() throws AWTException, InterruptedException, IOException {
		CustomActions.clickBtn(FirstGameScreen.settings_btn);
		WaitUtils.safeSleep(1000);
		new SettingsMenu(BaseClass.getDriver()).click_history_btn();
		//WaitUtils.safeSleep(10000);
	    boolean isVerified=ImageVerification.verifyImageWithTimeout(HistoryPage.historyPage_Portuguese, 20, 0.9);
		Assert.assertEquals(isVerified,true);
		HistoryPage.switchToHistoryPage();
		HistoryPage.closeHistoryPage();
		CommonFunctions.closeSettingsMenu();
		WaitUtils.safeSleep(1000);
	}
	@Then("Portuguese language should get updated in JP index")
	public void portuguese_language_should_get_updated_in_jp_index() {
		CustomActions.hoverMouse(FirstGameScreen.sapphireJackpotIndex);
		WaitUtils.safeSleep(1000);
		if(ImageVerification.verifyImage(FirstGameScreen.lastWinner_JPindex_Portuguese) &&
				ImageVerification.verifyImage(FirstGameScreen.numberOfWinners_Portuguese) &&
					ImageVerification.verifyImage(FirstGameScreen.biggestWinner_Portuguese)) Assert.assertTrue(true);
		else Assert.assertTrue(false);
		WaitUtils.safeSleep(1000);
	}
	@Then("Portuguese language should get updated in Gamble page")
	public void portuguese_language_should_get_updated_in_gamble_page() throws AWTException, InterruptedException, IOException {
		WaitUtils.safeSleep(1000);
		CommonFunctions.triggerGamble();
		CustomActions.clickBtn(FirstGameScreen.gambleEnabled_btn);
		boolean isVerified=GamblePage.checkGambleLoc_Portuguese();
		Assert.assertEquals(isVerified,true);
		WaitUtils.safeSleep(1000);
	}
	@Then("Portuguese language should get updated in Jackpot")
	public void portuguese_language_should_get_updated_in_jackpot() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@When("user selects Spanish")
	public void user_selects_spanish() throws AWTException, InterruptedException, IOException {
		CommonFunctions.changeLangToSpanish();
	}
	@Then("Spanish language should get updated in Settings")
	public void spanish_language_should_get_updated_in_settings() throws AWTException, InterruptedException {
		WaitUtils.safeSleep(1000);
		CustomActions.clickBtn(FirstGameScreen.settings_btn);
		boolean isVerified=ImageVerification.verifyImage(SettingsMenu.settingsMenu_Spanish);
		Assert.assertEquals(isVerified, true);
		CommonFunctions.closeSettingsMenu();
		WaitUtils.safeSleep(1000);
	}
	@Then("Spanish language should get updated in Help")
	public void spanish_language_should_get_updated_in_help() throws AWTException, InterruptedException {
		WaitUtils.safeSleep(1000);
	    SettingsMenu.click_help_btn();
	    boolean isVerified=ImageVerification.verifyImage(SettingsMenu.helpPage_Spanish);
	    Assert.assertEquals(isVerified,true);
	    PopUpClose.clickOnClosePopUp_btn();
	    WaitUtils.safeSleep(1000);
	}
	@Then("Spanish language should get updated in Info page")
	public void spanish_language_should_get_updated_in_info_page() throws AWTException, InterruptedException {
		WaitUtils.safeSleep(1000);
		CustomActions.clickBtn(FirstGameScreen.gameInfoInside_btn);
		boolean isVerified=ImageVerification.verifyImage(GameInfoInside.infoPage_popUp_spanish);
		Assert.assertEquals(isVerified,true);
		PopUpClose.clickOnClosePopUp_btn();
		WaitUtils.safeSleep(1000);
	}
	@Then("Spanish language should get updated in Bet pop up")
	public void spanish_language_should_get_updated_in_bet_pop_up() throws AWTException, InterruptedException {
		WaitUtils.safeSleep(1000);
		CustomActions.clickBtn(FirstGameScreen.betOptions_btn);
		boolean isVerified=ImageVerification.verifyImage(FirstGameScreen.betOptions_popUp_spanish);
		Assert.assertEquals(isVerified,true);
		PopUpClose.clickOnClosePopUp_btn();
		WaitUtils.safeSleep(1000);
	}
	@Then("Spanish language should get updated in Autoplay pop up")
	public void spanish_language_should_get_updated_in_autoplay_pop_up() throws AWTException, InterruptedException {
		CustomActions.clickBtn(FirstGameScreen.autospinOptions_btn);
		WaitUtils.safeSleep(1000);
		boolean isVerified=ImageVerification.verifyImage(AutospinOptions.autospin_popUp_spanish);
		Assert.assertEquals(isVerified,true);
		PopUpClose.clickOnClosePopUp_btn();
		WaitUtils.safeSleep(1000);
	}
	@Then("Spanish language should get updated in Base Game HUD")
	public void spanish_language_should_get_updated_in_base_game_hud() {
		WaitUtils.safeSleep(1000);
		boolean isVerified=ImageVerification.verifyImage(FirstGameScreen.baseGame_Spanish);
		Assert.assertEquals(isVerified,true);
		WaitUtils.safeSleep(1000);
	}
	@Then("Spanish language should get updated in History Page")
	public void spanish_language_should_get_updated_in_history_page() throws AWTException, InterruptedException, IOException {
		CustomActions.clickBtn(FirstGameScreen.settings_btn);
		WaitUtils.safeSleep(1000);
		new SettingsMenu(BaseClass.getDriver()).click_history_btn();
		//WaitUtils.safeSleep(10000);
	    boolean isVerified=ImageVerification.verifyImageWithTimeout(HistoryPage.historyPage_Spanish, 20, 0.9);
		Assert.assertEquals(isVerified,true);
		HistoryPage.switchToHistoryPage();
		HistoryPage.closeHistoryPage();
		CommonFunctions.closeSettingsMenu();
		WaitUtils.safeSleep(1000);
	}
	@Then("Spanish language should get updated in JP index")
	public void spanish_language_should_get_updated_in_jp_index() {
		CustomActions.hoverMouse(FirstGameScreen.sapphireJackpotIndex);
		WaitUtils.safeSleep(1000);
		if(ImageVerification.verifyImage(FirstGameScreen.lastWinner_JPindex_Spanish) &&
				ImageVerification.verifyImage(FirstGameScreen.numberOfWinners_JPindex_Spanish) &&
					ImageVerification.verifyImage(FirstGameScreen.biggestWinner_JPindex_Spanish)) Assert.assertTrue(true);
		else Assert.assertTrue(false);
		WaitUtils.safeSleep(1000);
	}
	@Then("Spanish language should get updated in Gamble page")
	public void spanish_language_should_get_updated_in_gamble_page() throws AWTException, InterruptedException, IOException {
		WaitUtils.safeSleep(1000);
		CommonFunctions.triggerGamble();
		CustomActions.clickBtn(FirstGameScreen.gambleEnabled_btn);
		boolean isVerified=GamblePage.checkGambleLoc_Spanish();
		Assert.assertEquals(isVerified,true);
		WaitUtils.safeSleep(1000);
	}
	@Then("Spanish language should get updated in Jackpot")
	public void spanish_language_should_get_updated_in_jackpot() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@When("user selects Bulgarian")
	public void user_selects_bulgarian() throws AWTException, InterruptedException, IOException {
		CommonFunctions.changeLangToBulgarian();
	}
	@Then("Bulgarian language should get updated in Settings")
	public void bulgarian_language_should_get_updated_in_settings() throws AWTException, InterruptedException {
		WaitUtils.safeSleep(1000);
		CustomActions.clickBtn(FirstGameScreen.settings_btn);
		boolean isVerified=ImageVerification.verifyImage(SettingsMenu.settingsMenu_Bulgarian);
		Assert.assertEquals(isVerified, true);
		CommonFunctions.closeSettingsMenu();
		WaitUtils.safeSleep(1000);
	}
	@Then("Bulgarian language should get updated in Help")
	public void bulgarian_language_should_get_updated_in_help() throws AWTException, InterruptedException {
		WaitUtils.safeSleep(1000);
	    SettingsMenu.click_help_btn();
	    boolean isVerified=ImageVerification.verifyImage(SettingsMenu.helpPage_Bulagrian);
	    Assert.assertEquals(isVerified,true);
	    PopUpClose.clickOnClosePopUp_btn();
	    WaitUtils.safeSleep(1000);
	}
	@Then("Bulgarian language should get updated in Info page")
	public void bulgarian_language_should_get_updated_in_info_page() throws AWTException, InterruptedException {
		WaitUtils.safeSleep(1000);
		CustomActions.clickBtn(FirstGameScreen.gameInfoInside_btn);
		boolean isVerified=ImageVerification.verifyImage(GameInfoInside.infoPage_popUp_bulgarian);
		Assert.assertEquals(isVerified,true);
		PopUpClose.clickOnClosePopUp_btn();
		WaitUtils.safeSleep(1000);
	}
	@Then("Bulgarian language should get updated in Bet pop up")
	public void bulgarian_language_should_get_updated_in_bet_pop_up() throws AWTException, InterruptedException {
		WaitUtils.safeSleep(1000);
		CustomActions.clickBtn(FirstGameScreen.betOptions_btn);
		boolean isVerified=ImageVerification.verifyImage(FirstGameScreen.betOptions_popUp_bulgarian);
		Assert.assertEquals(isVerified,true);
		PopUpClose.clickOnClosePopUp_btn();
		WaitUtils.safeSleep(1000);
	}
	@Then("Bulgarian language should get updated in Autoplay pop up")
	public void bulgarian_language_should_get_updated_in_autoplay_pop_up() throws AWTException, InterruptedException {
		CustomActions.clickBtn(FirstGameScreen.autospinOptions_btn);
		WaitUtils.safeSleep(1000);
		boolean isVerified=ImageVerification.verifyImage(AutospinOptions.autospin_popUp_bulgarian);
		Assert.assertEquals(isVerified,true);
		PopUpClose.clickOnClosePopUp_btn();
		WaitUtils.safeSleep(1000);
	}
	@Then("Bulgarian language should get updated in Base Game HUD")
	public void bulgarian_language_should_get_updated_in_base_game_hud() {
		WaitUtils.safeSleep(1000);
		boolean isVerified=ImageVerification.verifyImage(FirstGameScreen.baseGame_Bulgarian);
		Assert.assertEquals(isVerified,true);
		WaitUtils.safeSleep(1000);
	}
	@Then("Bulgarian language should get updated in History Page")
	public void bulgarian_language_should_get_updated_in_history_page() throws AWTException, InterruptedException, IOException {
		CustomActions.clickBtn(FirstGameScreen.settings_btn);
		WaitUtils.safeSleep(1000);
		new SettingsMenu(BaseClass.getDriver()).click_history_btn();
		//WaitUtils.safeSleep(10000);
	    boolean isVerified=ImageVerification.verifyImageWithTimeout(HistoryPage.historyPage_Bulgarian, 20, 0.9);
		Assert.assertEquals(isVerified,true);
		HistoryPage.switchToHistoryPage();
		HistoryPage.closeHistoryPage();
		CommonFunctions.closeSettingsMenu();
		WaitUtils.safeSleep(1000);
	}
	@Then("Bulgarian language should get updated in JP index")
	public void bulgarian_language_should_get_updated_in_jp_index() {
		CustomActions.hoverMouse(FirstGameScreen.sapphireJackpotIndex);
		WaitUtils.safeSleep(1000);
		if(ImageVerification.verifyImage(FirstGameScreen.lastWinner_JPindex_Bulgarian) &&
				ImageVerification.verifyImage(FirstGameScreen.numberOfWinners_JPindex_Bulgarian) &&
					ImageVerification.verifyImage(FirstGameScreen.biggestWinner_JPindex_Bulgarian)) Assert.assertTrue(true);
		else Assert.assertTrue(false);
		WaitUtils.safeSleep(1000);
	}
	@Then("Bulgarian language should get updated in Gamble page")
	public void bulgarian_language_should_get_updated_in_gamble_page() throws AWTException, InterruptedException, IOException {
		WaitUtils.safeSleep(1000);
		CommonFunctions.triggerGamble();
		CustomActions.clickBtn(FirstGameScreen.gambleEnabled_btn);
		boolean isVerified=GamblePage.checkGambleLoc_Bulgarian();
		Assert.assertEquals(isVerified,true);
		WaitUtils.safeSleep(1000);
	}
	@Then("Bulgarian language should get updated in Jackpot")
	public void bulgarian_language_should_get_updated_in_jackpot() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
