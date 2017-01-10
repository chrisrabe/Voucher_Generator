package generator.control.page;

import generator.control.manager.code.CodeManager;
import generator.control.manager.theme.IThemeManager;
import generator.view.page.PageView;
import generator.view.page.config.ConfigView;

/**
 * This class is responsible for implementing the listeners to the config view.
 * 
 * @author Chris
 */
public class ConfigController extends PageController {

	private ConfigView configView;
	private CodeManager codeManager;
	private IThemeManager themeManager;

	public ConfigController(CodeManager codeManager, IThemeManager themeManager) {
		this.codeManager = codeManager;
		this.themeManager = themeManager;
	}

	@Override
	protected PageView createView() {
		if (configView == null)
			configView = createConfigView();

		return configView;
	}

	private ConfigView createConfigView() {
		ConfigView tmp = new ConfigView();
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
