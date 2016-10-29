/*	File: GeneratorView.java
 * 	Author
 * 	Chris Rabe
 * 
 * 	Date				Author					Changes
 * 	16 Oct 16			Chris Rabe				created GenerateView.java
 */

package generator.gui.graphics.views;

import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;

import generator.assets.ComponentFactory;
import generator.gui.graphics.VControl;
import generator.gui.graphics.VControl.View;
import generator.gui.graphics.panels.VoucherPanel;

/**
 * This view contains functionalities of the generator.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class GeneratorView extends View {

	private VoucherPanel vouchPanel;

	public GeneratorView(VControl controller) {
		super(controller);
		initialise();
	}

	@Override
	public void initialise() {
		// Initialise panels
		vouchPanel = new VoucherPanel(this);
		// Initialise icons
		ImageIcon icon = ComponentFactory.createVoucherIcon(1.5);
		// Put everything together
		JTabbedPane tPane = ComponentFactory.createTabbedPane();
		tPane.setPreferredSize(this.getPreferredSize());
		tPane.addTab("Voucher", icon, vouchPanel);
		// Add it to the view
		this.add(tPane);
	}

	@Override
	public void setFocus() {

	}

}
