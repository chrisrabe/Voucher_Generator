package generator.control.page;

import generator.view.page.PageView;
import generator.view.page.home.HomeView;

/**
 * This class is responsible for adding action listeners to the home view.
 * 
 * @author Chris
 */
public class HomeController extends PageController {
	private HomeView homeView; // This controller is binded to home view.

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
	private HomeView createHomeView() {
		HomeView tmp = new HomeView();
		tmp.addIOBtnListener(e -> {
			navigation.navigateTo("io");
		});
		tmp.addVoucherBtnListener(e -> {
			navigation.navigateTo("voucher");
		});
		tmp.addDescriptionBtnListener(e -> {
			navigation.navigateTo("description");
		});
		tmp.addConfigBtnListener(e -> {
			navigation.navigateTo("config");
		});
		return tmp;
	}
}
