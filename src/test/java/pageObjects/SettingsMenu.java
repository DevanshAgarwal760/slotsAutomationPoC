package pageObjects;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.CustomActions;
import Utilities.WaitUtils;
import factory.BaseClass;

public class SettingsMenu extends BasePage 
{
	public SettingsMenu(WebDriver driver) 
	{
		super(driver);
	}
	
	FirstGameScreen fgs=new FirstGameScreen(BaseClass.driver);
	
	//locators
	@FindBy(xpath="//div[@class='selected-option']")
	public WebElement language;
	
	@FindBy(xpath="//li[@data-value='English']")
	public WebElement engLang; 
	
	
	
	@FindBy(xpath="(//label[@class='toggle'])[1]")
	public WebElement quickSpinOff_toggle;
	
	@FindBy(xpath="(//label[@class='toggle ON'])[1]")
	public WebElement quickSpinOn_toggle;
	
	@FindBy(xpath="//label[@class='toggle ON']")
	public WebElement soundOn_toggle;
	
	@FindBy(xpath="(//label[@class='toggle'])[2]")
	public WebElement soundOff_toggle;
	
	
	@FindBy(xpath="//div[@class='custom-dropdown']/child::div[1]")
	public WebElement languageDrpdwn_btn;
	
	@FindBy(xpath="//ul[@class='dropdown-list']//li")
	public List<WebElement> languageDrpdwn_list;
	
	//(//span[@class='Setting_Title_8 language-title headingMenu'])[2]
	//div[@class='opt1 helpIcon button']
	@FindBy(xpath="//div[@class='opt1 helpIcon button']//span[@class='Setting_Title_8 language-title headingMenu']")
	public WebElement help_btn;
	
	@FindBy(xpath="//span[@class='Setting_Title_7 history-title headingMenu button']")
	public WebElement history_btn;
	
	
	
	public static String settings_popUP=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\settings_popUp.png";
	public static String settings_popUP_english=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\settings_popUp_english.png";
	public static String helpPage=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\HelpPage.png";
	public static String helpPage_French=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\HelpPage_french.png";
	public static String helpPage_Bulagrian=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\HelpPage_Bulgarian.png";
	public static String helpPage_Spanish=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\HelpPage_Spanish.png";
	public static String helpPage_Portuguese=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\HelpPage_Portuguese.png";
	public static String helpbtn=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\SettingsMenu_HelpBtn.png";
	public static String helpPageClose_btn=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\HelpPage_closeBtn.png";
	public static String settingsMenu_English=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\settings_menu_english.png";
	public static String settingsMenu_French=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\settings_popUp_french.png";
	public static String settingsMenu_Portuguese=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\settings_popUp_Portuguese.png";
	public static String settingsMenu_Spanish=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\settings_popUp_Spanish.png";
	public static String settingsMenu_Bulgarian=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\settings_popUp_Bulgarian.png";
	
	@FindBy(xpath="//li[@data-value='French']")
	public WebElement frenchLang;
	
	@FindBy(xpath="//li[@data-value='Spanish']")
	public WebElement spanishLang;
	
	@FindBy(xpath="//li[@data-value='Bulgarian']")
	public WebElement bulgLang;
	
	@FindBy(xpath="//li[@data-value='Portuguese']")
	public WebElement portugLang;
	
	//action methods
	public void clickLangDropdown() 
	{
		BaseClass.driver.switchTo().frame(fgs.firstIframe);
		BaseClass.driver.switchTo().frame(fgs.secondIframe1);
		language.click();
		BaseClass.driver.switchTo().defaultContent();
		BaseClass.driver.switchTo().defaultContent();
	}
	
	public void clickEngLang() 
	{
		BaseClass.driver.switchTo().frame(fgs.firstIframe);
		BaseClass.driver.switchTo().frame(fgs.secondIframe1);
		engLang.click();
		BaseClass.driver.switchTo().defaultContent();
		BaseClass.driver.switchTo().defaultContent();
	}
	
	public void clickFrenchLang() 
	{
		BaseClass.driver.switchTo().frame(fgs.firstIframe);
		BaseClass.driver.switchTo().frame(fgs.secondIframe1);
		frenchLang.click();
		BaseClass.driver.switchTo().defaultContent();
		BaseClass.driver.switchTo().defaultContent();
	}
	
