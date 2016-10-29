/*	File: Display.java
 * 	
 * 	Date			Author				Changes
 * 	21 Oct 16		Chris Rabe			changed this to an abstract class
 */
package generator.gui.graphics.panels;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import generator.assets.Assets;
import generator.assets.ComponentFactory;
import generator.gui.graphics.VControl.View;

/**
 * This interface provides a method which could be called by the dialog objects
 * so that its parent display can update its scrollpanes after function has been
 * executed. Each display has two components, the control panel and the scroll
 * panel. The control panel contains buttons and the scroll panel contains a
 * list of objects or information which the user needs to know.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public abstract class Display extends JPanel {

	/** Changes the scale of the icons displayed */
	protected final double SCALE = 1.5;

	protected View parent;

	public Display(View parent) {
		this.parent = parent;
		initialise();
	}

	/**
	 * Updates the scrollpane on the display
	 */
	public abstract void update();

	/**
	 * Adds action listeners to the components of the display
	 */
	public abstract void addActionListeners();

	/**
	 * Creates the control panel for all the buttons related to this display.
	 */
	public abstract JPanel createControlPanel();

	/**
	 * Creates the panel which displays the scroll panel containing the JList.
	 */
	public abstract JPanel createScrollPanel();

	// Overrided Methods

	@Override
	public Dimension getPreferredSize() {
		return parent.getPreferredSize();
	}

	// Helper Methods

	protected JButton createButton(BufferedImage icon) {
		return ComponentFactory.createButton(Assets.scaleImage(icon, SCALE));
	}

	protected JPanel createButtonPane(JButton button, String text) {
		// setup components
		JLabel label = ComponentFactory.createLabel(text);
		// setup panel
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		// put everything together
		panel.add(label);
		panel.add(button);
		return panel;
	}

	/**
	 * Adds two panels into the display. The control panel and the scroll panel.
	 */
	private void initialise() {
		JPanel controlPanel = createControlPanel();
		JPanel scrollPanel = createScrollPanel();
		this.setLayout(new BorderLayout());
		this.add(controlPanel, BorderLayout.NORTH);
		this.add(scrollPanel, BorderLayout.CENTER);
		this.addActionListeners();
	}
}
