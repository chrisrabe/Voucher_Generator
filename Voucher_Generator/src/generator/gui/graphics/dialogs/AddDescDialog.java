/*	File: AddDescDialog.java
 * 	
 * 	Date		Author				Changes
 * 	29 Oct 16	Chris Rabe			created AddDescDialog
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
 * A JDialog which adds
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class AddDescDialog extends FunctionDialog {

	private JTextField descField;
	private JButton addBtn;

	public AddDescDialog(VControl controller, Display parent) {
		super(controller, parent);
	}

	@Override
	protected JComponent createInputPanel() {
		// Create sub panel
		JPanel desc = createDescPanel();
		// Setup panel
		JComponent panel = new JPanel();
		panel.setLayout(new GridLayout(2, 0));
		panel.add(desc);
		return panel;
	}

	@Override
	protected JPanel createBtnPanel() {
		addBtn = ComponentFactory.createButton("Add Description");
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		TitledBorder title = BorderFactory.createTitledBorder("Control");
		panel.setBorder(title);
		panel.add(addBtn);
		return panel;
	}

	@Override
	protected void addActionListeners() {
		descField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				descField.setText("");
				descField.setForeground(Color.BLACK);
			}
		});
		addBtn.addActionListener(e -> {
			String desc = descField.getText();
			if (desc.length() < 1) {
				descField.setForeground(Color.RED);
				showError(controller, "Description field must be filled!");
				return;
			}
			int oldSize = controller.getList(Command.DESC).size();
			controller.add(Command.DESC, null, desc);
			if (successfulAdd(oldSize)) {
				parent.update();
				showMessage(controller, "Successfully added new description.");
			}
			this.dispose();
		});
	}

	// Helper Methods

	/**
	 * Checks if the new description is successfully added. The old size and the
	 * new size should be different. This check is required because you cannot
	 * add duplicate description.
	 * 
	 * @param oldSize
	 * @return
	 */
	private boolean successfulAdd(int oldSize) {
		int newSize = controller.getList(Command.DESC).size();
		return newSize != oldSize;
	}

	private JPanel createDescPanel() {
		// set up components
		descField = ComponentFactory.createTextField();
		// set up panel
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		TitledBorder title = BorderFactory.createTitledBorder("Enter Description");
		panel.setBorder(title);
		// put everything together
		panel.add(descField);
		return panel;
	}
}
