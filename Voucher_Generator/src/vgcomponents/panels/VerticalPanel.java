package vgcomponents.panels;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 * This creates a JPanel which aligns the buttons vertically. All rows are equal
 * sized.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class VerticalPanel extends JPanel {

	public VerticalPanel(JComponent... components) {
		int rows = components.length;
		this.setLayout(new GridLayout(rows, 0));
		this.setOpaque(false);
		for (JComponent component : components) {
			this.add(component);
		}
	}

	public VerticalPanel(int width, int height, JComponent... components) {
		this(components);
		this.setPreferredSize(new Dimension(width, height));
	}
}
