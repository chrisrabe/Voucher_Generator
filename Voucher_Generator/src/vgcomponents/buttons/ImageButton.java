package vgcomponents.buttons;

import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import generator.resources.Resources;

/**
 * This class is a button which has an image icon inside it.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class ImageButton extends JButton {

	/**
	 * This contructor initialises the button so that it has an icon and a roll
	 * over icon. The icon is the static look of the button and the roll over is
	 * the icon which the button changes into when the mouse is hovered above
	 * it.
	 * 
	 * @param icon
	 * @param rollOver
	 */
	public ImageButton(String icon, String rollOver) {
		this.setIcon(new ImageIcon(Resources.getCachedImage(icon)));
		this.setRolloverIcon(new ImageIcon(Resources.getCachedImage(rollOver)));
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.setOpaque(false);
		this.setContentAreaFilled(false);
		this.setBorder(null);
		this.setFocusPainted(false);
	}

	public ImageButton(String imagePath, String rollOver, int width, int height) {
		this(imagePath, rollOver);
		this.setPreferredSize(new Dimension(width, height));
	}
}
