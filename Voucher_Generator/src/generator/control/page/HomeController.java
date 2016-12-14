package generator.control.page;

import generator.control.ApplicationController;
import generator.view.page.PageView;
import generator.view.page.home.Home;

/**
 * This class is responsible for adding action listeners to the home view.
 * 
 * @author Chris
 */
public class HomeController extends PageController {
	private Home homeView; // This controller is binded to home view.

	public HomeController(ApplicationController main) {
		super(main);
	}

	@Override
	public PageView createView() {
		if (homeView == null)
			homeView = new Home();

		return homeView;
	}
}
