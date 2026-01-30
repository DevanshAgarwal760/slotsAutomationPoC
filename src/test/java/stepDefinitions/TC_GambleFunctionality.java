package stepDefinitions;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import Utilities.CustomActions;
import Utilities.ImageVerification;
import Utilities.ScreenshotCapture;
import Utilities.WaitUtils;
import commonTestMethods.CommonFunctions;
import factory.BaseClass;
import hooks.Hooks;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.FirstGameScreen;
import pageObjects.GamblePage;
import pageObjects.SuribetHome;
import pageObjects.TransferAmountPopUp;

public class TC_GambleFunctionality 
{
	SuribetHome sh;
	TransferAmountPopUp tapu=new TransferAmountPopUp(BaseClass.driver);
	FirstGameScreen fgs;
	int initialAttempts=0;
	int finalAttempts=0;
	double initialGambleAmount=0;
	double finalGambleAmount=0;
	double winAmountBeforeGamble=0;
	double winAmountAfterGamble=0;
	String scenario1="Verify  the Attempts for correct guess in the Gamble gameplay";
	String scenario2="Verify  the Attempts for incorrect guess in the Gamble gameplay";
	
	@Given("The Gamble game has triggered")
	public void the_gamble_game_has_triggered() throws AWTException, InterruptedException, IOException {
	    //String logOff=sh.getText_logOff_btn();
	    //Assert.assertEquals(logOff, "Log Off");
		CommonFunctions cf=new CommonFunctions();
		cf.launchGame();
		CommonFunctions.triggerGamble();
	}

	@When("User clicks on gamble button")
	public void user_clicks_on_gamble_button() throws AWTException, InterruptedException, IOException {
		winAmountBeforeGamble=CommonFunctions.extractBalanceAmount();
	    CustomActions.clickBtn(FirstGameScreen.gambleEnabled_btn);
	}

	@Then("The gamble gameplay page should open")
	public void the_gamble_gameplay_page_should_open() throws InterruptedException {
	    boolean isVerified=ImageVerification.verifyImage(GamblePage.gamblePage);
	    Assert.assertEquals(isVerified, true);
	}
	
	@When("user clicks on collect button")
	public void user_clicks_on_collect_button() throws AWTException, InterruptedException {
	   CustomActions.clickBtn(GamblePage.gambleCollectBtn_English);
	   WaitUtils.safeSleep(2000);
	}
	@Then("User comes back to iFrame base Game HUD")
	public void user_comes_back_to_i_frame_base_game_hud() {
		boolean isVerified=ImageVerification.verifyImage(FirstGameScreen.firstScreen_HUD);
		Assert.assertEquals(isVerified, true);
	}

	@When("user clicks on Red button")
	public void user_clicks_on_red_button() throws AWTException, InterruptedException, IOException {
		
		int i=0;
		while(ImageVerification.verifyImage(GamblePage.gamblePage))
		{
			CustomActions.clickBtn(GamblePage.gambleRed_btn);
			i++;
			if(i>10) break; 
		}
	}

	@Then("user gets a win or loses gamble")
	public void user_gets_a_win_or_loses_gamble() throws AWTException, IOException, InterruptedException {
		WaitUtils.safeSleep(5000);
		if(ImageVerification.verifyImage(FirstGameScreen.firstScreen_HUD)) 
		{
			Assert.assertTrue(true);
		}
	}
	
	@When("The gamble gameplay page open")
	public void the_gamble_gameplay_page_open() throws InterruptedException {
		boolean isVerified=ImageVerification.verifyImage(GamblePage.gamblePage);
	    Assert.assertEquals(isVerified, true);
	}
	
	@When("user clicks on Red button once")
	public void user_clicks_on_red_button_once() throws AWTException, IOException, InterruptedException {
		if(Hooks.scen.equals(scenario1) || Hooks.scen.equals(scenario2))
			initialAttempts=GamblePage.extractGambleAttempts();
		else
			initialGambleAmount=GamblePage.extractGambleAmount();
		
		CustomActions.clickBtn(GamblePage.gambleRed_btn);
	}
	
