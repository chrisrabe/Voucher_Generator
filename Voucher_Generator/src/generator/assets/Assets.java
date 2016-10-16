/*	File: Assets.java
 * 
 * 	Date				Author				Changes
 * 	15 Oct 16			Chris Rabe			created Assets.java
 * 	15 Oct 16			Chris Rabe			added methods for getting image resources
 */

package generator.assets;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * This class cannot be created, however it contains static getters for loading
 * files such as images.
 * 
 * @author Chris
 */
public class Assets {
	// Path names
	private static final String IMAGE_PATH = "/generator/assets/img/";
	// Images
	private static BufferedImage addIcon;
	private static BufferedImage delIcon;
	private static BufferedImage genIcon;
	private static BufferedImage edtIcon;
	private static BufferedImage clrIcon;

	// Getters for Images
	public static BufferedImage getAddIcon() {
		if (addIcon == null) {
			try {
				addIcon = ImageIO.read(Assets.class.getResource(IMAGE_PATH + "file_add.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return addIcon;
	}

	public static BufferedImage getDelIcon() {
		if (delIcon == null) {
			try {
				delIcon = ImageIO.read(Assets.class.getResource(IMAGE_PATH + "file_delete.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return delIcon;
	}

	public static BufferedImage getGenIcon() {
		if (genIcon == null) {
			try {
				genIcon = ImageIO.read(Assets.class.getResource(IMAGE_PATH + "generate-icon.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return genIcon;
	}

	public static BufferedImage getEditIcon() {
		if (edtIcon == null) {
			try {
				edtIcon = ImageIO.read(Assets.class.getResource(IMAGE_PATH + "file_edit.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return edtIcon;
	}

	public static BufferedImage getClearIcon() {
		if (clrIcon == null) {
			try {
				clrIcon = ImageIO.read(Assets.class.getResource(IMAGE_PATH + "delete.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return clrIcon;
	}

	private Assets() {
	}
}
