package generator.control.page;

import generator.control.ApplicationController;
import generator.helper.converter.ValueConverter;
import generator.helper.exception.EmptyCollectionException;
import generator.helper.exception.InvalidInputException;
import generator.helper.exception.TimeoutException;
import generator.models.code.Code;
import generator.view.page.PageView;
import generator.view.page.voucher.Voucher;

public class VoucherController extends PageController {
	private Voucher voucherView;

	public VoucherController(ApplicationController main) {
		super(main);
	}

	// Model Interaction Methods

	public void addCode(Code code) {

	}

	public void delCode(String id) {
		try {
			main.getCodeManager().getStorage().remove(id);
			update();
		} catch (InvalidInputException | EmptyCollectionException e) {
			// Do nothing because null pointers already handled
		}
	}

	public void generate(int chars, int size) {
		try {
			main.getCodeManager().generateCode(chars, size);
			update();
		} catch (InvalidInputException | TimeoutException e) {
			// Ignore
		}
	}

	// Methods

	/**
	 * This method tells this controller that some changes have been made and
	 * the display should be updated. This method exists because if the io
	 * controller or the description controller executes methods which changes
	 * the vouchers, this controller needs to know in order to update its view.
	 */
	public void update() {
		String[] data = ValueConverter.convertCodeToArray(main.getCodeManager().getCodes());
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
			main.navigateTo("home");
		});
		tmp.addIoBtnListener(e -> {
			main.navigateTo("io");
		});
		tmp.addDescBtnListener(e -> {
			main.navigateTo("description");
		});
		tmp.addConfigBtnListener(e -> {
			main.navigateTo("config");
		});
		tmp.addAddBtnListener(e -> {
			// Add Logic Here
		});
		tmp.addDelBtnListener(e -> {
			String var = voucherView.getSelectedItem();
			if (var == " " || var == null) {
				show("You must select an item to delete");
			} else {
				delCode(var.split(" ")[0]);
			}
		});
		tmp.addEdtBtnListener(e -> {
			// Edit Logic Here
		});
		tmp.addGenBtnListener(e -> {
			generate(5, 5);
		});
		tmp.addClrBtnListener(e -> {
			main.getCodeManager().clear();
			update();
		});
		return tmp;
	}

}