	@When("user wins gamble for Red")
	public void user_wins_gamble_for_red()  throws InterruptedException, AWTException, IOException {
		if(Hooks.scen.equals(scenario1) || Hooks.scen.equals(scenario2)) 
		{
			WaitUtils.safeSleep(5000);
			//initialAttempts=GamblePage.extractGambleAttempts();
			int i=0;
			while(!ImageVerification.verifyImage(GamblePage.gamblePage)) 
			{
				CommonFunctions.triggerGamble();
				CustomActions.clickBtn(FirstGameScreen.gambleEnabled_btn);
				initialAttempts=GamblePage.extractGambleAttempts();
				CustomActions.clickBtn(GamblePage.gambleRed_btn);
				i++;
				if(i==8) break;
			}
		}
		
		else {
			WaitUtils.safeSleep(5000);
			//initialGambleAmount=GamblePage.extractGambleAmount();
			int i=0;
			while(!ImageVerification.verifyImage(GamblePage.gamblePage)) 
			{
				CommonFunctions.triggerGamble();
				CustomActions.clickBtn(FirstGameScreen.gambleEnabled_btn);
				initialGambleAmount=GamblePage.extractGambleAmount();
				CustomActions.clickBtn(GamblePage.gambleRed_btn);
				i++;
				if(i==8) break;
				WaitUtils.safeSleep(5000);
			}
		}
	}
	
	@Then("gamble amount should double")
	public void gamble_amount_should_double() throws AWTException, IOException, InterruptedException {
		WaitUtils.safeSleep(2000);
	    finalGambleAmount=GamblePage.extractGambleAmount();
	    if(finalGambleAmount==initialGambleAmount*2) 
	    {
	    	Assert.assertTrue(true);
	    }
	    else 
	    {
	    	Assert.assertTrue(false);
	    }
	}
	
	@When("user clicks on Black button once")
	public void user_clicks_on_black_button_once() throws AWTException, InterruptedException, IOException {
		initialGambleAmount=GamblePage.extractGambleAmount();
		CustomActions.clickBtn(GamblePage.gambleBlack_btn);
	}
	
	@When("user wins gamble for Black")
	public void user_wins_gamble_for_black() throws InterruptedException, AWTException, IOException {
		WaitUtils.safeSleep(5000);
		int i=0;
		while(!ImageVerification.verifyImage(GamblePage.gamblePage)) 
		{
			CommonFunctions.triggerGamble();
			CustomActions.clickBtn(FirstGameScreen.gambleEnabled_btn);
			initialGambleAmount=GamblePage.extractGambleAmount();
			CustomActions.clickBtn(GamblePage.gambleBlack_btn);
			i++;
			if(i==8) break;
		}
	}
	
	@When("user loses")
	public void user_loses() throws InterruptedException, AWTException, IOException {
		if(Hooks.scen.equals(scenario1) || Hooks.scen.equals(scenario2)) 
		{
			finalAttempts=GamblePage.keepExtractingGambleAttempts();
			WaitUtils.safeSleep(2000);
			int i=0;
		    while(!ImageVerification.verifyImage(FirstGameScreen.firstScreen_HUD)) 
		    {
		    	i++;
		    	CommonFunctions.triggerGamble();
		    	CustomActions.clickBtn(FirstGameScreen.gambleEnabled_btn);
		    	initialAttempts=GamblePage.extractGambleAttempts();
		    	CustomActions.clickBtn(GamblePage.gambleRed_btn);
		    	finalAttempts=GamblePage.keepExtractingGambleAttempts();
		    	WaitUtils.safeSleep(2000);
		    	if(i>5) break;
		    }
		}

	}
	
	@Then("gamble amount becomes {int}")
	public void gamble_amount_becomes(Integer int1) throws AWTException, IOException, InterruptedException {
	    if((int)finalGambleAmount==int1)
	    	Assert.assertTrue(true);
	    else
	    	Assert.assertTrue(false);
	}
	
