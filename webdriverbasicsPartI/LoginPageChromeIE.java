/*
 * This Test demonstrates how to execute tests using 
 * Chrome and Internet Explorer browser.
 */
package webdriverbasicsPartI;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;

public class LoginPageChromeIE {
	WebDriver driver;

	@Test
	public void loginWithChromeAndIE() {
		WebElement user = driver.findElement(By.id("username"));

		/*
		 * Calling sendKeys method of WebElement to type "tomsmith" in text box
		 * field
		 */
		user.sendKeys("tomsmith");

		/*
		 * Calling sendKeys() method on password field. Note here WebElement
		 * object is not created and method chaining is used instead. This is
		 * preferred if you are not going perform any other action on the same
		 * text box.
		 */
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		/*
		 * cling on login button.
		 */
		driver.findElement(By.className("radius")).click();

		/*
		 * It is discouraged to use Thread.sleep in our tests. We will
		 * eventually cover how to do away with them. But for this test, check
		 * removing below code and see if the test passes or fails?
		 * Even though, implicit wait is given in @BeforeMethod, still the 
		 * test fails if you do not provide below Thread.sleep()
		 */
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * Verifying after login, "Secure Area" is displayed in at the top.
		 */
		String secureArea = driver.findElement(By.tagName("h2")).getText();

		/*
		 * Verifying expected out with the actual output by checking the value
		 * of some text on the resulting page by using assertEquals() method of
		 * TestNG.
		 */
		assertEquals(secureArea, "Secure Area",
				"Login Failed as text expected is Secure Area while actual value on page is "
						+ secureArea);

		/* Logging out */
		driver.findElement(By.className("secondary")).click();

		/*
		 * It is discouraged to use Thread.sleep in our tests. We will
		 * eventually cover how to do away with them. Thread.sleep below is used
		 * so that you can observe that it has actually logout and then browser
		 * closes.
		*/ 
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@BeforeMethod
	public void beforeMethod() {
		
		/*
		 * Environment variables to be set for each browsers by giving path of the 
		 * driver executables. The below code shows this for each of the browsers
		 */
		
		 System.setProperty("webdriver.gecko.driver",
		 "test\\resources\\geckodriver.exe"); driver = new FirefoxDriver();
		 
		// Chrome Browser
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "test\\resources\\chromedriver.exe"); driver = new ChromeDriver();
		 */
		// IE Browser
/*		System.setProperty("webdriver.ie.driver",
				"test\\resources\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
*/		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://the-internet.herokuapp.com/login");
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
