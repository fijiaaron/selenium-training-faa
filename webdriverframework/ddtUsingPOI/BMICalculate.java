/*  
 * This is a class which tests the BMI functionality using 
 * Data Driven Testing.
 */
package webdriverframework.ddtUsingPOI;

import static org.testng.Assert.*;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class BMICalculate {
	WebDriver driver;
	CommonUtilityForPOI sheetData;
	
	/*
	 * DataProvider method is given a name. This name is referenced by
	 * @Test in its dataProvider attribute. 
	 */
	@DataProvider (name="BMITestDataProvider")
	public Iterator<Object[]> getYahooDataFromXLS() {
		Collection<Object[]> data = sheetData.getData();
		return data.iterator();
	}
	
  /*
   * @Test provides the dataProvider name from which it will receive data.
   * Test is getting 3 parameters from the dataProvider, height, weight, bmi, and
   * bmi category.	
   */
  @Test (dataProvider = "BMITestDataProvider")
  public void bmiTest(double ht, double wt,double bmi, String bmiCategory) {
	    
	  WebElement cmField = driver.findElement(By.id("cm"));
	  WebElement kgField = driver.findElement(By.id("kg"));
	  WebElement metricBMIButton = driver.findElement(By.id("sm"));
	  
	  cmField.clear();
	  cmField.sendKeys(Double.toString(ht));
	  kgField.clear();
	  kgField.sendKeys(Double.toString(wt));
	  
	  WebDriverWait wait = new WebDriverWait(driver,5);
	  wait.until(ExpectedConditions.elementToBeClickable(metricBMIButton));
	  metricBMIButton.click();


	  wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id='res']//tr[5]/td/b"), bmiCategory));
	  WebElement bmiCategoryField = driver.findElement(By.xpath("//*[@id='res']//tr[5]/td/b"));
	  assertEquals(bmiCategoryField.getText(),bmiCategory,"Expected and Actual values of BMI not matchin"); 
   }
  
  @BeforeTest
  public void beforeTest() throws InvalidFormatException, IOException {
	  
			System.setProperty("webdriver.gecko.driver", "test\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
			
			  driver.get("http://www.calcbmi.com/");
			  driver.manage().window().maximize();
			  
			  /*
			   * Create Java File object and pass XLS file in the constructor.
			   * Pass the FileInputStream to CommonUtilityForPOI in the constructor.
			   */
			  File file = new File("test/resources/data/BMIData.xls");
			  FileInputStream inputStream = new FileInputStream(file);
			  sheetData= new CommonUtilityForPOI(inputStream);
  	}

  @AfterTest
  public void afterTest() {
  	}

}
