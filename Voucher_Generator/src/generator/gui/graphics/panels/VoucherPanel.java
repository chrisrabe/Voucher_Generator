/*	File: VoucherPanel.java
 * 	
 * 	Date			Author				Changes
 * 	16 Oct 16		Chris Rabe			created VoucherPanel.java
 */
package generator.gui.graphics.panels;

import javax.swing.JPanel;

import generator.gui.graphics.VControl.View;

/**
 * This panel contains a scroll list which displays all the code inside the
 * generator. It also contains buttons for modification of Code objects inside
 * the generator.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class VoucherPanel extends Display {

	public VoucherPanel(View parent) {
		super(parent);
	}

	@Override
	public void update() {
		// TODO update the scroll panel and revalidate
	}

	@Override
	public void addActionListeners() {
		// TODO Auto-generated method stub

	}

	@Override
	public JPanel createControlPanel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JPanel createScrollPanel() {
		// TODO Auto-generated method stub
		return null;
	}
}
