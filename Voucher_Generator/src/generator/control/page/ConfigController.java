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
import generator.helper.groups.character.CharacterGroup;
import generator.view.display.config.chargroup.CharGroupDisplay;
import generator.view.display.config.encoding.EncodeDisplay;
import generator.view.display.config.themes.ThemesDisplay;
import generator.helper.exception.InvalidInputException;
import generator.view.page.PageView;
import generator.view.page.config.ConfigView;
import vgcomponents.themes.IVGTheme;
import vgcomponents.themes.renderer.VGThemeRenderer;

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
	private boolean updatingControllers;
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
			updatedManager = false;
		}
		if (themeManager.themeChanged()) {
			updateThemesDisplay();
			if(!updatingControllers){
				updatingControllers = true;
				navigation.updateControllers();
			}
			updatingControllers = false;
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
		CharacterGroup group = getSelectedGroup(display.getSelectedItem());
		if (group != null) {
			display.setCharactersField(new String(group.getCharacters()));
			display.setNameField(group.getName());
		}
	}

	/**
	 * Updates the active indicator image based from the selected character
	 * group.
	 * 
	 * @param display
	 */
	private void updateEncodeDisplay(EncodeDisplay display) {
		CharacterGroup group = getSelectedGroup(display.getSelectedItem());
		if (group != null)
			display.setImage(group.isActive() ? "active_icon" : "inactive_icon");
	}

	/**
	 * Updates the theme view's content to the selected theme.
	 * 
	 * @param display
	 */
	private void updateThemesDisplay(ThemesDisplay display) {
		IVGTheme theme = themeManager.getTheme(display.getSelectedIndex());
		if (theme != null)
			display.setCellRenderer(new VGThemeRenderer(theme));
	}

	private void updateThemesDisplay() {
		ThemesDisplay display = (ThemesDisplay) displayControllers.get("themes").getDisplay();
		display.setContent(ValueConverter.convertThemesToArray(themeManager));
		display.setCellRenderer(themeManager.getCellRenderer());
		display.addContentListener(createMouseListener(() -> {
			updateThemesDisplay(display);
		}));
	}

	/**
	 * Refreshes the encode display
	 */
	private void updateGroupDisplay() {
		CharGroupDisplay display = (CharGroupDisplay) displayControllers.get("group").getDisplay();
		display.setCellRenderer(themeManager.getCellRenderer());
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
		display.setCellRenderer(themeManager.getCellRenderer());
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
			public void mouseReleased(MouseEvent e) {
				function.run();
			}
		};
	}

	private CharacterGroup getSelectedGroup(String selected) {
		if (selected == null || selected.matches("\\s+"))
			return null;
		return codeManager.getConfigurations().getCharacterGroup(selected);
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
					// Set up the display
					themesDisplay = new ThemesDisplay();
					themesDisplay.setContent(ValueConverter.convertThemesToArray(themeManager));
					themesDisplay.setCellRenderer(themeManager.getCellRenderer());
					// Action Listeners
					themesDisplay.addConfirmBtnListener(e -> {
						IVGTheme theme = themeManager.getTheme(themesDisplay.getSelectedIndex());
						if (theme != null) {
							themeManager.setTheme(theme);
							update();
						}
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
						String name = charGroupDisplay.getNameField();
						String characters = charGroupDisplay.getCharactersField();
						if (name.matches("\\s+") || characters.matches("\\s+")) {
							show("Both fields must be filled in");
						} else {
							CharacterGroup group = new CharacterGroup(name, characters.toCharArray());
							try {
								codeManager.getConfigurations().addCharacterGroup(group);
								updatedManager = true;
								update();
							} catch (InvalidInputException e1) {
								show(e1.getMessage());
							}
						}
					});
					charGroupDisplay.addRemoveBtnListener(e -> {
						CharacterGroup group = getSelectedGroup(charGroupDisplay.getSelectedItem());
						if (group != null) {
							try {
								codeManager.getConfigurations().removeCharacterGroup(group.getName());
								updatedManager = true;
								update();
							} catch (InvalidInputException e1) {
								show(e1.getMessage());
							}
						}
					});
					charGroupDisplay.addUpdateBtnListener(e -> {
						CharacterGroup group = getSelectedGroup(charGroupDisplay.getSelectedItem());
						if (group != null) {
							updatedManager = true;
							group.setName(charGroupDisplay.getNameField());
							group.setCharacters(charGroupDisplay.getCharactersField().toCharArray());
							update();
						}
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
						toggleGroup(encodeDisplay, true);
					});
					encodeDisplay.addDisableBtnListener(e -> {
						toggleGroup(encodeDisplay, false);
					});
					encodeDisplay.addContentListener(createMouseListener(() -> {
						updateEncodeDisplay(encodeDisplay);
					}));
				}
				return encodeDisplay;
			}

			private void toggleGroup(EncodeDisplay display, boolean state) {
				CharacterGroup group = getSelectedGroup(display.getSelectedItem());
				group.setActive(state);
				updateEncodeDisplay(display);
			}
		};
	}
}
