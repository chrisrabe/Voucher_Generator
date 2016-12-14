package uicomponents.panels;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * This creates a JPanel which creates a grid with equal row and columns by
 * default.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class GridButtonPanel extends JPanel {

	public GridButtonPanel(JButton... buttons) {
		int edges = (int) Math.ceil(buttons.length / 2);
		this.setLayout(new GridLayout(edges, edges));
		this.setOpaque(false);
		for (JButton button : buttons) {
			this.add(button);
		}
	}

	public GridButtonPanel(int width, int height, JButton... buttons) {
		this(buttons);
		this.setPreferredSize(new Dimension(width, height));
	}
}
