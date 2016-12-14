package generator.resources;

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
		return String.format("%s%s", NAVIGATION_PATH, filename);
	}

	public static String getVoucherImagePath(String filename) {
		return String.format("%s%s", VOUCHER_PATH, filename);
	}

	public static String getDescriptionImagePath(String filename) {
		return String.format("%s%s", DESCRIPTION_PATH, filename);
	}

	public static String getIOImagePath(String filename) {
		return String.format("%s%s", IO_PATH, filename);
	}
}
