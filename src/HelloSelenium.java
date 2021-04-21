import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HelloSelenium
{
	public static void main(String[] args)
	{
		WebDriver driver;
		
		System.out.println("We're going to start chrome with selenium....");
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.faa.gov/");
		driver.quit();
	}
}
