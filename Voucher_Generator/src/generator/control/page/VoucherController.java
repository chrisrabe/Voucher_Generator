package generator.control.page;

import generator.control.ApplicationController;
import generator.view.page.PageView;
import generator.view.page.voucher.Voucher;

public class VoucherController extends PageController {
	private Voucher voucherView;

	public VoucherController(ApplicationController main) {
		super(main);
	}

	// Methods

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
		return tmp;
	}

}
