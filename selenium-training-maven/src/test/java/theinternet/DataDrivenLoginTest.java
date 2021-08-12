package theinternet;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import framework.SeleniumTest;

public class DataDrivenLoginTest extends SeleniumTest
{
	LoginPage loginPage;
	
	@BeforeMethod
	public void setup()
	{
		super.setup();
		loginPage = new LoginPage(driver);
	}
	
	@Test(dataProvider="users")
	public void testLogin(String username, String password, String expectedMessage)
	{
		loginPage.login(username, password);
		  
		String message = loginPage.getMessage();
		assertThat(message).contains(expectedMessage);
	}
	

	@DataProvider
	public Object[][] users() throws IOException
	{
		InputStream input = new FileInputStream("src/test/resources/users.properties");
		Properties users = new Properties();
		users.load(input);
		
		String validUsername = users.getProperty("valid.username");
		String validPassword = users.getProperty("valid.password");
		String invalidUsername = users.getProperty("invalid.username");
		String invalidPassword = users.getProperty("invalid.password");
		
		return new Object[][] {
			{ validUsername, validPassword, "You logged into a secure area!"},
			{ validUsername, invalidPassword, "Your password is invalid!"},
			{ invalidUsername, validPassword, "Your username is invalid!"}
		};
	}

}
