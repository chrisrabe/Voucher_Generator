package generator.control.manager.navigation;

import java.util.Map;

import generator.control.manager.theme.IThemeManager;
import generator.control.page.PageController;
import generator.view.window.ApplicationWindow;

public class NavigationManager implements INavigationManager {

	private ApplicationWindow application;
	private Map<String, PageController> controllers;
	private IThemeManager themeManager;

	public NavigationManager(ApplicationWindow application, Map<String, PageController> controllers,
			IThemeManager themeManager) {
		this.application = application;
		for (PageController controller : controllers.values()) {
			controller.setNavigationController(this);
		}
		this.controllers = controllers;
		this.themeManager = themeManager;
	}

	@Override
	public ApplicationWindow getWindow() {
		return application;
	}

	@Override
	public void navigateTo(String page) {
		PageController controller = controllers.get(page);
		application.setContent(controller.getView());
	}

	@Override
	public void updateControllers() {
		for (PageController controller : controllers.values()) {
			controller.update();
		}
		if (themeManager.themeChanged()) {
			themeManager.setChanged(false);
		}
	}

}
