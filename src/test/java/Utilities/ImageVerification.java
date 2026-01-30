package Utilities;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import commonTestMethods.CommonFunctions;
import io.cucumber.java.Scenario;

public class ImageVerification {
	
	public static int x;
	public static int y;
	public static int x2;
	public static int y2;
	public static int avgX;
	public static int avgY;
	public static int width;
	public static int height;
	Scenario scenario;
	
    public static boolean verifyImage(String path)   {
        // Load OpenCV native library 
    	System.out.println(CommonFunctions.BLUE+"Checking img: "+path.replace(System.getProperty("user.dir"), "")+CommonFunctions.RESET);
    	WaitUtils.safeSleep(500);
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        // Take screenshot of the screen
        ScreenshotCapture.captureFullSS();
        // Load images into OpenCV
        Mat screen = Imgcodecs.imread(System.getProperty("user.dir")+"\\src\\main\\resources\\currentScreen.png");
        Mat template = Imgcodecs.imread(path); // your saved image

        // Template matching
        int matchMethod = Imgproc.TM_CCOEFF_NORMED;
        int resultCols = screen.cols() - template.cols() + 1;
        int resultRows = screen.rows() - template.rows() + 1;
        Mat result = new Mat(resultRows, resultCols, CvType.CV_32FC1);

        Imgproc.matchTemplate(screen, template, result, matchMethod);
        Core.MinMaxLocResult mmr = Core.minMaxLoc(result);

        double threshold = 0.80; // 0.85 means 85% similarity, 1.0 means 100% similarity, 0.99 = 99%
        if (mmr.maxVal >= threshold) {
        	System.out.println(CommonFunctions.GREEN+"✅ Image found. Match: " + mmr.maxVal+CommonFunctions.RESET);

            // Draw rectangle around the matched region
            Point matchLoc = mmr.maxLoc;
            Point bottomRight = new Point(matchLoc.x + template.cols(), matchLoc.y + template.rows());
            Imgproc.rectangle(screen, matchLoc, bottomRight, new Scalar(0, 255, 0), 1);
            
            //Top-left corner
            x = (int) matchLoc.x;
            y = (int) matchLoc.y;

            // Width and Height of matched region
            width = (int)template.cols();
            height = (int)template.rows();

            // Bottom-right corner
            x2 = (int) (x + width);
            y2 = (int) (y + height);
            
            //Calculate avg of x and y to click in the center
            avgX=(int)(x+x2)/2;
            avgY=(int)(y+y2)/2;

            // Print details
            System.out.println("📍 Top-Left: (" + x + ", " + y + ")");
            System.out.println("📍 Bottom-Right: (" + x2 + ", " + y2 + ")");
            System.out.println("📏 Width: " + width + ", Height: " + height);
            System.out.println("📍 Centre of the button: (" + avgX + ", " + avgY + ")");

            // Save result image with highlighted match
            Imgcodecs.imwrite("result.png", screen);
            System.out.println("📸 Result saved as result.png with highlighted region.");
            return true;
        } else {
            System.out.println("❌ Image NOT found. Match: " + mmr.maxVal);
            return false;
        }
		

       }
    
    public static boolean verifyImageWithTimeout(String path, int timeoutInSeconds, double threshold)   {
    	System.out.println(CommonFunctions.BLUE+"Checking img: "+path.replace(System.getProperty("user.dir"), "")+CommonFunctions.RESET);
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        long startTime = System.currentTimeMillis();
        long endTime = startTime + timeoutInSeconds * 1000;

        while (System.currentTimeMillis() < endTime) {
        	WaitUtils.safeSleep(20); // Poll every 500 milliseconds

            ScreenshotCapture.captureFullSS();
            Mat screen = Imgcodecs.imread(System.getProperty("user.dir")+"\\src\\main\\resources\\currentScreen.png");
            Mat template = Imgcodecs.imread(path);

            if (screen.empty() || template.empty()) {
                //System.out.println("⚠️ Could not load screen or template image.");
                continue;
            }

            int matchMethod = Imgproc.TM_CCOEFF_NORMED;
            int resultCols = screen.cols() - template.cols() + 1;
            int resultRows = screen.rows() - template.rows() + 1;
            Mat result = new Mat(resultRows, resultCols, CvType.CV_32FC1);

            Imgproc.matchTemplate(screen, template, result, matchMethod);
            Core.MinMaxLocResult mmr = Core.minMaxLoc(result);
            if (mmr.maxVal >= threshold) {
            	System.out.println(CommonFunctions.GREEN+"✅ Image found. Match: " + mmr.maxVal+CommonFunctions.RESET);

                Point matchLoc = mmr.maxLoc;
                Point bottomRight = new Point(matchLoc.x + template.cols(), matchLoc.y + template.rows());
                Imgproc.rectangle(screen, matchLoc, bottomRight, new Scalar(0, 255, 0), 1);

                x = (int) matchLoc.x;
                y = (int) matchLoc.y;
                width = template.cols();
                height = template.rows();
                x2 = x + width;
                y2 = y + height;
                avgX = (x + x2) / 2;
                avgY = (y + y2) / 2;

                System.out.println("📍 Top-Left: (" + x + ", " + y + ")");
                System.out.println("📍 Bottom-Right: (" + x2 + ", " + y2 + ")");
                System.out.println("📏 Width: " + width + ", Height: " + height);
                System.out.println("📍 Centre of the button: (" + avgX + ", " + avgY + ")");

                Imgcodecs.imwrite("result.png", screen);
                //System.out.println("📸 Result saved as result.png with highlighted region.");
                return true;
            } else {
                System.out.println("⏳ Image not found yet. Match: " + mmr.maxVal);
            }
        }

        System.out.println("❌ Timeout reached. Image not found.");
        return false;
    }
    
