/*
 * This file contains all the configuration annotations in TestNG and their
 * priority of execution
 */
package testNG.AnnotationsExamples;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ConfigurationAnnotationExamples {
  @Test
  public void testC() {
	  System.out.println("Executing menthod present in annotation: @Test - Method testC \n");
  }
  
  @Test
  public void testA() {
	  System.out.println("Executing menthod present in annotation: @Test - Method testA \n");
  }
  
  @Test
  public void testB() {
	  System.out.println("Executing menthod present in annotation: @Test - Method testB \n");
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Executing menthod present in annotation: @BeforeMethod\n");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("Executing menthod present in annotation: @AfterMethod\n");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("Executing menthod present in annotation: @BeforeClass\n");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("Executing menthod present in annotation: @AfterClass\n");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Executing menthod present in annotation: @BeforeTest\n");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("Executing menthod present in annotation: @AfterTest\n");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Executing menthod present in annotation: @BeforeSuite\n");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("Executing menthod present in annotation: @AfterSuite\n");
  }

}