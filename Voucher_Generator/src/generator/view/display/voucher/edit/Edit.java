package generator.view.display.voucher.edit;

import java.awt.event.ActionListener;

/**
 * This class is responsible for implementing methods to the components of the
 * edit display.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class Edit extends EditDisplay {

	public Edit() {
		this.initialiseComponents();
	}

	// Button methods here

	public void addConfirmBtnListener(ActionListener listener) {
		confirmBtn.addActionListener(listener);
	}

	// Field methods here

	public String getIDField() {
		return idField.getText();
	}

	public void setIDField(String id) {
		idField.setText(id);
	}

	public String getDescriptionField() {
		return descriptionField.getText();
	}

	public void setDescriptionField(String description) {
		descriptionField.setText(description);
	}
}
