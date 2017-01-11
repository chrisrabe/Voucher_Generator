package generator.control.page;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;

import generator.control.display.IDisplayController;
import generator.control.manager.code.CodeManager;
import generator.control.manager.theme.IThemeManager;
import generator.helper.converter.ValueConverter;
import generator.view.display.config.chargroup.CharGroupDisplay;
import generator.view.display.config.encoding.EncodeDisplay;
import generator.view.display.config.themes.ThemesDisplay;
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
		if (themeManager.themeChanged() || updatedManager) {
			updateEncodeDisplay();
			updateGroupDisplay();
			if (themeManager.themeChanged()) {
				updateThemesDisplay();
				navigation.updateControllers();
			}
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
			configView.setContent(displayControllers.get("themes").getDisplay());
		});
		return tmp;
	}

	// Helper Methods

	/**
	 * Updates the two character fields based from the selected character group.
	 * 
	 * @param display
	 */
	private void updateGroupDisplay(CharGroupDisplay display) {
		System.out.println("Update fields");
	}

	/**
	 * Updates the active indicator image based from the selected character
	 * group.
	 * 
	 * @param display
	 */
	private void updateEncodeDisplay(EncodeDisplay display) {
		System.out.println("Update image");
	}

	/**
	 * Updates the theme view's content to the selected theme.
	 * 
	 * @param display
	 */
	private void updateThemesDisplay(ThemesDisplay display) {
		System.out.println("Update content");
	}

	private void updateThemesDisplay() {
		
	}

	/**
	 * Refreshes the encode display
	 */
	private void updateGroupDisplay() {
		CharGroupDisplay display = (CharGroupDisplay) displayControllers.get("group").getDisplay();
		display.setContent(ValueConverter.convertConfigurationToArray(codeManager.getConfigurations()));
		display.addContentListener(createMouseListener(() -> {
			updateGroupDisplay(display);
		}));
	}

	/**
	 * Refreshes the content JList of the encode display and then adds the mouse
	 * listener to the new content.
	 */
	private void updateEncodeDisplay() {
		EncodeDisplay display = (EncodeDisplay) displayControllers.get("encode").getDisplay();
		display.setContent(ValueConverter.convertConfigurationToArray(codeManager.getConfigurations()));
		display.addContentListener(createMouseListener(() -> {
			updateEncodeDisplay(display);
		}));
	}

	/**
	 * Creates a mouse listener and runs the function passed whenever the mouse
	 * is clicked
	 * 
	 * @param function
	 * @return
	 */
	public MouseListener createMouseListener(Runnable function) {
		return new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				function.run();
			}
		};
	}

	// Display contructor functions

	private Map<String, IDisplayController> createControllers() {
		Map<String, IDisplayController> tmp = new HashMap<String, IDisplayController>();
		tmp.put("encode", createEncodeController());
		tmp.put("group", createCharGroupController());
		tmp.put("themes", createThemesController());
		return tmp;
	}

	private IDisplayController createThemesController() {
		return new IDisplayController() {
			private ThemesDisplay themesDisplay;

			@Override
			public JPanel getDisplay() {
				if (themesDisplay == null) {
					themesDisplay = new ThemesDisplay();
					// Set up the display
					// Action Listeners
					themesDisplay.addConfirmBtnListener(e -> {

					});
					themesDisplay.addContentListener(createMouseListener(() -> {
						updateThemesDisplay(themesDisplay);
					}));
				}
				return themesDisplay;
			}
		};
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
					charGroupDisplay.addContentListener(createMouseListener(() -> {
						updateGroupDisplay(charGroupDisplay);
					}));
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
					encodeDisplay.addContentListener(createMouseListener(() -> {
						updateEncodeDisplay(encodeDisplay);
					}));
				}
				return encodeDisplay;
			}
		};
	}
}
