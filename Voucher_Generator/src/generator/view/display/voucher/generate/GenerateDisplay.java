package generator.view.display.voucher.generate;

import java.awt.event.ActionListener;

/**
 * This class is responsible for creating methods that interact with the display
 * components.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class GenerateDisplay extends GenerateGUI {

	public GenerateDisplay() {
		this.initialiseComponents();
	}

	// Button listener

	public void addGenerateBtnListener(ActionListener listener) {
		generateBtn.addActionListener(listener);
	}

	// Field Methods

	public String getCharsField() {
		return charsField.getText();
	}

	public void setCharsField(String text) {
		this.charsField.setText(text);
	}

	public String getSizeField() {
		return sizeField.getText();
	}

	public void setSizeField(String text) {
		sizeField.setText(text);
	}
}
