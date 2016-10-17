/*	File: EditCodeDialog.java
 * 	
 * 	Date				Author				Changes
 * 	17 Oct 16			Chris Rabe			created EditCodeDialog.java
 */

package generator.gui.graphics.dialogs;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import static generator.gui.graphics.VControl.View.showMessage;

import generator.assets.ComponentFactory;
import generator.backend.Code;
import generator.gui.graphics.VControl;
import generator.gui.graphics.VControl.Command;
import generator.gui.graphics.panels.Display;

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

	private JPanel createDescPanel() {
		JLabel desc = ComponentFactory.createLabel("Description");
		newDescField = ComponentFactory.createTextField();
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel.add(desc);
		panel.add(newDescField);
		return panel;
	}

	private JPanel createCodePanel() {
		JLabel code = ComponentFactory.createLabel("Code");
		String[] codes = getCodes(controller.getList(Command.CODE));
		codesBox = ComponentFactory.createStringCombo(codes);
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel.add(code);
		panel.add(codesBox);
		return panel;
	}

	private String[] getCodes(List<? extends Object> list) {
		String[] codes = new String[list.size()];
		for (int i = 0; i < codes.length; i++) {
			Object o = list.get(i);
			if (o instanceof Code) {
				Code c = (Code) o;
				codes[i] = c.getCode();
			}
		}
		return codes;
	}

	@Override
	protected JPanel createBtnPanel() {
		editBtn = ComponentFactory.createButton("Edit");
		JButton test = ComponentFactory.createButton("Test");
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel.add(editBtn);
		panel.add(test);
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
		});
	}
}
