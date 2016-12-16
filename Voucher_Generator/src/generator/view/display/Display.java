package generator.view.display;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * Represents a display. Allow views to have miniature controllers.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public abstract class Display extends JPanel {
	// Fields

	protected final Color BG_COLOUR = new Color(40, 40, 40);

	// Methods

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
}
