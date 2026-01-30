package stepDefinitions;

import java.awt.AWTException;
import java.io.IOException;

import Utilities.CustomActions;
import commonTestMethods.CommonFunctions;
import io.cucumber.java.en.When;

public class TC_ShortcutKeys 
{
	@When("win is triggered")
	public void win_is_triggered() throws AWTException, InterruptedException, IOException {
	    CommonFunctions.triggerWinWithKeyboard();
	}
	
	@When("user presses down arrow Key for take")
	public void user_presses_down_arrow_key_for_take() throws AWTException {
	    CustomActions.press_DownArrowKey();
	}
	
	@When("user presses i Key")
	public void user_presses_i_key() throws AWTException {
		CustomActions.press_IKey();
	}
	
	@When("user presses s Key")
	public void user_presses_s_key() throws AWTException {
		CustomActions.press_SKey();
	}
	
	@When("user presses up arrow key for gamble")
	public void user_presses_up_arrow_key_for_gamble() throws AWTException {
		CustomActions.press_UpArrowKey();
	}
	
	@When("user presses Space Key")
	public void user_presses_space_key() throws AWTException {
		CustomActions.press_SpaceKey();
	}
	
	@When("user presses h key")
	public void user_presses_h_key() throws AWTException {
	    CustomActions.press_HKey();
	}

}
