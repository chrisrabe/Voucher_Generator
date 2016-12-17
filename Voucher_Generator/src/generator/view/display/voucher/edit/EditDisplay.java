package generator.view.display.voucher.edit;

import java.awt.Graphics;

import generator.view.display.voucher.VoucherDisplay;

/**
 * This class is responsible for adding swing components into the edit display
 * of the voucher view.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class EditDisplay extends VoucherDisplay {

	@Override
	protected void initialiseComponents() {
	}

	@Override
	protected void drawBackground(Graphics g) {
		g.setColor(BG_COLOUR);
		g.fillRect(0, 0, getSize().width, getSize().height);
	}
}
