package pageObjects;

import java.awt.AWTException;
import java.io.IOException;
import java.util.HashSet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.CustomActions;
import Utilities.ImageVerification;
import Utilities.OCR;
import Utilities.WaitUtils;
import commonTestMethods.CommonFunctions;
import factory.BaseClass;

public class FirstGameScreen extends BasePage
{

	//Constructor
	public FirstGameScreen(WebDriver driver) 
	{
		super(driver);
	}
	
	//Locators 
	
	//to locate canvas
	//first iFrame
	@FindBy(css="#iframeSlotGame")
	public WebElement firstIframe;
	
	//second iFrame
	@FindBy(tagName="iframe")
	public WebElement secondIframe1;
	
	//locate canvas
	@FindBy(tagName="canvas")
	WebElement canvas;
	
	
	//iFrame locators using OpenCV and Tesseract
	public static String firstScreen_HUD=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\firstScreen_HUD.png";
	public static String balance_txt=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\GameHUD_BalanceText.png";
	public static String balance_txt_english=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\GameHUD_BalanceText_English.png";
	public static String betOptions_btn=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\GameHUD_BetOptionsBtn.png";
	public static String betOptions_btn_english=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\GameHUD_BetOptionsBtn_English.png";
	public static String fullscreen_btn=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\GameHUD_FullscreenBtn.png";
	public static String betOptions_popUp=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\GameHUD_betOptions_popUP.png";
	public static String betOptions_popUp_english=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\GameHUD_BetOptionsBtn_English.png";
	public static String betOptions_popUp_french=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\GameHUD_betOptions_popUP_French.png";
	public static String betOptions_popUp_portuguese=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\GameHUD_betOptions_popUP_Portuguese.png";
	public static String betOptions_popUp_spanish=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\GameHUD_betOptions_popUP_Spanish.png";
	public static String betOptions_popUp_bulgarian=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\GameHUD_betOptions_popUP_Bulgarian.png";
	public static String autospinOptions_btn=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\autospinOptions_btn.png";
	public static String spin_btn=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\spin_btn.png";
	public static String winAmount_txt=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\GameHUD_WinText.png";
	public static String winAmount_txt_english=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\GameHUD_WinText_English.png";
	public static String selectedQuickBet_btn=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\selectedQuickBet_btn.png";
	public static String quickBetBtn_stopTxt=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\QuickBet_StopTxt.png";
	public static String quickBetBtn_currencyName=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\QuickBet_CurrencyName.png";
	public static String selectedQuickBet_btn_english=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\selectedQuickBet_btn_English.png";
	public static String blankWin_txt=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\blankWin_txt.png";
	public static String blankWin_txt_english=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\blankWin_txt_English.png";
	public static String takeWin_btn=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\takeWin_btn.png";
	public static String lazyLoading_icon=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\lazyLoading_icon.png";
	public static String gameInfoInside_btn=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\GameHUD_GameInfoBtn.png";
	public static String settings_btn=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\GameHUD_SettingsBtn.png";
	public static String soundOn_btn=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\soundOn_btn.png";
	public static String soundOff_btn=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\soundOff_btn.png";
	public static String turboOff_btn=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\turboOff_btn.png";
	public static String turboOn_btn=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\turboOn_btn.png";
	public static String home_btn=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\GameHUD_HomeBtn.png";
	public static String gambleEnabled_btn=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\gambleEnabled_btn.png";
	public static String infiniteSpin_btn=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\InfiniteSpinButton.png";
	public static String spin9_btn=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\9Spin_btn.png";
	public static String spin19_btn=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\19Spin_btn.png";
	public static String spin99_btn=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\99Spin_btn.png";
	public static String stop_btn=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\stop_btn.png";
	public static String leftArrow_btn=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\leftArrow_btn.png";
	public static String rightArrow_btn=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\rightArrow_btn.png";
	public static String someBannerTriggered=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\someBannerTriggered.png";
	public static String someBannerTriggered_2=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\someBannerTriggered_2.png";
	public static String noBanner=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\noBanner.png";
	public static String jackpotBanner=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\jackpotBanner.png";
	public static String baseGame_English=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\BaseGame_English.png";
	public static String baseGame_French=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\BaseGame_French.png";
	public static String baseGame_Portuguese=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\BaseGame_Portuguese.png";
	public static String baseGame_Spanish=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\BaseGame_Spanish.png";
	public static String baseGame_Bulgarian=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\BaseGame_Bulgarian.png";
	public static String sapphireJackpotIndex=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\sapphireJackpotIndex.png";
	
	public static String lastWinner_JPindex=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\lastWinner_JPindex.png";
	public static String numberOfWinners_JPindex=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\numberOfWinners_JPindex.png";
	public static String biggestWinner_JPindex=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\biggestWinner_JPindex.png";
	
