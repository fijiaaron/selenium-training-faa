package theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage
{
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void setUsername(String username)
	{
		WebElement usernameField = driver.findElement(By.id("username"));
	    usernameField.sendKeys(username);
	}

	public void setPassword(String password)
	{
	    WebElement passwordField = driver.findElement(By.id("password"));
	    passwordField.sendKeys(password);
	}

	public SecurePage clickLogin()
	{
	    WebElement loginButton = driver.findElement(By.cssSelector("#login button"));
	    loginButton.click();
	    
	    return new SecurePage(driver);
	}
}
