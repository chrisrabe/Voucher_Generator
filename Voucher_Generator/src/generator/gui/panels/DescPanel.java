/*	File: DescPanel.java
 * 	
 * 	Date			Author				Changes
 * 	30 Oct 16		Chris Rabe			created DescPanel
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
import generator.gui.dialogs.AddDescDialog;
import generator.gui.dialogs.RemoveDescDialog;
import generator.gui.views.GeneratorView;

/**
 * Contains a panel for adding descriptions and distributing them to the code.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class DescPanel extends Display {

	private JScrollPane info;
	private JButton addBtn; // Add
	private JButton delBtn; // Delete
	private JButton disBtn; // Distribute

	public DescPanel(View parent) {
		super(parent);
	}

	@Override
	public void update() {
		JList<String> content = ComponentFactory.createJList(parent.getController().getList(Command.DESC));
		info.setViewportView(content);
	}

	@Override
	public void addActionListeners() {
		addBtn.addActionListener(e -> {
			new AddDescDialog(parent.getController(), this);
		});
		delBtn.addActionListener(e -> {
			if (parent.getController().getList(Command.DESC).isEmpty()) {
				showError(parent.getController(), "No description available");
			} else {
				new RemoveDescDialog(parent.getController(), this);
			}
		});
		disBtn.addActionListener(e -> {
			if (parent.getController().getList(Command.DESC).isEmpty()) {
				showError(parent.getController(), "Nothing to distribute");
			} else if (parent.getController().getList(Command.CODE).isEmpty()) {
				showError(parent.getController(), "Code must be generated first");
			} else {
				parent.getController().distribute();
				((GeneratorView) parent).updateVouchPanel();
				showMessage(parent.getController(), "Distributed description to vouchers");
			}
		});
	}

	@Override
	public JPanel createControlPanel() {
		initialiseButtons();
		// Create button panels
		JPanel addPane = createButtonPane(addBtn, "Add");
		JPanel delPane = createButtonPane(delBtn, "Delete");
		JPanel disPane = createButtonPane(disBtn, "Distribute");
		// Set up panel
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(new GridLayout(0, 3));
		// put everything together
		panel.add(addPane);
		panel.add(delPane);
		panel.add(disPane);
		return panel;
	}

	@Override
	public JPanel createScrollPanel() {
		info = ComponentFactory.createScrollList(parent.getController().getList(Command.DESC));
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(new BorderLayout());
		panel.add(info, BorderLayout.CENTER);
		return panel;
	}

	private void initialiseButtons() {
		addBtn = createButton(Assets.getAddDescIcon());
		delBtn = createButton(Assets.getDelDescIcon());
		disBtn = createButton(Assets.getDistributeIcon());
	}
}
