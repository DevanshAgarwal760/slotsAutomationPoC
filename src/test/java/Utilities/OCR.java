package Utilities;

import java.awt.AWTException;
import java.io.IOException;

import org.opencv.core.Core;

import commonTestMethods.CommonFunctions;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

public class OCR 
{
	public static String extractedTxt;
	public static String extractTxtManually(int x,int y,int width,int height) throws AWTException, IOException
	{
		ScreenshotCapture.captureFullSS();
		ScreenshotCapture.captureSubSS(x,y,width,height);
		
		try 
		{
            ITesseract tesseract = new Tesseract();

            // Set path to tessdata folder
            tesseract.setDatapath(System.getProperty("user.dir")+"\\src\\main\\resources\\tessdata");
            tesseract.setLanguage("eng");

            extractedTxt = tesseract.doOCR(ScreenshotCapture.subImageFile);
            System.out.println(CommonFunctions.RED+extractedTxt+CommonFunctions.RESET);
            System.out.println(CommonFunctions.YELLOW+" x:"+x +" y:"+y +" width: "+width+" height: "+height+CommonFunctions.RESET);
            /* implementation of OCR
            double value = Double.parseDouble(extractedOCR.replace(",", ""));
            System.out.println(value);
            System.out.println("OCR Result: " + value);
            */
        } 
		catch (Exception e)
		{
            e.printStackTrace();
        }
		return extractedTxt;
	}
	
	public static String extractTxtAtRunTime(String path) throws AWTException, IOException, InterruptedException
	{
		ImageVerification.verifyImage(path);
		WaitUtils.safeSleep(1000);
		ScreenshotCapture.captureFullSS();
		ScreenshotCapture.captureSubSS(ImageVerification.x,ImageVerification.y,ImageVerification.width,ImageVerification.height);
		try 
		{
            ITesseract tesseract = new Tesseract();

            // Set path to tessdata folder
            tesseract.setDatapath(System.getProperty("user.dir")+"\\src\\main\\resources\\tessdata");
            tesseract.setLanguage("eng");

            extractedTxt = tesseract.doOCR(ScreenshotCapture.subImageFile);
            System.out.println(CommonFunctions.RED+extractedTxt+CommonFunctions.RESET);  
            System.out.println(CommonFunctions.YELLOW+" x:"+ImageVerification.x+" y:"+ImageVerification.y+" width: "+ImageVerification.width+" height: "+ImageVerification.height+CommonFunctions.RESET);  
            /* implementation of OCR
            double value = Double.parseDouble(extractedOCR.replace(",", ""));
            System.out.println(value);
            System.out.println("OCR Result: " + value);
            */
        } 
		catch (Exception e)
		{
            e.printStackTrace();
        }
		return extractedTxt;
	}
	
	public static void extractTxtAtRunTimeWithTimeout(int x,int y,int width,int height,int timeoutInSeconds) throws AWTException, IOException, InterruptedException
	{
		//System.out.println(CommonFunctions.BLUE+"Checking img: "+path+CommonFunctions.RESET);
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        long startTime = System.currentTimeMillis();
        long endTime = startTime + timeoutInSeconds * 1000;

        while (System.currentTimeMillis() < endTime) {
	    	//WaitUtils.safeSleep(1); //poll 
			ScreenshotCapture.captureFullSS();
			ScreenshotCapture.captureSubSS(x,y,width,height);
			try 
			{
	            ITesseract tesseract = new Tesseract();
	
	            // Set path to tessdata folder
	            tesseract.setDatapath(System.getProperty("user.dir")+"\\src\\main\\resources\\tessdata");
	            tesseract.setLanguage("eng");
	
	            extractedTxt = tesseract.doOCR(ScreenshotCapture.subImageFile);
	            System.out.println(CommonFunctions.RED+extractedTxt+CommonFunctions.RESET);   
	            System.out.println(CommonFunctions.YELLOW+" x:"+ImageVerification.x+" y:"+ImageVerification.y+" width: "+ImageVerification.width+" height: "+ImageVerification.height+CommonFunctions.RESET);
	            
	            
	            /* implementation of OCR
	            double value = Double.parseDouble(extractedOCR.replace(",", ""));
	            System.out.println(value);
	            System.out.println("OCR Result: " + value);
	            */
	        } 
			catch (Exception e)
			{
	            e.printStackTrace();
	        }
			
        }
			/*if(extractedTxt_timeout.toLowerCase().contains(expectedTxt1)) 
            {
				System.out.println("Extracted text: "+extractedTxt_timeout);
            	return extractedTxt_timeout;
            }
			else if(extractedTxt_timeout.toLowerCase().contains(expectedTxt2)) 
            {
				System.out.println("Extracted text: "+extractedTxt_timeout);
            	return extractedTxt_timeout;
            }
			else 
			{
				continue;
			}*/
						
	    }
	
}
