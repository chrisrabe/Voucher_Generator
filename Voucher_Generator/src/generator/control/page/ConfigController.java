package generator.control.page;

import generator.control.ApplicationController;
import generator.view.page.PageView;
import generator.view.page.config.Config;

/**
 * This class is responsible for implementing the listeners to the config view.
 * 
 * @author Chris
 */
public class ConfigController extends PageController {
	private Config configView;

	public ConfigController(ApplicationController main) {
		super(main);
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
			main.navigateTo("home");
		});
		tmp.addVouchBtnListener(e -> {
			main.navigateTo("voucher");
		});
		tmp.addDescBtnListener(e -> {
			main.navigateTo("description");
		});
		tmp.addIoBtnListener(e -> {
			main.navigateTo("io");
		});
		return tmp;
	}

}
