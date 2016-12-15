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
	protected PageView createView() {
		if (homeView == null)
			homeView = createHomeView();

		return homeView;
	}

	// Helper Methods

	/**
	 * Creates the home view and adds action listeners to the view.
	 * 
	 * @return
	 */
	private Home createHomeView() {
		Home tmp = new Home();
		tmp.addIOBtnListener(e -> {
			main.navigateTo("io");
		});
		tmp.addVoucherBtnListener(e -> {
			main.navigateTo("voucher");
		});
		return tmp;
	}
}
