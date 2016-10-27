/*	File: GeneratorView.java
 * 	Author
 * 	Chris Rabe
 * 
 * 	Date				Author					Changes
 * 	16 Oct 16			Chris Rabe				created GenerateView.java
 */

package generator.gui.graphics.views;

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
		vouchPanel = new VoucherPanel(this);
		this.add(vouchPanel);
	}

	@Override
	public void setFocus() {

	}

}
