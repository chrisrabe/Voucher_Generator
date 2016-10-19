/*	File: RemoveCodeDialog.java
 * 	Date			Author				Change
 * 	20 Oct 16		Chris Rabe			created RemoveCodeDialog.java
 */
package generator.gui.graphics.dialogs;

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

import static generator.gui.graphics.VControl.View.*;

import generator.assets.ComponentFactory;
import generator.gui.graphics.VControl;
import generator.gui.graphics.VControl.Command;
import generator.gui.graphics.panels.Display;

/**
 * This dialog box contains panels for removing a specific code from the
 * generator and reducing the size of the code generated.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class RemoveCodeDialog extends FunctionDialog {

	private JComboBox<String> codesBox;
	private JTextField newAmt;

	private JButton removeBtn;
	private JButton reduceBtn;

	public RemoveCodeDialog(VControl controller, Display parent) {
		super(controller, parent);
	}

	@Override
	protected JComponent createInputPanel() {
		JPanel remove = createRemovePanel();
		JPanel reduce = createReducePanel();
		// Setup panel
		JComponent panel = new JPanel();
		panel.setLayout(new GridLayout(2, 0));
		panel.add(remove);
		panel.add(reduce);
		return panel;
	}

	@Override
	protected JPanel createBtnPanel() {
		// Create the buttons
		removeBtn = ComponentFactory.createButton("Remove");
		reduceBtn = ComponentFactory.createButton("Reduce");
		// Set up the panel
		JPanel panel = new JPanel();
		TitledBorder title = BorderFactory.createTitledBorder("Controls");
		panel.setBorder(title);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		// Put everything together
		panel.add(removeBtn);
		panel.add(reduceBtn);
		return panel;
	}

	@Override
	protected void addActionListeners() {
		newAmt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				newAmt.setText("");
				newAmt.setForeground(Color.BLACK);
			}
		});

		removeBtn.addActionListener(e -> {
			String code = (String) codesBox.getSelectedItem();
			controller.delete(Command.CODE, code, null);
			// parent.update();
			showMessage(controller, "Successfully removed code.");
			this.dispose();
		});

		reduceBtn.addActionListener(e -> {
			boolean pass = false;
			int amt = -1;
			// Check if the value in the text box is a number
			String val = newAmt.getText();
			if (isNumeric(val)) {
				amt = Integer.parseInt(val);
				pass = true;
			}
			// If pass is false, then invalid input
			if (!pass) {
				showError(controller, "You must enter a number.");
				return;
			}
			// Check if it is greater than or equal zero
			if (amt < 0) {
				showError(controller, "Number must be bigger than zero");
				return;
			}
			controller.reduce(amt);
			// parent.update();
			showMessage(controller, "Successfully reduced code generated.");
			this.dispose();
		});
	}

	// Helper Methods

	private JPanel createRemovePanel() {
		// Set up the components
		JLabel label = ComponentFactory.createLabel("Code");
		String[] codes = getCodes(controller.getList(Command.CODE));
		codesBox = ComponentFactory.createStringCombo(codes);
		// Set up the panel
		JPanel panel = new JPanel();
		TitledBorder title = BorderFactory.createTitledBorder("Remove");
		panel.setBorder(title);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		// put everything together
		panel.add(label);
		panel.add(codesBox);
		return panel;
	}

	private JPanel createReducePanel() {
		// Set up the components
		JLabel label = ComponentFactory.createLabel("Amount");
		newAmt = ComponentFactory.createTextField();
		// Set up the panel
		JPanel panel = new JPanel();
		TitledBorder title = BorderFactory.createTitledBorder("Reduce");
		panel.setBorder(title);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		// put everything together
		panel.add(label);
		panel.add(newAmt);
		return panel;
	}

	public static void main(String[] args) {
		VControl control = new VControl();
		control.generate(5, 5);
		new RemoveCodeDialog(control, null);
	}
}
