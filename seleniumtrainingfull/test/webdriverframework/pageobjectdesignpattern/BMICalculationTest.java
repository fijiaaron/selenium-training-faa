/*
 * This program calculates bmi by accepting values : height, weight, age
 * TestNG test using Page Object Design Pattern.
 * Note that no WebDriver classes are required in your test.
 */

package webdriverframework.pageobjectdesignpattern;

import static org.testng.Assert.*;
import org.testng.annotations.*;

public class BMICalculationTest {
	/* Declare the reference of Page Object Class */
	BMICalulationPO bmi;

	@BeforeMethod
	public void setUp() throws Exception {
		/* Create the object of Page Object Class and get the URL*/
		bmi = new BMICalulationPO();
		/* get() method first checks whether page is loaded by 
		 * calling isLoaded() and the calls load() if isLoaded() fails
		 * after executing load(), it again calls isLoaded() to verify if 
		 * page is loaded by verifying the title 
		 */
		bmi.get();
	}

	@AfterMethod
	public void tearDown() throws Exception {
		bmi.close();
	}

	@Test
	public void testCalculatedBMIIsCorrect() {
		/* calls the calculateBmi method of page object and passes 
		 * height, weight and age a input data 
		 */
		bmi.calculateBmi("167", "55", "25");
		/* Verify the value of bmi by calling getBmi() method of Page Object */		
		assertTrue(bmi.getBmi().contains("20"));
	}

}
