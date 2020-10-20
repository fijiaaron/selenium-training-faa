package webdriverframework.ddtUsingPOI;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class YahooInboxPO extends LoadableComponent<YahooInboxPO>{
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
	
	@FindBy(id = "attach-btn-menu")
	WebElement uploadButton;
	
	@FindBy(id = "yucs-profile")
	WebElement profileButton;
	
	@FindBy(id = "yucs-signout")
	WebElement signOutButton;
	
	
	WebDriver driver;
	WebDriverWait wait;
	Actions builder;
	String title = "- Yahoo Mail";
	
	YahooInboxPO(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}

	public YahooInboxPO composeEmail(String to, String subject, String body)
	{
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(composeButton));
		composeButton.click();
		composeButton.click();
		
		wait.until(ExpectedConditions.visibilityOf(toField));
		toField.clear();
		toField.sendKeys(to);
		
		subjField.clear();
		subjField.sendKeys(subject);
		
		msgBody.clear();
		msgBody.sendKeys(body);
		
		uploadButton.click();
		
		wait.until(ExpectedConditions.visibilityOf(sendButton));
		sendButton.click();
		return this;
	}
	
	@Override
	protected void load()
	{
		
	}
	
	@Override
	protected void isLoaded() {
		assertTrue(driver.getTitle().contains(title));
	}

}
