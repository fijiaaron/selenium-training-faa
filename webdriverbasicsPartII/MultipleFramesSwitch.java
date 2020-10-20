/*
 * Example of switching from one frame to another. 
 * We can deal with the frames using switchTo.frame() method.
 * We can switch frames by using ID, frame name or index, and 
 * also frame as a WebElement.
 */
package webdriverbasicsPartII;

import static org.testng.Assert.*;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class MultipleFramesSwitch {
	WebDriver driver;

	@Test
	public void testFamesSwitch() {
		/*
		 * Main homepage contains two frames (frame-top and frame-bottom)
		 * Switching over the frame-top which contains other 3 child frames
		 * (frame-left, frame-bottom and frame-right).switchTo().frame()
		 * function is used to switching the frames on web page.Here we used
		 * WebElement to switch on frame.
		 */
		WebElement topFrames = driver.findElement(By
				.xpath("//frame[@name='frame-top']"));
		try {
			driver.switchTo().frame(topFrames);

			/*
			 * We are storing all the child frames present in Top-Frame frame.
			 * Printing the total count of the frames.
			 */
			List<WebElement> alliFrames = driver.findElements(By
					.xpath("//frameset[@name='frameset-middle']/frame"));
			System.out.println("Total no. of iFrames present: "
					+ alliFrames.size());

			/*
			 * Switching to frame-left by passing webElement as an argument
			 */
			WebElement leftiFrame = driver.findElement(By
					.xpath("//frame[@name='frame-left']"));
			driver.switchTo().frame(leftiFrame);

			/*
			 * In the frame-left, Entering a keyword into the input field.
			 */
			WebElement nameField = driver.findElement(By.id("name"));
			nameField.sendKeys("Selenium");

			/*
			 * Switching back to parent frame (top-frame) i.e. coming out of the
			 * child frame.
			 */
			driver.switchTo().parentFrame();

			/*
			 * Switching to frame-middle by passing name of the frame as an
			 * argument.
			 */
			driver.switchTo().frame("frame-middle");
			driver.findElement(By.id("surname")).sendKeys("WebDriver");

			/*
			 * Switching back to parent frame (top-frame) i.e. coming out of the
			 * child frame.
			 */
			driver.switchTo().parentFrame();

			/*
			 * Switching to frame-left by passing index of the frame as an
			 * argument. Index starts from 0. For 3rd frame we are passing here
			 * 2 as a index number.
			 */
			driver.switchTo().frame(2);
			driver.findElement(By.id("yahoo")).click();

			/*
			 * Coming out of all the frames i.e.(Default browser web page)
			 */
			driver.switchTo().defaultContent();
		} catch (NoSuchFrameException e) {
			fail("No Frames Present !");
		}
		System.out.println(driver.getTitle());

	}

	@BeforeTest
	public void beforeTest() {
		/* Firefox Browser */
		System.setProperty("webdriver.gecko.driver",
				"test\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();

		/* Load the HTML page in browser */
		driver.get("file:///C:/Users/Admin/Dropbox/Paratus/SimpliLearn/SimpliLearnExamples/webdrivertraining/test/resources/HTMLpages/Multiple Frames.htm");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterTest
	public void afterTest() {
	}

}
