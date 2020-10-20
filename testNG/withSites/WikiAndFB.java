/*
 * This file is created to show how one can specify a specific method 
 * in a specific class to be executed using TestNG
 */
package testNG.withSites;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.AssertJUnit;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;



//import org.junit.*;
//import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WikiAndFB {
  private WebDriver driver;
  
  	@BeforeClass
  	public void setUpForAllTests(){
/*  	  System.setProperty("webdriver.ie.driver", "test\\resources\\IEDriverServer.exe");
    	driver = new InternetExplorerDriver();*/
  	}
    @BeforeMethod
    public void setUp() throws Exception {
    	System.setProperty("webdriver.ie.driver", "test\\resources\\IEDriverServer.exe");
     	driver = new InternetExplorerDriver();
  
//	System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
//  	driver = new ChromeDriver();
//  	
//    System.setProperty("webdriver.ie.driver", "test\\resources\\IEDriverServer.exe");
//  	driver = new InternetExplorerDriver();
	  
	  
	//  driver = new FirefoxDriver();
  //  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test (alwaysRun = true)
  public void testForWiki() throws Exception {
    driver.get("http://www.wikipedia.org");

  }

  @Test
  public void testForFB() throws Exception {
    	  driver.get("http://www.facebook.com");

  }
  @AfterMethod
public void tearDown() throws Exception {
   // driver.quit();

  }
}

