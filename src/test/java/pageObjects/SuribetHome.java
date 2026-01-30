package pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.WaitUtils;
import factory.BaseClass;

public class SuribetHome extends BasePage
{

	public SuribetHome(WebDriver driver) 
	{
		super(driver);
	}
	
	//Locators
	
	//If user is logged in, log-off button will appear
	@FindBy(xpath="(//span[@ng-click='frm.Logout()'])[2]/a")
	WebElement logOff_btn;
	
	@FindBy(xpath="//input[@ng-model='globalslotsgameCtlr.filterQuery']")
	WebElement search_box;
	
	@FindBy(xpath="//div/span[contains(text(),'PL')]")
	WebElement firstGame_play_btn;
	
	@FindBy(xpath="//input[@placeholder='Email / Mobile / CardNo']") 
	WebElement accountID_box;
	
	@FindBy(xpath="//input[@placeholder='Password / Card Pin']")
	WebElement accountPwd_box;
	
	@FindBy(xpath="//input[@class='loginActive']")
	WebElement login_btn;
	
	public void set_accountID_box(String accID) 
	{
		accountID_box.sendKeys(accID);
	}
	public void set_accountPwd_box(String accPwd) 
	{
		accountPwd_box.sendKeys(accPwd);
	}
	public void click_login_btn() 
	{
		login_btn.click();
	}
	
	public String getText_logOff_btn() 
	{
		String logOff=logOff_btn.getText();
		return logOff;
	}
	public void input_search_box() throws IOException 
	{
		search_box.clear();
		search_box.sendKeys(BaseClass.getProperties().getProperty("gameName"));
	}
	
	public void clickPlay_firstGame() throws InterruptedException 
	{
		firstGame_play_btn.click();
		WaitUtils.safeSleep(7000);
	}
	
}
	

