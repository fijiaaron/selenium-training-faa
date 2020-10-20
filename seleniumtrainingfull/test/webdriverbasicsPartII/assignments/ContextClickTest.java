/*
 * Here we used contextClick() method to perform right click action on element.
 */
package webdriverbasicsPartII.assignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class ContextClickTest {
	WebDriver driver;
	Actions builder;

	@Test
	public void testRightClickByActionsClass() {

		WebElement rightClickBtn = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));

		/* Print the button text */
		System.out.println(rightClickBtn.getText());

		/*
		 * To right click, we used contextClick() method on the webElement.
		 * contextClick() is method of Action class.
		 */
		builder = new Actions(driver);
		builder.contextClick(rightClickBtn).build().perform();
		;

		/*
		 * builder.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER);
		 * builder.build().perform();
		 * 
		 * try { Thread.sleep(2000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		/* OR */

		WebElement editOption = driver.findElement(By.xpath("html/body/ul/li[1]"));
		builder.click(editOption).build().perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver",
				"test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();

		/* Load the given URL in browser. */
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();

		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterTest
	public void afterTest() {
		// driver.quit();
	}

}
