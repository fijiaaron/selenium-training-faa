package webdriverbasicsPartII;

import java.io.IOException;
 
import java.util.concurrent.TimeUnit;
 




import org.openqa.selenium.By;
 
import org.openqa.selenium.WebDriver;
 
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
 
public class TestUsingAutoIT {
 
private static WebDriver driver = null;

@BeforeMethod
public void setUp() {
	System.setProperty("webdriver.gecko.driver", "test\\resources\\geckodriver.exe");	
    driver = new FirefoxDriver(); 
    driver.get("http://the-internet.herokuapp.com/upload");
}

@Test
public void testUsingAutoIT() throws IOException {
	/* calling the AutoIT executable */
    
    driver.findElement(By.id("file-upload")).click();
    Runtime.getRuntime().exec("test\\resources\\AutoIT\\FileUploadC.exe");
    

}



 
}