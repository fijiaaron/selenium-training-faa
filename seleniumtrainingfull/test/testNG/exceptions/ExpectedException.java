/*
 * Explains how ExpectedExceptions works
 */
package testNG.exceptions;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.annotations.Test;

public class ExpectedException {
	/*
	 * Test is expecting NoSuchElementException and the same exception
	 * is thrown inside the test method so this test will pass.
	 */
	@Test(expectedExceptions = { NoSuchElementException.class })
	public void exceptionTestOne() throws Exception {
		throw new NoSuchElementException("No Such Element Found !");
	}
	/*
	 * Test is expecting NoSuchElementException or StaleElementReferenceException
	 * but NoAlertPresentException is thrown and hence the test fails
	 */
	
	@Test(expectedExceptions = { NoSuchElementException.class,
			StaleElementReferenceException.class })
	public void exceptionTestTwo() throws Exception {
		throw new NoAlertPresentException();
	}

}
