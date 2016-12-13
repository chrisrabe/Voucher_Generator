package generator;

import generator.control.ApplicationController;

/**
 * Starts the application.
 * 
 * @author Chris
 */
public class Main {
	public static final String VERSION = "1.0.0";

	public static void main(String[] args) {
		ApplicationController controller = new ApplicationController();
		controller.startApplication();
	}
}
