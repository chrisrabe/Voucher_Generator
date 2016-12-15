package vgcomponents.panels;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Creates a horizontally aligned panel. It ensures that all components are the
 * same size.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class HorizontalButtonPanel extends JPanel {

	public HorizontalButtonPanel(JButton... buttons) {
		int columns = buttons.length;
		this.setLayout(new GridLayout(0, columns));
		this.setOpaque(false);
		for (JButton button : buttons) {
			this.add(button);
		}
	}

	public HorizontalButtonPanel(int width, int height, JButton... buttons) {
		this(buttons);
		this.setPreferredSize(new Dimension(width, height));
	}
}
