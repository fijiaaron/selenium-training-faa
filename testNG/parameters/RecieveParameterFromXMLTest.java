/*
 * This file is created as an examples of 
 * passing parameters from TestNG configuration file to
 * TestNG class file. This file in particular accepts Browser 
 * parameter from the TestNG configuration file.
 */

package testNG.parameters;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RecieveParameterFromXMLTest {

	@BeforeSuite
	public void suite()
	{
		System.out.println("Before suite");
	}
	
	@Parameters({"Browser"})
	@BeforeClass (alwaysRun = true)
	public void setUp(@Optional("FF") String browser){	    
	System.out.println("Value of Browser parameter-" + browser);
		ManageDriver.openBrowser(browser);
		ManageDriver.driver().get("http://www.google.com");
		//homePage.get();
	 }
	
	@Test
	public void test()
	{
		System.out.println("Inside Test");
	}
}
