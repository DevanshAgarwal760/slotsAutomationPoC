package pageObjects;

import org.openqa.selenium.WebDriver;

public class GameInfoInside extends BasePage 
{
	public GameInfoInside(WebDriver driver) 
	{
		super(driver);
	}
	
	//locators
	public static String infoPage_popUp=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\infoPage_popUp.png"; 
	public static String infoPage_popUp_english=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\infoPage_popUp_English.png";
	public static String infoPage_popUp_french=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\infoPage_popUp_french.png";
	public static String infoPage_popUp_spanish=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\infoPage_popUp_Spanish.png";
	public static String infoPage_popUp_portuguese=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\infoPage_popUp_Portuguese.png";
	public static String infoPage_popUp_bulgarian=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\infoPage_popUp_Bulgarian.png";
	public static String infoPage_popUp_chrome=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\infoPage_popUp.png"; 

}
