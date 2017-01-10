package generator.control.page;

import generator.view.page.PageView;
import generator.view.page.config.Config;

/**
 * This class is responsible for implementing the listeners to the config view.
 * 
 * @author Chris
 */
public class ConfigController extends PageController {

	private Config configView;

	public ConfigController() {
		// Need a code manager
		// Need theme manager
	}

	@Override
	protected PageView createView() {
		if (configView == null)
			configView = createConfigView();

		return configView;
	}

	private Config createConfigView() {
		Config tmp = new Config();
		// Navigation
		tmp.addHomeBtnListener(e -> {
			navigation.navigateTo("home");
		});
		tmp.addVouchBtnListener(e -> {
			navigation.navigateTo("voucher");
		});
		tmp.addDescBtnListener(e -> {
			navigation.navigateTo("description");
		});
		tmp.addIoBtnListener(e -> {
			navigation.navigateTo("io");
		});
		return tmp;
	}
}
