package tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTestNG
{
	@Test
	public void successfulLogin()
	{
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");

	    driver = new ChromeDriver();
	 
	    driver.get("https://the-internet.herokuapp.com/login");
	    driver.findElement(By.id("username")).sendKeys("tomsmith");
	    driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
	    driver.findElement(By.cssSelector(".fa")).click();
	    
	    String message1 = driver.findElement(By.id("flash")).getText();
	    System.out.println(message1);
	    
	    assertTrue(message1.equals("Your password is invalid!\n"+ "×"));
	    
	    driver.findElement(By.linkText("Logout")).click();
	    String message2 = driver.findElement(By.id("flash")).getText();
	    System.out.println(message2);

	    
	    driver.quit();
	}
	
	
	@Test
	public void unsuccessfulLogin()
	{
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");

	    driver = new ChromeDriver();
	 
	    driver.get("https://the-internet.herokuapp.com/login");
	    driver.findElement(By.id("username")).sendKeys("tomsmith");
	    driver.findElement(By.id("password")).sendKeys("SuperWrongPassword!");
	    driver.findElement(By.cssSelector(".fa")).click();
	    
	    String message1 = driver.findElement(By.id("flash")).getText();
	    System.out.println(message1);
	    
	    		
	    assertTrue(message1.equals("Your password is invalid!\n"+ "×"));
	    
	    driver.quit();
	}
}
