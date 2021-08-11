// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

public class LoginTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @SuppressWarnings("deprecation")
@Test
  public void loginTest() throws InterruptedException {
    driver.get("https://the-internet.herokuapp.com/login");
    driver.findElement(By.cssSelector("html")).click();
    driver.findElement(By.id("username")).click();
    
    By usernameLocator = By.id("username");
    WebElement usernameField = driver.findElement(usernameLocator);
    
    driver.findElement(By.id("username")).sendKeys("tomsmith");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
    Thread.sleep(1000);
    driver.findElement(By.cssSelector("button[type=submit]")).click();
    Thread.sleep(5000);
    assertThat(driver.findElement(By.id("flash")).getText(), is("You logged into a secure area!\n�"));
    assertThat(driver.findElement(By.cssSelector("h2")).getText(), is("Secure Area"));
    Thread.sleep(1000);
    driver.findElement(By.cssSelector("a.button")).click();
    Thread.sleep(1000);
    assertThat(driver.findElement(By.id("flash")).getText(), is("You logged out of the secure area!\n�"));
    assertThat(driver.findElement(By.cssSelector("h2")).getText(), is("Login Page"));
  }
}
