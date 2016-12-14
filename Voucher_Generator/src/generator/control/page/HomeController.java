package generator.control.page;

import generator.control.ApplicationController;
import generator.view.page.PageView;
import generator.view.page.home.Home;

public class HomeController extends PageController {

	public HomeController(ApplicationController main) {
		super(main, "navigationIcon", "Home");
	}

	@Override
	public PageView createView() {
		return new Home();
	}
}
