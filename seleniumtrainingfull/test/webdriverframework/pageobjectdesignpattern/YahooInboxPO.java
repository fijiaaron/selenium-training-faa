/*
 * This is Page Object class for Yahoo Inbox page. For detail
 * description of various aspects of Page object, please refer
 * BMICalculationPO.java file. This page object will highlight only 
 * the aspect not mentioned in BMICalculationPO.java. 
 */
package webdriverframework.pageobjectdesignpattern;

import static org.testng.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YahooInboxPO extends LoadableComponent<YahooInboxPO> {
	@FindBy(xpath = "//li[@id='Compose']/button")
	WebElement composeButton;

	@FindBy(id = "to-field")
	WebElement toField;

	@FindBy(id = "subject-field")
	WebElement subjField;

	@FindBy(id = "rtetext")
	WebElement msgBody;

	@FindBy(xpath = "//div[@class='bottomToolbar squeeze-toolbar']/span[1]")
	WebElement sendButton;

	WebDriver driver;
	WebDriverWait wait;
	Actions builder;
	String title = "- Yahoo Mail";

	/*
	 * Typically the drive instance is passed by the page object in which object
	 * of this page object gets invoked.
	 */
	YahooInboxPO(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
		/*
		 * Calling get() is important as it will trigger the isLoaded() method
		 * execution to verify the page is loaded before test starts
		 */
		get();
	}

	/*
	 * Note that composeEmail method returns the current page object. This is a
	 * good practice and provides possibility of chaining multiple methods.
	 */
	public YahooInboxPO composeEmail(String to, String subject, String body) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(composeButton));
		composeButton.click();

		wait.until(ExpectedConditions.visibilityOf(toField));
		toField.clear();
		toField.sendKeys(to);

		subjField.clear();
		subjField.sendKeys(subject);

		msgBody.clear();
		msgBody.sendKeys(body);

		wait.until(ExpectedConditions.visibilityOf(sendButton));
		sendButton.click();
		return this;
	}

	public void close() {
		driver.quit();
	}

	@Override
	protected void load() {
		/*
		 * Nothing required as this page is not directly accessible via url.
		 * Signin action will lend us into this page
		 */
	}

	@Override
	protected void isLoaded() {
		assertTrue(driver.getTitle().contains(title));
	}
}
