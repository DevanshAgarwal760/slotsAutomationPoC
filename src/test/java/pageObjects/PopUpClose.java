package pageObjects;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;

import Utilities.CustomActions;
import commonTestMethods.CommonFunctions;

public class PopUpClose extends BasePage
{
	public PopUpClose(WebDriver driver) 
	{
		super(driver);
	}
	
	//locator
	static public String closePopUp_btn=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\closePopUp_btn.png";
	
	
	//action method
	public static void clickOnClosePopUp_btn() throws AWTException, InterruptedException 
    {
    	CustomActions.clickBtn(closePopUp_btn);
    	CommonFunctions.moveMouseAway();
    }
}
