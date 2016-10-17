
package generator.gui.graphics.panels;

/**
 * This interface provides a method which could be called by the dialog objects
 * so that its parent display can update its scrollpanes after function has been
 * executed.
 * 
 * @author Chris
 */
public interface Display {
	/**
	 * Updates the scrollpane on the display
	 */
	public void update();
}
