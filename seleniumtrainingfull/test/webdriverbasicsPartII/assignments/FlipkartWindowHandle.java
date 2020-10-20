/*
 * This example shows how to handle multiple windows
 */
package webdriverbasicsPartII.assignments;

import static org.testng.Assert.*;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class FlipkartWindowHandle {
	WebDriver driver;
	
  @Test
  public void handleFlipkartWindow() {		
		/*
		 * getWindowHandles() returns all the possible window's IDs in the form
		 * of String. We are storing all the IDs in Set.
		 */
		Set<String> allWindowsID = driver.getWindowHandles();
		
		/*
		 * Click on the button which will open new browser window
		.*/
		WebElement winPopUpBtn = driver.findElement(By.xpath(".//*[@id='Window popup']"));
		winPopUpBtn.click();
		try {
			/*
			 * Switching over new opened window.
			 */
			driver.switchTo().window("Flipkart");
			
			/*
			 * Searching "Laptop" on the flipkart website.		
			 */
			WebElement searchField = driver.findElement(By.className("LM6RPg"));
			searchField.sendKeys("Laptop");
			
			driver.findElement(By.className("vh79eN")).click();
	
			/*
			 * It is discouraged to use Thread.sleep in our tests. We will
			 * eventually cover how to do away with them. Thread.sleep below is used
			 * so that you can observe alert actions.
			 */
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			driver.close();
		} catch (NoSuchWindowException e) {
			fail("No Such Window Present!");
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * Using for loop, we are switching over our desired parent window. By
		 * checking condition on each window ID present in Set. 
		 * Even though there is only one window is open by now, the following
		 * demonstrates how you can handle in case there are multiple windows
		 */
		for (String currentWinID : allWindowsID) {
			if (driver.switchTo().window(currentWinID).getTitle().equals("Learn JavaScript Alerts")) {
				driver.quit();
			}
		}
  }
  
  
  @BeforeTest
  public void beforeTest() {
	  /* Firefox Browser */
		System.setProperty("webdriver.gecko.driver", "test\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();

		/* Load the given HTML file using it's location */
		driver.get("file:///C:/Users/Admin/Dropbox/Paratus/SimpliLearn/SimpliLearnExamples/webdrivertraining/test/resources/HTMLpages/JSAlertsExamples.html");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @AfterTest
  public void afterTest() {
  }

}
