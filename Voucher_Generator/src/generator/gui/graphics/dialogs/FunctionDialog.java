/*	File: FunctionDialog.java
 * 
 * 	Date				Author					Changes
 * 	17 Oct 16			Chris Rabe				created FunctionDialog.java
 */
package generator.gui.graphics.dialogs;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;

import generator.gui.graphics.VControl;
import generator.gui.graphics.panels.Display;

/**
 * This class provides a skeletal implementation of a JDialog for functions.
 * Since majority of them have same function definitions, then I decided to
 * group all similar functions here.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public abstract class FunctionDialog extends JDialog {
	protected VControl controller;
	protected Display parent;

	public FunctionDialog(VControl controller, Display parent) {
		this.controller = controller;
		this.parent = parent;
		initialise();
	}

	// Abstract methods

	protected abstract JComponent createInputPanel();

	protected abstract JPanel createBtnPanel();

	protected abstract void addActionListeners();

	private void initialise() {
		this.setLayout(new BorderLayout());
		JPanel main = createMainPanel();
		this.add(main, BorderLayout.CENTER);
		this.setPreferredSize(new Dimension(240, 200));
		addActionListeners();
		pack();
		setLocationRelativeTo(controller);
		setResizable(false);
		setVisible(true);
	}

	private JPanel createMainPanel() {
		JComponent input = createInputPanel();
		JPanel btnPanel = createBtnPanel();
		// Put everything together
		JPanel main = new JPanel();
		main.setLayout(new BoxLayout(main, BoxLayout.PAGE_AXIS));
		main.add(input);
		main.add(btnPanel);
		return main;
	}

}
