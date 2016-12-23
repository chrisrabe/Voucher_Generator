package generator.view.display.io.load;

import java.awt.event.ActionListener;

/**
 * This class provides methods which add listeners to the components.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class Load extends LoadDisplay {

	public Load() {
		this.initialiseComponents();
	}

	public void addXmlBtnListener(ActionListener listener) {
		xmlBtn.addActionListener(listener);
	}

	public void addTxtBtnListener(ActionListener listener) {
		txtBtn.addActionListener(listener);
	}
}