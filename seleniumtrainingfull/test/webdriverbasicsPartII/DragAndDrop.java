/*We are performing drag and drop action.
 * Here we are using dragAndDrop(sourceEle, targetEle) function of Action class.
 * We can directly pass the draggable web element and droppable web element as an arguments.
 */
/*We can drag an element on web page and drop it on target area.
 * Such actions can be performed by Actions class.
 * Here, we used dragAndDrop(source, target) method to perform the action. 
 */
package webdriverbasicsPartII;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class DragAndDrop {
	WebDriver driver;

	@Test
	public void f() {
		/*
		 * Locating the iFrame section where the draggable and droppable elemets
		 * are present.
		 */
		WebElement iFrame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));

		/* Switching to iFrame section. */
		driver.switchTo().frame(iFrame);

		/*
		 * Locating the source element which we can drag and target area where
		 * we can drop
		 */
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));

		/* Verifying the WebElement's visible text */
		assertEquals("Drag me to my target", source.getText());
		assertEquals("Drop here", target.getText());

		/*
		 * Here we are using creating Action class' object to call the function
		 * for drag and drop. For drag and drop functionality, we are using
		 * dragAndDrop(source, target) method.
		 * 
		 */
		Actions builder = new Actions(driver);
		builder.dragAndDrop(source, target).build().perform();

	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "Assignments\\resources\\chromedriver.exe");
		driver = new ChromeDriver();

		/* Load the given URL in browser */
		driver.get("http://jqueryui.com/droppable/");
		driver.manage().window().maximize();

		/* Using implicit wait to provide time to wait to find web elements */
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@AfterTest
	public void afterTest() {
	}

}
