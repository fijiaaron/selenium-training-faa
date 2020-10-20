/*
 * The FlipKartPage class inherits LoadableComponent
 * and implements load and isLoaded methods. For more 
 * detail example, you can refer the page object design
 * pattern source code package.
 */

package corejavarefresher.objectorientedprogramming.abstractexample;

public class FlipKartPage extends LoadableComponent {

	String url = "http://www.flipkart.com";
	String expectedPageTitle = "FlipKart home";
	private String actualTitleFromPage;

	public FlipKartPage(String componentName, String actualTitleFromPage) {
		super(componentName);
		this.actualTitleFromPage = actualTitleFromPage;

	}

	@Override
	public void load() {
		goToUrl(url);

	}

	private void goToUrl(String url2) {
		// Contains code to load the URL

	}

	@Override
	public void isLoaded() {
		assertEquals(expectedPageTitle,actualTitleFromPage);		
	}

	private void assertEquals(String expectedPageTitle2,
			String actualTitleFromPage2) {			
		if (!expectedPageTitle.equals(actualTitleFromPage2))
			throw new RuntimeException("Page title does not match") ;
			
		
		
	}

}
