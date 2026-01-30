package pageObjects;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commonTestMethods.CommonFunctions;
import factory.BaseClass;

public class HistoryPage extends BasePage
{
	static FirstGameScreen fgs;
	public HistoryPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath="//title")
	public WebElement historyPage_title;
	
	
	public static String historyPage_English=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\historyPage_English.png";
	public static String historyPage_French=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\historyPage_French.png";
	public static String historyPage_Spanish=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\historyPage_Spanish.png";
	public static String historyPage_Portuguese=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\historyPage_Portuguese.png";
	public static String historyPage_Bulgarian=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\historyPage_Bulgarian.png";
	
	
	public String getHistoryPagetitle() 
	{
		return historyPage_title.getText();
	}
	
	
	public static void switchToHistoryPage() 
	{
		//BaseClass.driver.switchTo().defaultContent();
		//BaseClass.driver.switchTo().defaultContent();
		Set<String> windowHandles=BaseClass.driver.getWindowHandles();
		for(String s:windowHandles) 
		{
			if(!s.equals(CommonFunctions.gameWindowID)) 
			{
				BaseClass.driver.switchTo().window(s);
			}
		}
	}
	
	public static boolean isHistoryPage() 
	{
		switchToHistoryPage();
		if(BaseClass.driver.getTitle().equalsIgnoreCase("history")) return true;
		else return false;
	}
	
	public static void closeHistoryPage() throws IOException 
	{
		BaseClass.driver.close();
		BaseClass.driver.switchTo().window(CommonFunctions.gameWindowID);
		fgs=new FirstGameScreen(BaseClass.driver);
		fgs.switchIFrames();
	}
}
