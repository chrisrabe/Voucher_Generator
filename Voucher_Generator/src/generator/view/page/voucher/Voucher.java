package generator.view.page.voucher;

import javax.swing.JFrame;

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

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.add(new Voucher());
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
