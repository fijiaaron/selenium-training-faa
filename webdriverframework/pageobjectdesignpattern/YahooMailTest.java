package webdriverframework.pageobjectdesignpattern;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class YahooMailTest {
	WebDriver driver;
	YahooMailLogin myYahoo;
	YahooInboxPO myInbox;

	@Test
	public void yahooEmail() throws IOException, InterruptedException {
		myInbox = myYahoo.yahooSignIn("test@ymail.com", "9503743433aB");
		myInbox.composeEmail("test1@ymail.com", "test message", "Hi,\nThis is test message.\n\nThanks");	
	}

	@BeforeTest
	public void beforeTest() throws InvalidFormatException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		// PageFactory.initElements(driver, this);
		myYahoo = new YahooMailLogin(driver);
		myYahoo.get();
	}

	@AfterTest
	public void afterTest() {
		myInbox.close();
	}

}
