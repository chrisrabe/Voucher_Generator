package generator.view.display.description;

import java.awt.Dimension;

import generator.view.display.Display;

/**
 * This class provides the resolution for the description displays.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public abstract class DescriptionDisplay extends Display {
	// Fields

	protected final Dimension DISPLAY_RESOLUTION = new Dimension(700, 600);

	// Abstract Methods

	@Override
	public Dimension getPreferredSize() {
		return DISPLAY_RESOLUTION;
	}
}
