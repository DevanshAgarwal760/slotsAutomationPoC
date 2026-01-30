package pageObjects;

import org.openqa.selenium.WebDriver;

public class JackpotScreen extends BasePage
{
	public JackpotScreen(WebDriver driver) 
	{
		super(driver);
	}
	
	//locators
	public static String jackpotScreen=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\jackpotScreen.png";
	public static String jackpotStar_btn=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\jackpotStar_btn.png";
	
}
