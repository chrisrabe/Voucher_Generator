/*	File: GenerateDialog.java
 * 	Date			Author					Changes
 * 	17 Oct 16		Chris Rabe				added some functionalities to the buttons
 */
package generator.gui.graphics.dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;

import static generator.gui.graphics.VControl.View.*;

import generator.assets.ComponentFactory;
import generator.gui.graphics.VControl;

/**
 * This dialog component prompts the user to enter the 'n' and 'c' values for
 * generating codes.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class GenerateDialog extends JDialog {
	private VControl parent;

	private JTextField numCodes;
	private JTextField numChars;
	private JButton generateBtn;

	public GenerateDialog(VControl parent) {
		this.parent = parent;
		initialise();
	}

	private void initialise() {
		this.setLayout(new BorderLayout());
		JPanel main = createMainPanel();
		this.add(main, BorderLayout.CENTER);
		this.setPreferredSize(new Dimension(240, 200));
		addActionListeners();
		pack();
		setLocationRelativeTo(parent);
		setResizable(false);
		setVisible(true);
	}

	// Panel creation Methods

	private JPanel createMainPanel() {
		JComponent input = createInputPanel();
		JPanel gen = createGeneratePanel();
		// Put everything together
		JPanel main = new JPanel();
		main.setLayout(new BoxLayout(main, BoxLayout.PAGE_AXIS));
		main.add(input);
		main.add(gen);
		return main;
	}

	private JPanel createGeneratePanel() {
		generateBtn = ComponentFactory.createButton("Generate");
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel.add(generateBtn);
		return panel;
	}

	private JComponent createInputPanel() {
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
		vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(chars).addComponent(numChars));
		layout.setVerticalGroup(vGroup);
		return panel;
	}

	private void addActionListeners() {
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
				showError(parent, "Both fields must be numbers.");
				return;
			}
			// Show error if at least one field is less than or equal zero
			if (n <= 0 || c <= 0) {
				showError(parent, "Both fields must be greater than zero.");
				return;
			}
			parent.generate(n, c);
			showMessage(parent, String.format("Successfull created %d vouchers.", n));
			this.setVisible(false);
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
