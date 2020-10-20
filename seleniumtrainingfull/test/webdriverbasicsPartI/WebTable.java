/* WebTable class is a user generic or common defined class 
 * to perform various operation on  Web Tables
 * Here, we have created functions like getRowCount(), getColumnCount, 
 * getCellData, getCellPosition, etc..
 * */
package webdriverbasicsPartI;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;

public class WebTable {
	private WebElement webTable;

	/* We are passing actual WebTable element as a parameter here. */
	public WebTable(WebElement webTable) {
		String tagName = webTable.getTagName();

		if (null == tagName || !"table".equals(tagName.toLowerCase())) {
			throw new UnexpectedTagNameException("table", tagName);
		}

		this.webTable = webTable;
	}

	/* It returns the total no. of row count in the Table */
	public int getRowCount() {
		List<WebElement> rowCount = webTable.findElements(By.tagName("tr"));
		int totalRows = rowCount.size();
		return totalRows;

	}

	/* It returns the total no. of row count in the Column */
	public int getColumnCount() {
		List<WebElement> rowCount = webTable.findElements(By.tagName("tr"));
		/* Get the first row and then count the columns for that row */
		WebElement headerRow = rowCount.get(0);
		/*
		 * Sometimes HTML table may not have th as header columns and have td
		 * instead. This method needs to be modified in that case.
		 */
		List<WebElement> columnCount = headerRow.findElements(By.tagName("th"));
		int totalColumns = columnCount.size();

		return totalColumns;

	}

	/* It returns the data present in the given Cell in the form of String. */
	public String getCellData(int rowID, int colID) {

		List<WebElement> rowCount = webTable.findElements(By.tagName("tr"));
		WebElement exactRow = rowCount.get(rowID - 1);
		List<WebElement> columnCount = exactRow.findElements(By.tagName("td"));
		WebElement exactCol = columnCount.get(colID - 1);

		return exactCol.getText();

	}

	/* It gives the cell position of the given data */
	public void getCellPositionBasedOnCellContent(String pos) {
		List<WebElement> allRows = webTable.findElements(By.tagName("tr"));

		for (int i = 0; i < allRows.size(); i++) {
			List<WebElement> allCols = allRows.get(i).findElements(
					By.tagName("td"));
			for (int j = 0; j < allCols.size(); j++) {
				WebElement currCol = allCols.get(j);
				if (currCol.getText().equals(pos)) {
					System.out.println("(" + (i + 1) + ", " + (j + 1) + ")");
					break;
				}
			}
		}

	}

	/* It deletes the provided Row */
	public void deleteRow(int rowId) {
		List<WebElement> allRows = webTable.findElements(By.tagName("tr"));
		List<WebElement> allCols = allRows.get(rowId).findElements(
				By.tagName("td"));

		WebElement deleteID = allCols.get(5).findElement(
				By.xpath("//table[@id='table1']//tr/td[6]/a[@href='#delete']"));

		deleteID.click();

		System.out.println("Row no.:" + rowId + " is deleted!!");
	}

}
