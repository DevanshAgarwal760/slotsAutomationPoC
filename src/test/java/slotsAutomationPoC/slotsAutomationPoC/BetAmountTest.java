package slotsAutomationPoC.slotsAutomationPoC;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

import java.io.File;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class BetAmountTest 
{
	public static void main(String args[]) throws InterruptedException, AWTException 
	{
		WebDriver driver=new ChromeDriver();
		Robot robot = new Robot();
		File imageFile = new File("src/main/resources/sample.png"); // your image
		File subImageFile = new File("src/main/resources/cropped.png");
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://demo.ysecit.in:10451/YgtGames/YgtGame/");
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
		
		driver.findElement(By.xpath("//input[@ng-model='globalslotsgameCtlr.filterQuery']")).sendKeys("20SplendidHot");
		//div/span[contains(text(),'PL')]
		driver.findElement(By.xpath("//div/span[contains(text(),'PL')]")).click();
		//Thread.sleep(10000);
		driver.findElement(By.xpath("(//input[@id='transferInput'])[1]")).clear();
		driver.findElement(By.xpath("(//input[@id='transferInput'])[1]")).sendKeys("1000");
		driver.findElement(By.xpath("//div[@class='Transfer_Ok_but']")).click();
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
		Point location = canvas.getLocation();
		System.out.println(location);
		//int xOffset = 960;
		//int yOffset = 540;
		
		
		//Take Screenshot of full screen
		
		try {
            // Create Robot instance
            // Get screen size
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());

            // Capture full screen
            BufferedImage fullImage = robot.createScreenCapture(screenRect);
            ImageIO.write(fullImage, "png", imageFile);
            BufferedImage croppedImage = fullImage.getSubimage(460, 880, 142, 34);
            ImageIO.write(croppedImage, "png", subImageFile);
            
            // Save to file
            
            

            System.out.println("Full screen screenshot saved!");
        } catch (java.io.IOException ex) {
            ex.printStackTrace();
        }
		
		//OCR code
		try {
            ITesseract tesseract = new Tesseract();

            // Set path to tessdata folder
            tesseract.setDatapath("C:\\Users\\1767\\eclipse-workspace\\slotsAutomationPoC\\src\\main\\resources\\tessdata");
            tesseract.setLanguage("eng");

            String result = tesseract.doOCR(subImageFile);
            double value = Double.parseDouble(result.replace(",", ""));
            System.out.println(value);
            System.out.println("OCR Result: " + value);
        } catch (Exception e) {
            e.printStackTrace();
        }

		// Calculate absolute screen coordinates
		int x = 1554;
		int y = 548;

		try {
		    robot.mouseMove(x, y);
		    Thread.sleep(100);
		    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		    Thread.sleep(100);
		    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		    Thread.sleep(100);
		    System.out.println("Click successful using Robot");
		    
		    /*robot.keyPress(KeyEvent.VK_1);
		    robot.keyRelease(KeyEvent.VK_1);
		    Thread.sleep(400);
		    robot.keyPress(KeyEvent.VK_SPACE);
		    robot.keyRelease(KeyEvent.VK_SPACE);*/
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
