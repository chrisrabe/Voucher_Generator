package vgcomponents.panels;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * This creates a JPanel which aligns the buttons vertically. All rows are equal
 * sized.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class VerticalButtonPanel extends JPanel {

	public VerticalButtonPanel(JButton... buttons) {
		int rows = buttons.length;
		this.setLayout(new GridLayout(rows, 0));
		this.setOpaque(false);
		for (JButton button : buttons) {
			this.add(button);
		}
	}

	public VerticalButtonPanel(int width, int height, JButton... buttons) {
		this(buttons);
		this.setPreferredSize(new Dimension(width, height));
	}
}
