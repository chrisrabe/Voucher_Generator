package vgcomponents.factories;

import generator.resources.Resources;
import vgcomponents.buttons.ImageButton;

/**
 * This class is responsible for creating voucher generator button components.
 * 
 * @author Chris
 */
public abstract class VGButtonFactory {

	// Fields
	private static final int FONT_SIZE = 6;

	// Configuration Button creator methods

	/**
	 * Creates an image button with the given file name as the icon.
	 * 
	 * @param filename
	 * @return
	 */
	public static ImageButton createConfigButton(String filename) {
		String icon = Resources.getConfigImagePath(filename);
		String ro = Resources.getConfigRollOverImage(filename);
		return new ImageButton(icon, ro);
	}

	public static ImageButton createConfigButton(String filename, String toolTip) {
		ImageButton btn = createConfigButton(filename);
		String tip = VGToolTipFactory.createToolTip(toolTip, FONT_SIZE);
		btn.setToolTipText(tip);
		return btn;
	}

	public static ImageButton createConfigButton(String filename, int size) {
		String icon = Resources.getConfigImagePath(filename);
		String ro = Resources.getConfigRollOverImage(filename);
		return new ImageButton(icon, ro, size);
	}

	public static ImageButton createConfigButton(String filename, String toolTip, int size) {
		ImageButton btn = createConfigButton(filename, size);
		String tip = VGToolTipFactory.createToolTip(toolTip, FONT_SIZE);
		btn.setToolTipText(tip);
		return btn;
	}

	// Navigation Button creator methods

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
		String tip = VGToolTipFactory.createToolTip(toolTip, FONT_SIZE);
		btn.setToolTipText(tip);
		return btn;
	}

	public static ImageButton createNavigationButton(String filename, int size) {
		String icon = Resources.getNavigationImagePath(filename);
		String ro = Resources.getNavigationRollOverImage(filename);
		return new ImageButton(icon, ro, size);
	}

	public static ImageButton createNavigationButton(String filename, String toolTip, int size) {
		ImageButton btn = createNavigationButton(filename, size);
		String tip = VGToolTipFactory.createToolTip(toolTip, FONT_SIZE);
		btn.setToolTipText(tip);
		return btn;
	}

	// Voucher Button creator methods

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
		String tip = VGToolTipFactory.createToolTip(toolTip, FONT_SIZE);
		btn.setToolTipText(tip);
		return btn;
	}

	public static ImageButton createVoucherButton(String filename, int size) {
		String icon = Resources.getVoucherImagePath(filename);
		String ro = Resources.getVoucherRollOverImage(filename);
		return new ImageButton(icon, ro, size);
	}

	public static ImageButton createVoucherButton(String filename, String toolTip, int size) {
		ImageButton btn = createVoucherButton(filename, size);
		String tip = VGToolTipFactory.createToolTip(toolTip, FONT_SIZE);
		btn.setToolTipText(tip);
		return btn;
	}

	// Description Button creation methods

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
		String tip = VGToolTipFactory.createToolTip(toolTip, FONT_SIZE);
		btn.setToolTipText(tip);
		return btn;
	}

	public static ImageButton createDescriptionButton(String filename, int size) {
		String icon = Resources.getDescriptionImagePath(filename);
		String ro = Resources.getDescriptionRollOverImage(filename);
		return new ImageButton(icon, ro, size);
	}

	public static ImageButton createDescriptionButton(String filename, String toolTip, int size) {
		ImageButton btn = createDescriptionButton(filename, size);
		String tip = VGToolTipFactory.createToolTip(toolTip, FONT_SIZE);
		btn.setToolTipText(tip);
		return btn;
	}

	// IO Button creation methods

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
		String tip = VGToolTipFactory.createToolTip(toolTip, FONT_SIZE);
		btn.setToolTipText(tip);
		return btn;
	}

	public static ImageButton createIOButton(String filename, int size) {
		String icon = Resources.getIOImagePath(filename);
		String ro = Resources.getIORollOverImage(filename);
		return new ImageButton(icon, ro, size);
	}

	public static ImageButton createIOButton(String filename, String toolTip, int size) {
		ImageButton btn = createIOButton(filename, size);
		String tip = VGToolTipFactory.createToolTip(toolTip, FONT_SIZE);
		btn.setToolTipText(tip);
		return btn;
	}
}
