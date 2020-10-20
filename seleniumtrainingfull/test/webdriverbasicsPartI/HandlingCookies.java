/* Selenium webdriver can perform required task with respect to browser cookies. 
 * We can get, add , delete, delete particular cookie by passing the name, and so on.
 */
package webdriverbasicsPartI;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HandlingCookies {
	WebDriver driver;

	@Test
	public void testCookieCommands() {

		driver.get("http://flipkart.com/");
		driver.manage().window().maximize();

		/*
		 * We need to import "org.openqa.selenium.Cookie" to initialize the
		 * instance of Cookie In this example we are passing, name=mycookie and
		 * value=123456789123
		 */
		Cookie cookieName = new Cookie("myCookie", "Learn Selenium WebDriver 3.x");
		driver.manage().addCookie(cookieName);
		

		/* getCookies() function is used to fetch all the cookies present in the
		 * web page. 
		 * All the cookies we are string in Set of type Cookie.
		 */
		Set<Cookie> cookiesList = driver.manage().getCookies();
		/* Printing all the cookies stored in the cookiesList set. */
		for (Cookie getcookies : cookiesList) {
			System.out.println(getcookies);
		}
		
		System.out.println();
		System.out.println();
		System.out.println();

		/* We can delete single cookie using deleteCookie() method 
		 * by passing the cookie.
		 */
		driver.manage().deleteCookie(cookieName);
		System.out.println("*** Now the myCookie should not be listed below ***");
		for (Cookie getcookies : cookiesList) {
			System.out.println(getcookies);
		}
		System.out.println("*** myCookie should not be listed above ***");
		System.out.println();
		System.out.println();
		System.out.println();
	
		/*
		 * Again adding the same cookie
		 */
		driver.manage().addCookie(cookieName);
		System.out.println("Checking if the cookie got added agains" + driver.manage().getCookieNamed("myCookie"));
		/* We can delete single cookie using deleteCookieNamed() method 
		 * only passing the cookie name(String).
		 */
		driver.manage().deleteCookieNamed("myCookie");
		System.out.println("Now the myCookie should not be listed below");
		for (Cookie getcookies : cookiesList) {
			System.out.println(getcookies);
		}
		System.out.println("myCookie should not be listed above");

		System.out.println();
		System.out.println();
		System.out.println();

		
		/* We can delete all the cookies present in web page 
		 * using deleteAllCookies().
		 */
		driver.manage().deleteAllCookies();

		for (Cookie getcookies : cookiesList) {
			System.out.println("After deleting the cookie with name " + getcookies);
		}
	}

	@BeforeTest
	public void beforeTest() {
		/* Firefox Browser*/
/*		System.setProperty("webdriver.gecko.driver", "test\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
*/		
		System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	@AfterTest
	public void afterTest() {
	}

}
