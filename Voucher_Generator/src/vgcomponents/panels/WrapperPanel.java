package vgcomponents.panels;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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

	public WrapperPanel(int borderThickness, JPanel... panels) {
		this(panels);
		this.setBorder(new EmptyBorder(borderThickness, borderThickness, borderThickness, borderThickness));
	}
}
