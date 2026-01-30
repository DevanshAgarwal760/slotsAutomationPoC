package pageObjects;

import org.openqa.selenium.WebDriver;

public class AutospinOptions extends BasePage
{
	//constructor
	public AutospinOptions(WebDriver driver) 
	{
		super(driver);
	}
	
	//locators
	public static String autospin_btn=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\autospinOptions_btn.png";
	public static String autospin_popUp=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\GameHUD_AutoplayOptions.png";
	public static String autospin_popUp_english=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\GameHUD_AutoplayOptions_English.png";
	public static String autospin_popUp_french=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\GameHUD_AutoplayOptions_French.png";
	public static String autospin_popUp_bulgarian=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\GameHUD_AutoplayOptions_Bulgarian.png";
	public static String autospin_popUp_spanish=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\GameHUD_AutoplayOptions_Spanish.png";
	public static String autospin_popUp_portuguese=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\GameHUD_AutoplayOptions_Portuguese.png";
	
}
