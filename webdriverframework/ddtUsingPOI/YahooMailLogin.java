package webdriverframework.ddtUsingPOI;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class YahooMailLogin extends LoadableComponent<YahooMailLogin>{
	@FindBy(id="login-username")
	WebElement emailField;
	
	@FindBy(id="login-passwd")
	WebElement passWordField;
	
	@FindBy(id="login-signin")
	WebElement signInButton;
	
	WebDriver driver;
	WebDriverWait wait;
	String url = "http://yahoomail.com/";
    String title = "Yahoo - login";
	
	public YahooMailLogin(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void load()
	{
		this.driver.get(url);
		driver.manage().window().maximize();
	}
	
	public void isLoaded()
	{
		assertTrue(driver.getTitle().equals(title));
	}
	
	public YahooInboxPO yahooSignIn(String userID, String passWord)
	{
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(emailField));
		emailField.clear();
		emailField.sendKeys(userID);
		signInButton.click();
		wait.until(ExpectedConditions.visibilityOf(passWordField));
		passWordField.sendKeys(passWord);
		signInButton.click();
		YahooInboxPO myInbox = new YahooInboxPO(driver);
		return myInbox;
	}

}
