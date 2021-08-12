package theinternet;

import static org.assertj.core.api.Assertions.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import framework.SeleniumTest;

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
	public void loginSuccess(String browser)
	{
		System.out.println("browser:" + browser);
		loginPage.login("tomsmith", "SuperSecretPassword!");
	  
		String message = loginPage.getMessage();
		assertThat(message).contains("You logged into a secure area!");
	}
	
	@Test
	public void loginFailure()
	{	
		loginPage.login("tomsmith", "SuperDuperWrongPassword!");
	    
		String message = loginPage.getMessage();
		assertThat(message).contains("Your password is invalid!");
	}
}
