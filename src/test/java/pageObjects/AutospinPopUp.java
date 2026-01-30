package pageObjects;

import org.openqa.selenium.WebDriver;

public class AutospinPopUp extends BasePage
{
	public AutospinPopUp(WebDriver driver) 
	{
		super(driver);
	}
	
	//locators
	public static String autospinInfinite_btn= System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\autospinInfinite_btn.png";
	public static String autospin10_btn= System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\autospin10_btn.png";
	public static String autospin20_btn= System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\autospin20_btn.png";
	public static String autospin100_btn= System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\autospin100_btn.png";
}
