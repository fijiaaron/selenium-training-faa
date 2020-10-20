/* We are dealing with normal drop down using Select Class. 
 * In drop down, we can select and de-select only one option at a time by using
 * selectByVisibleText(), selectByValue(),selectByIndex(). 
 * Here, we are also using getOptions(), isMultiple(), getOptions.size() functions.
 */
package webdriverbasicsPartI;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class DropDownSelect {
	WebDriver driver;

	@Test
	public void f() {

		driver.get("https://login.yahoo.com/account/create?");
		driver.manage().window().maximize();
		/*
		 * Month Drop down
		 */
		WebElement month = driver.findElement(By.id("usernamereg-month"));
		/*
		 * We are creating object of Select Class by passing drop down
		 * webElement as an argument
		 */
		Select monthDropDown = new Select(month);
		/*
		 * verify that it is a drop down and not multi select
		 */
		assertFalse(monthDropDown.isMultiple());
		/*
		 * Day Drop down
		 */
		WebElement day = driver.findElement(By.id("usernamereg-day"));
		Select dayDropDown = new Select(day);
		/*
		 * Year Drop down
		 */
		WebElement year = driver.findElement(By.id("usernamereg-year"));
		Select yearDropDown = new Select(year);

		System.out.println("Number of months in the drop down are : "
				+ monthDropDown.getOptions().size());
		/*
		 * verify if the number of options are 13
		 */
		assertEquals(13, monthDropDown.getOptions().size());

		/*
		 * To retrieve the by default selected option in the drop down, we used
		 * getFirstSelectedOption().getText() methods and printing the option
		 * name
		 */
		String selectedOption = monthDropDown.getFirstSelectedOption()
				.getText();
		System.out.println("By default selected option is : " + selectedOption);

		/*
		 * We can select drop down option using
		 * selectByVisibleText("OptionName")
		 */
		monthDropDown.selectByVisibleText("December");

		/* We can select drop down option using selectByValue("OptionValueName") */
		dayDropDown.selectByValue("15");

		/* We can select drop down option using selectByIndex(indextNo) */
		yearDropDown.selectByIndex(26);

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
		 * Here in the List of WebElement type, we are storing all the options
		 * present in the drop down. Using for loop, we are checking every
		 * option to match the given condition. After successful match of option
		 * and the condition, it will select that option using click() function.
		 */

		List<WebElement> allMonthsOptions = monthDropDown.getOptions();

		for (WebElement currentMonth : allMonthsOptions) {
			if (currentMonth.getText().equals("March")) {
				currentMonth.click();
				break;
			}
		}

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
