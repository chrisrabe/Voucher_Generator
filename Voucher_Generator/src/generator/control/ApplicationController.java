package generator.control;

import java.util.HashMap;
import java.util.Map;

import generator.control.manager.navigation.INavigationManager;
import generator.control.manager.navigation.NavigationManager;
import generator.control.page.ConfigController;
import generator.control.page.DescriptionController;
import generator.control.page.HomeController;
import generator.control.page.IOController;
import generator.control.page.PageController;
import generator.control.page.VoucherController;
import generator.models.code.manager.CodeManager;
import generator.models.description.manager.DescriptionManager;
import generator.view.window.ApplicationWindow;

/**
 * This class is responsible for updating the application window's content. It
 * also stores code and description managers for page controllers to use.
 * 
 * @author Chris
 */
public class ApplicationController {

	// Fields

	private CodeManager codeManager;
	private DescriptionManager descriptionManager;
	private INavigationManager navigation;

	// Constructor

	public ApplicationController(CodeManager codeManager, DescriptionManager descriptionManager) {
		this.codeManager = codeManager;
		this.descriptionManager = descriptionManager;
	}

	// Methods

	/**
	 * Creates a new application window and starts the program.
	 */
	public void startApplication() {
		this.navigation = new NavigationManager(new ApplicationWindow(), createControllers());
		this.navigation.navigateTo("home");
	}

	// Helper Methods

	/**
	 * Initialises the controllers.
	 * 
	 * @return
	 */
	private Map<String, PageController> createControllers() {
		Map<String, PageController> tmp = new HashMap<String, PageController>();
		// Add controllers here
		tmp.put("home", new HomeController());
		tmp.put("io", new IOController(codeManager));
		tmp.put("voucher", new VoucherController(codeManager));
		tmp.put("description", new DescriptionController(descriptionManager));
		tmp.put("config", new ConfigController());
		return tmp;
	}
}
