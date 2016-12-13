package generator.control;

import generator.view.window.ApplicationWindow;

/**
 * This class is responsible for updating the application window's content. It
 * also stores code and description managers for page controllers to use.
 * 
 * @author Chris
 */
public class ApplicationController {

	private ApplicationWindow application;

	/**
	 * Creates a new application window.
	 */
	public void startApplication() {
		application = new ApplicationWindow();
	}
}
