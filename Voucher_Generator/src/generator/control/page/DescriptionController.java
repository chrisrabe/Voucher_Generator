package generator.control.page;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import generator.control.display.IDisplayController;
import generator.control.manager.code.CodeManager;
import generator.control.manager.description.DescriptionManager;
import generator.control.manager.theme.IThemeManager;
import generator.helper.converter.ValueConverter;
import generator.helper.exception.EmptyCollectionException;
import generator.helper.exception.InvalidInputException;
import generator.view.display.description.add.AddDisplay;
import generator.view.page.PageView;
import generator.view.page.description.DescriptionView;
import vgcomponents.dialogs.VGDialog;

/**
 * This class implements the action listeners for the description view.
 * 
 * @author Chris
 */
public class DescriptionController extends PageController {

	private DescriptionView descriptionView;
	private CodeManager codeManager;
	private DescriptionManager descriptionManager;
	private IThemeManager themeManager;

	private Map<String, IDisplayController> displayControllers;
	private JDialog curDialog;

	public DescriptionController(DescriptionManager descriptionManager, CodeManager codeManager,
			IThemeManager themeManager) {
		displayControllers = createControllers();
		this.descriptionManager = descriptionManager;
		this.codeManager = codeManager;
		this.themeManager = themeManager;
	}

	// Methods

	@Override
	public void update() {
		String[] data = ValueConverter.convertDescriptionsToArray(descriptionManager.getDescriptions());
		if (descriptionView != null) {
			descriptionView.setContent(data);
			descriptionView.setCellRenderer(themeManager.getCellRenderer());
		}
		if (descriptionView != null && themeManager.themeChanged())
			descriptionView.setCellRenderer(themeManager.getCellRenderer());
	}

	@Override
	protected PageView createView() {
		if (descriptionView == null)
			descriptionView = createDescriptionView();

		return descriptionView;
	}

	// Model Methods

	/**
	 * Distributes the description from the description manager into
	 */
	private void distribute() {
		try {
			if (!codeManager.getCodes().isEmpty()) {
				descriptionManager.distribute(codeManager.getCodes());
				navigation.updateControllers();
				show("Distribution Successful. Check vouchers to see result.");
			} else {
				throw new EmptyCollectionException("You must produce codes in order to distribute descriptions.");
			}
		} catch (EmptyCollectionException e) {
			show(e.getMessage(), JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Removes the selected item from the list.
	 */
	private void delete() {
		String line = descriptionView.getSelectedItem();
		if (line == null || line.equals(" ")) {
			show("You must select an item to delete");
			return;
		}
		try {
			descriptionManager.getStorage().remove(line.trim());
			update();
		} catch (EmptyCollectionException e) {
			show(e.getMessage(), JOptionPane.ERROR_MESSAGE);
		}
	}

	private void add() {
		AddDisplay display = (AddDisplay) displayControllers.get("add").getDisplay();
		display.setDescriptionField("");
		// Show display
		disposeDialog();
		curDialog = new VGDialog(navigation, display);
	}

	// Helper Methods

	private void disposeDialog() {
		if (curDialog != null) {
			curDialog.dispose();
			curDialog = null;
		}
	}

	private Map<String, IDisplayController> createControllers() {
		Map<String, IDisplayController> tmp = new HashMap<String, IDisplayController>();
		tmp.put("add", createAddController());
		return tmp;
	}

	private DescriptionView createDescriptionView() {
		DescriptionView tmp = new DescriptionView();
		tmp.setCellRenderer(themeManager.getCellRenderer());
		// Add navigation listeners
		tmp.addHomeBtnListener(e -> {
			navigation.navigateTo("home");
		});
		tmp.addVoucherBtnListener(e -> {
			navigation.navigateTo("voucher");
		});
		tmp.addIoBtnListener(e -> {
			navigation.navigateTo("io");
		});
		tmp.addConfigBtnListener(e -> {
			navigation.navigateTo("config");
		});
		// Add function listeners
		tmp.addClrBtnListener(e -> {
			descriptionManager.clear();
			update();
		});
		tmp.addDisBtnListener(e -> {
			distribute();
		});
		tmp.addDelBtnListener(e -> {
			delete();
		});
		tmp.addAddBtnListener(e -> {
			add();
		});
		return tmp;
	}

	// Constructor functions

	private IDisplayController createAddController() {
		return new IDisplayController() {
			private AddDisplay display;

			@Override
			public JPanel getDisplay() {
				display = new AddDisplay();
				display.addConfirmBtnListener(e -> {
					String value = display.getDescriptionField();
					if (value != null && !value.matches("\\s+")) {
						try {
							descriptionManager.addDescription(value);
							disposeDialog();
							update();
						} catch (InvalidInputException e1) {
							show(e1.getMessage(), JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				return display;
			}
		};
	}
}
