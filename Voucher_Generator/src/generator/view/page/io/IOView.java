package generator.view.page.io;

import java.awt.event.ActionListener;

import javax.swing.JPanel;

/**
 * This class represents the IO page view. It adds action listeners to the
 * components of IOView.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class IOView extends IOGUI {

	public IOView() {
		this.initialiseComponents();
	}

	// Navigation Listeners

	public void addHomeBtnListener(ActionListener listener) {
		this.homeBtn.addActionListener(listener);
	}

	public void addConfigBtnListener(ActionListener listener) {
		this.configBtn.addActionListener(listener);
	}

	public void addDescBtnListener(ActionListener listener) {
		this.descBtn.addActionListener(listener);
	}

	public void addVouchBtnListener(ActionListener listener) {
		this.vouchBtn.addActionListener(listener);
	}

	// IO Listeners

	public void addLoadBtnListener(ActionListener listener) {
		this.loadBtn.addActionListener(listener);
	}

	public void addSaveBtnListener(ActionListener listener) {
		this.saveBtn.addActionListener(listener);
	}

	// Display Methods

	public void setDisplayContent(JPanel newContent) {
		display.remove(content);
		content = newContent;
		display.add(newContent);
		this.revalidate();
		this.repaint();
	}
}
