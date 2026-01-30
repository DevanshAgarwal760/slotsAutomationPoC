package pageObjects;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import Utilities.ImageVerification;
import Utilities.OCR;
import commonTestMethods.CommonFunctions;
import hooks.Hooks;

public class GamblePage extends BasePage
{
	public GamblePage(WebDriver driver) 
	{
		super(driver);
	}
	
	public static String gamblePage=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\gamblePage.png";
	public static String gambleRed_btn=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\gambleRed_btn.png";
	public static String gambleBlack_btn=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\gambleBlack_btn.png";
	public static String gambleDiamonds_btn=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\gambleDiamond_btn.png";
	public static String gambleSpades_btn=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\gambleSpade_btn.png";
	public static String gambleClubs_btn=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\gambleClubs_btn.png";
	public static String gambleHearts_btn=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\gambleHearts_btn.png";
	public static String gambleCollectBtn_Bulgarian=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\gambleCollectBtn_Bulgarian.png";
	public static String gambleCollectBtn_English=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\gambleCollectBtn_English.png";
	public static String gambleAttemptsLeft_txt=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\gambleAttemptsLeft_txt.png";
	
	
	public static int extractGambleAttempts() throws AWTException, IOException, InterruptedException 
	{
	    String extracted="";
	    int attempts=0;
	    Thread.sleep(1500);
	    if(ImageVerification.verifyImage(gambleAttemptsLeft_txt)) 
	    {
	    	extracted=OCR.extractTxtManually(561, 795, 30, 40);
	    	attempts=Integer.parseInt(CommonFunctions.extractDecimal(extracted));	
	    	return attempts;
	    }
	    else if(ImageVerification.verifyImage(FirstGameScreen.firstScreen_HUD))
	    {
	    	return 0;
	    }
	    else 
	    {
	    	return 0;
	    }
		
	}
	
	public static int extractGambleAttemptsAfterResume() throws AWTException, IOException, InterruptedException 
	{
	    String extracted="";
	    int attempts=0;
	    Thread.sleep(1500);
	    if(ImageVerification.verifyImageWithTimeout(gamblePage, 5, 0.85)) 
	    {
	    	extracted=OCR.extractTxtManually(561, 795, 30, 40);
	    	attempts=Integer.parseInt(CommonFunctions.extractDecimal(extracted));	
	    	return attempts;
	    }
	    else if(ImageVerification.verifyImage(FirstGameScreen.firstScreen_HUD))
	    {
	    	return 0;
	    }
	    else 
	    {
	    	return 0;
	    }
		
	}

	public static double extractGambleAmount() throws AWTException, IOException, InterruptedException 
	{
		String extracted="";
	    double gambleAmount=0.0;
	    Thread.sleep(1500);
	    if(ImageVerification.verifyImage(gamblePage)) 
	    {
	    	extracted=OCR.extractTxtManually(774, 314, 370, 44); //(774, 311, 370, 44)
	    	gambleAmount=Double.parseDouble(CommonFunctions.extractDecimal(extracted));	
	    }
	    return gambleAmount;
	}
	
	public static double extractGambleAmountAfterResume() throws AWTException, IOException, InterruptedException 
	{
		String extracted="";
	    double gambleAmount=0.0;
	    Thread.sleep(1500);
	    if(ImageVerification.verifyImage(gamblePage)) 
	    {
	    	extracted=OCR.extractTxtManually(774, 314, 370, 44);
	    	gambleAmount=Double.parseDouble(CommonFunctions.extractDecimal(extracted));	
	    }
	    return gambleAmount;
	}
	
	public static double keepExtractingGambleAmount() throws AWTException, IOException, InterruptedException 
	{
		int timeoutSeconds=10;
		String extracted="";
	    double gambleAmount=0.0;
		long startTime = System.currentTimeMillis();
		while ((System.currentTimeMillis() - startTime) < timeoutSeconds * 1000) {
			
		    //Thread.sleep(100);
		    if(ImageVerification.verifyImageWithTimeout(gamblePage, 1, 0.85)) 
		    {
		    	extracted=OCR.extractTxtManually(774, 314, 370, 44); //(862, 316, 200, 28)
		    	gambleAmount=Double.parseDouble(CommonFunctions.extractDecimal(extracted));
		    	if(gambleAmount==0.0) break;
		    }
	    }
		
	    return gambleAmount;
	}
	
