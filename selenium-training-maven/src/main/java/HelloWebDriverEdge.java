import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class HelloWebDriverEdge
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.edge.driver", "src/main/resources/msedgedriver.exe");
		
		System.out.println("Hello WebDriver Edge");
		
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.faa.gov");
		
		System.out.println(driver.getTitle());
		
		driver.quit();
	}

}
