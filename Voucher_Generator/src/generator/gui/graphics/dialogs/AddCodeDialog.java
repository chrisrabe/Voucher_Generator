/* File: AddCode.java
 * 
 * Date			Author			Changes
 * 17 Oct 16	Chris Rabe		created AddCodeDialog.java
 * 20 Oct 16	Chris Rabe		updated the look of the dialog
 */
package generator.gui.graphics.dialogs;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import static generator.gui.graphics.VControl.View.*;

import generator.assets.ComponentFactory;
import generator.gui.graphics.VControl;
import generator.gui.graphics.VControl.Command;
import generator.gui.graphics.panels.Display;

/**
 * This field prompts the user for a name and a description to add the code.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class AddCodeDialog extends FunctionDialog {

	private JTextField nameField;
	private JTextField descField;
	private JButton addBtn;

	public AddCodeDialog(VControl controller, Display parent) {
		super(controller, parent);
	}

	protected JComponent createInputPanel() {
		// Create sub panel
		JPanel name = createNamePanel();
		JPanel desc = createDescPanel();
		// Setup panel
		JComponent panel = new JPanel();
		panel.setLayout(new GridLayout(2, 0));
		panel.add(name);
		panel.add(desc);
		return panel;
	}

	protected JPanel createBtnPanel() {
		addBtn = ComponentFactory.createButton("Add Code");
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		TitledBorder title = BorderFactory.createTitledBorder("Control");
		panel.setBorder(title);
		panel.add(addBtn);
		return panel;
	}

	protected void addActionListeners() {
		nameField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nameField.setText("");
				nameField.setForeground(Color.BLACK);
			}
		});

		descField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				descField.setText("");
				descField.setForeground(Color.BLACK);
			}
		});

		addBtn.addActionListener(e -> {
			boolean pass1 = true;
			boolean pass2 = true;
			String name = nameField.getText();
			String desc = descField.getText();
			// Do some error checking
			if (name.length() < 1) {
				nameField.setForeground(Color.RED);
				pass1 = false;
			}
			if (desc.length() < 1) {
				descField.setForeground(Color.RED);
				pass2 = false;
			}
			if (!pass1 || !pass2) {
				showError(controller, "Both fields must be filled in!");
				return;
			}
			controller.add(Command.CODE, name, desc);
			parent.update();
			showMessage(controller, "Successfully added new code.");
			this.dispose();
		});
	}

	// Helper Methods

	private JPanel createDescPanel() {
		// Set up components
		descField = ComponentFactory.createTextField();
		// Set up panel
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		TitledBorder title = BorderFactory.createTitledBorder("Description");
		panel.setBorder(title);
		// Put everything together
		panel.add(descField);
		return panel;
	}

	private JPanel createNamePanel() {
		// Set up components
		nameField = ComponentFactory.createTextField();
		// Set up panel
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		TitledBorder title = BorderFactory.createTitledBorder("Voucher Code");
		panel.setBorder(title);
		// Put everything together
		panel.add(nameField);
		return panel;
	}
}
