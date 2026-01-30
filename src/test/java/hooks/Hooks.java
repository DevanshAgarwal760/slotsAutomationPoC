package hooks;

import java.awt.AWTException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import Utilities.WaitUtils;
import commonTestMethods.CommonFunctions;
import factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import pageObjects.SuribetHome;


public class Hooks 
{

	 public static Properties p;
     static SuribetHome sh;
     TakesScreenshot ts;
     byte[] screenshot;
     public static String scen;
     //private static final long TIMEOUT_MINUTES = 5;
     private static final ExecutorService executor = Executors.newCachedThreadPool();

     
	
	@BeforeAll
    public static void setup() throws IOException, InterruptedException
    {
    	BaseClass.driver=BaseClass.initializeBrowser();
    	    	
    	p=BaseClass.getProperties();
    	login();
    			
	}
	
	@Before
    public void beforeScenario(Scenario scenario) {
		scen=scenario.getName();
    }
	
	//Runs after each scenario
	@After
	public void closeIFrame(Scenario scenario) throws AWTException, InterruptedException 
	{
		scen=scenario.getName();
		CommonFunctions.closeIFrame();
		BaseClass.driver.switchTo().defaultContent();
		BaseClass.driver.switchTo().defaultContent();
	}
		
    
    @AfterAll
    public static void tearDown() {
        		
    	BaseClass.driver.quit();
       
    }
    
    /*@BeforeStep
    public void takeScreenshot() 
    {
    	TakesScreenshot ts=(TakesScreenshot) BaseClass.driver;
        screenshot=ts.getScreenshotAs(OutputType.BYTES);
    }*/
    
    @AfterStep
    public void addScreenshot(Scenario scenario) 
    {
        
    	// this is for cucumber report
        if(scenario.isFailed()) 
        {
        	TakesScreenshot ts=(TakesScreenshot) BaseClass.driver;
            screenshot=ts.getScreenshotAs(OutputType.BYTES);
        	scenario.attach(screenshot, "image/png",scenario.getName());
        	LogEntries logs = BaseClass.driver.manage().logs().get(LogType.BROWSER);
        	String logFilePath = System.getProperty("user.dir")+"\\target\\logs\\" + scenario.getName().replaceAll("[^a-zA-Z0-9]", "_") + ".txt";

            writeLogsToFile(logs, logFilePath);
            attachLogFileToScenario(scenario, logFilePath);
        }
        
      
    }
    
    public void writeLogsToFile(LogEntries logs, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (LogEntry entry : logs) {
                writer.write(entry.getLevel() + " " + entry.getMessage() + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void attachLogFileToScenario(Scenario scenario, String filePath) {
        try {
            byte[] logBytes = Files.readAllBytes(Paths.get(filePath));
            scenario.attach(logBytes, "text/plain", "browser-logs.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void login() throws InterruptedException 
    {
    	sh=new SuribetHome(BaseClass.driver);
    	String url=p.getProperty("appURL");
    	String accID=p.getProperty("accID");
    	String accPwd=p.getProperty("accPwd");
    	BaseClass.driver.get(url);
    	sh.set_accountID_box(accID);
    	sh.set_accountPwd_box(accPwd);
    	sh.click_login_btn();
    	//BaseClass.driver.findElement(By.xpath("//input[@placeholder='Password / Card Pin']")).sendKeys(accPwd);
    	//BaseClass.driver.findElement(By.xpath("//input[@class='loginActive']")).click();
		////i[@ng-click='DayValShow=false']
		// click on upload document pop up
		WebElement upload=BaseClass.driver.findElement(By.xpath("//i[@ng-click='ShowUpdateCusDocupl=false']"));
		WebElement auth=BaseClass.driver.findElement(By.xpath("//button[@ng-click='CloseEnable2FA(false)']"));
		WaitUtils.safeSleep(1000);
		if(upload.isDisplayed()) 
		{
			upload.click();
			WaitUtils.safeSleep(1000);
		}
		if(auth.isDisplayed()) 
		{
			auth.click();
			WaitUtils.safeSleep(1000);
		}
		
    }
   
}