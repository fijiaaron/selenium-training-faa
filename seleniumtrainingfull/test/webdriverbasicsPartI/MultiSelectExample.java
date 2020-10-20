/* We are dealing with Combo drop down box using Select Class. 
 * In Combo, we can select and de-select more than one options using click() method. 
 * Here, we are using getOptions(), isMultiple(), getOptions.size() functions.
 */
package webdriverbasicsPartI;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class MultiSelectExample {
	WebDriver driver;

	@Test
	public void dropdownTests() {
		/* Load the current URL */
		driver.get("http://cookbook.seleniumacademy.com/Config.html");
		driver.manage().window().maximize();

		/* We are locating the drop down using xpath locator technique */
		WebElement colors = driver.findElement(By
				.xpath("//select[@name='color']"));

		/*
		 * We are creating object of Select Class by passing drop down
		 * webElement as an argument
		 */
		Select colorSelect = new Select(colors);

		/*
		 * getOptions.size() function returns the total no. options present in
		 * the drop down.
		 */
		System.out.println("Number of options in Colors Multi Select is : "
				+ colorSelect.getOptions().size());

		assertEquals(5, colorSelect.getOptions().size());

		/*
		 * Here, we are checking the given drop down is combo box or not.
		 * isMultiple() returns the boolean value (TRUE or FALSE) TURE = It is
		 * Combo drop down (we can select multiple options.) FALSE = it is
		 * normal drop down. (Select one option at a time.)
		 */
		assertTrue(colorSelect.isMultiple());

		/*
		 * Storing all the options of drop down in the List of type WebElement
		 * Printing them sequentially by using for loop.
		 */
		List<WebElement> allColorOptions = colorSelect.getOptions();
		for (int i = 0; i < colorSelect.getOptions().size(); i++) {
			System.out
					.println("Option is: " + allColorOptions.get(i).getText());
		}

		/*
		 * Like normal dropDown, we can select options in Combo dropDown by
		 * Value, VisibleText, Index. Here we are selecting multiple options by
		 * performing click() operation.
		 */
		colorSelect.selectByValue("rd");
		colorSelect.selectByVisibleText("Silver");

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

		/*
		 * Like normal dropDown, we can select options in Combo dropDown by
		 * Value, VisibleText, Index. Here we are de-selecting the already
		 * selected options.
		 */
		colorSelect.deselectByValue("sl");
		colorSelect.deselectByIndex(2);

	}

	@BeforeMethod
	public void beforeTest() {
		System.setProperty("webdriver.gecko.driver",
				"test\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
	}

	@AfterMethod
	public void afterTest() {
	}

}
