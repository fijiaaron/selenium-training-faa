/*We will see all the WebElement methods to perform multiple action on web page.
 *  WebElement methods like findElement and findElements, getText, getTitle, clear, 
 *  getAttribute, isDisplayed, isEnabled, isSelected() and so on..
 */
package webdriverframework.log4j;

import org.testng.annotations.Test;
import org.w3c.dom.DOMConfiguration;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class BMICalculateLogTest {
	WebDriver driver;
	
  @Test
  public void bmiLogTest() {
	    
	  /*Find webElements of we pages using findElement() function and ID as a locating technique. 	   */
	  WebElement cmField = driver.findElement(By.id("cm"));
	  WebElement kgField = driver.findElement(By.id("kg"));
	  WebElement metricBMIButton = driver.findElement(By.id("sm"));
	  
	  /* sendKeys() function is used to insert data into the input fields. */
	  cmField.sendKeys("180");
	  Log.info("Height is entered in the height field.");
	  
	  kgField.sendKeys("78");
	  Log.info("Weight is entered in the weight field.");
	  
	  try {
		  /* click() method is used to perform click action on the button. */
		  metricBMIButton.click();
		  Log.info("Clicked on the Calculate BMI button");
		  
	} catch (Exception e) {
		Log.error("Clickable button is not found!");
	}
	  
	  Log.endTestCase("bmiLogTest");
	  
	  
  }
  @BeforeTest
  public void beforeTest() throws Exception {
	/* Firefox Browser*/
			System.setProperty("webdriver.gecko.driver", "test\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();

			DOMConfigurator.configure("log4jconfiguration.xml");
			Logger Log1 = Logger.getLogger(BMICalculateLogTest.class.getName());
			Log.startTestCase("bmiLogTest");
	
			Log1.fatal("This is logging Fatal Error");
			Log1.warn("This is warning Logged");		
	
			/*Load the URL in browser*/
			driver.get("http://www.calcbmi.com/");
		    driver.manage().window().maximize();
			
			
  }

  @AfterTest
  public void afterTest() {
  }

}
