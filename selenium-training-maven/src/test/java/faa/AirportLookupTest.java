package faa;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import framework.SeleniumTest;

public class AirportLookupTest 
{
	WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		
		String os = System.getProperty("os.name").toLowerCase();
		if (os.contains("windows"))
		{
			System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		}
		else if (os.contains("mac"))
		{
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
		}
	}
	
	@Parameters({ "browser" })
	@Test
	public void airportLookup(String browser) throws InterruptedException
	{
		if (browser.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		if (browser.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		
		driver.get("https://www.faa.gov/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.id("airportCode")).sendKeys("GPI");
		driver.findElement(By.id("checkAirport")).click();
		
		By checkAirport = By.id("checkAirport");
		WebElement checkAirportButton = driver.findElement(checkAirport);
		checkAirportButton.click();
		
		String airportName = driver.findElement(By.cssSelector(".airportInfo b")).getText();
		System.out.println("airportName: " + airportName);
		
		driver.quit();
	}
}
