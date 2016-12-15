package generator.view.page.voucher;

import java.awt.event.ActionListener;

/**
 * Contains methods which adds action listeners to the view and gets or sets
 * data from any components.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class Voucher extends VoucherView {

	public Voucher() {
		this.initialiseComponents();
	}

	// Navigation Action Listeners

	public void addHomeBtnListener(ActionListener listener) {
		homeBtn.addActionListener(listener);
	}

	public void addIoBtnListener(ActionListener listener) {
		ioBtn.addActionListener(listener);
	}

	public void addConfigBtnListener(ActionListener listener) {
		configBtn.addActionListener(listener);
	}

	public void addDescBtnListener(ActionListener listener) {
		descBtn.addActionListener(listener);
	}

	// Tool Bar Listeners

	public void addAddBtnListener(ActionListener listener) {
		addBtn.addActionListener(listener);
	}

	public void addDelBtnListener(ActionListener listener) {
		delBtn.addActionListener(listener);
	}

	public void addEdtBtnListener(ActionListener listener) {
		edtBtn.addActionListener(listener);
	}

	public void addGenBtnListener(ActionListener listener) {
		genBtn.addActionListener(listener);
	}

	public void addClrBtnListener(ActionListener listener) {
		clrBtn.addActionListener(listener);
	}
}
