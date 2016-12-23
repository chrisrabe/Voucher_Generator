package generator.control.page;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import generator.control.display.IDisplayController;
import generator.control.manager.code.CodeManager;
import generator.helper.converter.ValueConverter;
import generator.helper.exception.EmptyCollectionException;
import generator.helper.exception.InvalidInputException;
import generator.helper.exception.TimeoutException;
import generator.view.display.voucher.add.Add;
import generator.view.display.voucher.edit.Edit;
import generator.view.display.voucher.generate.Generate;
import generator.view.page.PageView;
import generator.view.page.voucher.Voucher;

public class VoucherController extends PageController {

	private Voucher voucherView;
	private CodeManager codeManager;

	private String[] cache;
	private Map<String, IDisplayController> displayControllers;

	public VoucherController(CodeManager codeManager) {
		displayControllers = createControllers();
		this.codeManager = codeManager;
	}

	// Model Interaction Methods

	public void delCode(String id) {
		try {
			codeManager.getStorage().remove(id);
			update();
		} catch (InvalidInputException | EmptyCollectionException e) {
			show(e.getMessage(), JOptionPane.ERROR_MESSAGE);
		}
	}

	public void generate(int chars, int size) {
		try {
			codeManager.generateCode(chars, size);
			update();
		} catch (InvalidInputException | TimeoutException e) {
			show(e.getMessage());
		}
	}

	// PageController Methods

	/**
	 * Changes the data inside the JList inside the voucher view. If the view
	 * has not been created yet, it caches the changes.
	 */
	@Override
	public void update() {
		String[] data = ValueConverter.convertCodeToArray(codeManager.getCodes());
		if (voucherView != null) {
			voucherView.setContent(data);
		} else {
			cache = data;
		}

	}

	@Override
	protected PageView createView() {
		if (voucherView == null)
			voucherView = createVoucherView();

		return voucherView;
	}

	// Helper Methods

	private Voucher createVoucherView() {
		Voucher tmp = new Voucher();
		// Check if there are cached data
		if (cache != null) {
			tmp.setContent(cache);
			cache = null; // release the cached data
		}
		// Add navigation listeners
		tmp.addHomeBtnListener(e -> {
			navigation.navigateTo("home");
		});
		tmp.addIoBtnListener(e -> {
			navigation.navigateTo("io");
		});
		tmp.addDescBtnListener(e -> {
			navigation.navigateTo("description");
		});
		tmp.addConfigBtnListener(e -> {
			navigation.navigateTo("config");
		});
		// Add function listeners
		tmp.addDelBtnListener(e -> {
			String id = getCodeID(voucherView.getSelectedItem());
			if (id != null)
				delCode(id);
		});
		tmp.addAddBtnListener(e -> {
			// Add Logic Here
		});
		tmp.addEdtBtnListener(e -> {
			// Edit Logic Here
		});
		tmp.addGenBtnListener(e -> {
			// Generate Logic Here
		});
		tmp.addClrBtnListener(e -> {
			codeManager.clear();
			update();
		});
		return tmp;
	}

	/**
	 * Retrieves the code ID from the given string.
	 * 
	 * @param line
	 * @return
	 */
	private String getCodeID(String line) {
		if (line == " " || line == null) {
			show("You must select an item to delete");
			return null;
		}
		return line.split(" ")[0];
	}

	private Map<String, IDisplayController> createControllers() {
		Map<String, IDisplayController> tmp = new HashMap<String, IDisplayController>();
		tmp.put("add", createAddController());
		tmp.put("edit", createEditController());
		tmp.put("gen", createGenerateController());
		return tmp;
	}

	// Display controllers

	private IDisplayController createGenerateController() {
		return new IDisplayController() {
			private Generate generateDisplay;

			@Override
			public JPanel getDisplay() {
				if (generateDisplay == null) {
					generateDisplay = new Generate();
					generateDisplay.addGenerateBtnListener(e -> {
						// Add generate logic here
					});
				}
				return generateDisplay;
			}
		};
	}

	private IDisplayController createEditController() {
		return new IDisplayController() {
			private Edit editDisplay;

			@Override
			public JPanel getDisplay() {
				if (editDisplay == null) {
					editDisplay = new Edit();
					editDisplay.addConfirmBtnListener(e -> {
						// Edit logic here
					});
				}
				return editDisplay;
			}
		};
	}

	private IDisplayController createAddController() {
		return new IDisplayController() {
			private Add addDisplay;

			@Override
			public JPanel getDisplay() {
				if (addDisplay == null) {
					addDisplay = new Add();
					addDisplay.addGenerateBtnListener(e -> {
						// generate code id here
					});
					addDisplay.addConfirmBtnListener(e -> {
						// add logic here
					});
				}
				return addDisplay;
			}
		};
	}

}
