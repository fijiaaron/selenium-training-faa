package tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonTest
{
	WebDriver driver;

	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	
	@AfterMethod
	public void cleanup()
	{
		driver.quit();
	}
	
	@Test
	public void getAllTheButtons()
	{
		driver.get("https://www.faa.gov/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		List<WebElement> buttons = driver.findElements(By.tagName("button"));
		System.out.println("number of buttons: " + buttons.size());
		
		for (WebElement button : buttons)
		{
			String text = button.getText();
			System.out.println(text);
		}
	}
}
