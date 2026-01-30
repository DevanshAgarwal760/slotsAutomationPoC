package testScripts;


import java.awt.AWTException;
import java.io.IOException;
import commonTestMethods.CommonFunctions;

public class Test
{
	
	public static void main(String args[]) throws AWTException, InterruptedException, IOException 
	{ 
		System.out.println(CommonFunctions.isBannerTriggered());
	}
}
// without banner match score: 0.999856173992157
// with banner match score: 0.9999998211860657

//without banner match score: 0.999856173992157
//with banner match score: 0.9999998211860657