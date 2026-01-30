package commonTestMethods;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Utilities.CustomActions;
import Utilities.ImageVerification;
import Utilities.OCR;
import Utilities.WaitUtils;
import factory.BaseClass;
import pageObjects.FirstGameScreen;
import pageObjects.FreeSpinsScreen;
import pageObjects.GamblePage;
import pageObjects.JackpotScreen;
import pageObjects.SettingsMenu;
import pageObjects.SuribetHome;
import pageObjects.TransferAmountPopUp;

public class CommonFunctions 
{
	static double balance=0.0; 
	static double balanceAfterSpin=0.0; 
	static double win=0.0; 
	static double bet=0.0; 
	public static Robot robot;
	SuribetHome sh;
	TransferAmountPopUp tapu=new TransferAmountPopUp(BaseClass.driver);
	FirstGameScreen fgs;
	
	//for printing in colors
	public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    static boolean triggered=false;
    public static String gameWindowID;
	
    
    public void launchGame() throws IOException, InterruptedException, AWTException 
    {
    	if(!ImageVerification.verifyImage(FirstGameScreen.firstScreen_HUD)) 
		{
			sh=new SuribetHome(BaseClass.driver);
		    sh.input_search_box();
			sh.clickPlay_firstGame();
			
			if(CommonFunctions.handleFeatureResumes()==false) 
			{
				tapu.setAmount_inputBox();
				tapu.clickTransfer_okBtn();
			}
		}
			CommonFunctions.changeLangToEnglish();
			gameWindowID=BaseClass.driver.getWindowHandle();
    }
    
