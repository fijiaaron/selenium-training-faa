import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class HelloIEDriver
{
	public static void main(String[] args)
	{
		WebDriver driver;
		
		System.out.println("We're going to start internet explorer with selenium....");
		System.setProperty("webdriver.ie.driver", "resources\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.get("https://www.faa.gov/");
		String title = driver.getTitle();
		System.out.println(title);
		
		driver.quit();
	}
}
