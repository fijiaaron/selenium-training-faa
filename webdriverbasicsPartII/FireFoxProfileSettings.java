/*
 * Explains how to open Firefox with a specific profile.
 */
package webdriverbasicsPartII;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FireFoxProfileSettings {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		// Creating a profile object
		FirefoxProfile profile = new FirefoxProfile();
		ProfilesIni profileini = new ProfilesIni();

		/*
		 * Make sure all firefox instances are closed To create a profile go to
		 * Windows run command and type "firefox -p". Create a new profile and
		 * give a name. In this case, it is WebDriverProfile.
		 */
		profile = profileini.getProfile("WebDriverProfile");
		/* Now set the preference for home page, and untrusted certificates */
		profile.setPreference("browser.startup.homepage",
				"http://www.amazon.com");
		profile.setAcceptUntrustedCertificates(false);
		profile.setAssumeUntrustedCertificateIssuer(false);

		/*
		 * To use the above profile we need to pass it to the driver. This is
		 * how we can manipulate Firefox settings.
		 */

		driver = new FirefoxDriver(profile);

	}

	@AfterMethod
	public void tearDown() {
		// driver.quit();
	}

	@Test
	public void testExamples() {
		driver.get("http://www.google.com");
		WebElement element = driver.findElement(By.id("lst-ib"));
		element.sendKeys("Selenium Training");
	}
}
