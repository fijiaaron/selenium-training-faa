/*
 * This is a Page Object class for Yahoo SignIn page.
 * For detail description of various aspects of Page object, 
 * please refer BMICalculationPO.java file. 
 * This page object will highlight only the aspect 
 * not mentioned in BMICalculationPO.java. 
 */
package webdriverframework.pageobjectdesignpattern;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	@Override
	public void load()
	{
		this.driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Override
	public void isLoaded()
	{
		assertTrue(driver.getTitle().equals(title));
	}
	/*
	 * Note that yahooSignIn() method returns the YahooInboxPO object.
	 * This is simulating the web application behaviour, where clicking
	 * on signIn button takes us to the new page. 
	 */
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
