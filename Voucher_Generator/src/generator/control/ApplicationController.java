package generator.control;

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

	private ApplicationWindow application;
	private CodeManager codeManager;
	private DescriptionManager descriptionManager;

	// Constructor

	public ApplicationController() {
		codeManager = new MapCodeManager();
		descriptionManager = new ListDescriptionManager();
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
	}
}