	public static int keepExtractingGambleAttempts() throws AWTException, IOException, InterruptedException 
	{
		int timeoutSeconds=10;
		String extracted="";
	    int gambleAttempts=0;
		long startTime = System.currentTimeMillis();
		while ((System.currentTimeMillis() - startTime) < timeoutSeconds * 1000) {
			
		    //Thread.sleep(100);
		    if(ImageVerification.verifyImageWithTimeout(gamblePage, 1, 0.85)) 
		    {
		    	extracted=OCR.extractTxtManually(561, 795, 30, 40);
		    	gambleAttempts=Integer.parseInt(CommonFunctions.extractDecimal(extracted));
		    	if(gambleAttempts==0) break;
		    }
	    }
		
	    return gambleAttempts;
	}
	
	public static String collectGamble_English=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\collectGamble_English.png";
	public static String infoTextGamble_English=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\infoTextGamble_English.png";
	public static String redBlackBtnGamble_English=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\redBlackBtnGamble_English.png";
	public static String historyGamble_English=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\historyGamble_English.png";
	public static String attemptsLeftGamble_English=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\attemptsLeftGamble_English.png";
	public static String suitWinGamble_English=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\suitWinGamble_English.png";
	public static String gambleAmountTextGamble_English=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\gambleAmountTextGamble_English.png";
	public static String colorWinGamble_English=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\colorWinGamble_English.png";
	
	public static String collectGamble_French=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\collectGamble_French.png";
	public static String infoTextGamble_French=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\infoTextGamble_French.png";
	public static String redBlackBtnGamble_French=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\redBlackBtnGamble_French.png";
	public static String historyGamble_French=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\historyGamble_French.png";
	public static String attemptsLeftGamble_French=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\attemptsLeftGamble_French.png";
	public static String suitWinGamble_French=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\suitWinGamble_French.png";
	public static String gambleAmountTextGamble_French=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\gambleAmountTextGamble_French.png";
	public static String colorWinGamble_French=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\colorWinGamble_French.png";
	
	public static String collectGamble_Spanish=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\collectGamble_Spanish.png";
	public static String infoTextGamble_Spanish=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\infoTextGamble_Spanish.png";
	public static String redBlackBtnGamble_Spanish=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\redBlackBtnGamble_Spanish.png";
	public static String historyGamble_Spanish=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\historyGamble_Spanish.png";
	public static String attemptsLeftGamble_Spanish=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\attemptsLeftGamble_Spanish.png";
	public static String suitWinGamble_Spanish=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\suitWinGamble_Spanish.png";
	public static String gambleAmountTextGamble_Spanish=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\gambleAmountTextGamble_Spanish.png";
	public static String colorWinGamble_Spanish=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\colorWinGamble_Spanish.png";
	
	public static String collectGamble_Bulgarian=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\collectGamble_Bulgarian.png";
	public static String infoTextGamble_Bulgarian=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\infoTextGamble_Bulgarian.png";
	public static String redBlackBtnGamble_Bulgarian=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\redBlackBtnGamble_Bulgarian.png";
	public static String historyGamble_Bulgarian=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\historyGamble_Bulgarian.png";
	public static String attemptsLeftGamble_Bulgarian=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\attemptsLeftGamble_Bulgarian.png";
	public static String suitWinGamble_Bulgarian=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\suitWinGamble_Bulgarian.png";
	public static String gambleAmountTextGamble_Bulgarian=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\gambleAmountTextGamble_Bulgarian.png";
	public static String colorWinGamble_Bulgarian=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\colorWinGamble_Bulgarian.png";
	
