package generator.view.display.config.chargroup;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.ListCellRenderer;

import vgcomponents.lists.VGList;

/**
 * Provides methods for adding listeners and retrieving data from the GUI.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class CharGroupDisplay extends CharGroupGUI {

	public CharGroupDisplay() {
		this.initialiseComponents();
	}

	// Button Listeners

	public void addAddBtnListener(ActionListener listener) {
		addBtn.addActionListener(listener);
	}

	public void addRemoveBtnListener(ActionListener listener) {
		removeBtn.addActionListener(listener);
	}

	public void addUpdateBtnListener(ActionListener listener) {
		updateBtn.addActionListener(listener);
	}

	// Content Methods

	public void addContentListener(MouseListener listener) {
		content.addMouseListener(listener);
	}

	public void setCellRenderer(ListCellRenderer<String> renderer) {
		content.setCellRenderer(renderer);
		content.repaint();
	}

	public int getSelectedIndex() {
		return content.getSelectedIndex();
	}

	public String getSelectedItem() {
		return content.getSelectedValue();
	}

	public void setContent(String[] data) {
		content = new VGList(data);
		display.setViewportView(content);
		this.revalidate();
		this.repaint();
	}

	// Text Field Methods

	public String getCharactersField() {
		return charactersField.getText();
	}

	public void setCharactersField(String text) {
		charactersField.setText(text);
	}

	public String getNameField() {
		return nameField.getText();
	}

	public void setNameField(String text) {
		nameField.setText(text);
	}
}
