package generator;

import generator.control.ApplicationController;
import generator.models.code.manager.MapCodeManager;
import generator.models.description.manager.ListDescriptionManager;

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
