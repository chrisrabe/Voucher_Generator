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
public class HorizontalPanel extends JPanel {

	/**
	 * The justification parameter should just the FlowLayout static variables.
	 * 
	 * @param justification
	 * @param components
	 */
	public HorizontalPanel(int justification, JComponent... components) {
		this.setOpaque(false);
		this.setLayout(new FlowLayout(justification));
		for (JComponent component : components) {
			this.add(component);
		}
	}

	/**
	 * Creates a horizontal panel with an empty border around it. The thickness
	 * is indicated by borderThickness.
	 * 
	 * @param justification
	 * @param borderThickness
	 * @param components
	 */
	public HorizontalPanel(int justification, int borderThickness, JComponent... components) {
		this(justification, components);
		this.setBorder(new EmptyBorder(borderThickness, borderThickness, borderThickness, borderThickness));
	}
}
