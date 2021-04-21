/*  We will see all the WebElement methods to perform multiple action on web page.
 *  WebElement methods like findElement and findElements, getText, getTitle, clear, 
 *  getAttribute, isDisplayed, isEnabled, isSelected() and so on..
 */
package webdriverbasicsPartI;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class BMICalculate {
	WebDriver driver;

	@Test
	public void testWebElementCommands() {
		/* Load the URL in browser */
		driver.get("http://www.calcbmi.com/");
		driver.manage().window().maximize();

		/*
		 * Find webElements of we pages using findElement() function and ID as a
		 * locating technique.
		 */
		WebElement cmField = driver.findElement(By.id("cm"));
		WebElement kgField = driver.findElement(By.id("kg"));
		WebElement metricBMIButton = driver.findElement(By.id("sm"));

		/* sendKeys() function is used to insert data into the input fields. */
		cmField.sendKeys("180");
		kgField.sendKeys("78");
		
		/* click() method is used to perform click action on the button. */
		metricBMIButton.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		 * getText() function is used to get the text of WebElement in the form
		 * of string Here, button does not have the text value.
		 */
		WebElement bmi = driver.findElement(By.xpath("//div[@id='res']//tr[4]/td"));	
		String bmiCalculatedValue = bmi.getText();
		System.out.println("Calculated BMI Value is : " + bmiCalculatedValue);

		/*
		 * getAttribute(arg) function is used to retrieve the value of any
		 * attribute of WebElement We have to pass the attribute name as an
		 * argument to getAttribute(arg) function. Here, we are passing "value"
		 * attribute as an argument to getAttribute("value") and printing the
		 * result.
		 */
		String heightEntered = cmField.getAttribute("value");
		System.out.println("Height Entered is : " + heightEntered);

		/* clear() method is used to clear the data present in the input field */
		cmField.clear();
		kgField.clear();

		/*
		 * getCssValue() retrieves the value of a CSS attribute of any
		 * WebElement. We need to pass the attribute name as an argument to
		 * getCssValue() methodHere, we are passing "color" attribute as an
		 * argument to getCssValue("color") and printing the result.
		 */
		String cssValueOfBtn = metricBMIButton.getCssValue("color");
		System.out.println("CSS vlaue of Button : " + cssValueOfBtn);

		/*
		 * getTagName() retrieves the tag name of any WebElement.Here, we want
		 * the tag name of the input field and button.
		 */
		String fieldTagName = cmField.getTagName();
		System.out.println("Input Field's tag name : " + fieldTagName);

		String buttonTagName = metricBMIButton.getTagName();
		System.out.println("button's tag name : " + buttonTagName);

		/* locating the radio button present on the page. */
		WebElement bmiRadioButton = driver.findElement(By.id("ctw"));

		/*
		 * isDisplayed() is used to determine the visibility of an element on
		 * the web page. This function returns the boolean value (true or false)
		 */
		boolean condition1 = bmiRadioButton.isDisplayed();
		if (condition1)
			System.out.println("BMI radio button is visible");
		else
			System.out.println("BMI radio button is not visible");

		/*
		 * isEnabled() is used to check whether the element is enable or not.
		 * This function returns the boolean value (true or false)
		 */
		boolean condition2 = bmiRadioButton.isEnabled();
		if (condition2)
			System.out.println("BMI radio button is enabled");
		else
			System.out.println("BMI radio button is not enabled");


		/*
		 * isEnabled() is used to check whether the radio button is already
		 * selected or not. This function returns the boolean value (true or
		 * false)
		 */
		boolean condition3 = bmiRadioButton.isSelected();
		if (condition3)
			System.out.println("BMI radio button is selected");
		else
			System.out.println("BMI radio button is not selected");


		/*
		 * getLocation() function retrieves the position of the button in the
		 * form of Point which contains X and Y coordinates. Here, we are
		 * getting the location of button using getLocation() function and
		 * storing in the Point type. We are again getting X and Y values from
		 * the Point in the Integer type and printing them
		 */
		Point buttonLocation = bmiRadioButton.getLocation();
		int x = buttonLocation.x;
		int y = buttonLocation.y;
		System.out.println("Button Location: (x = " + x + ", y = " + y + " )");

		/*
		 * getRect() function retrieves the position of an element in the form
		 * of Rectangle(Height, Width) We get height and width of the element in
		 * the form of integer using getHeight() and getWidth() functions.
		 */
		Rectangle rectangle = bmiRadioButton.getRect();
		int height = rectangle.getHeight();
		int width = rectangle.getWidth();
		System.out.println("Height of Button: " + height
				+ "\nWidth of Button: " + width);

		/*
		 * getSize() function retrieves the position of an element in the form
		 * of Dimension(Height, Width) We get height and width of the element in
		 * the form of integer using getHeight() and getWidth() functions.
		 */
		Dimension buttonSize = cmField.getSize();
		int hght = buttonSize.getHeight();
		int wdth = buttonSize.getWidth();
		System.out.println("Height of Button: " + height
				+ "\nWidth of Button: " + width);

	}

	@BeforeTest
	public void beforeTest() {
		/* Firefox Browser */
		System.setProperty("webdriver.gecko.driver",
				"test\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
	}

	@AfterTest
	public void afterTest() {
	}

}
