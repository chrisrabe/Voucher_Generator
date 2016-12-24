package generator.control.page;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import generator.control.display.IDisplayController;
import generator.control.manager.code.CodeManager;
import generator.helper.converter.ValueConverter;
import generator.helper.exception.EmptyCollectionException;
import generator.helper.exception.InvalidInputException;
import generator.helper.exception.TimeoutException;
import generator.models.code.Code;
import generator.view.display.voucher.add.Add;
import generator.view.display.voucher.edit.Edit;
import generator.view.display.voucher.generate.Generate;
import generator.view.page.PageView;
import generator.view.page.voucher.Voucher;
import vgcomponents.dialogs.VGDialog;

public class VoucherController extends PageController {

	private Voucher voucherView;
	private CodeManager codeManager;

	private String[] cache;
	private Map<String, IDisplayController> displayControllers;
	private JDialog curDialog;

	public VoucherController(CodeManager codeManager) {
		displayControllers = createControllers();
		this.codeManager = codeManager;
	}

	// Model Interaction Methods

	public void editCode(String id, String newDescription) {
		try {
			Code code = codeManager.getStorage().get(id);
			code.setDescription(newDescription);
		} catch (EmptyCollectionException e) {
			show(e.getMessage());
		}
	}

	public void delCode(String id) {
		try {
			codeManager.getStorage().remove(id);
		} catch (InvalidInputException | EmptyCollectionException e) {
			show(e.getMessage(), JOptionPane.ERROR_MESSAGE);
		}
	}

	public void generate(int chars, int size) {
		try {
			codeManager.generateCode(chars, size);
		} catch (InvalidInputException | TimeoutException e) {
			show(e.getMessage());
		}
	}

	private void editCode(String id) {
		try {
			// Update the edit display
			Code code = codeManager.getStorage().get(id);
			Edit display = (Edit) displayControllers.get("edit").getDisplay();
			display.setIDField(code.getID());
			display.setDescriptionField(code.getDescription());
			// Show display
			disposeDialog();
			curDialog = new VGDialog(navigation, display);
		} catch (EmptyCollectionException e) {
			show(e.getMessage());
		}
	}

	private void addCode() {
		// Reset display fields
		Add display = (Add) displayControllers.get("add").getDisplay();
		display.setIDField("");
		display.setDescriptionField("");
		// Show display
		disposeDialog();
		curDialog = new VGDialog(navigation, display);
	}

	private void generate() {
		// Reset display fields
		Generate display = (Generate) displayControllers.get("gen").getDisplay();
		display.setCharsField("");
		display.setSizeField("");
		// Show display
		disposeDialog();
		curDialog = new VGDialog(navigation, display);
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

	private void disposeDialog() {
		if (curDialog != null) {
			curDialog.dispose();
			curDialog = null;
		}
	}

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
			if (id != null) {
				delCode(id);
				update();
			}
		});
		tmp.addClrBtnListener(e -> {
			codeManager.clear();
			update();
		});
		tmp.addAddBtnListener(e -> {
			addCode();
		});
		tmp.addEdtBtnListener(e -> {
			String id = getCodeID(voucherView.getSelectedItem());
			if (id != null)
				editCode(id);
		});
		tmp.addGenBtnListener(e -> {
			generate();
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
						String chars = generateDisplay.getCharsField().trim();
						String size = generateDisplay.getSizeField().trim();
						if (isNumeric(chars) && isNumeric(size)) {
							generate(Integer.parseInt(chars), Integer.parseInt(size));
							update();
						} else {
							show("Fields must be a number");
						}
						curDialog.dispose();
						curDialog = null;
					});
				}
				return generateDisplay;
			}

			private boolean isNumeric(String s) {
				if (s == null)
					return false;
				return s.matches("[-+]?\\d*\\.?\\d+");
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
						String id = editDisplay.getIDField();
						String desc = editDisplay.getDescriptionField();
						editCode(id, desc);
						disposeDialog();
						update();
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
						String length = addDisplay.getLengthField();
						if (isNumeric(length)) {
							try {
								addDisplay.setIDField(codeManager.generateCodeID(Integer.parseInt(length)));
							} catch (NumberFormatException | InvalidInputException e1) {
								show(e1.getMessage());
							}
						} else {
							show("Length field must be a number.");
						}
					});
					addDisplay.addConfirmBtnListener(e -> {
						String id = addDisplay.getIDField().trim();
						String desc = addDisplay.getDescriptionField().trim();
						if (id.equals("") || desc.equals("")) {
							show("ID and Description fields must be filled in.");
						} else {
							codeManager.getStorage().add(new Code(id, desc));
							disposeDialog();
							update();
						}
					});
				}
				return addDisplay;
			}

			private boolean isNumeric(String s) {
				if (s == null)
					return false;
				return s.matches("[-+]?\\d*\\.?\\d+");
			}
		};
	}

}
