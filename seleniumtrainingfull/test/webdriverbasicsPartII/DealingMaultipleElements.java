/*We are fetching all the Links present on the web page.
 * Storing in the List.
 *  Printing all the Links one by one using for loop.
 */
package webdriverbasicsPartII;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class DealingMaultipleElements {
	WebDriver driver;

	@Test
	public void f() {

		/* Storing all the Links present on the web page in Lisr */
		List<WebElement> allLinksOnPage = driver.findElements(By.tagName("a"));

		/*
		 * Printing the Links on console in the format Link Name (i.e. visible
		 * text of link) – href
		 */
		for (WebElement currentLink : allLinksOnPage) {
			System.out.println("Link name: " + currentLink.getText() + " ->  " + currentLink.getAttribute("href"));
		}

	}

	@BeforeTest
	public void beforeTest() {
		// Firefox Browser
		System.setProperty("webdriver.gecko.driver", "Assignments\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();

		/* Load the URL in browser */
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();

	}

	@AfterTest
	public void afterTest() {
	}

}
