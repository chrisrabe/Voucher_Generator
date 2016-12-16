package generator.control;

import java.util.HashMap;
import java.util.Map;

import generator.control.page.ConfigController;
import generator.control.page.DescriptionController;
import generator.control.page.HomeController;
import generator.control.page.IOController;
import generator.control.page.PageController;
import generator.control.page.VoucherController;
import generator.models.code.manager.CodeManager;
import generator.models.code.manager.MapCodeManager;
import generator.models.description.manager.DescriptionManager;
import generator.models.description.manager.ListDescriptionManager;
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
	private ApplicationWindow application;
	private Map<String, PageController> pageControllers;

	// Constructor

	public ApplicationController() {
		codeManager = new MapCodeManager();
		descriptionManager = new ListDescriptionManager();
		pageControllers = createControllers();
	}

	// Getters

	public CodeManager getCodeManager() {
		return codeManager;
	}

	public DescriptionManager getDescriptionManager() {
		return descriptionManager;
	}

	// Methods

	/**
	 * Creates a new application window and starts the program.
	 */
	public void startApplication() {
		application = new ApplicationWindow();
		navigateTo("home");
	}

	/**
	 * Changes the application content to the indicated page.
	 * 
	 * @param page
	 */
	public void navigateTo(String page) {
		PageController controller = pageControllers.get(page);
		application.setContent(controller.getView());
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
		tmp.put("home", new HomeController(this));
		tmp.put("io", new IOController(this));
		tmp.put("voucher", new VoucherController(this));
		tmp.put("description", new DescriptionController(this));
		tmp.put("config", new ConfigController(this));
		return tmp;
	}
}
