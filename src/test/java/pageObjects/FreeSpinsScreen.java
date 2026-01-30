package pageObjects;

import org.openqa.selenium.WebDriver;

public class FreeSpinsScreen extends BasePage
{
	 public FreeSpinsScreen(WebDriver driver) 
	 {
		 super(driver);
	 }
	 
	 //locators
	 public static String freeSpins_txt=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\freeSpin_txt.png";
	 public static String freeSpins_txt_Bulgarian=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\freeSpin_txt_Bulgarian.png";
}