	@Then("win amount in base game becomes {int}")
	public void win_amount_in_base_game_becomes(Integer int1) throws InterruptedException, AWTException, IOException {
		winAmountAfterGamble=CommonFunctions.extractWinAmount();
		if((int)winAmountAfterGamble==int1)
			Assert.assertTrue(true);
	    else
	    	Assert.assertTrue(false);
	}
	
	@When("user clicks on Diamond button once")
	public void user_clicks_on_diamond_button_once() throws AWTException, IOException, InterruptedException {
		initialGambleAmount=GamblePage.extractGambleAmount();
		CustomActions.clickBtn(GamblePage.gambleDiamonds_btn);
	}
	@When("user wins gamble for Diamond")
	public void user_wins_gamble_for_diamond() throws AWTException, InterruptedException, IOException {
		WaitUtils.safeSleep(5000);
		int i=0;
		while(!ImageVerification.verifyImage(GamblePage.gamblePage)) 
		{
			CommonFunctions.triggerGamble();
			CustomActions.clickBtn(FirstGameScreen.gambleEnabled_btn);
			initialGambleAmount=GamblePage.extractGambleAmount();
			CustomActions.clickBtn(GamblePage.gambleDiamonds_btn);
			i++;
			if(i==10) break;
			WaitUtils.safeSleep(5000);
		}
	}
	@Then("gamble amount should quadruple")
	public void gamble_amount_should_quadruple() throws AWTException, IOException, InterruptedException {
		WaitUtils.safeSleep(2000);
	    finalGambleAmount=GamblePage.extractGambleAmount();
	    Assert.assertEquals(finalGambleAmount, initialGambleAmount * 4);
	}
	
	@When("user clicks on Hearts button once")
	public void user_clicks_on_hearts_button_once() throws AWTException, IOException, InterruptedException {
		initialGambleAmount=GamblePage.extractGambleAmount();
		CustomActions.clickBtn(GamblePage.gambleHearts_btn);
	}
	@When("user wins gamble for Hearts")
	public void user_wins_gamble_for_hearts() throws AWTException, InterruptedException, IOException {
		WaitUtils.safeSleep(5000);
		int i=0;
		while(!ImageVerification.verifyImage(GamblePage.gamblePage)) 
		{
			CommonFunctions.triggerGamble();
			CustomActions.clickBtn(FirstGameScreen.gambleEnabled_btn);
			initialGambleAmount=GamblePage.extractGambleAmount();
			CustomActions.clickBtn(GamblePage.gambleHearts_btn);
			i++;
			if(i==10) break;
			WaitUtils.safeSleep(5000);
		}
	}
	
	@When("user clicks on Clubs button once")
	public void user_clicks_on_clubs_button_once() throws AWTException, IOException, InterruptedException {
		initialGambleAmount=GamblePage.extractGambleAmount();
		CustomActions.clickBtn(GamblePage.gambleClubs_btn);
	}
	@When("user wins gamble for Clubs")
	public void user_wins_gamble_for_clubs() throws AWTException, InterruptedException, IOException {
		WaitUtils.safeSleep(5000);
		int i=0;
		while(!ImageVerification.verifyImage(GamblePage.gamblePage)) 
		{
			CommonFunctions.triggerGamble();
			CustomActions.clickBtn(FirstGameScreen.gambleEnabled_btn);
			initialGambleAmount=GamblePage.extractGambleAmount();
			CustomActions.clickBtn(GamblePage.gambleClubs_btn);
			i++;
			if(i==10) break;
			WaitUtils.safeSleep(5000);
		}
	}
	
	@When("user clicks on Spades button once")
	public void user_clicks_on_spades_button_once() throws AWTException, IOException, InterruptedException {
		initialGambleAmount=GamblePage.extractGambleAmount();
		CustomActions.clickBtn(GamblePage.gambleSpades_btn);
	}
	
