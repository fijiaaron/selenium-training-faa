/*This Program is not Working on Chrome
 * Actions class is not supporting on FF.
 * */
package webdriverbasicsPartII;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class ContextMenuTest {
	WebDriver driver;
	Actions builder;
	
  @Test
  public void f() {
	  	WebElement contextClickArea = driver.findElement(By.id("hot-spot"));
	  	
	  	builder = new Actions(driver);
	  	
	  	builder.contextClick(contextClickArea);
	  	builder.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN);
	  	builder.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN);
	  	builder.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	  
	  
  }
  @BeforeTest
  public void beforeTest() {
	// Firefox Browser
			System.setProperty("webdriver.gecko.driver", "test\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();

			driver.get("http://the-internet.herokuapp.com/context_menu");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @AfterTest
  public void afterTest() {
		
  }

}
