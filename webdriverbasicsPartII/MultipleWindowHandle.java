/* We can handle multiple pop-up windows in Selenium.
 * Here, we are switching from parent window to new opened window and performing actions.
 * Using getWindowHandle and getWindowHandles() we can switch to multiple windows.
 */
package webdriverbasicsPartII;

import static org.testng.Assert.*;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class MultipleWindowHandle {
	WebDriver driver;

	@Test
	public void handleMultipleWindow() {
		/*
		 * Getting and storing the parent window's ID. getWindowHandle() method
		 * returns current window's ID in the form of string. It is useful to
		 * switch back to parent window from pop-up window.
		 */
		String parentWindowID = driver.getWindowHandle();

		/* Click on Thanks button to open linked pop-up window. */
		WebElement thanksButton = driver.findElement(By
				.xpath(".//*[@id='gotit']/input"));
		thanksButton.click();

		try {
			/*
			 * Switching over new opened window by passing window name as an
			 * argument in switchTo.window() function.
			 */
			driver.switchTo().window("JSAlertsExamples");

			/* Clicking on the button which is present on new opened window. */
			WebElement nextPageBtn = driver.findElement(By.id("simple"));
			nextPageBtn.click();

			/*
			 * It is discouraged to use Thread.sleep in our tests. We will
			 * eventually cover how to do away with them. Thread.sleep below is
			 * used so that you can observe alert actions.
			 */

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			/*
			 * Switching over the alert to perform actions on it.
			 */
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
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.close();
		} catch (NoSuchWindowException e) {

		}
		/* Switching back to parent window from opened new window. */
		driver.switchTo().window(parentWindowID);
		System.out.println(driver.getTitle());

		/* Verifying the parent window's title */
		assertEquals("Handle Multiple Windows", driver.getTitle());

	}

	@BeforeTest
	public void beforeTest() {
		/* Firefox Browser */
		System.setProperty("webdriver.gecko.driver",
				"test\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();

		/* Load the given HTML file using it's location */
		driver.get("file:///C:/Users/Admin/Dropbox/Paratus/SimpliLearn/SimpliLearnExamples/webdrivertraining/test/resources/HTMLpages/Multiple Windows.html");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterTest
	public void afterTest() {
	}

}
