/*
 * This program demonstrates how to make tests belong to groups, 
 * how to create dependencies among groups.
 * 
 */

package testNG.groups;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class YahooSignInDependency {

	WebDriver driver;
	/*
	 * Below method will be executed irrespective of any particular
	 * group or method selected from TestNG configuration file. 
	 */
	@BeforeClass(alwaysRun = true)
	public void setUp() {

		System.setProperty("webdriver.gecko.driver",
				"test\\resources\\geckodriver.exe");
		// System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
		// System.setProperty("webdriver.ie.driver", "test\\resources\\IEDriverServer.exe");
		driver = new FirefoxDriver();
		// driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver = new InternetExplorerDriver();

		
	}
	/*
	 * Below test belongs to two groups URL and Yahoo but
	 * does not depend upon any other groups
	 */
	@Test (groups = {"URL","Yahoo"})
	public void goToYahooMailDOTCom() {
		driver.get("http://www.yahoomail.com");
	}

	/*
	 * Below test belongs to SignIn and Yahoo group but depends on method
	 * goToYahooMailDOTCom
	 */
	@Test (groups = {"signIn","Yahoo"}, dependsOnMethods = "goToYahooMailDOTCom")
	public void testYahooLogin() {
		driver.findElement(By.id("login-username")).sendKeys("j.apurva");
		WebElement signIn = driver.findElement(By.id("persistent"));
		if (signIn.isSelected())
			signIn.click();
		driver.findElement(By.id("login-signin")).click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.id("login-passwd")));

		driver.findElement(By.id("login-passwd")).sendKeys("paratus123");
		driver.findElement(By.id("login-signin")).click();
		wait.until(ExpectedConditions.titleContains(" - Yahoo Mail"));
		assertTrue(driver.getTitle().contains("- Yahoo Mail"));
	}
	
	/*
	 * Below test belongs to Gmail group and depends upon Yahoo group tests.
	 * The test also has a description attribute defined describing something 
	 * about test
	 */
	@Test (dependsOnGroups = "Yahoo",groups="Gmail", description = "Gmail Test")
	public void gmailSingIn() {
		driver.get("http://www.gmail.com");
	}
	
	@Test (enabled = false, dependsOnGroups = "Yahoo",groups="flipKart", description = "Flipkart Test")
	public void flipKartSingIn() {
		driver.get("http://www.gmail.com");
	}

	@AfterClass
	public void tearDown() {
	//	driver.quit();
	}

}
