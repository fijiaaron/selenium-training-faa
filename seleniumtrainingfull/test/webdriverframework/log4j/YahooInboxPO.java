package webdriverframework.log4j;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	YahooInboxPO(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}

	public void composeEmail(String to)
	{
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(composeButton));
		composeButton.click();
		composeButton.click();
		
		wait.until(ExpectedConditions.visibilityOf(toField));
		toField.clear();
		toField.sendKeys(to);
		
		subjField.clear();
		subjField.sendKeys("test message");
		
		msgBody.clear();
		msgBody.sendKeys("Hi,\nThis is test message.\n\nThanks,\nSai");
		
		uploadButton.click();
		
		wait.until(ExpectedConditions.visibilityOf(sendButton));
		sendButton.click();
	}
	
	@SuppressWarnings("deprecation")
	public void logoutYahoo()
	{
		builder = new Actions(driver);
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(profileButton));
		builder.moveToElement(profileButton).pause(3000).click(signOutButton).build().perform();
		
	}
	
	@Override
	protected void load()
	{
		
	}
	@Override
	protected void isLoaded()
	{
		
	}

}
