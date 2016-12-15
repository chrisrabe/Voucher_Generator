package vgcomponents.panels;

import java.awt.BorderLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * This creates a JPanel which takes five arguments. Each arguments represent
 * the position they are placed in.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class DockedPanel extends JPanel {

	/**
	 * Creates a Docked panel.
	 * 
	 * @param north
	 * @param south
	 * @param east
	 * @param west
	 * @param center
	 */
	public DockedPanel(JComponent north, JComponent south, JComponent east, JComponent west, JComponent center) {
		this.setLayout(new BorderLayout());
		this.setOpaque(false);
		if (north != null)
			this.add(north, BorderLayout.NORTH);
		if (south != null)
			this.add(south, BorderLayout.SOUTH);
		if (east != null)
			this.add(east, BorderLayout.EAST);
		if (west != null)
			this.add(west, BorderLayout.WEST);
		if (center != null)
			this.add(center, BorderLayout.CENTER);
	}

	public DockedPanel(int borderThickness, JComponent north, JComponent south, JComponent east, JComponent west,
			JComponent center) {
		this(north, south, east, west, center);
		this.setBorder(new EmptyBorder(borderThickness, borderThickness, borderThickness, borderThickness));
	}
}
