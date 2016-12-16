package generator.view.display.io.save;

import java.awt.event.ActionListener;

/**
 * This class is responsible for adding action listener methods to the save
 * display.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class Save extends SaveDisplay {

	public Save() {
		this.initialiseComponents();
	}

	public void addXmlBtnListener(ActionListener listener) {
		xmlBtn.addActionListener(listener);
	}

	public void addTxtBtnListener(ActionListener listener) {
		txtBtn.addActionListener(listener);
	}

	public void addPngBtnListener(ActionListener listener) {
		pngBtn.addActionListener(listener);
	}
}
