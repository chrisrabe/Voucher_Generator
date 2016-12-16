package generator.view.display.config;

import java.awt.Dimension;

import generator.view.display.Display;

/**
 * This represents a panel inside the configuration view. This is similar to a
 * page view, however it has a smaller display value.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public abstract class ConfigDisplay extends Display {

	// Fields

	protected final Dimension DISPLAY_RESOLUTION = new Dimension(700, 600);

	// Abstract Methods

	@Override
	public Dimension getPreferredSize() {
		return DISPLAY_RESOLUTION;
	}
}
