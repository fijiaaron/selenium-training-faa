/* We are performing various type of operations on WebTable
 * like getRowCount, getColumnCount, getCellData, deletaRow, etc..
 */
package webdriverbasicsPartI;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class WebTableOperationsTest {
	private WebDriver driver;
	private WebTable table;
	
  @Test
  public void testHTMLTable() { 
	  
	  /*We get total no. of columns by using getColumnCount() function.*/
	  System.out.println("Total Columns in the Table: "+table.getColumnCount());
	  
	  /*We get total no. of columns by using getRowCount() function.*/
	  System.out.println("Total Row in the Table: "+table.getRowCount());
	  
	  /*Using getCellData(rowID, colID), we can get data present in that cell.*/
	  String cellData = table.getCellData(2, 3);
	  System.out.println("Cell Data: "+cellData );
	  
	  /*getCellPosition(String) will return the position of that String data present in the WebTable*/
	  table.getCellPositionBasedOnCellContent("Jason");
	  
	/*deleteRow(rowID) function deletes the entire row of given ID*/
	  table.deleteRow(3);
	  
  }
  
  @BeforeTest
  public void beforeTest() {
	
		System.setProperty("webdriver.gecko.driver", "test\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://the-internet.herokuapp.com/tables");
		driver.manage().window().maximize();
		/*Creating object of WebTable class by passing WebTable element as an argument
		 * WebTable is user defined class and not provided by Selenium or JAVA.
		 * We are accessing all the functions of WebTable class through the object of that class.
		 * */
		table = new WebTable(driver.findElement(By.tagName("table")));
  }

  @AfterTest
  public void afterTest() {
  }

}
