package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import theinternet.LoginPage;
import theinternet.SecurePage;

public class LoginTestRefactored
{
	WebDriver driver;
	LoginPage loginPage;
	SecurePage securePage;
	
	@BeforeClass
	public static void init()
	{
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
	}
	
	@BeforeMethod
	public void setup()
	{	
	    driver = new ChromeDriver();
	 
	    driver.get("https://the-internet.herokuapp.com/login");
	    loginPage = new LoginPage(driver);
	}
	
	@AfterMethod
	public void cleanup()
	{
	    driver.quit();
	}
	
	@Test
	public void successfulLogin()
	{	
	    loginPage.setUsername("tomsmith");
	    loginPage.setPassword("SuperSecretPassword!");
	    
	    securePage = loginPage.clickLogin();
	    String message1 = securePage.getMessage();
	    
	    assertEquals(message1, "You logged into a secure area!\n"+ "×");
	    
	    driver.findElement(By.linkText("Logout")).click();
	    String message2 = driver.findElement(By.id("flash")).getText();
	    System.out.println(message2);
		
	    assertEquals(message2, "You logged out of the secure area!\n"+ "×");
	}
	
	@Test
	public void unsuccessfulLogin()
	{
	    loginPage.setUsername("tomsmith");
	    loginPage.setPassword("SuperDuperWrongPassword!");
	    loginPage.clickLogin();
	    
	    String message1 = driver.findElement(By.id("flash")).getText();
	    System.out.println(message1);
	    
	    assertEquals(message1, "Your password is invalid!\n"+ "×");	
	}
}
