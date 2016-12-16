package vgcomponents.image;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

/**
 * Creates a JPanel which draws an image.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class ImagePanel extends JPanel {

	private BufferedImage image;

	public ImagePanel(BufferedImage image) {
		this.image = image;
		this.setOpaque(true);
		this.setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
	}

	public ImagePanel(BufferedImage image, int size) {
		this(getScaledImage(image, size));
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
	}

	private static BufferedImage getScaledImage(BufferedImage source, int size) {
		Image scaled = source.getScaledInstance(-1, size, Image.SCALE_SMOOTH);
		BufferedImage bufferedScaled = new BufferedImage(scaled.getWidth(null), scaled.getHeight(null),
				BufferedImage.TYPE_INT_RGB);
		bufferedScaled.getGraphics().drawImage(scaled, 0, 0, null);
		return bufferedScaled;
	}
}
