package vgcomponents.factories;

import generator.resources.Resources;
import vgcomponents.image.ImagePanel;

/**
 * This class contains methods which creates image panels.
 * 
 * @author Chris
 */
public abstract class VGImagePanelFactory {

	/**
	 * creates an image panel containing a config image icon.
	 * 
	 * @param filename
	 * @return
	 */
	public static ImagePanel createConfigImagePanel(String filename) {
		String image = Resources.getConfigImagePath(filename);
		return new ImagePanel(Resources.getCachedImage(image));
	}

	public static ImagePanel createConfigImagePanel(String filename, int size) {
		String image = Resources.getConfigImagePath(filename);
		return new ImagePanel(Resources.getCachedImage(image), size);
	}
}
