/*We can perform hover action of mouse cursor using moveToElement(element) method.
 * moveToElement(element) is method of Action class.
 */
package webdriverbasicsPartII;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class HoverAndClickTest {
	WebDriver driver;
	Actions builder;
  
@Test
  public void f() {
	  driver.get("http://swisnl.github.io/jQuery-contextMenu/demo/trigger-hover.html");
	 // driver.manage().window().maximize();
	  
	  WebElement hoverMeBtn = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
	  builder = new Actions(driver);
	  System.out.println(hoverMeBtn.getText());
	  builder.moveToElement(hoverMeBtn).pause(3000);
	  builder.build().perform();;
	  
	  /*
	  builder.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN);
	  builder.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN);
	  builder.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER);
	  builder.build().perform();
	  
	  try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  */
	  try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  WebElement delete = driver.findElement(By.xpath("html/body/ul/li[5]"));
	  builder.moveToElement(delete).pause(2000).click(delete).build().perform();
	  try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  Alert alert = driver.switchTo().alert();
	  alert.accept();  
  }
  
  @BeforeTest
  public void beforeTest() {
	// Firefox Browser
		//	System.setProperty("webdriver.gecko.driver", "Assignments\\resources\\geckodriver.exe");
		//	driver = new FirefoxDriver();

			// Chrome Browser
			
			 System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe"); 
			 driver = new ChromeDriver();
			 

			// IE Browser
			  /* System.setProperty("webdriver.ie.driver",
				* "Assignments\\resources\\IEDriverServer1.exe");
				* driver = new InternetExplorerDriver();
				*/
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @AfterTest
  public void afterTest() {
	//  driver.quit();
  }

}
