package vgcomponents.panels;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 * Creates a horizontally aligned panel. It ensures that all components are the
 * same size.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class HorizontalButtonPanel extends JPanel {

	public HorizontalButtonPanel(JComponent... components) {
		int columns = components.length;
		this.setLayout(new GridLayout(0, columns));
		this.setOpaque(false);
		for (JComponent component : components) {
			this.add(component);
		}
	}

	public HorizontalButtonPanel(int width, int height, JComponent... components) {
		this(components);
		this.setPreferredSize(new Dimension(width, height));
	}
}