	public static String lastWinner_JPindex_French=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\lastWinner_JPindexFrench.png";
	public static String numberOfWinners_JPindex_French=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\numberOfWinners_JPindexFrench.png";
	public static String biggestWinner_JPindex_French=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\biggestWinner_JPindexFrench.png";
	
	public static String lastWinner_JPindex_Spanish=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\lastWinner_JPindexSpanish.png";
	public static String numberOfWinners_JPindex_Spanish=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\numberOfWinners_JPindexSpanish.png";
	public static String biggestWinner_JPindex_Spanish=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\biggestWinner_JPindexSpanish.png";
	
	public static String lastWinner_JPindex_Bulgarian=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\lastWinner_JPindexBulgarian.png";
	public static String numberOfWinners_JPindex_Bulgarian=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\numberOfWinners_JPindexBulgarian.png";
	public static String biggestWinner_JPindex_Bulgarian=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\biggestWinner_JPindexBulgarian.png";
	
	public static String lastWinner_JPindex_Portuguese=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\lastWinner_JPindexPortuguese.png";
	public static String numberOfWinners_Portuguese=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\numberOfWinners_JPindexPortuguese.png";
	public static String biggestWinner_Portuguese=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\biggestWinner_JPindexPortuguese.png";
	
	
	
	
	//FullScreen locators using OpenCV and Tesseract
	public static String fullscreenHUD_firstScreen=System.getProperty("user.dir")+"\\ExpectedImages\\FullScreen\\GameHUD_FirstScreen.png";
	public static String windowMode_btn=System.getProperty("user.dir")+"\\ExpectedImages\\FullScreen\\windowMode_btn.png";
	
	
	//Play Now (Maximized) locators using OpenCV and Tesseract
	
	public static void openSettingsMenu() throws AWTException, InterruptedException, IOException 
	{
		WaitUtils.safeSleep(1000);
		CustomActions.clickBtn(FirstGameScreen.settings_btn);
	}
	
	public void switchIFrames() throws IOException 
	{
		BaseClass.driver.switchTo().frame(firstIframe);
		BaseClass.driver.switchTo().frame(secondIframe1);
	}
	
	//SRD text under balance heading text
	public String getText_SRD() throws InterruptedException, AWTException, IOException
	{
		WaitUtils.safeSleep(15000);
		return OCR.extractTxtManually(516, 913, 35, 17);
	}
	
	public static void clickSpin_btn() throws AWTException, InterruptedException 
	{
		CustomActions.clickBtn(spin_btn);
	}
	
	public static boolean keepExtractingAndCheckSpinCount(int spinCount) throws AWTException, IOException, InterruptedException 
	{
		//int timeoutSeconds=10;
		String extracted="";
		//long startTime = System.currentTimeMillis();
		int currentSpinCount=1;
		//boolean bannerFlag=ImageVerification.verifyImageInstantly(FirstGameScreen.someBannerTriggered);
		//boolean jackpotFlag=ImageVerification.verifyImageInstantly(JackpotScreen.jackpotScreen);
		//boolean freeSpinsFlag=ImageVerification.verifyImageInstantly(FreeSpinsScreen.freeSpins_txt);
		HashSet<Integer> hs=new HashSet<Integer>();
		while (currentSpinCount>=0 && currentSpinCount<spinCount) 
		{
			try {
			//Thread.sleep(100);
			extracted=OCR.extractTxtManually(1531, 492, 49, 39);
		    currentSpinCount=Integer.parseInt(CommonFunctions.extractValue(extracted));
		    System.out.println("currentSpinCount: "+currentSpinCount);
		    hs.add(currentSpinCount);
		    //if(ImageVerification.verifyImageInLessThanSecond(FirstGameScreen.someBannerTriggered, 0.02, 1.0) && 
		    //ImageVerification.verifyImageInLessThanSecond(FirstGameScreen.someBannerTriggered_2, 0.02, 1.0)) 
		    CommonFunctions.clickAtCentre();
				if(ImageVerification.verifyImageInstantly(JackpotScreen.jackpotScreen)) 
			    {
			    	CommonFunctions.handleJackpot_custom();
			    	while(!ImageVerification.verifyImageInLessThanSecond(FirstGameScreen.noBanner, 0.02, 0.9)) 
			    	{
			    		WaitUtils.safeSleep(1);
			    	}
			    		
			    }
	
		    //if(ImageVerification.verifyImageInLessThanSecond(FreeSpinsScreen.freeSpins_txt, 0.02, 0.8));
		    if(currentSpinCount==0) break;
			}
			catch(NumberFormatException e) 
			{
				continue;
			}
		}
		if(hs.size()==spinCount) 
		{
			System.out.println("Passed. These are the counts extracted: "+hs);
			System.out.println("Size of the HashSet: "+hs.size());
			return true;
		}	
		System.out.println("Failed. These are the counts extracted: "+hs);
		System.out.println("Size of the HashSet: "+hs.size());
		return false;	
	}
	
		
}
