package theinternet;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends SeleniumTest
{
	LoginPage loginPage;
	
	@BeforeMethod
	public void setup()
	{
		super.setup();
		loginPage = new LoginPage(driver);
	}
	
	@Test
	public void loginSuccess()
	{
		loginPage.login("tomsmith", "SuperSecretPassword!");
	  
		String message = loginPage.getMessage();
		
		assertEquals(message, "You logged into a secure area!\n×");
	}
	
	@Test
	public void loginFailure()
	{	
		loginPage.login("tomsmith", "SuperDuperWrongPassword!");
	    
		String message = loginPage.getMessage();
		
		assertEquals(message, "Your password is invalid!\n×");
	}
}
