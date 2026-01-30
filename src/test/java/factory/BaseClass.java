package factory;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass {

		 public static WebDriver driver;
	     static Properties p;
	     static ChromeOptions optionsChrome;
	     static EdgeOptions optionsEdge;
	     	  	     
	public static WebDriver initializeBrowser() throws IOException
	{
		optionsChrome = new ChromeOptions();
		LoggingPreferences logPrefs = new LoggingPreferences();
		logPrefs.enable(LogType.BROWSER, Level.ALL);
		optionsChrome.setCapability("goog:loggingPrefs", logPrefs);
		optionsChrome.setExperimentalOption("excludeSwitches", java.util.Collections.singletonList("enable-automation"));
		optionsChrome.setExperimentalOption("useAutomationExtension", false);
		/*optionsChrome.addArguments("--headless=new");
		optionsChrome.addArguments("window-size=1920,1080");
		optionsChrome.addArguments("--disable-gpu");
		optionsChrome.addArguments("--no-sandbox");*/

		// preferences to disable Chrome password manager
	    Map<String, Object> prefs = new HashMap<>();
	    prefs.put("credentials_enable_service", false);
	    prefs.put("profile.password_manager_enabled", false);
	    optionsChrome.setExperimentalOption("prefs", prefs);
		
		optionsEdge = new EdgeOptions();
		optionsEdge.setExperimentalOption("excludeSwitches", 
		    java.util.Collections.singletonList("enable-automation"));
		
		
		p = getProperties();
        String executionEnv = p.getProperty("execution_env");
        String browser = p.getProperty("browser").toLowerCase();
        String os = p.getProperty("os").toLowerCase();
		
		if(executionEnv.equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			//os
			 switch (os) {
             case "windows":
                 capabilities.setPlatform(Platform.WINDOWS);
                 break;
             case "mac":
                 capabilities.setPlatform(Platform.MAC);
                 break;
             case "linux":
                 capabilities.setPlatform(Platform.LINUX);
                 break;
             default:
                 System.out.println("No matching OS");
                 return null;
            }
			
			//browser
			 switch (browser) {
             case "chrome":
                 capabilities.setBrowserName("chrome");
                 break;
             case "edge":
                 capabilities.setBrowserName("MicrosoftEdge");
                 break;
             case "firefox":
                 capabilities.setBrowserName("firefox");
                 break;
             default:
                 System.out.println("No matching browser");
                 return null;
             }
	       
	        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
			
		}
		else if(executionEnv.equalsIgnoreCase("local"))
			{
				switch(browser.toLowerCase()) 
				{
				case "chrome":
			        driver=new ChromeDriver(optionsChrome);
			        break;
			    case "edge":
			    	driver=new EdgeDriver(optionsEdge);
			        break;
			    case "firefox":
			    	driver=new FirefoxDriver();
			        break;
			    default:
			        System.out.println("No matching browser");
			        driver=null;
				}
			}
		 driver.manage().deleteAllCookies(); 
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		 
		 return driver;
		 
	}
	
	public static WebDriver getDriver() {
			return driver;
		}

	public static Properties getProperties() throws IOException
	{		 
        FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
       	p=new Properties();
		p.load(file);
		return p;
	}
	
	
	public static String getTimeStamp() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String timestamp = now.format(formatter);
        System.out.println("Current Timestamp: " + timestamp);
		return timestamp;
    }
	
	
	
	/*public static String randomeString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	
	public static String randomeNumber()
	{
		String generatedString=RandomStringUtils.randomNumeric(10);
		return generatedString;
	}
	
		
	public static String randomAlphaNumeric()
	{
	String str=RandomStringUtils.randomAlphabetic(5);
	 String num=RandomStringUtils.randomNumeric(10);
	return str+num;
	}*/
	
	
}
