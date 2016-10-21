/*	File: Display.java
 * 	
 * 	Date			Author				Changes
 * 	21 Oct 16		Chris Rabe			changed this to an abstract class
 */
package generator.gui.graphics.panels;

import javax.swing.JPanel;

import generator.gui.graphics.VControl.View;

/**
 * This interface provides a method which could be called by the dialog objects
 * so that its parent display can update its scrollpanes after function has been
 * executed.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public abstract class Display extends JPanel {
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

	private void initialise() {
		// TODO fill this in
	}
}
