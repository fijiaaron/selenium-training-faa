/*
 * Loading page using WebDriver, maximizes the browser window.
 * Inserting keyword in search filed and clicking on the search button.
 * Storing all the search result links in List and printing the search result count.
 */
package webdriverbasicsPartI;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class WebdriverCommands {
	WebDriver driver;

	@Test
	public void testBrowserCommands() {
		/* Load the URL in browser */
		driver.get("https://in.yahoo.com/");

		/*
		 * We can perform many actions on browser window using manage().window()
		 * Maximize the window using maximize() function.
		 */
		driver.manage().window().maximize();

		/* Get the page title using getTitle() method. */
		String pageTitle = driver.getTitle();
		System.out.println("Page Title is:" + pageTitle);

		/*
		 * Enter in Search field “Selenium” and click on search button To locate
		 * the WebElements (search field and search button), we used
		 * findElement() method and we are locating these elements using their
		 * id attributes.
		 */
		WebElement searchField = driver.findElement(By.id("uh-search-box"));
		searchField.sendKeys("Selenium");
		WebElement searchButton = driver.findElement(By.id("uh-search-button"));
		/*
		 * click() method is used to click on the WebElement (searchButton).
		 */

		searchButton.click();

		/*
		 * Print current page URL getCurrentUrl() retrieves current page URL in
		 * the form of String.
		 */
		String currentURL = driver.getCurrentUrl();
		System.out.println("Current page URL:" + currentURL);

		/*
		 * using findElements() function, We are storing all search result URLs
		 * in a List of WebElement type.
		 */
		List<WebElement> allSearchResults = driver
				.findElements(By.tagName("a"));
		/*
		 * size() function returns integer type (no. of WebElements present in
		 * the list)
		 */
		int noOfSearchresults = allSearchResults.size();

		System.out.print("The number of search results on the page:" + noOfSearchresults);

	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.gecko.driver",
				"test\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
