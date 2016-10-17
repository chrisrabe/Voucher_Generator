/*	File: VoucherPanel.java
 * 	
 * 	Date			Author				Changes
 * 	16 Oct 16		Chris Rabe			created VoucherPanel.java
 */
package generator.gui.graphics.panels;

import javax.swing.JPanel;

import generator.gui.graphics.VControl.View;

@SuppressWarnings("serial")
public class VoucherPanel extends JPanel implements Display {
	private View parent;

	public VoucherPanel(View parent) {
		this.parent = parent;
	}

	@Override
	public void update() {
	}
}
