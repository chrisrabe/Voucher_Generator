package generator.view.page;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * Provides a skeletal implementation of the page view.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public abstract class PageView extends JPanel {

	// Fields -- Could be replaced with a configuration class

	protected final Dimension PAGE_RESOLUTION = new Dimension(1024, 768);

	// Abstract Methods

	/**
	 * Adds components into this JPanel.
	 */
	protected abstract void initialiseComponents();

	/**
	 * Draws the background for this page view.
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
		return PAGE_RESOLUTION;
	}
}
