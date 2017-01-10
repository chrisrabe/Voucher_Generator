package generator;

import generator.control.ApplicationController;
import generator.control.manager.code.MapCodeManager;
import generator.control.manager.description.ListDescriptionManager;
import generator.control.manager.theme.ThemeManager;
import vgcomponents.themes.VGTheme;

/**
 * Starts the application.
 * 
 * @author Chris
 */
public class Main {
	public static final String VERSION = "1.0.0";

	public static void main(String[] args) {
		ApplicationController controller = new ApplicationController(new MapCodeManager(), new ListDescriptionManager(),
				new ThemeManager(new VGTheme()));
		controller.startApplication();
	}
}
