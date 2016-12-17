package generator.view.display.voucher;

import java.awt.Dimension;

import generator.view.display.Display;

/**
 * This class represents a display for the voucher view.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public abstract class VoucherDisplay extends Display {

	// Fields

	protected final Dimension DISPLAY_RESOLUTION = new Dimension(700, 600);

	// Abstract Methods

	@Override
	public Dimension getPreferredSize() {
		return DISPLAY_RESOLUTION;
	}
}