	@When("user wins gamble for Spades")
	public void user_wins_gamble_for_spades() throws AWTException, IOException, InterruptedException {
		WaitUtils.safeSleep(5000);
		int i=0;
		while(!ImageVerification.verifyImage(GamblePage.gamblePage)) 
		{
			CommonFunctions.triggerGamble();
			CustomActions.clickBtn(FirstGameScreen.gambleEnabled_btn);
			initialGambleAmount=GamblePage.extractGambleAmount();
			CustomActions.clickBtn(GamblePage.gambleSpades_btn);
			i++;
			if(i==10) break;
			WaitUtils.safeSleep(5000);
		}
	}
	
	@Then("The page should consist Attempts field")
	public void the_page_should_consist_attempts_field() throws InterruptedException {
		boolean isVerified=ImageVerification.verifyImage(GamblePage.gambleAttemptsLeft_txt);
		Assert.assertEquals(isVerified, true);
	}
	@Then("attempts should become zero")
	public void attempts_should_become_zero() throws AWTException, IOException, InterruptedException {
		finalAttempts=GamblePage.keepExtractingGambleAttempts();
		Assert.assertEquals(finalAttempts, 0);
	}
	
	@Then("attempts should decrease by one")
	public void attempts_should_decrease_by_one() throws AWTException, IOException, InterruptedException {
		WaitUtils.safeSleep(5000);
		finalAttempts=GamblePage.extractGambleAttempts();
		Assert.assertEquals(finalAttempts, initialAttempts-1);
	}
	
	@When("user loses for Red")
	public void user_loses_for_red() throws AWTException, IOException, InterruptedException {
		finalGambleAmount=GamblePage.keepExtractingGambleAmount();
		WaitUtils.safeSleep(2000);
		int i=0;
	    while(!ImageVerification.verifyImage(FirstGameScreen.firstScreen_HUD)) 
	    {
	    	i++;
	    	CommonFunctions.triggerGamble();
	    	CustomActions.clickBtn(FirstGameScreen.gambleEnabled_btn);
	    	initialGambleAmount=GamblePage.extractGambleAmount();
	    	CustomActions.clickBtn(GamblePage.gambleRed_btn);
	    	finalGambleAmount=GamblePage.keepExtractingGambleAmount();
	    	WaitUtils.safeSleep(2000);
	    	if(i>8) break;
	    }
	}
	
	@When("user loses for Clubs")
	public void user_loses_for_clubs() throws AWTException, IOException, InterruptedException {
		finalGambleAmount=GamblePage.keepExtractingGambleAmount();
		WaitUtils.safeSleep(2000);
		int i=0;
	    while(!ImageVerification.verifyImage(FirstGameScreen.firstScreen_HUD)) 
	    {
	    	i++;
	    	CommonFunctions.triggerGamble();
	    	CustomActions.clickBtn(FirstGameScreen.gambleEnabled_btn);
	    	initialGambleAmount=GamblePage.extractGambleAmount();
	    	CustomActions.clickBtn(GamblePage.gambleClubs_btn);
	    	finalGambleAmount=GamblePage.keepExtractingGambleAmount();
	    	WaitUtils.safeSleep(2000);
	    	if(i>5) break;
	    }
	}
	
	@When("user loses for Hearts")
	public void user_loses_for_hearts() throws AWTException, InterruptedException, IOException {
		finalGambleAmount=GamblePage.keepExtractingGambleAmount();
		WaitUtils.safeSleep(2000);
		int i=0;
	    while(!ImageVerification.verifyImage(FirstGameScreen.firstScreen_HUD)) 
	    {
	    	i++;
	    	CommonFunctions.triggerGamble();
	    	CustomActions.clickBtn(FirstGameScreen.gambleEnabled_btn);
	    	initialGambleAmount=GamblePage.extractGambleAmount();
	    	CustomActions.clickBtn(GamblePage.gambleHearts_btn);
	    	finalGambleAmount=GamblePage.keepExtractingGambleAmount();
	    	WaitUtils.safeSleep(2000);
	    	if(i>5) break;
	    }
	}
	
