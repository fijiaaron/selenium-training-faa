package theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	WebDriver driver;
	
	@FindBy(id="username")
	WebElement usernameField;
	
	@FindBy(name="password")
	WebElement passwordField;
	
	@FindBy(css=".fa-sign-in")
	WebElement loginButton;
	
	@FindBy(id="flash")
	WebElement flashMessage;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage open()
	{
		driver.get("https://the-internet.herokuapp.com/login");
		return this;
	}
	
	public boolean isLoaded()
	{
		return driver.getCurrentUrl().endsWith("/login");
	}
	
	public void login(String username, String password)
	{
		if (! isLoaded())
		{
			open();
		}
		
	    usernameField.sendKeys(username);
	    passwordField.sendKeys(password);
	    loginButton.click();
	}
	
	public String getMessage()
	{
	    return flashMessage.getText();   
	}
		
}
