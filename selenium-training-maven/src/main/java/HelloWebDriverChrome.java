import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWebDriverChrome
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		
		System.out.println("Hello Selenium");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.faa.gov");
		
		System.out.println(driver.getTitle());
		
		driver.quit();
	}
}