	public void clickSpanishLang() 
	{
		BaseClass.driver.switchTo().frame(fgs.firstIframe);
		BaseClass.driver.switchTo().frame(fgs.secondIframe1);
		spanishLang.click();
		BaseClass.driver.switchTo().defaultContent();
		BaseClass.driver.switchTo().defaultContent();
	}
	
	public void clickBulgLang() 
	{
		BaseClass.driver.switchTo().frame(fgs.firstIframe);
		BaseClass.driver.switchTo().frame(fgs.secondIframe1);
		bulgLang.click();
		BaseClass.driver.switchTo().defaultContent();
		BaseClass.driver.switchTo().defaultContent();
	}
	
	public void clickPortugLang() 
	{
		BaseClass.driver.switchTo().frame(fgs.firstIframe);
		BaseClass.driver.switchTo().frame(fgs.secondIframe1);
		portugLang.click();
		BaseClass.driver.switchTo().defaultContent();
		BaseClass.driver.switchTo().defaultContent();
	}
	
	public void enable_quickSpin() 
	{
		BaseClass.driver.switchTo().frame(fgs.firstIframe);
		BaseClass.driver.switchTo().frame(fgs.secondIframe1);
		quickSpinOff_toggle.click();
		BaseClass.driver.switchTo().defaultContent();
		BaseClass.driver.switchTo().defaultContent();
	}
	public void disable_quickSpin() 
	{
		BaseClass.driver.switchTo().frame(fgs.firstIframe);
		BaseClass.driver.switchTo().frame(fgs.secondIframe1);
		quickSpinOn_toggle.click();
		BaseClass.driver.switchTo().defaultContent();
		BaseClass.driver.switchTo().defaultContent();
	}
	public void enable_Sound() 
	{
		BaseClass.driver.switchTo().frame(fgs.firstIframe);
		BaseClass.driver.switchTo().frame(fgs.secondIframe1);
		soundOff_toggle.click();
		BaseClass.driver.switchTo().defaultContent();
		BaseClass.driver.switchTo().defaultContent();
	}
	public void disable_Sound() 
	{
		BaseClass.driver.switchTo().frame(fgs.firstIframe);
		BaseClass.driver.switchTo().frame(fgs.secondIframe1);
		soundOn_toggle.click();
		BaseClass.driver.switchTo().defaultContent();
		BaseClass.driver.switchTo().defaultContent();
	}
	public void click_languageDrpdwn_btn() 
	{
		BaseClass.driver.switchTo().frame(fgs.firstIframe);
		BaseClass.driver.switchTo().frame(fgs.secondIframe1);
		languageDrpdwn_btn.click();
		BaseClass.driver.switchTo().defaultContent();
		BaseClass.driver.switchTo().defaultContent();
	}
	/*public void click_help_btn() 
	{
		BaseClass.driver.switchTo().frame(fgs.firstIframe);
		BaseClass.driver.switchTo().frame(fgs.secondIframe1);
		JavascriptExecutor js=(JavascriptExecutor)BaseClass.driver;
		js.executeScript("arguments[0].click();",help_btn);
		BaseClass.driver.switchTo().defaultContent();
		BaseClass.driver.switchTo().defaultContent();
	}*/
	
	public static void click_help_btn() throws AWTException, InterruptedException 
	{
		CustomActions.clickBtn(FirstGameScreen.settings_btn);
		WaitUtils.safeSleep(1000);
		CustomActions.clickBtn(helpbtn);
	}
	
	public void click_history_btn() 
	{
		BaseClass.driver.switchTo().frame(fgs.firstIframe);
		BaseClass.driver.switchTo().frame(fgs.secondIframe1);
		history_btn.click();
		BaseClass.driver.switchTo().defaultContent();
		BaseClass.driver.switchTo().defaultContent();
	}
	
	public boolean areLanguagesPresent() 
	{
		BaseClass.driver.switchTo().frame(fgs.firstIframe);
		BaseClass.driver.switchTo().frame(fgs.secondIframe1);
		int i=0;
		String s[]= {"Bulgarian","English","French","Portuguese","Spanish"};
		for(WebElement l:languageDrpdwn_list) 
		{
			for(String lang:s) 
			{
				if(lang.equals(l.getText())) 
				{ 
					i++;
					break;
				}
					
			}
		}
		BaseClass.driver.switchTo().defaultContent();
		BaseClass.driver.switchTo().defaultContent();
		if(i==5) return true;
		else return false;
	}
	
}
