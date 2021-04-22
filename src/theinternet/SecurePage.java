package theinternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecurePage
{
	WebDriver driver;
	
	@FindBy(tagName = "h2")
	WebElement heading;
	
	
	@FindBy(id = "flash")
	WebElement message;
	
	public SecurePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

    public String getMessage()
    {
    	return message.getText();
    }
    
    public boolean isLoaded()
    {
    	return heading.getText().equals("Secure Area");
    }
}
