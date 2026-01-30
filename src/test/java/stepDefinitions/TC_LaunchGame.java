package stepDefinitions;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;

import Utilities.ImageVerification;
import commonTestMethods.CommonFunctions;
import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.FirstGameScreen;
import pageObjects.SuribetHome;
import pageObjects.TransferAmountPopUp;

public class TC_LaunchGame 
{
	SuribetHome sh=new SuribetHome(BaseClass.driver);
	TransferAmountPopUp tapu=new TransferAmountPopUp(BaseClass.driver);
	FirstGameScreen fgs;
	@Given("User is logged in to demo web site")
	public void user_is_logged_in_to_demo_web_site() throws IOException, InterruptedException, AWTException {
	    sh.input_search_box();
		sh.clickPlay_firstGame();
	}

	@When("User searches and launches the game")
	public void user_searches_and_launches_the_game() throws IOException, InterruptedException, AWTException {
		if(CommonFunctions.handleFeatureResumes()==false) 
		{
			tapu=new TransferAmountPopUp(BaseClass.driver);
			tapu.setAmount_inputBox();
			tapu.clickTransfer_okBtn();
		}
			CommonFunctions.changeLangToEnglish();
	}

	@Then("User should be able to see the Base game HUD")
	public void user_should_be_able_to_see_the_base_game_hud() throws InterruptedException, AWTException {
		//image verification using OpenCV
		boolean isVerified=ImageVerification.verifyImage(FirstGameScreen.firstScreen_HUD);
		Assert.assertEquals(isVerified, true);
	}
}
