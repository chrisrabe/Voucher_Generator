/*	File: GenerateDialog.java
 * 	Date			Author					Changes
 * 	17 Oct 16		Chris Rabe				added some functionalities to the 
 */
package generator.gui.graphics.dialogs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;

import generator.assets.ComponentFactory;

/**
 * This dialog component prompts the user to enter the 'n' and 'c' values for
 * generating codes.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class GenerateDialog extends JDialog {
	private JFrame parent;

	private JTextField numCodes;
	private JTextField numChars;
	private JButton generateBtn;

	public GenerateDialog(JFrame parent) {
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
		generateBtn.addActionListener(e -> {
			System.out.println(this.getSize());
		});
	}

	// Helper Methods

	private boolean isNumeric(String s) {
		if (s == null) {
			return false;
		}
		return s.matches("[-+]?\\d*\\.?\\d+");
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(600, 600));
		JButton gen = ComponentFactory.createButton("Gen");
		panel.add(gen);
		gen.addActionListener(e -> {
			new GenerateDialog(frame);
		});
		frame.setLocationByPlatform(true);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}
}
