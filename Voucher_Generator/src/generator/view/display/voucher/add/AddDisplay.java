package generator.view.display.voucher.add;

import java.awt.Graphics;

import generator.view.display.voucher.VoucherDisplay;

/**
 * This class is responsible for implementing the swing components for the add
 * display of the voucher view.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public abstract class AddDisplay extends VoucherDisplay {

	@Override
	protected void initialiseComponents() {
		
	}

	@Override
	protected void drawBackground(Graphics g) {
		g.setColor(BG_COLOUR);
		g.fillRect(0, 0, getSize().width, getSize().height);
	}

}