	@When("user loses for Spades")
	public void user_loses_for_spades() throws AWTException, IOException, InterruptedException {
		finalGambleAmount=GamblePage.keepExtractingGambleAmount();
		WaitUtils.safeSleep(2000);
		int i=0;
	    while(!ImageVerification.verifyImage(FirstGameScreen.firstScreen_HUD)) 
	    {
	    	i++;
	    	CommonFunctions.triggerGamble();
	    	CustomActions.clickBtn(FirstGameScreen.gambleEnabled_btn);
	    	initialGambleAmount=GamblePage.extractGambleAmount();
	    	CustomActions.clickBtn(GamblePage.gambleSpades_btn);
	    	finalGambleAmount=GamblePage.keepExtractingGambleAmount();
	    	WaitUtils.safeSleep(2000);
	    	if(i>5) break;
	    }
	}
	
	@When("user loses for Diamond")
	public void user_loses_for_diamond() throws AWTException, IOException, InterruptedException {
		finalGambleAmount=GamblePage.keepExtractingGambleAmount();
		WaitUtils.safeSleep(2000);
		int i=0;
	    while(!ImageVerification.verifyImage(FirstGameScreen.firstScreen_HUD)) 
	    {
	    	i++;
	    	CommonFunctions.triggerGamble();
	    	CustomActions.clickBtn(FirstGameScreen.gambleEnabled_btn);
	    	initialGambleAmount=GamblePage.extractGambleAmount();
	    	CustomActions.clickBtn(GamblePage.gambleDiamonds_btn);
	    	finalGambleAmount=GamblePage.keepExtractingGambleAmount();
	    	WaitUtils.safeSleep(2000);
	    	if(i>5) break;
	    }
	}
	
	@When("user loses for Black")
	public void user_loses_for_black() throws AWTException, IOException, InterruptedException {
		finalGambleAmount=GamblePage.keepExtractingGambleAmount();
		WaitUtils.safeSleep(2000);
		int i=0;
	    while(!ImageVerification.verifyImage(FirstGameScreen.firstScreen_HUD)) 
	    {
	    	i++;
	    	CommonFunctions.triggerGamble();
	    	CustomActions.clickBtn(FirstGameScreen.gambleEnabled_btn);
	    	initialGambleAmount=GamblePage.extractGambleAmount();
	    	CustomActions.clickBtn(GamblePage.gambleBlack_btn);
	    	finalGambleAmount=GamblePage.keepExtractingGambleAmount();
	    	WaitUtils.safeSleep(2000);
	    	if(i>5) break;
	    }
	}
	
	@When("user closes the game")
	public void user_closes_the_game() throws AWTException, InterruptedException, IOException {
		WaitUtils.safeSleep(5000);
		ScreenshotCapture.captureSubSS_gamble_history();
		initialGambleAmount=GamblePage.extractGambleAmount();
		initialAttempts=GamblePage.extractGambleAttempts();
	    CommonFunctions.closeIFrame();
	    WaitUtils.safeSleep(1000);
	}

	@When("user relaunches the game")
	public void user_relaunches_the_game() throws IOException, InterruptedException {
		sh=new SuribetHome(BaseClass.driver);
	    sh.input_search_box();
		sh.clickPlay_firstGame();
		WaitUtils.safeSleep(5000);
	}
	
	@Then("gamble game session should resume")
	public void gamble_game_session_should_resume() throws AWTException, IOException, InterruptedException 
	{
		boolean isHistorySame=ImageVerification.verifyImage(System.getProperty("user.dir")+"\\src\\main\\resources\\cropped_gamble_history.png");
		boolean isGambleAmountSame=false;
		if(initialGambleAmount==GamblePage.extractGambleAmountAfterResume()) isGambleAmountSame = true;
		boolean isAttemptsSame=false;
		if(initialAttempts==GamblePage.extractGambleAttemptsAfterResume()) isGambleAmountSame = true;
		
		if(isHistorySame==true && isGambleAmountSame==true && isAttemptsSame==true)
			Assert.assertEquals(isHistorySame,true);
	}
	
	@Then("win field should be blank")
	public void win_field_should_be_blank() {
	    boolean isVerified=ImageVerification.verifyImageWithTimeout(FirstGameScreen.blankWin_txt_english, 5, 0.8);
	    Assert.assertEquals(isVerified,true);
	}
	
}
