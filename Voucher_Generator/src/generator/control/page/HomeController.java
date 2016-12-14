package generator.control.page;

import generator.control.ApplicationController;
import generator.resources.Resources;
import generator.view.page.PageView;
import generator.view.page.home.Home;

/**
 * This class is responsible for navigating to other views.
 * 
 * @author Chris
 */
public class HomeController extends PageController {

	public HomeController(ApplicationController main) {
		super(main, Resources.getNavigationImagePath("home.png"), "Home");
	}

	@Override
	public PageView createView() {
		return new Home();
	}
}
