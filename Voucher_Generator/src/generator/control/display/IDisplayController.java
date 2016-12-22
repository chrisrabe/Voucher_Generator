package generator.control.display;

import javax.swing.JPanel;

/**
 * This represents a controller for the displays inside a view.
 * 
 * @author Chris
 */
public interface IDisplayController {

	/**
	 * Retrieves the display from the controller
	 * 
	 * @return
	 */
	public JPanel getDisplay();
}
