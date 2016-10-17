/* File: AddCode.java
 * 
 * Date			Author			Changes
 * 17 Oct 16	Chris Rabe		created AddCodeDialog.java
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
import generator.gui.graphics.VControl.Command;

/**
 * This field prompts the user for a name and a description to add the code.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class AddCodeDialog extends JDialog {
	private VControl parent;

	private JTextField nameField;
	private JTextField descField;
	private JButton addBtn;

	public AddCodeDialog(VControl parent) {
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

	private JPanel createMainPanel() {
		JComponent input = createInputPanel();
		JPanel gen = createAddPanel();
		// Put everything together
		JPanel main = new JPanel();
		main.setLayout(new BoxLayout(main, BoxLayout.PAGE_AXIS));
		main.add(input);
		main.add(gen);
		return main;
	}

	private JComponent createInputPanel() {
		// Create components
		JLabel nameL = ComponentFactory.createLabel("Voucher Code");
		JLabel descL = ComponentFactory.createLabel("Description");
		nameField = ComponentFactory.createTextField();
		descField = ComponentFactory.createTextField();
		// Setup panel
		JComponent panel = new JPanel();
		// Set up group layout
		GroupLayout layout = new GroupLayout(panel);
		// Turn on automatically adding gaps between components
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		// Create a sequential group for horizontal axis
		GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
		hGroup.addGroup(layout.createParallelGroup().addComponent(nameL).addComponent(nameField));
		hGroup.addGroup(layout.createParallelGroup().addComponent(descL).addComponent(descField));
		layout.setHorizontalGroup(hGroup);
		// Create a sequential group for vertical axis
		GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
		vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(nameL).addComponent(nameField));
		vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(descL).addComponent(descField));
		layout.setVerticalGroup(vGroup);
		return panel;
	}

	private JPanel createAddPanel() {
		addBtn = ComponentFactory.createButton("Add Code");
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel.add(addBtn);
		return panel;
	}

	private void addActionListeners() {
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
				showError(parent, "Both fields must be filled in!");
				return;
			}
			parent.add(Command.CODE, name, desc);
			showMessage(parent, "Successfully added new code.");
		});
	}
}
