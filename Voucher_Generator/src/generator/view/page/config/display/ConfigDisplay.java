package generator.view.page.config.display;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * This represents a panel inside the configuration view. This is similar to a
 * page view, however it has a smaller display value.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public abstract class ConfigDisplay extends JPanel {

	// Fields

	protected final Dimension DISPLAY_RESOLUTION = new Dimension(700, 600);
	protected final Color BG_COLOUR = new Color(40, 40, 40);

	// Abstract Methods

	/**
	 * Adds components into this JPanel
	 */
	protected abstract void initialiseComponents();

	/**
	 * Draws the background for the display.
	 * 
	 * @param g
	 */
	protected abstract void drawBackground(Graphics g);

	// JPanel Methods

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.drawBackground(g);
	}

	@Override
	public Dimension getPreferredSize() {
		return DISPLAY_RESOLUTION;
	}
}
