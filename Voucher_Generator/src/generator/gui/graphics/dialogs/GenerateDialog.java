/*	File: GenerateDialog.java
 * 	Date			Author					Changes
 * 	17 Oct 16		Chris Rabe				added some functionalities to the buttons
 */
package generator.gui.graphics.dialogs;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;

import static generator.gui.graphics.VControl.View.*;

import generator.assets.ComponentFactory;
import generator.gui.graphics.VControl;
import generator.gui.graphics.panels.Display;

/**
 * This dialog component prompts the user to enter the 'n' and 'c' values for
 * generating codes.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class GenerateDialog extends FunctionDialog {

	private JTextField numCodes;
	private JTextField numChars;
	private JButton generateBtn;

	public GenerateDialog(VControl controller, Display parent) {
		super(controller, parent);
	}

	protected JPanel createBtnPanel() {
		generateBtn = ComponentFactory.createButton("Generate");
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel.add(generateBtn);
		return panel;
	}

	protected JComponent createInputPanel() {
		// Create components
		JLabel codes = ComponentFactory.createLabel("Number of Codes");
		JLabel chars = ComponentFactory.createLabel("Length of Codes");
		numCodes = ComponentFactory.createTextField();
		numChars = ComponentFactory.createTextField();
		// Setup panel
		JComponent panel = new JPanel();
		// Set up group layout
		GroupLayout layout = new GroupLayout(panel);
		// Turn on automatically adding gaps between components
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		// Create a sequential group for horizontal axis
		GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
		hGroup.addGroup(layout.createParallelGroup().addComponent(codes).addComponent(numCodes));
		hGroup.addGroup(layout.createParallelGroup().addComponent(chars).addComponent(numChars));
		layout.setHorizontalGroup(hGroup);
		// Create a sequential group for vertical axis
		GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
		vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(codes).addComponent(numCodes));
		vGroup.addGroup(layout.createParallelGroup().addComponent(chars).addComponent(numChars));
		layout.setVerticalGroup(vGroup);
		return panel;
	}

	protected void addActionListeners() {
		numCodes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				numCodes.setText("");
				numCodes.setForeground(Color.BLACK);
			}
		});

		numChars.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				numChars.setText("");
				numChars.setForeground(Color.BLACK);
			}
		});
		generateBtn.addActionListener(e -> {
			// Variables to pass
			boolean pass1 = false;
			boolean pass2 = false;
			int n = -1;
			int c = -1;
			// Check if both texts are valid
			String codes = numCodes.getText();
			String chars = numChars.getText();
			if (isNumeric(codes)) {
				n = Integer.parseInt(codes);
				pass1 = true;
			} else {
				numCodes.setForeground(Color.RED);
			}
			if (isNumeric(chars)) {
				c = Integer.parseInt(chars);
				pass2 = true;
			} else {
				numChars.setForeground(Color.RED);
			}
			// Show error if at least one field failed.
			if (!pass1 || !pass2) {
				showError(controller, "Both fields must be numbers.");
				return;
			}
			// Show error if at least one field is less than or equal zero
			if (n <= 0 || c <= 0) {
				showError(controller, "Both fields must be greater than zero.");
				return;
			}
			controller.generate(n, c);
			parent.update();
			showMessage(controller, String.format("Successfull created %d vouchers.", n));
		});
	}

	// Helper Methods

	private boolean isNumeric(String s) {
		if (s == null) {
			return false;
		}
		return s.matches("[-+]?\\d*\\.?\\d+");
	}
}
