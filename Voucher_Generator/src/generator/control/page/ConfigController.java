package generator.control.page;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;

import generator.control.display.IDisplayController;
import generator.control.manager.code.CodeManager;
import generator.control.manager.theme.IThemeManager;
import generator.helper.converter.ValueConverter;
import generator.view.display.config.chargroup.CharGroupDisplay;
import generator.view.display.config.encoding.EncodeDisplay;
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

	private boolean updatedManager;
	private Map<String, IDisplayController> displayControllers;

	public ConfigController(CodeManager codeManager, IThemeManager themeManager) {
		this.displayControllers = createControllers();
		this.codeManager = codeManager;
		this.themeManager = themeManager;
	}

	// Methods

	@Override
	protected PageView createView() {
		if (configView == null)
			configView = createConfigView();

		return configView;
	}

	@Override
	public void update() {
		if (updatedManager) {
			updateEncodeDisplay();
			updateGroupDisplay();
		}
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
		tmp.addEncodBtnListener(e -> {
			configView.setContent(displayControllers.get("encode").getDisplay());
		});
		tmp.addGroupBtnListener(e -> {
			configView.setContent(displayControllers.get("group").getDisplay());
		});
		tmp.addThemeBtnListener(e -> {

		});
		return tmp;
	}

	// Helper Methods

	private void updateGroupDisplay() {
		CharGroupDisplay display = (CharGroupDisplay) displayControllers.get("group").getDisplay();
		display.setContent(ValueConverter.convertConfigurationToArray(codeManager.getConfigurations()));
		display.addContentListener(new MouseAdapter() {

		});
	}

	/**
	 * Refreshes the content JList of the encode display and then adds the mouse
	 * listener to the new content.
	 */
	private void updateEncodeDisplay() {
		EncodeDisplay display = (EncodeDisplay) displayControllers.get("encode").getDisplay();
		display.setContent(ValueConverter.convertConfigurationToArray(codeManager.getConfigurations()));
		display.addContentListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Update Image");
			}
		});
	}

	// Display contructor functions

	private Map<String, IDisplayController> createControllers() {
		Map<String, IDisplayController> tmp = new HashMap<String, IDisplayController>();
		tmp.put("encode", createEncodeController());
		tmp.put("group", createCharGroupController());
		return tmp;
	}

	private IDisplayController createCharGroupController() {
		return new IDisplayController() {
			private CharGroupDisplay charGroupDisplay;

			@Override
			public JPanel getDisplay() {
				if (charGroupDisplay == null) {
					// Set up the display
					charGroupDisplay = new CharGroupDisplay();
					charGroupDisplay
							.setContent(ValueConverter.convertConfigurationToArray(codeManager.getConfigurations()));
					charGroupDisplay.setCellRenderer(themeManager.getCellRenderer());
					// Action Listeners
					charGroupDisplay.addAddBtnListener(e -> {

					});
					charGroupDisplay.addRemoveBtnListener(e -> {

					});
					charGroupDisplay.addUpdateBtnListener(e -> {

					});
					charGroupDisplay.addContentListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							System.out.println("Update fields");
						}
					});
				}
				return charGroupDisplay;
			}
		};
	}

	private IDisplayController createEncodeController() {
		return new IDisplayController() {
			private EncodeDisplay encodeDisplay;

			@Override
			public JPanel getDisplay() {
				if (encodeDisplay == null) {
					// Set up the display
					encodeDisplay = new EncodeDisplay();
					encodeDisplay
							.setContent(ValueConverter.convertConfigurationToArray(codeManager.getConfigurations()));
					encodeDisplay.setCellRenderer(themeManager.getCellRenderer());
					// Action Listeners
					encodeDisplay.addEnableBtnListener(e -> {

					});
					encodeDisplay.addDisableBtnListener(e -> {

					});
					encodeDisplay.addContentListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							System.out.println("Update Image");
						}
					});
				}
				return encodeDisplay;
			}
		};
	}
}
