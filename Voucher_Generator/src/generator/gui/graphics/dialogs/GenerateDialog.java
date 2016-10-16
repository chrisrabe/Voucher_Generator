package generator.gui.graphics.dialogs;

import javax.swing.JDialog;

import generator.gui.graphics.panels.VoucherPanel;

/**
 * This dialog component prompts the user to enter the 'n' and 'c' values for
 * generating codes.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class GenerateDialog extends JDialog {
	private VoucherPanel parent;

	public GenerateDialog(VoucherPanel parent) {
		this.parent = parent;
	}
}
