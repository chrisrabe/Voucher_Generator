/*	File: SettingsDialog.java
 * 
 * 	Date				Author				Changes
 * 	19 Nov 16			Chris Rabe			created SettingsDialog.java
 */
package generator.gui.dialogs;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import generator.assets.ComponentFactory;
import generator.config.Configuration;
import generator.gui.VControl;

/**
 * Contains methods for toggling the values allowed for the generator to use.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class SettingsDialog extends JDialog {

	private JComboBox<String> toggleUpperCase;
	private JComboBox<String> toggleLowerCase;
	private JComboBox<String> toggleNumbers;
	private JButton confirmBtn;

	private VControl controller;

	public SettingsDialog(VControl controller) {
		this.controller = controller;
		initialise();
	}

	private void initialise() {
		initialiseComponents();
		initialiseBody();
		addActionListeners();
		// pack everything in and set it visible and non resizable
		this.pack();
		this.setLocationRelativeTo(controller);
		this.setResizable(false);
		this.setVisible(true);
	}

	private void initialiseBody() {
		// Create panels that stores components
		JPanel upCasePane = ComponentFactory.createComponentLabelPanel(toggleUpperCase, "Upper case");
		JPanel loCasePane = ComponentFactory.createComponentLabelPanel(toggleLowerCase, "Lower Case");
		JPanel numberPane = ComponentFactory.createComponentLabelPanel(toggleNumbers, "Numbers");
		JPanel labelPane = createCenteredComponentPanel(new JLabel("Toggle encoding values for the vouchers:"));
		JPanel buttonPane = createCenteredComponentPanel(confirmBtn);
		// Set up the body panel
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(new GridLayout(5, 0));
		// Put everything together
		panel.add(labelPane);
		panel.add(upCasePane);
		panel.add(loCasePane);
		panel.add(numberPane);
		panel.add(buttonPane);
		// set it as the main content
		this.add(panel);
	}

	private void initialiseComponents() {
		toggleUpperCase = createOnOffBox();
		toggleLowerCase = createOnOffBox();
		toggleNumbers = createOnOffBox();
		// switch to the appropriate index based on configuration
		toggleUpperCase.setSelectedIndex(getSelectedIndex(Configuration.UPPER_CASE));
		toggleLowerCase.setSelectedIndex(getSelectedIndex(Configuration.LOWER_CASE));
		toggleNumbers.setSelectedIndex(getSelectedIndex(Configuration.NUMBERS));
		// create button
		confirmBtn = ComponentFactory.createButton("Confirm");
	}

	private int getSelectedIndex(boolean condition) {
		return condition ? 0 : 1;
	}

	private JComboBox<String> createOnOffBox() {
		return ComponentFactory.createStringCombo(new String[] { "On", "Off" });
	}

	private JPanel createCenteredComponentPanel(JComponent component) {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel.add(component);
		return panel;
	}

	private void addActionListeners() {
		confirmBtn.addActionListener(e -> {
			Configuration.UPPER_CASE = checkBoxCondition(toggleUpperCase);
			Configuration.LOWER_CASE = checkBoxCondition(toggleLowerCase);
			Configuration.NUMBERS = checkBoxCondition(toggleNumbers);
			this.dispose();
		});
	}

	private boolean checkBoxCondition(JComboBox<String> box) {
		String s = (String) box.getSelectedItem();
		return s.equals("On") ? true : false;
	}
}
