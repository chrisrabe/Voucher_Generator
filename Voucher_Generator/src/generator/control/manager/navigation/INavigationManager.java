package generator.control.manager.navigation;

import generator.view.window.ApplicationWindow;

public interface INavigationManager {

	/**
	 * Returns the application window which contains all the pages.
	 * 
	 * @return
	 */
	public ApplicationWindow getWindow();

	/**
	 * Changes the page inside the window depending on the key.
	 * 
	 * @param page
	 */
	public void navigateTo(String page);

	/**
	 * Calls all the update method of the controllers.
	 */
	public void updateControllers();
}
