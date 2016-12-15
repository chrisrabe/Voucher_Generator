package vgcomponents.panels;

import java.awt.FlowLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * This class creates a panel which places components from right to left or left
 * to right.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class AlignedPanel extends JPanel {

	/**
	 * The alignment parameter should just the FlowLayout static variables.
	 * 
	 * @param alignment
	 * @param components
	 */
	public AlignedPanel(int alignment, JComponent... components) {
		this.setOpaque(false);
		this.setLayout(new FlowLayout(alignment));
		for (JComponent component : components) {
			this.add(component);
		}
	}

	/**
	 * Creates an aligned panel with an empty border around it. The thickness
	 * is indicated by borderThickness.
	 * 
	 * @param alignment
	 * @param borderThickness
	 * @param components
	 */
	public AlignedPanel(int alignment, int borderThickness, JComponent... components) {
		this(alignment, components);
		this.setBorder(new EmptyBorder(borderThickness, borderThickness, borderThickness, borderThickness));
	}
}
