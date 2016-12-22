package generator;

import generator.control.ApplicationController;
import generator.control.manager.code.MapCodeManager;
import generator.control.manager.description.ListDescriptionManager;

/**
 * Starts the application.
 * 
 * @author Chris
 */
public class Main {
	public static final String VERSION = "1.0.0";

	public static void main(String[] args) {
		ApplicationController controller = new ApplicationController(new MapCodeManager(),
				new ListDescriptionManager());
		controller.startApplication();
	}
}
