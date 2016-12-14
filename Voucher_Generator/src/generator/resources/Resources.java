package generator.resources;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

/**
 * This class is responsible for returning the correct file path given the file
 * name.
 * 
 * @author Chris
 */
public abstract class Resources {
	// Directory Paths

	private static final String NAVIGATION_PATH = "/generator/resources/image/navigation/";
	private static final String VOUCHER_PATH = "/generator/resources/image/voucher/";
	private static final String DESCRIPTION_PATH = "/generator/resources/image/description/";
	private static final String IO_PATH = "/generator/resources/image/io/";

	// Image Path accessors

	public static String getNavigationImagePath(String filename) {
		return String.format("%s%s.png", NAVIGATION_PATH, filename);
	}

	public static String getVoucherImagePath(String filename) {
		return String.format("%s%s.png", VOUCHER_PATH, filename);
	}

	public static String getDescriptionImagePath(String filename) {
		return String.format("%s%s.png", DESCRIPTION_PATH, filename);
	}

	public static String getIOImagePath(String filename) {
		return String.format("%s%s.png", IO_PATH, filename);
	}

	public static String getNavigationRollOverImage(String filename) {
		return getNavigationImagePath(String.format("%s-ro", filename));
	}

	public static String getVoucherRollOverImage(String filename) {
		return getVoucherImagePath(String.format("%s-ro", filename));
	}

	public static String getDescriptionRollOverImage(String filename) {
		return getDescriptionImagePath(String.format("%s-ro", filename));
	}

	public static String getIORollOverImage(String filename) {
		return getIOImagePath(String.format("%s-ro", filename));
	}

	// Cached Images

	private static Map<String, BufferedImage> cachedImages = new HashMap<String, BufferedImage>();

	/**
	 * Returns the image stored inside the given path.
	 * 
	 * @param path
	 * @return
	 */
	public static BufferedImage getCachedImage(String path) {
		if (!cachedImages.containsKey(path))
			cachedImages.put(path, getImage(path));

		return cachedImages.get(path);
	}

	private static BufferedImage getImage(String path) {
		try {
			return ImageIO.read(Resources.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
