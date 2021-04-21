/*
 * This is a page object class for BMI Page. 
 */
package webdriverframework.pageobjectdesignpattern;

import static org.testng.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BMICalulationPO extends LoadableComponent<BMICalulationPO> {
	/*
	 * Declaring all the fields which we need for our test by using @FindBy
	 * annotation of Selenium.
	 */
	@FindBy(how = How.NAME, using = "hc")
	public WebElement height;

	@FindBy(name = "wk")
	/*
	 * @CacheLookup should be used only if the field is not dynamic For dynamic
	 * fields @CacheLookup should be avoided otherwise you may get
	 * StaleElementReferenceException
	 */
	@CacheLookup
	public WebElement weight;

	@FindBy(how = How.XPATH, using = "//input[@name='us'][@value='0']")
	public WebElement gender;

	@FindBy(name = "ua")
	@CacheLookup
	public WebElement ageYear;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'metric units')]")
	public WebElement unit;

	@FindBy(how = How.XPATH, using = "//input[@name='ue'][@value='0']")
	public WebElement nationality;

	@FindBy(how = How.XPATH, using = "//input[@name='di'][@value='0']")
	public WebElement diet;

	@FindBy(how = How.XPATH, using = "//input[@value='Calculate']")
	@CacheLookup
	public WebElement calculatebmi;

	@FindBy(how = How.XPATH, using = "//div[@id='maincol']//p[@class='subhead'][1]")
	private WebElement bmi;

	private WebDriverWait wait;
	private WebDriver driver;
	private String url = "http://www.smartbmicalculator.com/?ru=0";
	private String title = "Calculate your BMI, correctly rated according to age and sex";

	/*
	 * The constructor for Page Object class. Initializes the browser and calls
	 * PageFactory.initElements() method to initialize the elements.
	 */
	public BMICalulationPO() {
		System.setProperty("webdriver.gecko.driver",
				"test\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}

	/*
	 * Overriding the abstract method provided in LoadableComponent. The main
	 * objective of this method is to verify whether the page is loaded
	 * properly. If you keep this empty or do not put assert then your page will
	 * not load. As per the logic of get() method in LoadableComponent, isLoaded
	 * is called first and if isLoaded() fails then only load() is called.
	 */
	@Override
	public void isLoaded() {
		assertEquals(driver.getTitle(), title, "Test fail");

	}

	/*
	 * This method is used to load the page. This will be empty for nexted page
	 * objects and typically have code for Home page/entry point only.
	 */
	@Override
	public void load() {
		driver.get(url);

	}

	public void close() {
		driver.quit();
	}

	public void calculateBmi(String heightinput, String weightinput, String age) {
		height.clear();
		height.sendKeys(heightinput);
		weight.clear();
		weight.sendKeys(weightinput);
		gender.click();
		ageYear.sendKeys(age);
		nationality.click();
		diet.click();
		calculatebmi.click();
		wait.until(ExpectedConditions.invisibilityOf(calculatebmi));
	}

	public String getBmi() {
		wait.until(ExpectedConditions.visibilityOf(bmi));
		return bmi.getText();
	}

}