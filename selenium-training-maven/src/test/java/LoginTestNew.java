import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTestNew
{
	@Test
	public void loginSuccess() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		
		// open login page
		driver.get("https://the-internet.herokuapp.com/login");
		
		// enter username
	    driver.findElement(By.id("username")).sendKeys("tomsmith");
	    
	    // enter password
	    driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
	    
	    // click login button
	    driver.findElement(By.cssSelector("button[type=submit]")).click();
		
	    // get message
	    String message = driver.findElement(By.id("flash")).getText();
		
	    // get title
		String title = driver.getTitle(); 
		
	    // Assert
		assertEquals(title, "The Internet");
		assertEquals(message, "You logged into a secure area!\n×");
		
		
		// Close Browser
		Thread.sleep(3000);
		driver.quit();
	}
}
