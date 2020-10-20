/*
 * The file is an abstract class.
 * You cannot create instance of an abstract class
 * The child class of this class implements all
 * the abstract methods. 
 * The example is created which resembles the LoadableComponent
 * class provided by Selenium WebDriver which is used to 
 * implement page object design pattern. 
 */

package corejavarefresher.objectorientedprogramming.abstractexample;

abstract public class LoadableComponent {
	// Private member variable
	private String componentName;

	public LoadableComponent(String componentName) {
		this.componentName = componentName;
	}

	public String getComponentName() {
		return componentName;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	/*
	 * This method is used to load the web page and verify whether the page is
	 * loaded properly or not
	 */

	public boolean get() {
		try {
			isLoaded();
			return true;
		} catch (Exception e) {
			load();
		}
		isLoaded();
		return true;
	}

	/*
	 * abstract method which child class should implement the logic to load a
	 * particular page
	 */
	abstract public void load();

	/*
	 * abstract method which child class should implement the logic to verify
	 * whether the page is loaded
	 */

	abstract public void isLoaded();
}
