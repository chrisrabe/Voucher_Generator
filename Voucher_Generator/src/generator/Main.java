package generator;

import generator.control.ApplicationController;
import generator.control.manager.code.MapCodeManager;
import generator.control.manager.description.ListDescriptionManager;
import generator.control.manager.theme.VGThemeManager;

/**
 * Starts the application.  
 * 
 * @author Chris
 */
public class Main {
	public static final String VERSION = "1.0.0";

	public static void main(String[] args) {
		// Initialise the main application controller
		ApplicationController controller = new ApplicationController(
										   new MapCodeManager(), 
										   new ListDescriptionManager(),
										   new VGThemeManager());
		controller.startApplication();
	}
}
