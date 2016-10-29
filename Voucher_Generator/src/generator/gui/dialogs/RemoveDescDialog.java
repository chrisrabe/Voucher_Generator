/*	File: RemoveCodeDialog.java
 * 
 * 	Date			Author			Changes
 * 	29 Oct 16		Chris Rabe		created RemoveDescDialog
 */
package generator.gui.dialogs;

import static generator.gui.VControl.View.showMessage;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import generator.assets.ComponentFactory;
import generator.gui.VControl;
import generator.gui.VControl.Command;
import generator.gui.panels.Display;

/**
 * This dialog box is used for removing any existing descriptions inside the
 * generator.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class RemoveDescDialog extends FunctionDialog {

	private JComboBox<String> descBox;
	private JButton delBtn;

	public RemoveDescDialog(VControl controller, Display parent) {
		super(controller, parent);
	}

	@Override
	protected JComponent createInputPanel() {
		JPanel delete = createDeletePanel();
		// set up panel
		JComponent panel = new JPanel();
		panel.setLayout(new GridLayout(2, 0));
		panel.add(delete);
		return panel;
	}

	@Override
	protected JPanel createBtnPanel() {
		delBtn = ComponentFactory.createButton("Delete");
		// set up the panel
		JPanel panel = new JPanel();
		TitledBorder title = BorderFactory.createTitledBorder("Controls");
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel.setBorder(title);
		// put everything together
		panel.add(delBtn);
		return panel;
	}

	@Override
	protected void addActionListeners() {
		delBtn.addActionListener(e -> {
			String desc = (String) descBox.getSelectedItem();
			controller.delete(Command.DESC, null, desc);
			parent.update();
			showMessage(controller, "Successfully removed description.");
			this.dispose();
		});
	}

	// Helper Methods

	private JPanel createDeletePanel() {
		// Set up components
		String[] desc = toArray(controller.getList(Command.DESC));
		descBox = ComponentFactory.createStringCombo(desc);
		// Set up the panel
		JPanel panel = new JPanel();
		TitledBorder title = BorderFactory.createTitledBorder("Descriptions");
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel.setBorder(title);
		// put everything together
		panel.add(descBox);
		return panel;
	}
}
