import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class RemoteTest
{
	@Test
	public void openFAAPage() throws MalformedURLException
	{
		URL url = new URL("http://10.37.129.2:4444/wd/hub");
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", "safari");
		capabilities.setCapability("platform", "MacOS");
		
		RemoteWebDriver driver = new RemoteWebDriver(url, capabilities);
		
		driver.get("https://www.faa.gov");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCapabilities());
		driver.quit();
	}
}
