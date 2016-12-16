package generator.view.display.io;

import java.awt.Dimension;

import generator.view.display.Display;

/**
 * This view represents a panel inside the io view. It represents the type of
 * operation which the user intends to do.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public abstract class IODisplay extends Display {

	// Fields

	protected final Dimension DISPLAY_RESOLUTION = new Dimension(600, 450);

	// Abstract Methods

	@Override
	public Dimension getPreferredSize() {
		return DISPLAY_RESOLUTION;
	}
}
