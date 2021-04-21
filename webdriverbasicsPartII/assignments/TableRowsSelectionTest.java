/*Here we are dealing with Web Table present in the iFrame.
 * We are selecting multiple rows using CTRL key.
 * Verifying the no. of selected rows with our expectation.
 */
package webdriverbasicsPartII.assignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class TableRowsSelectionTest {
	WebDriver driver;

	@Test
	public void f() {
		/* Clicking on Row drop down option to expand for sub-options */
		WebElement rowTypeSelect = driver.findElement(By.xpath(".//*[@id='doc']/div/nav/ul/li[4]/a"));
		rowTypeSelect.click();

		/*
		 * Selecting Select and Hover Row type from the expanded sub-menu. To
		 * get actual web table
		 */
		WebElement selectAndHoverType = driver.findElement(By.xpath("//li[@class='sub_menu opened']/ul/li[3]/a"));
		selectAndHoverType.click();

		/* Switching to iFrame where the actual Web Table is present. */
		WebElement tableiFrame = driver.findElement(By.xpath("//div/iframe[@id='jqxInnerdemoContainer']"));
		driver.switchTo().frame(tableiFrame);

		/*
		 * Listing all the row web elements into the List using
		 * findElements(By,xpath("")) locating tech.
		 */
		List<WebElement> AllRowsOfTable = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
		System.out.println(AllRowsOfTable.size());

		/* We are using Actions class to select the rows using CTRL key */
		Actions builder = new Actions(driver);
		builder.click(AllRowsOfTable.get(1)) /* 1st Row selected */
		       .keyDown(Keys.CONTROL)
			   .click(AllRowsOfTable.get(3)) /* 3rd Row selected */
		       .click(AllRowsOfTable.get(6)) /* 6th Row selected */
		       .keyUp(Keys.CONTROL);
		Action selectMultipleRows = builder.build();
		selectMultipleRows.perform();

		/* Here we get total number of selected Rows. */
		int selectedRowCount = driver
				.findElements(By.xpath("//table/tbody/tr/td[1][contains(@class,'jqx-grid-cell-selected')]")).size();

		/* We are verifying the toatl no. of selected rows Vs our expected. */
		assertEquals(3, selectedRowCount);

	}

	@BeforeTest
	public void beforeTest() {
		// Firefox Browser
		System.setProperty("webdriver.chrome.driver", "Assignments\\resources\\chromedriver.exe");
		driver = new ChromeDriver();

		/* Load the given URL in browser. */
		driver.get(
				"http://www.jqwidgets.com/jquery-widgets-demo/demos/jqxdatatable/index.htm#demos/jqxdatatable/javascript-datatable-rows-selection.htm");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterTest
	public void afterTest() {

	}

}
