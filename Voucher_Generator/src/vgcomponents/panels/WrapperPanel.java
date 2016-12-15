package vgcomponents.panels;

import javax.swing.JComponent;
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

	public WrapperPanel(JComponent... components) {
		this.setOpaque(false);
		for (JComponent component : components) {
			this.add(component);
		}
	}

	public WrapperPanel(int borderThickness, JComponent... components) {
		this(components);
		this.setBorder(new EmptyBorder(borderThickness, borderThickness, borderThickness, borderThickness));
	}
}
