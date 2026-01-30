package testScripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import Utilities.CustomActions;
import Utilities.ImageVerification;
import Utilities.WaitUtils;
import commonTestMethods.CommonFunctions;
import pageObjects.FirstGameScreen;

public class Test2
{
	
	public static void main(String args[]) throws AWTException, InterruptedException, IOException 
	{ 
		int i=0;
		ArrayList<Double> winAmount=new ArrayList<>(); 
	    
	    double totalWin=0;
	    double betAmount=0;
		while(i<=100)
		{
			try 
			{   
				//click buy button
				if(ImageVerification.verifyImageWithTimeout(System.getProperty("user.dir")+"\\ExpectedImages\\iFrame\\GameHUD_BetOptionsBtn.png", 60, 0.85))
				{
					Robot robot=new Robot();
					robot.mouseMove(960,540);
					WaitUtils.safeSleep(100);
					robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				    WaitUtils.safeSleep(100);
				    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				    WaitUtils.safeSleep(100);
					robot.keyPress(KeyEvent.VK_Q);
				    robot.keyRelease(KeyEvent.VK_Q);
					WaitUtils.safeSleep(2000);
					robot.keyPress(KeyEvent.VK_SPACE);
				    robot.keyRelease(KeyEvent.VK_SPACE);
					CommonFunctions.isJackpotTriggered();
					robot.mouseMove(960,540);
				    WaitUtils.safeSleep(100);
				    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				    WaitUtils.safeSleep(100);
				    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				    System.out.println(i++);
				    WaitUtils.safeSleep(100);
				    int j=0;
				    while(ImageVerification.verifyImage(FirstGameScreen.stop_btn) || j<10) 
				    {
				    	WaitUtils.safeSleep(1000);
				    	robot.mouseMove(1556,512);
					    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
					    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
					    j++;
				    }
				    ImageVerification.verifyImageWithTimeout(FirstGameScreen.takeWin_btn, 60, 0.85);
				    CustomActions.clickBtn(FirstGameScreen.winAmount_txt_english);
				    WaitUtils.safeSleep(2000);
				    CustomActions.clickBtn(FirstGameScreen.takeWin_btn);
				    if(CommonFunctions.extractWinAmountTest()==0.0) {
				    	System.out.println("Win Amount in Free spins cam out to be 0.0");
				    	break;
			    	}
				    winAmount.add(CommonFunctions.extractWinAmountTest()-3000);
				}
			} 
			catch (Exception e) 
			{
			    e.printStackTrace();
			}
		}
		for(double j:winAmount) 
		{
			System.out.println(j);
			totalWin+=j;
			
			//betAmount+=2.8;
		}
		System.out.println("Total Win Amount after 100 free spin buys: "+totalWin);
		//System.out.println("Total Win Amount after 100 free spin buys: "+betAmount);
	}
	
	
}

