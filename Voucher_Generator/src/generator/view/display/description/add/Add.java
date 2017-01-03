package generator.view.display.description.add;

import java.awt.event.ActionListener;

/**
 * This class provides methods that adds listeners to the components of the add
 * display.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class Add extends AddDisplay {

	public Add() {
		this.initialiseComponents();
	}

	/**
	 * Adds an action listener to the confirm button.
	 * 
	 * @param listener
	 */
	public void addConfirmBtnListener(ActionListener listener) {
		confirmBtn.addActionListener(listener);
	}

	public void setDescriptionField(String text) {
		descriptionField.setText(text);
	}

	/**
	 * Retrieves the string inside the description field.
	 * 
	 * @return
	 */
	public String getDescriptionField() {
		return descriptionField.getText();
	}
}
