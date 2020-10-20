/*
 * This file is created as an examples of 
 * passing parameters from TestNG configuration file to
 * TestNG class file. This file in particular opens the browser
 * based on parameters passed to the method openBrowser()
 */
package testNG.parameters;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

public class ManageDriver {
	
	private static WebDriver driver;
	
	public static void openBrowser(String browser) {
		System.out.println("Inside setBrowser value = " + browser);
		if (browser.equalsIgnoreCase("chrome")) {
			System.out.println("Test will run on Chrome Browser");
			System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
	    	driver = new ChromeDriver();			
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			System.out.println("Test will run on Firefox Browser");
			System.setProperty("webdriver.gecko.driver", "test\\resources\\geckodriver.exe");	
			driver = new FirefoxDriver();
		}
		else if (browser.equals("IE")) {
			System.out.println("Test will run on Internet Explorer Browser");
			System.setProperty("webdriver.ie.driver", "src\\test\\java\\resources\\IEDriverServer.exe");
	    	driver = new InternetExplorerDriver();
	    	
		}	
		else 
		{
			System.out.println("Test will run on Firefox Browser as Default Browser");
			System.setProperty("webdriver.gecko.driver", "test\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
    	
	}
  
    public static WebDriver driver() {
    	return driver;
    }  
        
    public static void open(String url) {
    	driver.manage().window().maximize();
    	driver.get(url); 
       
     }

    public static void close() {
       driver.quit();
    }
}
