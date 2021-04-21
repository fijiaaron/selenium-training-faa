/*
 * This program demonstrates how to select/deselect a checkbox.
 * 
 */

package webdriverbasicsPartI.assignments;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class YahooSignIn {

	WebDriver driver;

	@BeforeMethod()
	public void setUp() {

		System.setProperty("webdriver.gecko.driver",
				"test\\resources\\geckodriver.exe");
		// System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
		// System.setProperty("webdriver.ie.driver", "test\\resources\\IEDriverServer.exe");
		driver = new FirefoxDriver();
		// driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver = new InternetExplorerDriver();

		driver.get("http://www.yahoomail.com");
	}

	@Test
	public void testYahooLogin() {
		driver.findElement(By.id("login-username")).sendKeys("j.apurva");
		WebElement signIn = driver.findElement(By.id("persistent"));

		/*
		 * It is always required that you check whether the checkbox is already
		 * selected then only uncheck if you want to uncheck the checkbox. But
		 * if the requirement was to check the checkbox then you will ahve to
		 * write if (!signIn.isSelected()) click(); instead of what is mentioned
		 * below.
		 */
		if (signIn.isSelected())
			signIn.click();

		driver.findElement(By.id("login-signin")).click();

		/* 
		 * explicit wait - to wait for few seconds for textbox 'password' to be
		 * visible.
		 */
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.id("login-passwd")));

		driver.findElement(By.id("login-passwd")).sendKeys("paratus123");
		driver.findElement(By.id("login-signin")).click();
		assertTrue(driver.getTitle().contains("- Yahoo Mail"));
	}

	@AfterMethod
	public void tearDown() {
		/*
		 * You can comment the below line if you want see whether login happened
		 * and want to look at the page content. Otherwise, will close fast and
		 * you may not be able to observe whether actuall login happened.
		 */
		driver.quit();
	}

}
