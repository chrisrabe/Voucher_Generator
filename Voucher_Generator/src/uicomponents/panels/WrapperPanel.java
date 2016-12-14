package uicomponents.panels;

import javax.swing.JPanel;

/**
 * A custom panel which serves to wrap components around it so that the overall
 * shape of the component doesn't get modified.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class WrapperPanel extends JPanel {

	public WrapperPanel(JPanel... panels) {
		this.setOpaque(false);
		for (JPanel panel : panels) {
			this.add(panel);
		}
	}
}