	public static String collectGamble_Portuguese=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\collectGamble_Portuguese.png";
	public static String infoTextGamble_Portuguese=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\infoTextGamble_Portuguese.png";
	public static String redBlackBtnGamble_Portuguese=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\redBlackBtnGamble_Portuguese.png";
	public static String historyGamble_Portuguese=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\historyGamble_Portuguese.png";
	public static String attemptsLeftGamble_Portuguese=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\attemptsLeftGamble_Portuguese.png";
	public static String suitWinGamble_Portuguese=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\suitWinGamble_Portuguese.png";
	public static String gambleAmountTextGamble_Portuguese=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\gambleAmountTextGamble_Portuguese.png";
	public static String colorWinGamble_Portuguese=System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\colorWinGamble_Portuguese.png";
	
	public static boolean checkGambleLoc_Bulgarian() 
	{
		if(ImageVerification.verifyImage(collectGamble_Bulgarian) &&
		   ImageVerification.verifyImage(infoTextGamble_Bulgarian)	&&
		   ImageVerification.verifyImage(redBlackBtnGamble_Bulgarian) &&
		   ImageVerification.verifyImage(historyGamble_Bulgarian) &&
		   ImageVerification.verifyImage(attemptsLeftGamble_Bulgarian) &&
		   ImageVerification.verifyImage(suitWinGamble_Bulgarian) &&
		   ImageVerification.verifyImage(gambleAmountTextGamble_Bulgarian) &&
		   ImageVerification.verifyImage(colorWinGamble_Bulgarian)) return true;
		
		else return false;
	}
	
	public static boolean checkGambleLoc_Spanish() 
	{
		if(ImageVerification.verifyImage(collectGamble_Spanish) &&
		   ImageVerification.verifyImage(infoTextGamble_Spanish)	&&
		   ImageVerification.verifyImage(redBlackBtnGamble_Spanish) &&
		   ImageVerification.verifyImage(historyGamble_Spanish) &&
		   ImageVerification.verifyImage(attemptsLeftGamble_Spanish) &&
		   ImageVerification.verifyImage(suitWinGamble_Spanish) &&
		   ImageVerification.verifyImage(gambleAmountTextGamble_Spanish) &&
		   ImageVerification.verifyImage(colorWinGamble_Spanish)) return true;
		
		else return false;
	}
	
	public static boolean checkGambleLoc_Portuguese() 
	{
		if(ImageVerification.verifyImage(collectGamble_Portuguese) &&
		   ImageVerification.verifyImage(infoTextGamble_Portuguese)	&&
		   ImageVerification.verifyImage(redBlackBtnGamble_Portuguese) &&
		   ImageVerification.verifyImage(historyGamble_Portuguese) &&
		   ImageVerification.verifyImage(attemptsLeftGamble_Portuguese) &&
		   ImageVerification.verifyImage(suitWinGamble_Portuguese) &&
		   ImageVerification.verifyImage(gambleAmountTextGamble_Portuguese) &&
		   ImageVerification.verifyImage(colorWinGamble_Portuguese)) return true;
		
		else return false;
	}
	
	public static boolean checkGambleLoc_English() 
	{
		if(ImageVerification.verifyImage(collectGamble_English) &&
		   ImageVerification.verifyImage(infoTextGamble_English)	&&
		   ImageVerification.verifyImage(redBlackBtnGamble_English) &&
		   ImageVerification.verifyImage(historyGamble_English) &&
		   ImageVerification.verifyImage(attemptsLeftGamble_English) &&
		   ImageVerification.verifyImage(suitWinGamble_English) &&
		   ImageVerification.verifyImage(gambleAmountTextGamble_English) &&
		   ImageVerification.verifyImage(colorWinGamble_English)) return true;
		
		else return false;
	}
	
	public static boolean checkGambleLoc_French() 
	{
		if(ImageVerification.verifyImage(collectGamble_French) &&
		   ImageVerification.verifyImage(infoTextGamble_French)	&&
		   ImageVerification.verifyImage(redBlackBtnGamble_French) &&
		   ImageVerification.verifyImage(historyGamble_French) &&
		   ImageVerification.verifyImage(attemptsLeftGamble_French) &&
		   ImageVerification.verifyImage(suitWinGamble_French) &&
		   ImageVerification.verifyImage(gambleAmountTextGamble_French) &&
		   ImageVerification.verifyImage(colorWinGamble_French)) return true;
		
		else return false;
	}
	
	
	
}
