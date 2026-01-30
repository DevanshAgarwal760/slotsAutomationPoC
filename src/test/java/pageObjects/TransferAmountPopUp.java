package pageObjects;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.WaitUtils;
import factory.BaseClass;

public class TransferAmountPopUp extends BasePage 
{
	public TransferAmountPopUp(WebDriver driver) 
	{
		super(driver);
	}
	
	//locators
	@FindBy(xpath="(//input[@id='transferInput'])[1]")
	WebElement amount_inputBox;
	
	@FindBy(xpath="//div[@class='Transfer_Ok_but']")
	WebElement transfer_okBtn;
	
	//action methods
	public void setAmount_inputBox() throws IOException, InterruptedException 
	{
		amount_inputBox.clear();
		WaitUtils.safeSleep(1000);
		amount_inputBox.sendKeys(BaseClass.getProperties().getProperty("gameAmount"));
	}
	public void clickTransfer_okBtn() throws InterruptedException, IOException 
	{
		transfer_okBtn.click();
		WaitUtils.safeSleep(1000);
		BaseClass.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		if(transfer_okBtn.isDisplayed()) 
		{
			transfer_okBtn.click();
		}
		WaitUtils.safeSleep(6000);
		BaseClass.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
}
