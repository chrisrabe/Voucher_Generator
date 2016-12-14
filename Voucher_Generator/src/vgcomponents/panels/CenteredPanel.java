package vgcomponents.panels;

import java.awt.FlowLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * Creates a JPanel where all the components are centered.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class CenteredPanel extends JPanel {

	public CenteredPanel(JComponent... components) {
		this.setOpaque(false);
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		for (JComponent component : components) {
			this.add(component);
		}
	}

	public CenteredPanel(int borderThickness, JComponent... components) {
		this(components);
		this.setBorder(new EmptyBorder(borderThickness, borderThickness, borderThickness, borderThickness));
	}
}
