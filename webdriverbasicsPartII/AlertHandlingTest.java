/*We can handle Alerts in Selenium using Alert class.
 * We can use accesp(), dismiss() and sendKeys() commands.
 * Thread.sleep is used in the program so that alerts actions can 
 * be easily observed. Otherwise they are discouraged to be used in tests
 */
package webdriverbasicsPartII;

import static org.testng.Assert.*;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class AlertHandlingTest {
	WebDriver driver;

	@Test (description = "Test to check Simple Alert")
	public void testSimpleAlert() {

		/* Clicking on the Next button which will open the alert! */
		WebElement nextPageBtn = driver.findElement(By.id("simple"));
		nextPageBtn.click();

		/*
		 * Creating an Object of Alert class to switch on it and perform
		 * actions.
		 */
		try {
			Alert alert = driver.switchTo().alert();

			/*
			 * Get the Text displayed on Alert using getText() method of Alert
			 * class
			 */
			String textOnAlert = alert.getText();
			System.out.println("Test on Alert:  " + textOnAlert);
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/* accept() method is used to click on OK button on alert */
			alert.accept();
			assertEquals("Please enter the email ID, before navigating to next Page", textOnAlert,"Alert Message Not as per Requirements !");
		} catch (NoAlertPresentException e) {
			System.out
					.println("There is a defect as Alert was expected but not there");
			fail("No Alert was found !");
		}
	}

	@Test (description = "Test to check Confirm Alert")
	public void testConfirmAlert() {

		WebElement saveBtn = driver.findElement(By.id("confirm"));
		saveBtn.click();
		try {
			Alert alert = driver.switchTo().alert();

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			alert.accept();
		} catch (NoAlertPresentException e) {
			fail("No Alert Present !");
		}
		assertEquals("You Clicked on OK!",driver.findElement(By.id("saveResult")).getText(),"The result does not match");
		saveBtn.click();
		try {
			Alert alert = driver.switchTo().alert();
			/* dismiss() method is used to click on CANCEL button on alert */
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			alert.dismiss();
		} catch (NoAlertPresentException e) {
			fail("No Alert Present !");
		}
		assertEquals("You Clicked Cancel!",driver.findElement(By.id("saveResult")).getText(),"The result does not match");
	}

	@Test (description = "Test to check Prompt Alert")
	public void testPromptAlert() {

		WebElement promptBtn = driver.findElement(By.id("prompt"));
		promptBtn.click();
		String emailID = "abc@def.com";
		try {
			Alert alert = driver.switchTo().alert();
			/*
			 * sendKeys(String) is used to enter String value into input field
			 * present on the alert.
			 */
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			alert.sendKeys(emailID);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			alert.accept();
			assertEquals("Thanks ! Your Email ID is - "+ emailID,driver.findElement(By.id("email")).getText(),"The result does not match");
		} catch (NoAlertPresentException e) {
			fail("No Alert Present !");
		}

	}

	@BeforeTest
	public void beforeTest() {

		System.setProperty("webdriver.gecko.driver",
				"test\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();

		/* Load the given HTML file using it's location */
		driver.get("file:///C:/Users/Admin/Dropbox/Paratus/SimpliLearn/SimpliLearnExamples/seleniumtrainingexamples/test/resources/HTMLpages/JSAlertsExamples.html");
		driver.manage().window().maximize();
	}

	@AfterTest
	public void afterTest() {
	}

}
