package generator.view.display.voucher.add;

import java.awt.event.ActionListener;

/**
 * This class is responsible for creating methods that will link the view to the
 * controller.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class Add extends AddDisplay {

	public Add() {
		this.initialiseComponents();
	}

	// Button Methods

	public void addConfirmBtnListener(ActionListener listener) {
		confirmBtn.addActionListener(listener);
	}

	public void addGenerateBtnListener(ActionListener listener) {
		generateBtn.addActionListener(listener);
	}

	// Field Methods

	public String getIDField() {
		return idField.getText();
	}

	public void setIDField(String text) {
		idField.setText(text);
	}

	public String getDescriptionField() {
		return descriptionField.getText();
	}

	public void setDescriptionField(String text) {
		descriptionField.setText(text);
	}

	public String getLengthField() {
		return lengthField.getText();
	}

	public void setLengthField(String text) {
		lengthField.setText(text);
	}
}
