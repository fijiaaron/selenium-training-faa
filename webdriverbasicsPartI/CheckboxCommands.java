/* We can perform check and uncheck option on checkBox
 * We can check whether the checkBox is already selected or not using 
 * isSelected() function. The purpose of this test is to check the 
 * first checkbox and  the second checkbox.
 */
package webdriverbasicsPartI;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class CheckboxCommands {
	WebDriver driver;

	@Test
	public void testCheckbox() {
		/* Load the URL using get(URL) method */
		driver.get("http://the-internet.herokuapp.com/checkboxes");
		driver.manage().window().maximize();

		/*
		 * Using findElement() method we are locating web element on the web
		 * page using XPATH as a locating technique
		 */
		WebElement checkBox1 = driver.findElement(By
				.xpath("//form[@id='checkboxes']/input[1]"));
		WebElement checkBox2 = driver.findElement(By
				.xpath("//form[@id='checkboxes']/input[2]"));

		/*
		 * We can check the given check-box is selected or not using
		 * isSelected() function. It retrieves TRUE or FALSE value
		 */
		boolean firstCheckboxStatus = checkBox1.isSelected();
		System.out.println("First Checkbox is selected? : "
				+ (firstCheckboxStatus ? "Yes" : "No"));

		boolean secondCheckboxStatus = checkBox2.isSelected();
		System.out.println("Second Checkbox is selected? : "
				+ (secondCheckboxStatus ? "Yes" : "No"));

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
		 * To select the check box or to uncheck already checked check-box we
		 * use click() method. The purpose of current test is to check the first
		 * checkbox and uncheck the second checkbox
		 */
		if (!firstCheckboxStatus)
			checkBox1.click();
		if (secondCheckboxStatus)
			checkBox2.click();

		/* Verifying whether check-box is checked/unchecked or not */
		System.out.println("First Checkbox is selected? : "
				+ (checkBox1.isSelected() ? "Yes" : "No"));
		System.out.println("Second Checkbox is selected? : "
				+ (checkBox2.isSelected() ? "Yes" : "No"));

	}

	@BeforeMethod
	public void beforeTest() {
		
		System.setProperty("webdriver.gecko.driver",
				"test\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();

	}

	@AfterMethod
	public void afterTest() {
		/*
		 * The driver.quit() is commented just that one can see the checkbox clicks have changed.
		 */
		// driver.quit();
	}

}
