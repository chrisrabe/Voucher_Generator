package vgcomponents.buttons;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.image.BufferedImage;

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
		this(icon, rollOver, -1);
	}

	/**
	 * Resizes the icon so that the button resizes along with it. If the size
	 * passed is -1, then it uses the original dimensions of the image icon.
	 * 
	 * @param icon
	 * @param rollOver
	 * @param size
	 */
	public ImageButton(String icon, String rollOver, int size) {
		this();
		this.setIcon(new ImageIcon(getScaledImage(Resources.getCachedImage(icon), size)));
		this.setRolloverIcon(new ImageIcon(getScaledImage(Resources.getCachedImage(rollOver), size)));
	}

	private ImageButton() {
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.setOpaque(false);
		this.setContentAreaFilled(false);
		this.setBorder(null);
		this.setFocusPainted(false);
	}

	private BufferedImage getScaledImage(BufferedImage source, int size) {
		Image scaled = source.getScaledInstance(-1, size, Image.SCALE_SMOOTH);
		BufferedImage bufferedScaled = new BufferedImage(scaled.getWidth(null), scaled.getHeight(null),
				BufferedImage.TYPE_INT_RGB);
		bufferedScaled.getGraphics().drawImage(scaled, 0, 0, null);
		return bufferedScaled;
	}
}
