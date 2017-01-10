package vgcomponents.panels;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 * This creates a JPanel which creates a grid with equal row and columns by
 * default.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class GridPanel extends JPanel {

	public GridPanel(JComponent... components) {
		int edges = (int) Math.ceil(components.length / 2);
		this.setLayout(new GridLayout(edges == 0 ? 1 : edges, edges == 0 ? 1 : edges));
		this.setOpaque(false);
		for (JComponent component : components) {
			this.add(component);
		}
	}

	public GridPanel(int width, int height, JComponent... components) {
		this(components);
		this.setPreferredSize(new Dimension(width, height));
	}
}
