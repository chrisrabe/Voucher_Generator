package vgcomponents.lists;

import java.awt.Dimension;

import javax.swing.JList;
import javax.swing.ListCellRenderer;

import vgcomponents.themes.VGTheme;
import vgcomponents.themes.renderer.VGThemeRenderer;

/**
 * Creates a JList which stores a generic object and a theme.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class VGList extends JList<String> {

	/**
	 * Creates a voucher generator list with the standard theme.
	 * 
	 * @param width
	 * @param height
	 * @param data
	 */
	public VGList(int width, int height, String[] data) {
		this(width, height, data, new VGThemeRenderer(new VGTheme()));
	}

	/**
	 * Creates a voucher generator list with a custom theme.
	 * 
	 * @param width
	 * @param height
	 * @param data
	 * @param renderer
	 */
	public VGList(int width, int height, String[] data, ListCellRenderer<String> renderer) {
		super(data);
		this.setCellRenderer(renderer);
		this.setPreferredSize(new Dimension(width, height));
	}
}
