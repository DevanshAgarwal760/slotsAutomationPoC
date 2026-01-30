package stepDefinitions;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import commonTestMethods.CommonFunctions;

public class BigWin 
{
	@Test
	public void test1() throws InterruptedException, AWTException 
	{
		
		ChromeOptions optionsChrome = new ChromeOptions();
		optionsChrome.setExperimentalOption("excludeSwitches", java.util.Collections.singletonList("enable-automation"));
		optionsChrome.setExperimentalOption("useAutomationExtension", false);
		
		EdgeOptions optionsEdge = new EdgeOptions();
		optionsEdge.setExperimentalOption("excludeSwitches", java.util.Collections.singletonList("enable-automation"));
		
		WebDriver driver=new ChromeDriver(optionsChrome);
		Robot robot = new Robot();
		File imageFile = new File("src/main/resources/sample.png"); // your image
		File subImageFile = new File("src/main/resources/cropped.png");
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		/*driver.get("https://demo.ysecit.in:10451/YgtGames/YgtGame/");
		driver.findElement(By.xpath("//input[@placeholder='Email / Mobile / CardNo']")).sendKeys("8017627028");
		driver.findElement(By.xpath("//input[@placeholder='Password / Card Pin']")).sendKeys("mans@123");
		driver.findElement(By.xpath("//input[@class='loginActive']")).click();
		////i[@ng-click='DayValShow=false']
		WebElement upload=driver.findElement(By.xpath("//i[@ng-click='DayValShow=false']"));
		Thread.sleep(3000);
		if(upload.isDisplayed()) 
		{
			upload.click();
			Thread.sleep(1000);
		}
		
		//Thread.sleep(8000);
		
		driver.findElement(By.xpath("//input[@ng-model='globalslotsgameCtlr.filterQuery']")).sendKeys("Lucky7");
		//div/span[contains(text(),'PL')]
		driver.findElement(By.xpath("//div/span[contains(text(),'PL')]")).click();
		//Thread.sleep(10000);
		driver.findElement(By.xpath("(//input[@id='transferInput'])[1]")).clear();
		driver.findElement(By.xpath("(//input[@id='transferInput'])[1]")).sendKeys("1000");
		driver.findElement(By.xpath("//div[@class='Transfer_Ok_but']")).click();
		//driver.findElement(By.xpath("//div[@class='Transfer_Ok_but']")).click();
		Thread.sleep(10000);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='canvasWrapper']//canvas")));
		
		// Switch to first iframe
		WebElement firstIframe = driver.findElement(By.cssSelector("#iframeSlotGame"));
		driver.switchTo().frame(firstIframe);

		// Switch to nested iframe
		WebElement secondIframe = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(secondIframe);

		// Locate the canvas element
		WebElement canvas = driver.findElement(By.tagName("canvas"));
		wait.until(ExpectedConditions.elementToBeClickable(canvas));
		
		Thread.sleep(8000);
		
		

		// Click at specific position (x: 964, y: 540)
		/*Point location = canvas.getLocation();
		System.out.println(location);
		//int xOffset = 960;
		//int yOffset = 540;
		
		
		try {
		    robot.mouseMove(1548, 275);
		    Thread.sleep(100);
		    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		    Thread.sleep(100);
		    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		    Thread.sleep(100);
		    System.out.println("Click successful using Robot");
		    
		    //robot.keyPress(KeyEvent.VK_1);
		    //robot.keyRelease(KeyEvent.VK_1);
		    //Thread.sleep(400);
		    //robot.keyPress(KeyEvent.VK_SPACE);
		    //robot.keyRelease(KeyEvent.VK_SPACE);
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		//Take Screenshot of full screen
		Thread.sleep(1500);
		//ImageVerification.verifyImage("C:\\Users\\1767\\eclipse-workspace\\slotsAutomationPoC\\ExpectedImages\\GameHUD_BetOptionsBtn.png");
				
		try {
            // Create Robot instance
            // Get screen size
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());

            // Capture full screen
            BufferedImage fullImage = robot.createScreenCapture(screenRect);
            ImageIO.write(fullImage, "png", imageFile);
            //BufferedImage croppedImage = fullImage.getSubimage(460, 880, 142, 34);516,905,35,17
            BufferedImage croppedImage = fullImage.getSubimage(372, 887, 312, 35);
            ImageIO.write(croppedImage, "png", subImageFile);
            
            // Save to file
            System.out.println("Full screen screenshot saved!");
        } catch (java.io.IOException ex) {
            ex.printStackTrace();
        }
		
		//OCR code
		try {
            OCR.extractTxtAtRunTime("C:\\Users\\1767\\eclipse-workspace\\slotsAutomationPoC\\ExpectedImages\\iFrame\\GameHUD_BalanceText.png");
            Thread.sleep(1000);
            System.out.println(OCR.extractedTxt);
            //Top-Left: (499, 835) coordinates of balance in bulgarian lang- Actual co-ordinates of balance (436, 857, 193, 33)
            OCR.extractTxtManually(ImageVerification.x-63, ImageVerification.y+22, 193, 33);
            System.out.println(OCR.extractedTxt);
            double value = Double.parseDouble(OCR.extractedTxt.replace(",", ""));
            System.out.println("OCR Result: " + value);
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		// Calculate absolute screen coordinates
		//int x = 1554;
		//int y = 548;

		try {
		    robot.mouseMove(ImageVerification.avgX, ImageVerification.avgY);
		    Thread.sleep(100);
		    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		    Thread.sleep(100);
		    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		    Thread.sleep(100);
		    System.out.println("Click successful using Robot");
		    
		    //robot.keyPress(KeyEvent.VK_1);
		    //robot.keyRelease(KeyEvent.VK_1);
		    //Thread.sleep(400);
		    //robot.keyPress(KeyEvent.VK_SPACE);
		    //robot.keyRelease(KeyEvent.VK_SPACE);
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		Thread.sleep(1000);
		//ImageVerification.verifyImage("C:\\Users\\1767\\eclipse-workspace\\slotsAutomationPoC\\ExpectedImages\\BetOption_100.png");
		
		try {
		    robot.mouseMove(ImageVerification.avgX, ImageVerification.avgY);
		    Thread.sleep(100);
		    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		    Thread.sleep(100);
		    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		    Thread.sleep(100);
		    System.out.println("Click successful using Robot");
		    
		    //robot.keyPress(KeyEvent.VK_1);
		    //robot.keyRelease(KeyEvent.VK_1);
		    //Thread.sleep(400);
		    //robot.keyPress(KeyEvent.VK_SPACE);
		    //robot.keyRelease(KeyEvent.VK_SPACE);
		} catch (Exception e) {
		    e.printStackTrace();
		}
				
		File source=canvas.getScreenshotAs(OutputType.FILE);
		File target=new File("C:\\Users\\1767\\eclipse-workspace\\ysecit\\Screenshots\\my1.png");
		source.renameTo(target);
		/*Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(
		    "var canvas = arguments[0];" +
		    "var x = 1960;" +
		    "var y = 800;" +
		    "canvas.dispatchEvent(new MouseEvent('click', {" +
		    "clientX: x, clientY: y, bubbles: true}));", canvas);*/
		
		
		// Switch back to default content after action
		//driver.switchTo().defaultContent();
		
		//WebElement canvas = driver.findElement(By.cssSelector("canvas[style='touch-action: none; cursor: inherit;']"));
		//
		/*Dimension size = canvas.getSize();
		System.out.println("Rendered width: " + size.getWidth());
		System.out.println("Rendered height: " + size.getHeight());*/
		
	}
}
