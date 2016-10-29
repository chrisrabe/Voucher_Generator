/*	File: GeneratorView.java
 * 	Author
 * 	Chris Rabe
 * 
 * 	Date				Author					Changes
 * 	16 Oct 16			Chris Rabe				created GenerateView.java
 */

package generator.gui.views;

import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;

import generator.assets.ComponentFactory;
import generator.gui.VControl;
import generator.gui.VControl.View;
import generator.gui.panels.DescPanel;
import generator.gui.panels.VoucherPanel;

/**
 * This view contains functionalities of the generator.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class GeneratorView extends View {

	private VoucherPanel vouchPanel;
	private DescPanel descPanel;

	public GeneratorView(VControl controller) {
		super(controller);
		initialise();
	}

	public void updateVouchPanel() {
		vouchPanel.update();
	}

	@Override
	public void initialise() {
		// Initialise panels
		vouchPanel = new VoucherPanel(this);
		descPanel = new DescPanel(this);
		// Initialise icons
		ImageIcon icon1 = ComponentFactory.createVoucherIcon(1.5);
		ImageIcon icon2 = ComponentFactory.createDescIcon(1.5);
		// Put everything together
		JTabbedPane tPane = ComponentFactory.createTabbedPane();
		tPane.setPreferredSize(this.getPreferredSize());
		tPane.addTab("Voucher", icon1, vouchPanel);
		tPane.addTab("Description", icon2, descPanel);
		// Add it to the view
		this.add(tPane);
	}

	@Override
	public void setFocus() {

	}

}
