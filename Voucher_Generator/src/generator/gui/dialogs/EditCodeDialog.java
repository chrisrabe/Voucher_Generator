/*	File: EditCodeDialog.java
 * 	
 * 	Date				Author				Changes
 * 	17 Oct 16			Chris Rabe			created EditCodeDialog.java
 * 	20 Oct 16			Chris Rabe			added a border around the sub panels
 */

package generator.gui.dialogs;

import static generator.gui.VControl.View.showMessage;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import generator.assets.ComponentFactory;
import generator.gui.VControl;
import generator.gui.VControl.Command;
import generator.gui.panels.Display;

/**
 * Retrieves all the codes from the VControl and displays them in a JComboBox.
 * The user can then pick a code and then modify the with the given description.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class EditCodeDialog extends FunctionDialog {

	private JComboBox<String> codesBox;
	private JTextField newDescField;
	private JButton editBtn;

	public EditCodeDialog(VControl controller, Display parent) {
		super(controller, parent);
	}

	@Override
	protected JComponent createInputPanel() {
		JPanel code = createCodePanel();
		JPanel desc = createDescPanel();
		// Setup Panel
		JComponent panel = new JPanel();
		panel.setLayout(new GridLayout(2, 0));
		panel.add(code);
		panel.add(desc);
		return panel;
	}

	@Override
	protected JPanel createBtnPanel() {
		editBtn = ComponentFactory.createButton("Edit");
		JPanel panel = new JPanel();
		TitledBorder title = BorderFactory.createTitledBorder("Control");
		panel.setBorder(title);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel.add(editBtn);
		return panel;
	}

	@Override
	protected void addActionListeners() {
		newDescField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				newDescField.setText("");
				newDescField.setForeground(Color.BLACK);
			}
		});
		editBtn.addActionListener(e -> {
			String code = (String) codesBox.getSelectedItem();
			String desc = newDescField.getText();
			controller.editCode(code, desc);
			parent.update();
			showMessage(controller, "Successfully changed code.");
			this.dispose();
		});
	}

	// Helper Methods

	private JPanel createDescPanel() {
		JLabel desc = ComponentFactory.createLabel("Description");
		newDescField = ComponentFactory.createTextField();
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		TitledBorder title = BorderFactory.createTitledBorder("Description");
		panel.setBorder(title);
		panel.add(desc);
		panel.add(newDescField);
		return panel;
	}

	private JPanel createCodePanel() {
		JLabel code = ComponentFactory.createLabel("Code");
		String[] codes = toArray(controller.getList(Command.CODE));
		codesBox = ComponentFactory.createStringCombo(codes);
		JPanel panel = new JPanel();
		TitledBorder title = BorderFactory.createTitledBorder("Code");
		panel.setBorder(title);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel.add(code);
		panel.add(codesBox);
		return panel;
	}
}
