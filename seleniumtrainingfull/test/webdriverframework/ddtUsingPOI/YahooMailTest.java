package webdriverframework.ddtUsingPOI;

import org.testng.annotations.Test;



import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

import webdriverframework.ddtUsingPOI.CommonUtilityForPOI;
import webdriverframework.ddtUsingPOI.YahooInboxPO;

public class YahooMailTest {
	WebDriver driver;
	YahooMailLogin myYahoo;
	YahooInboxPO myInbox;
	CommonUtilityForPOI sheetData;
	
	@DataProvider (name="YahooLoginDataProvider")
	public Iterator<Object[]> getYahooDataFromXLS() {
		Collection<Object[]> data = sheetData.getData();
		return data.iterator();
	}
	
	@Test (dataProvider = "YahooLoginDataProvider")
  public void yahooEmail(String user,String pass) throws IOException, InterruptedException {
	//	myYahoo.load();
	  myInbox = myYahoo.yahooSignIn(user, pass);
	  /* Below data can also come from the XLS file. */
	  myInbox.composeEmail("test1@ymail.com", "test message", "Hi,\nThis is test message.\n\nThanks");	  
  }
	
	
  @BeforeTest
  public void beforeTest() throws InvalidFormatException, IOException {
	  System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
	  driver = new ChromeDriver();
	  //PageFactory.initElements(driver, this);
	  myYahoo = new YahooMailLogin(driver);
	  myYahoo.load();
	  
      File file = new File("test/resources/data/Credentials.xls");
	  FileInputStream inputStream = new FileInputStream(file);
	  sheetData= new CommonUtilityForPOI(inputStream);
	  
  }

  @AfterTest
  public void afterTest() {
  }

}
