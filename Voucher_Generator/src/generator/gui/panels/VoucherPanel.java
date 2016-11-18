/*	File: VoucherPanel.java
 * 	
 * 	Date			Author				Changes
 * 	16 Oct 16		Chris Rabe			created VoucherPanel.java
 * 	27 Oct 16		Chris Rabe			added a bunch of buttons and labels onto the display
 * 	27 Oct 16		Chris Rabe			fixed update method
 * 	29 Oct 16		Chris Rabe			can now scale icons
 */
package generator.gui.panels;

import static generator.gui.VControl.View.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import generator.assets.Assets;
import generator.assets.ComponentFactory;
import generator.gui.VControl.Command;
import generator.gui.VControl.View;
import generator.gui.dialogs.AddCodeDialog;
import generator.gui.dialogs.EditCodeDialog;
import generator.gui.dialogs.GenerateDialog;
import generator.gui.dialogs.RemoveCodeDialog;

/**
 * This panel contains a scroll list which displays all the code inside the
 * generator. It also contains buttons for modification of Code objects inside
 * the generator.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class VoucherPanel extends Display {

	private JScrollPane info;
	private JButton addBtn; // Add
	private JButton edtBtn; // Edit
	private JButton genBtn; // Generate
	private JButton delBtn; // Remove
	private JButton clrBtn; // Clear

	public VoucherPanel(View parent) {
		super(parent);
	}

	@Override
	public void update() {
		JList<String> content = ComponentFactory.createJList(parent.getController().getList(Command.CODE));
		info.setViewportView(content);
	}

	@Override
	public void addActionListeners() {
		addBtn.addActionListener(e -> {
			new AddCodeDialog(parent.getController(), this);
		});
		edtBtn.addActionListener(e -> {
			if (parent.getController().getList(Command.CODE).isEmpty()) {
				showError(parent.getController(), "There are no codes to edit.");
			} else {
				new EditCodeDialog(parent.getController(), this);
			}
		});
		genBtn.addActionListener(e -> {
			new GenerateDialog(parent.getController(), this);
		});
		delBtn.addActionListener(e -> {
			if (parent.getController().getList(Command.CODE).isEmpty()) {
				showError(parent.getController(), "There are no codes to remove.");
			} else {
				new RemoveCodeDialog(parent.getController(), this);
			}
		});
		clrBtn.addActionListener(e -> {
			if (parent.getController().getList(Command.CODE).isEmpty()) {
				showError(parent.getController(), "Nothing to clear");
			} else {
				parent.getController().clearAll(Command.CODE);
				update();
				showMessage(parent.getController(), "Clear successful");
			}
		});
	}

	@Override
	public JPanel createControlPanel() {
		initialiseButtons();
		// Create button panels
		JPanel addPane = createButtonPane(addBtn, "Add");
		JPanel edtPane = createButtonPane(edtBtn, "Edit");
		JPanel genPane = createButtonPane(genBtn, "Generate");
		JPanel delPane = createButtonPane(delBtn, "Delete");
		JPanel clrPane = createButtonPane(clrBtn, "Clear");
		// Set up panel
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(new GridLayout(0, 5));
		// Put everything together
		panel.add(addPane);
		panel.add(delPane);
		panel.add(edtPane);
		panel.add(genPane);
		panel.add(clrPane);
		return panel;
	}

	@Override
	public JPanel createScrollPanel() {
		info = ComponentFactory.createScrollList(parent.getController().getList(Command.CODE));
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(new BorderLayout());
		panel.add(info, BorderLayout.CENTER);
		return panel;
	}

	// Helper Methods

	private void initialiseButtons() {
		addBtn = createButton(Assets.getAddIcon());
		edtBtn = createButton(Assets.getEditIcon());
		delBtn = createButton(Assets.getDelIcon());
		genBtn = createButton(Assets.getGenIcon());
		clrBtn = createButton(Assets.getClearIcon());
	}
}