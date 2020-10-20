/*
 * This program demonstrates how to hover mouse cursor on an element.
 * using Action class.
 */
package webdriverbasicsPartII.assignments;

import static org.testng.Assert.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AnnaActionClassAssignment {
	WebDriver driver;

	@BeforeMethod
	public void setUp() throws Exception {
		/* For Chrome Browser */
		System.setProperty("webdriver.chrome.driver",
				"test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();

		/* Load the URL in browser */
		driver.get("https://www.annauniv.edu/");
		driver.manage().window().maximize();

		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@AfterMethod
	public void tearDown() throws Exception {

	}

	@Test
	public void testSimpleAlert() {
		driver.findElement(By.xpath("//a[contains(text(),'Departments')]"))
				.click();
		WebElement civil = driver.findElement(By.name("link13"));

		Actions builder = new Actions(driver);
		WebElement ocean = driver.findElement(By.id("menuItemHilite34"));

		/*
		 * Using moveToElement(WebElement), we can hover cursor on particular
		 * WebElement. Mouse cursor hovers on Civil link.
		 */
		builder.moveToElement(civil).moveToElement(ocean).click().build()
				.perform();

		/* Verifying the title using getTitle() function. */
		assertEquals(
				
				"Institute For Ocean Management - Anna University offers M.Tech in Coastal Management. ENVIS Center for Coastal Zone Management and Coastal Shelterbelts",
				driver.getTitle(),"Comparison of Page Title Failed!");
		WebElement research = driver.findElement(By.id("link3"));
		WebElement coastal = driver.findElement(By.id("menuItemHilite13"));
		/*
		 * mouse hover on element "Research Themes"
		 */
		builder.moveToElement(research).moveToElement(coastal).click().build()
				.perform();
		assertEquals(":: IOM - Institute For Ocean Management - Anna University ::",
				driver.getTitle(),"Comparison of Page Title Failed!");
	}
}