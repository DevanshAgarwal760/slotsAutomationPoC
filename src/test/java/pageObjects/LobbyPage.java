package pageObjects;

import org.openqa.selenium.WebDriver;

public class LobbyPage extends BasePage
{
	public LobbyPage(WebDriver driver) 
	{
		super(driver);
	}
	
	//locators
	public static String lobbyPage_screen=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\lobbyPage.png";
}
