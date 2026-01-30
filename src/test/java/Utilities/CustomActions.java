package Utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import commonTestMethods.CommonFunctions;
import pageObjects.FirstGameScreen;

public class CustomActions
{
	public static  Robot robot;
	
	public static void clickBtn(String path) throws AWTException, InterruptedException 
	{
		ImageVerification.verifyImage(path);
		try 
		{
			if(robot==null)
				robot =new Robot();
		    robot.mouseMove(ImageVerification.avgX, ImageVerification.avgY);
		    WaitUtils.safeSleep(50);
		    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		    WaitUtils.safeSleep(50);
		    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		    WaitUtils.safeSleep(50);
		    System.out.println("Click successful using Robot");
		    //CommonFunctions.moveMouseAway();
		    //robot.keyPress(KeyEvent.VK_1);
		    //robot.keyRelease(KeyEvent.VK_1);
		    //WaitUtils.safeSleep(400);
		    //robot.keyPress(KeyEvent.VK_SPACE);
		    //robot.keyRelease(KeyEvent.VK_SPACE);
		} 
		catch (Exception e) 
		{
		    e.printStackTrace();
		}
	}
	
	public static void hoverMouse(String path) 
	{
		try 
		{
			if(robot==null)
				robot =new Robot();
			ImageVerification.verifyImage(FirstGameScreen.sapphireJackpotIndex);
		    robot.mouseMove(ImageVerification.avgX, ImageVerification.avgY);
		    WaitUtils.safeSleep(50);
		    robot.mouseMove(ImageVerification.avgX+1, ImageVerification.avgY+1);
		    WaitUtils.safeSleep(50);
		    robot.mouseMove(ImageVerification.avgX, ImageVerification.avgY);
		    WaitUtils.safeSleep(50);
		}
		catch (Exception e) 
		{
		    e.printStackTrace();
		}
	}
	
	public static void clickPreviousBtn() throws AWTException  
	{
		try 
		{
			if(robot==null)
				robot =new Robot();
		    robot.mouseMove(ImageVerification.avgX, ImageVerification.avgY);
		    WaitUtils.safeSleep(100);
		    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		    WaitUtils.safeSleep(100);
		    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		    WaitUtils.safeSleep(100);
		    System.out.println("Click successful using Robot");
		    
		    //robot.keyPress(KeyEvent.VK_1);
		    //robot.keyRelease(KeyEvent.VK_1);
		    //WaitUtils.safeSleep(400);
		    //robot.keyPress(KeyEvent.VK_SPACE);
		    //robot.keyRelease(KeyEvent.VK_SPACE);
		} 
		catch (Exception e) 
		{
		    e.printStackTrace();
		}
	}
	
	public static void press_DownArrowKey() throws AWTException 
	{
		if(robot==null)
			robot =new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
	    robot.keyRelease(KeyEvent.VK_DOWN);
	}
	
	public static void press_SpaceKey() throws AWTException 
	{
		if(robot==null)
			robot =new Robot();
		robot.keyPress(KeyEvent.VK_SPACE);
	    robot.keyRelease(KeyEvent.VK_SPACE);
	}
	
	public static void press_IKey() throws AWTException 
	{
		if(robot==null)
			robot =new Robot();
		robot.keyPress(KeyEvent.VK_I);
	    robot.keyRelease(KeyEvent.VK_I);
	}
	
	public static void press_SKey() throws AWTException 
	{
		if(robot==null)
			robot =new Robot();
		robot.keyPress(KeyEvent.VK_S);
	    robot.keyRelease(KeyEvent.VK_S);
	}
	
	public static void press_UpArrowKey() throws AWTException 
	{
		if(robot==null)
			robot =new Robot();
		robot.keyPress(KeyEvent.VK_UP);
	    robot.keyRelease(KeyEvent.VK_UP);
	}
	
	public static void press_HKey() throws AWTException 
	{
		if(robot==null)
			robot =new Robot();
		robot.keyPress(KeyEvent.VK_H);
	    robot.keyRelease(KeyEvent.VK_H);
	}
	
	public static void press_QKey() throws AWTException 
	{
		if(robot==null)
			robot =new Robot();
		robot.keyPress(KeyEvent.VK_Q);
	    robot.keyRelease(KeyEvent.VK_Q);
	}
	
}
