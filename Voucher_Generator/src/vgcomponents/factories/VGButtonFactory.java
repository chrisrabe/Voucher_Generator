package vgcomponents.factories;

import generator.resources.Resources;
import vgcomponents.buttons.ImageButton;

/**
 * This class is responsible for creating voucher generator button components.
 * 
 * @author Chris
 */
public abstract class VGButtonFactory {

	/**
	 * Creates an image button with the given filename as the icon.
	 * 
	 * @param filename
	 * @return
	 */
	public static ImageButton createNavigationButton(String filename) {
		String icon = Resources.getNavigationImagePath(filename);
		String ro = Resources.getNavigationRollOverImage(filename);
		return new ImageButton(icon, ro);
	}

	/**
	 * Creates an image button with the given filename as the icon and assigned
	 * tool tip.
	 * 
	 * @param filename
	 * @param toolTip
	 * @return
	 */
	public static ImageButton createNavigationButton(String filename, String toolTip) {
		ImageButton btn = createNavigationButton(filename);
		String tip = VGToolTipFactory.createToolTip(toolTip, 6);
		btn.setToolTipText(tip);
		return btn;
	}

	/**
	 * Creates an image button with the given filename as the icon.
	 * 
	 * @param filename
	 * @return
	 */
	public static ImageButton createVoucherButton(String filename) {
		String icon = Resources.getVoucherImagePath(filename);
		String ro = Resources.getVoucherRollOverImage(filename);
		return new ImageButton(icon, ro);
	}

	/**
	 * Creates an image button with the given filename as the icon and assigned
	 * tool tip.
	 * 
	 * @param filename
	 * @param toolTip
	 * @return
	 */
	public static ImageButton createVoucherButton(String filename, String toolTip) {
		ImageButton btn = createVoucherButton(filename);
		String tip = VGToolTipFactory.createToolTip(toolTip, 6);
		btn.setToolTipText(tip);
		return btn;
	}

	/**
	 * Creates an image button with the given filename as the icon.
	 * 
	 * @param filename
	 * @return
	 */
	public static ImageButton createDescriptionButton(String filename) {
		String icon = Resources.getDescriptionImagePath(filename);
		String ro = Resources.getDescriptionRollOverImage(filename);
		return new ImageButton(icon, ro);
	}

	/**
	 * Creates an image button with the given filename as the icon and assigned
	 * tool tip.
	 * 
	 * @param filename
	 * @param toolTip
	 * @return
	 */
	public static ImageButton createDescriptionButton(String filename, String toolTip) {
		ImageButton btn = createDescriptionButton(filename);
		String tip = VGToolTipFactory.createToolTip(toolTip, 6);
		btn.setToolTipText(tip);
		return btn;
	}

	/**
	 * Creates an image button with the given filename as the icon.
	 * 
	 * @param filename
	 * @return
	 */
	public static ImageButton createIOButton(String filename) {
		String icon = Resources.getIOImagePath(filename);
		String ro = Resources.getIORollOverImage(filename);
		return new ImageButton(icon, ro);
	}

	/**
	 * Creates an image button with the given filename as the icon and assigned
	 * tool tip.
	 * 
	 * @param filename
	 * @param toolTip
	 * @return
	 */
	public static ImageButton createIOButton(String filename, String toolTip) {
		ImageButton btn = createIOButton(filename);
		String tip = VGToolTipFactory.createToolTip(toolTip, 6);
		btn.setToolTipText(tip);
		return btn;
	}
}
