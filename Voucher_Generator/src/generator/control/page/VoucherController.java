package generator.control.page;

import javax.swing.JOptionPane;

import generator.control.manager.code.CodeManager;
import generator.helper.converter.ValueConverter;
import generator.helper.exception.EmptyCollectionException;
import generator.helper.exception.InvalidInputException;
import generator.helper.exception.TimeoutException;
import generator.view.page.PageView;
import generator.view.page.voucher.Voucher;

public class VoucherController extends PageController {

	private Voucher voucherView;
	private CodeManager codeManager;

	public VoucherController(CodeManager codeManager) {
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

	// Methods

	/**
	 * This method tells this controller that some changes have been made and
	 * the display should be updated. This method exists because if the io
	 * controller or the description controller executes methods which changes
	 * the vouchers, this controller needs to know in order to update its view.
	 */
	@Override
	public void update() {
		String[] data = ValueConverter.convertCodeToArray(codeManager.getCodes());
		voucherView.setContent(data);
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
		tmp.addDelBtnListener(e -> {
			String var = voucherView.getSelectedItem();
			if (var == " " || var == null) {
				show("You must select an item to delete");
			} else {
				delCode(var.split(" ")[0]);
			}
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

}
