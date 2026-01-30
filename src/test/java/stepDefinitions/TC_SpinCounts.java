package stepDefinitions;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.FirstGameScreen;

public class TC_SpinCounts 
{
	@Then("Reels should spin from ninety nine to one")
	public void reels_should_spin_from_ninety_nine_to_one() throws AWTException, IOException, InterruptedException 
	{
		boolean isVerified=FirstGameScreen.keepExtractingAndCheckSpinCount(100);
		Assert.assertEquals(isVerified, true);
	}

	@Then("Reels should spin from nineteen to one")
	public void reels_should_spin_from_nineteen_to_one() throws AWTException, IOException, InterruptedException {
		boolean isVerified=FirstGameScreen.keepExtractingAndCheckSpinCount(20);
		Assert.assertEquals(isVerified, true);
	}

	@Then("Reels should spin from nine to one")
	public void reels_should_spin_from_nine_to_one() throws AWTException, IOException, InterruptedException {
		boolean isVerified=FirstGameScreen.keepExtractingAndCheckSpinCount(10);
		Assert.assertEquals(isVerified, true);
	}
}
