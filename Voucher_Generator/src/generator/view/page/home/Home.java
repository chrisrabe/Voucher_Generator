package generator.view.page.home;

import java.awt.event.ActionListener;

/**
 * This class is responsible for providing methods which adds action listener to
 * the home view components.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class Home extends HomeView {

	public Home() {
		this.initialiseComponents();
	}

	/**
	 * Adds a listener to the configuration button
	 * 
	 * @param listener
	 */
	public void addConfigBtnListener(ActionListener listener) {
		this.configBtn.addActionListener(listener);
	}

	/**
	 * Adds a listener to the io button.
	 * 
	 * @param listener
	 */
	public void addIOBtnListener(ActionListener listener) {
		this.ioBtn.addActionListener(listener);
	}

	/**
	 * Adds a listener to the voucher button
	 * 
	 * @param listener
	 */
	public void addVoucherBtnListener(ActionListener listener) {
		this.voucherBtn.addActionListener(listener);
	}

	/**
	 * Adds a listener to the description button
	 * 
	 * @param listener
	 */
	public void addDescriptionBtnListener(ActionListener listener) {
		this.descBtn.addActionListener(listener);
	}
}