	public static double extractBalanceAmount() throws InterruptedException, AWTException, IOException 
	{
		handleFeatureGames();
		try {
            OCR.extractTxtAtRunTime(FirstGameScreen.balance_txt_english);
            WaitUtils.safeSleep(1000);
            OCR.extractTxtManually(ImageVerification.x-63, ImageVerification.y+22, 193, 33);
            System.out.println(OCR.extractedTxt);
            balance = Double.parseDouble(OCR.extractedTxt.replace(",", ""));
            System.out.println("Initial Balance: " + balance);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
		return balance;
	}
	
	public static double extractBalanceAmountAfterSpin() throws InterruptedException, AWTException, IOException 
	{
		handleFeatureGames();
		try {
			if(ImageVerification.verifyImage(FirstGameScreen.takeWin_btn)) 
			{
				CustomActions.clickBtn(FirstGameScreen.takeWin_btn);
			}
            OCR.extractTxtAtRunTime(FirstGameScreen.balance_txt_english);
            WaitUtils.safeSleep(200);
            OCR.extractTxtManually(ImageVerification.x-63, ImageVerification.y+22, 193, 33);
            System.out.println(OCR.extractedTxt);
            balanceAfterSpin = Double.parseDouble(OCR.extractedTxt.replace(",", ""));
            System.out.println("Balance after spin: " + balanceAfterSpin);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
		return balanceAfterSpin;
	}
	
	public static double extractWinAmount() throws InterruptedException, AWTException, IOException 
	{
		handleFeatureGames();
		if(ImageVerification.verifyImage(FirstGameScreen.blankWin_txt_english)) 
		{
			System.out.println("The win amount is 0.0");
			return 0.00;
		}
		else
		{
		try {
		
            OCR.extractTxtAtRunTime(FirstGameScreen.winAmount_txt_english);
            WaitUtils.safeSleep(1000);
            OCR.extractTxtManually(ImageVerification.x-63, ImageVerification.y+20, 193, 33);
            System.out.println(OCR.extractedTxt);
            win = Double.parseDouble(OCR.extractedTxt.replace(",", ""));
            System.out.println("Win amount: " + win);
        } catch (Exception e) {
            System.out.println("OCR extracted an empty String. In this case the win amount will default to 0.0");
        }
		return win;
		}
		
	}
	
	public static double extractWinAmountTest() throws InterruptedException, AWTException, IOException 
	{
		//handleFeatureGames();
		if(ImageVerification.verifyImageWithTimeout(FirstGameScreen.blankWin_txt_english, 1 ,0.69)) 
		{
			System.out.println("The win amount is 0.0");
			return 0.00;
		}
		else
		{
		try 
		{
            OCR.extractTxtAtRunTime(FirstGameScreen.winAmount_txt_english);
            WaitUtils.safeSleep(1000);
            OCR.extractTxtManually(ImageVerification.x-63, ImageVerification.y+20, 193, 33);
            System.out.println(OCR.extractedTxt);
            win = Double.parseDouble(OCR.extractedTxt.replace(",", ""));
            System.out.println("Win amount: " + win);
        } 
		catch (Exception e) {
            System.out.println("OCR extracted an empty String. In this case the win amount will default to 0.0");
        }
		return win;
		}
		
	}
	
	public static double extractBetAmount() throws AWTException, IOException 
	{
		try {
            //OCR.extractTxtAtRunTime(FirstGameScreen.selectedQuickBet_btn_english);
            WaitUtils.safeSleep(1000);
            ImageVerification.verifyImage(FirstGameScreen.selectedQuickBet_btn_english);
            OCR.extractTxtManually(ImageVerification.x, ImageVerification.y+17, 81, 29);
            //OCR.extractTxtManually(738, 849, 81, 34);
            //OCR.extractTxtManually(738, 852, 81, 27);
            //OCR.extractTxtManually(739, 837, 81, 59);
            System.out.println(OCR.extractedTxt);
            //String withoutComma=OCR.extractedTxt;
            bet = Double.parseDouble(extractDecimal(OCR.extractedTxt));
            System.out.println("Current Bet amount: " + bet);
        } catch (Exception e) {
            e.printStackTrace();
            OCR.extractTxtManually(ImageVerification.x+91, ImageVerification.y+17, 81, 29);
            System.out.println(OCR.extractedTxt);
            bet = Double.parseDouble(extractDecimal(OCR.extractedTxt));
            System.out.println("Current Bet amount: " + bet);
        }
		return bet;
	}
	
	public static boolean calculateBalanceAfterSpin() throws AWTException, InterruptedException, IOException 
	{
		if(ImageVerification.verifyImage(FirstGameScreen.lazyLoading_icon)) 
		{
			WaitUtils.safeSleep(3000);
		}
		
		//check and handle if feature games are triggered
		CommonFunctions.handleFeatureGames();
		if(ImageVerification.verifyImage(FirstGameScreen.takeWin_btn)) 
		{
			CustomActions.clickBtn(FirstGameScreen.takeWin_btn);
		}
		extractWinAmount();
		extractBetAmount();
		extractBalanceAmountAfterSpin();
		double expBalanceAfterSpin=balance-bet+win;
		BigDecimal bd = new BigDecimal(expBalanceAfterSpin);
        bd = bd.setScale(2, RoundingMode.HALF_UP); // Round to 2 decimal places
        double roundedBalance = bd.doubleValue();
        if(CommonFunctions.balanceAfterSpin==roundedBalance) 
		{
			System.out.println("Balance amount matched! The expected amount is: "+roundedBalance);
			return true;
		}
		else 
		{
			System.out.println("Balance amount is different! It should be: "+roundedBalance);
			return false;
		}
		
	}
	
	public static boolean isJackpotTriggered() throws InterruptedException, AWTException 
	{
		if(ImageVerification.verifyImageWithTimeout(JackpotScreen.jackpotScreen, 8, 0.8)) 
		{
			handleJackpot();
			return true;
		} 
		else return false;
	}
	
	public static void handleJackpot() throws AWTException, InterruptedException 
	{
		int i=0;
		while(i<11) 
		{
			if(!ImageVerification.verifyImage(JackpotScreen.jackpotStar_btn)) 
			{
				i++;
			}
			else 
			{
				CustomActions.clickBtn(JackpotScreen.jackpotStar_btn);
				i++;
			}
		}
		System.out.println("Wait for 25 secs to let the jackpot complete.");
		WaitUtils.safeSleep(25000);
	}
	
	public static void moveMouseAway() throws InterruptedException 
	{
		//967 515	
		try {
			if(robot==null)	
				robot=new Robot();
		    robot.mouseMove(967, 515);
		    //robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		    //Thread.sleep(100);
		    //.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}
	
	public static void clickAtCentre() 
	{
		//967 515	
				try {
					if(robot==null)	
						robot=new Robot();
				    robot.mouseMove(967, 515);
				    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				    //Thread.sleep(100);
				    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				} catch (Exception e) {
				    e.printStackTrace();
				}
	}
	
	public static void openSettingsMenu() throws AWTException, InterruptedException, IOException 
	{
		WaitUtils.safeSleep(1000);
		CustomActions.clickBtn(FirstGameScreen.settings_btn);
	}
	
	public static void changeLangToEnglish() throws AWTException, InterruptedException, IOException 
	{
		BaseClass.driver.switchTo().defaultContent();
		BaseClass.driver.switchTo().defaultContent();
		FirstGameScreen fgs=new FirstGameScreen(BaseClass.driver);
		SettingsMenu sm=new SettingsMenu(BaseClass.driver);
		WaitUtils.safeSleep(2000);
		CustomActions.clickBtn(FirstGameScreen.settings_btn);
		sm.clickLangDropdown();
		sm.clickEngLang();
		CommonFunctions.closeSettingsMenu();
		BaseClass.driver.switchTo().defaultContent();
		BaseClass.driver.switchTo().defaultContent();
	}
	
	public static void changeLangToFrench() throws AWTException, InterruptedException, IOException 
	{
		BaseClass.driver.switchTo().defaultContent();
		BaseClass.driver.switchTo().defaultContent();
		FirstGameScreen fgs=new FirstGameScreen(BaseClass.driver);
		SettingsMenu sm=new SettingsMenu(BaseClass.driver);
		WaitUtils.safeSleep(2000);
		CustomActions.clickBtn(FirstGameScreen.settings_btn);
		sm.clickLangDropdown();
		sm.clickFrenchLang();
		CommonFunctions.closeSettingsMenu();
		BaseClass.driver.switchTo().defaultContent();
		BaseClass.driver.switchTo().defaultContent();
	}
	
	public static void changeLangToSpanish() throws AWTException, InterruptedException, IOException 
	{
		BaseClass.driver.switchTo().defaultContent();
		BaseClass.driver.switchTo().defaultContent();
		FirstGameScreen fgs=new FirstGameScreen(BaseClass.driver);
		SettingsMenu sm=new SettingsMenu(BaseClass.driver);
		WaitUtils.safeSleep(2000);
		CustomActions.clickBtn(FirstGameScreen.settings_btn);
		sm.clickLangDropdown();
		sm.clickSpanishLang();
		CommonFunctions.closeSettingsMenu();
		BaseClass.driver.switchTo().defaultContent();
		BaseClass.driver.switchTo().defaultContent();
	}
	
	public static void changeLangToBulgarian() throws AWTException, InterruptedException, IOException 
	{
		BaseClass.driver.switchTo().defaultContent();
		BaseClass.driver.switchTo().defaultContent();
		FirstGameScreen fgs=new FirstGameScreen(BaseClass.driver);
		SettingsMenu sm=new SettingsMenu(BaseClass.driver);
		WaitUtils.safeSleep(2000);
		CustomActions.clickBtn(FirstGameScreen.settings_btn);
		sm.clickLangDropdown();
		sm.clickBulgLang();
		CommonFunctions.closeSettingsMenu();
		BaseClass.driver.switchTo().defaultContent();
		BaseClass.driver.switchTo().defaultContent();
	}
	
	public static void changeLangToPortuguese() throws AWTException, InterruptedException, IOException 
	{
		BaseClass.driver.switchTo().defaultContent();
		BaseClass.driver.switchTo().defaultContent();
		FirstGameScreen fgs=new FirstGameScreen(BaseClass.driver);
		SettingsMenu sm=new SettingsMenu(BaseClass.driver);
		WaitUtils.safeSleep(2000);
		CustomActions.clickBtn(FirstGameScreen.settings_btn);
		sm.clickLangDropdown();
		sm.clickPortugLang();
		CommonFunctions.closeSettingsMenu();
		BaseClass.driver.switchTo().defaultContent();
		BaseClass.driver.switchTo().defaultContent();
	}
	
	public static void closeSettingsMenu() throws AWTException, InterruptedException 
	{
		CustomActions.clickBtn(System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\settings_popUp_close_btn.png");
	}
	
	public static void triggerGamble() throws AWTException, InterruptedException, IOException 
	{
		int count=0;
		WaitUtils.safeSleep(200);
		while(!ImageVerification.verifyImage(FirstGameScreen.gambleEnabled_btn)) 
		{
			if(ImageVerification.verifyImage(GamblePage.gamblePage)) 
			{
				CustomActions.clickBtn(GamblePage.gambleCollectBtn_English);
			}
			WaitUtils.safeSleep(500);
			CustomActions.clickBtn(FirstGameScreen.spin_btn);
			WaitUtils.safeSleep(400);
			CustomActions.clickPreviousBtn();
			moveMouseAway();
			count++;
			if(count==100) 
			{
				return;
			}
			handleFeatureGames();
		}
	}
	
	public static void triggerWin() throws AWTException, InterruptedException, IOException 
	{
		int count=0;
		while(!ImageVerification.verifyImage(FirstGameScreen.takeWin_btn)) 
		{
			CustomActions.clickBtn(FirstGameScreen.spin_btn);
			//if(!ImageVerification.verifyImage(FirstGameScreen.stop_btn)) break;
			moveMouseAway();
			handleFeatureGames();
			count++;
			if(count==9) 
			{
				return;
			}
		}
	}
	
	public static void triggerWinWithKeyboard() throws AWTException, InterruptedException, IOException 
	{
		int count=0;
		while(!ImageVerification.verifyImage(FirstGameScreen.takeWin_btn)) 
		{
			CustomActions.press_SpaceKey();
			//moveMouseAway();
			handleFeatureGames();
			count++;
			if(count==10) 
			{
				return;
			}
		}
	}
	
	public static boolean isGambleResumed() throws InterruptedException, AWTException 
	{
		//go to base game by collecting the amount
		if(ImageVerification.verifyImageWithTimeout(GamblePage.gamblePage, 8, 0.9)) 
		{
			CustomActions.clickBtn(GamblePage.gambleCollectBtn_Bulgarian);
			return true;
		}
		else return false;
		
	}
	
	public static boolean handleFeatureResumes() throws InterruptedException, AWTException 
	{
		if(isBannerTriggered()) 
		{
			if(isJackpotTriggered()) return true;
			if(isFreeSpinTriggered_Bulgarian()) return true;
		}
	    if(isGambleResumed()) {
	    	return true;
	    }
		
		return false;
	}
	public static String removeSRDFromString(String s) 
	{
		String srd="srd";
		if(s.toLowerCase().contains(srd)) 
		{
			s.toLowerCase().replace("srd", "");
			s.trim();
		}
		return s;
	}
	public static String extractDecimal(String s) 
	{
		
		String input = s.replace("O", "0").replace(",","");
		String decimalValue="";
        // Regex to match decimal numbers (with optional leading digits)
        String regex1 = "\\d+\\.\\d+";
        String regex2 = "\\b\\d+\\b";

        Pattern pattern1 = Pattern.compile(regex1);
        Pattern pattern2 = Pattern.compile(regex2);
        Matcher matcher1 = pattern1.matcher(input);
        Matcher matcher2 = pattern2.matcher(input);
        
        if (matcher1.find()) {
        	System.out.println("value is float");
            decimalValue = matcher1.group();
            System.out.println("Extracted decimal: " + decimalValue);
        } 
        else if(matcher2.find()) 
        {
        	System.out.println("value is integer");
        	decimalValue = matcher2.group();
            System.out.println("Extracted decimal: " + decimalValue);
        }
        else
        {
            System.out.println("No decimal found.");
        }
		return decimalValue;
        
       
	}
	public static String extractValue(String s) 
	{
		
		//String input = s;
		String value=s.trim();
        // Regex to match decimal numbers (with optional leading digits)
        //String regex1 = "\\d+\\.\\d+";
		System.out.println("Extracted value: "+value);
		return value; 
	}
	
	public static void closeIFrame() throws AWTException, InterruptedException 
	{
		CustomActions.clickBtn(System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\iFrame_closeBtn.png");
	}
	
	public static void handleFeatureGames() throws InterruptedException, AWTException, IOException 
	{
		if(isBannerTriggered()) 
		{
			//to skip big win banner(if triggered) to the end
			clickAtCentre();
			isJackpotTriggered();
			isFreeSpinTriggered();
			clickAtCentre();
		}
	}
	
	public static boolean isBannerTriggered() throws InterruptedException 
	{
		return ImageVerification.verifyImageWithTimeout(FirstGameScreen.someBannerTriggered, 5, 0.9999);
		//return ImageVerification.verifyImageWithTimeout(FirstGameScreen.someBannerTriggered_2, 5, 0.9999);
	}
	
	public static void isFreeSpinTriggered() throws InterruptedException 
	{
		if(ImageVerification.verifyImageWithTimeout(FreeSpinsScreen.freeSpins_txt, 10, 0.8)) 
		{
			System.out.println("Wait a min for free spins completion");
			WaitUtils.safeSleep(60000);
			System.out.println("Free spins completed");
			if(ImageVerification.verifyImageWithTimeout(FreeSpinsScreen.freeSpins_txt, 5, 0.8)) 
			{
				isFreeSpinTriggered();
			}
			else if(ImageVerification.verifyImageWithTimeout(FreeSpinsScreen.freeSpins_txt_Bulgarian, 5, 0.8)) 
			{
				isFreeSpinTriggered_Bulgarian();
			}
			return;
		}
		
	}
	
	public static boolean isFreeSpinTriggered_Bulgarian() throws InterruptedException 
	{
		if(ImageVerification.verifyImageWithTimeout(FreeSpinsScreen.freeSpins_txt_Bulgarian, 15, 0.8)) 
		{
			//No other option but to wait until the free spins are completed. Lets hope to God that free spins do not re-trigger
			System.out.println("Waiting for a min for free spins completion");
			WaitUtils.safeSleep(65000);
			System.out.println("Free spins completed");
			if(ImageVerification.verifyImageWithTimeout(FreeSpinsScreen.freeSpins_txt, 5, 0.8)) 
			{
				isFreeSpinTriggered();
			}
			else if(ImageVerification.verifyImageWithTimeout(FreeSpinsScreen.freeSpins_txt_Bulgarian, 5, 0.8)) 
			{
				isFreeSpinTriggered_Bulgarian();
			}
			return true;
		}
		return false;
	}
	
	public static void handleJackpot_custom() throws InterruptedException, AWTException 
	{
		int i=0;
		while(i<11) 
		{
			if(!ImageVerification.verifyImage(JackpotScreen.jackpotStar_btn)) 
			{
				i++;
			}
			else 
			{
				CustomActions.clickBtn(JackpotScreen.jackpotStar_btn);
				i++;
			}
		}
	}

	
	
	
	/*public static void isMultiWinTriggered() throws AWTException, IOException, InterruptedException 
	{
		System.out.println("Checking multiwin banner");
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        long startTime = System.currentTimeMillis();
        long endTime = startTime + 3 * 1000;

        while (System.currentTimeMillis() < endTime) 
        {
        	OCR.extractTxtManually(737, 395, 474, 191);
        	String multiWin[]= {"big","huge","massive","win"};
        	for(String s:multiWin) 
        	{
        		if(OCR.extractedTxt.toLowerCase().matches(".*"+s+".*"));
        		{
        			try {
        				if(robot==null)	
        					robot=new Robot();
        			    robot.mouseMove(967, 515);
        			    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        			    Thread.sleep(100);
        			    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        			} catch (Exception e) {
        			    e.printStackTrace();
        			}
        			Thread.sleep(3000);
        			return;
        		}
        	}
        }
	}*/
}
