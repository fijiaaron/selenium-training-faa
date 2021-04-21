/*Selecting multiple rows of Web Table.
 * Here we are also verifying the actual no. of selected rows Vs our expected.
 */
package webdriverbasicsPartII;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MultipleRowSelect {
	WebDriver driver;

	@Test
	public void f() {

		/* Storing all the rows of web table into the List. */
		List<WebElement> allRowsOfFirstCol = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[1]"));

		/* Printing the no. of total rows. */
		System.out.println("Size of array: " + allRowsOfFirstCol.size());

		/* by using click() method, we are selecting more than one rows (3) */
		allRowsOfFirstCol.get(2).click();
		allRowsOfFirstCol.get(6).click();
		allRowsOfFirstCol.get(5).click();

		/* We are getting total no. of already selected rows. */
		int totalSelectedRows = driver.findElements(By.xpath("//table/tbody/tr[contains(@class, 'selected')]")).size();
		System.out.println(totalSelectedRows + " row(s) selected");

		/*
		 * Clicking on Row Count button to get the message present on alert and
		 * also printing the message.
		 */
		WebElement rowCountBtn = driver.findElement(By.id("button"));
		rowCountBtn.click();
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println(alertText);

		/* Verifying the number of actual selected rows Vs our expected */

		assertEquals(4, totalSelectedRows);
	}

	@BeforeTest
	public void beforeTest() {
		// Firefox Browser
		System.setProperty("webdriver.gecko.driver", "Assignments\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();

		/* Load the given URL in browser. */
		driver.get("https://datatables.net/examples/api/select_row.html");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterTest
	public void afterTest() {
		// driver.quit();

	}
}
