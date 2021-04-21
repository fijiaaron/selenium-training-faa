/*
 * This file has two tests which opens different website.
 * This is created to demonstrate parallel execution of methods.
 */
package testNG.withSites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class MultipleSites {
  private WebDriver driver;
  
  @Test
  public void makeMyTrip() {
	  driver.get("http://www.makemytrip.com");
  }
  
  @Test
  public void bookMyShow() {
	  driver.get("http://www.bookmyshow.com");
  }
  
  
  @BeforeMethod
  public void beforeClass() {
	System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
	driver = new ChromeDriver();  
  }

  @AfterMethod
  public void afterClass() {
  }

}
