package theinternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SeleniumTest
{
	protected WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		
//		driver = new ChromeDriver();
		driver = new EdgeDriver();
	}
	
	@AfterMethod
	public void cleanup() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}
	
}
