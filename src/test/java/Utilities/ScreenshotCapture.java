package Utilities;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageTypeSpecifier;
import javax.imageio.ImageWriter;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataNode;
import javax.imageio.stream.ImageOutputStream;

public class ScreenshotCapture 
{
	public static Robot robot;
	public static File imageFile = new File(System.getProperty("user.dir")+"\\src\\main\\resources\\currentScreen.png"); // your image
	public static File subImageFile = new File("src/main/resources/cropped.png");
	public static File subImageFile_gamble_history = new File(System.getProperty("user.dir")+"\\src\\main\\resources\\cropped_gamble_history.png");
	public static BufferedImage fullImage;
		
	public static void captureFullSS()
	{
		try {
		// Get screen size	
		if(robot==null)	
			robot=new Robot();
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());

        // Capture full screen
        //System.out.println(screenRect);
        fullImage = robot.createScreenCapture(screenRect);
        ImageIO.write(fullImage, "png", imageFile);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void captureSubSS(int x, int y, int width, int height) throws IOException {
	    BufferedImage croppedImage = fullImage.getSubimage(x, y, width, height);
	    ImageIO.write(croppedImage, "png", subImageFile);
	}
	
	public static void captureSubSS_gamble_history() throws IOException {
		captureFullSS();
	    BufferedImage croppedImage_gamble_history = fullImage.getSubimage(1280, 790, 35, 33); //1315, 823, 35, 33
	    ImageIO.write(croppedImage_gamble_history, "png", subImageFile_gamble_history);
	}
}