    public static boolean verifyImageInLessThanSecond(String path, double timeoutInSeconds, double threshold)   {
    	System.out.println(CommonFunctions.BLUE+"Checking img: "+path.replace(System.getProperty("user.dir"), "")+CommonFunctions.RESET);
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        long startTime = System.currentTimeMillis();
        long endTime = (long) (startTime + timeoutInSeconds * 1000);

        while (System.currentTimeMillis() < endTime) {
        	WaitUtils.safeSleep(20); // Poll every 500 milliseconds

            ScreenshotCapture.captureFullSS();
            Mat screen = Imgcodecs.imread(System.getProperty("user.dir")+"\\src\\main\\resources\\currentScreen.png");
            Mat template = Imgcodecs.imread(path);

            if (screen.empty() || template.empty()) {
                System.out.println("⚠️ Could not load screen or template image.");
                continue;
            }

            int matchMethod = Imgproc.TM_CCOEFF_NORMED;
            int resultCols = screen.cols() - template.cols() + 1;
            int resultRows = screen.rows() - template.rows() + 1;
            Mat result = new Mat(resultRows, resultCols, CvType.CV_32FC1);

            Imgproc.matchTemplate(screen, template, result, matchMethod);
            Core.MinMaxLocResult mmr = Core.minMaxLoc(result);
            if (mmr.maxVal >= threshold) {
            	System.out.println(CommonFunctions.GREEN+"✅ Image found. Match: " + mmr.maxVal+CommonFunctions.RESET);

                Point matchLoc = mmr.maxLoc;
                Point bottomRight = new Point(matchLoc.x + template.cols(), matchLoc.y + template.rows());
                Imgproc.rectangle(screen, matchLoc, bottomRight, new Scalar(0, 255, 0), 1);

                x = (int) matchLoc.x;
                y = (int) matchLoc.y;
                width = template.cols();
                height = template.rows();
                x2 = x + width;
                y2 = y + height;
                avgX = (x + x2) / 2;
                avgY = (y + y2) / 2;

                System.out.println("📍 Top-Left: (" + x + ", " + y + ")");
                System.out.println("📍 Bottom-Right: (" + x2 + ", " + y2 + ")");
                System.out.println("📏 Width: " + width + ", Height: " + height);
                System.out.println("📍 Centre of the button: (" + avgX + ", " + avgY + ")");

                Imgcodecs.imwrite("result.png", screen);
                System.out.println("📸 Result saved as result.png with highlighted region.");
                return true;
            } else {
                System.out.println("⏳ Image not found yet. Match: " + mmr.maxVal);
            }
        }

        System.out.println("❌ Timeout reached. Image not found.");
        return false;
    }
    
    public static boolean verifyImageInstantly(String path)   {
        // Load OpenCV native library 
    	System.out.println(CommonFunctions.BLUE+"Checking img: "+path.replace(System.getProperty("user.dir"), "")+CommonFunctions.RESET);
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        // Take screenshot of the screen
        ScreenshotCapture.captureFullSS();
        // Load images into OpenCV
        Mat screen = Imgcodecs.imread(System.getProperty("user.dir")+"\\src\\main\\resources\\currentScreen.png");
        Mat template = Imgcodecs.imread(path); // your saved image

        // Template matching
        int matchMethod = Imgproc.TM_CCOEFF_NORMED;
        int resultCols = screen.cols() - template.cols() + 1;
        int resultRows = screen.rows() - template.rows() + 1;
        Mat result = new Mat(resultRows, resultCols, CvType.CV_32FC1);

        Imgproc.matchTemplate(screen, template, result, matchMethod);
        Core.MinMaxLocResult mmr = Core.minMaxLoc(result);

        double threshold = 0.8; // 0.8 means 80% similarity, 1.0 means 100% similarity, 0.99 = 99%
        if (mmr.maxVal >= threshold) {
            System.out.println(CommonFunctions.GREEN+"✅ Image found. Match: " + mmr.maxVal+CommonFunctions.RESET);

            // Draw rectangle around the matched region
            Point matchLoc = mmr.maxLoc;
            Point bottomRight = new Point(matchLoc.x + template.cols(), matchLoc.y + template.rows());
            Imgproc.rectangle(screen, matchLoc, bottomRight, new Scalar(0, 255, 0), 1);
            
            //Top-left corner
            x = (int) matchLoc.x;
            y = (int) matchLoc.y;

            // Width and Height of matched region
            width = (int)template.cols();
            height = (int)template.rows();

            // Bottom-right corner
            x2 = (int) (x + width);
            y2 = (int) (y + height);
            
            //Calculate avg of x and y to click in the center
            avgX=(int)(x+x2)/2;
            avgY=(int)(y+y2)/2;

            // Print details
            /*System.out.println("📍 Top-Left: (" + x + ", " + y + ")");
            System.out.println("📍 Bottom-Right: (" + x2 + ", " + y2 + ")");
            System.out.println("📏 Width: " + width + ", Height: " + height);
            System.out.println("📍 Centre of the button: (" + avgX + ", " + avgY + ")");*/

            // Save result image with highlighted match
            Imgcodecs.imwrite("result.png", screen);
            System.out.println("📸 Result saved as result.png with highlighted region.");
            return true;
        } else {
            System.out.println("❌ Image NOT found. Match: " + mmr.maxVal);
            return false;
        }
		

       }
}

