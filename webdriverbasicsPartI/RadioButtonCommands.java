/* For Radio button, we can select radio button only once.
 * We can not de-select already selected radio button. 
 * Only one radio button can be selected in a single group.
 */
package webdriverbasicsPartI;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class RadioButtonCommands {
	WebDriver driver;
	
  @Test
  public void testRadioButtons() {
	  /*Load the URL using get(URL) method */
	  driver.get("http://www.calcbmi.com/");
	  driver.manage().window().maximize();
	  
	  /*Using findElement() method we are locating web element on the web page 
	   * using XPATH as a locating technique
	   */
	  WebElement radioButton1 = driver.findElement(By.id("ctw"));
	  WebElement radioButton2 = driver.findElement(By.id("ctb"));
	  
	  /* We can check the given radio button is selected or not using isSelected() function. 
	   * It retrieves TRUE or FALSE value
	   */
	  boolean firstRadioButtonStatus = radioButton1.isSelected();
	  System.out.println("First radio button  is selected ? "+ (firstRadioButtonStatus? "Yes" : "No"));
	  
	  boolean secondRadioButtonStatus = radioButton2.isSelected();
	  System.out.println("Second radio button  is selected ? "+ (secondRadioButtonStatus? "Yes" : "No"));
	  
	 /*
		 * It is discouraged to use Thread.sleep in our tests. 
		 * We will eventually cover how to do away with them. 
		 * Thread.sleep below is used so that you can 
		 * observe that it has actually changes the option from
		 * first radio button to the next.
		 */
	  try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  /* 
	   * To select the radio button we use click() method. 
	   * Here we can not deselect the already selected radio button.
	   */
	  if (!secondRadioButtonStatus)
	     radioButton2.click();
	  
	  /*Verifying whether radio button is selected or not*/ 
	  System.out.println("First radio button  is selected ? "+ (radioButton1.isSelected()? "Yes" : "No"));
	  System.out.println("Second radio button  is selected ? "+ (radioButton2.isSelected()? "Yes" : "No"));
  }

  @BeforeMethod
  public void beforeTest() {
	 
		System.setProperty("webdriver.gecko.driver", "test\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
  }

  @AfterMethod
  public void afterTest() {
  }

}
