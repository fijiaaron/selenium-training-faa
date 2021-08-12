package oneshore.training;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import theinternet.pages.LoginPage;
import theinternet.pages.SecurePage;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefinitions
{
	WebDriver driver;
	LoginPage loginPage;
	SecurePage securePage;

	@Before
	public void setup()
	{
		driver = new ChromeDriver();
		loginPage = new LoginPage(driver);
		securePage = new SecurePage(driver);
	}

	@After
	public void cleanup()
	{
		driver.quit();
	}

	@Given("I am on the login page")
	public void i_am_on_the_login_page()
	{
		loginPage.open();
	}

	@When("I enter my username and password")
	public void i_enter_my_username_and_password()
	{
		loginPage.login("tomsmith", "SuperSecretPassword!");
	}

	@Then("I should be able to access the secure area")
	public void i_should_be_able_to_access_the_secure_area()
	{
		String heading = securePage.getHeading();
		String flashMessage = securePage.getFlashMessage();
		
		assertThat(heading).isEqualTo("Secure Area");
		assertThat(flashMessage).contains("You logged into a secure area");
	}
	
	

	@When("I enter my username and an invalid password")
	public void i_enter_my_username_and_an_invalid_password() {
		loginPage.login("tomsmith", "SuperWrongPassword!");
	}
	
	@Then("I should receive the error message {string}")
	public void i_should_receive_the_error_message(String string) {
		assertThat(loginPage.isLoaded()).isTrue();
		String flashMessage = loginPage.getFlashMessage();
		assertThat(flashMessage).contains("Your password is invalid!");
	}
	
	@Then("I am still on the login page")
	public void i_am_still_on_the_login_page() {
		assertThat(loginPage.isLoaded()).isTrue();
		String heading = loginPage.getHeading();
		assertThat(heading).isEqualTo("Login Page");
	}
}
