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

	public VGList(int width, int height, String[] data, ListCellRenderer<String> renderer) {
		this(data, renderer);
		this.setPreferredSize(new Dimension(width, height));
	}

	public VGList(String[] data) {
		this(data, new VGThemeRenderer(new VGTheme()));
	}

	/**
	 * Creates a voucher generator list with a custom theme.
	 * 
	 * @param data
	 * @param renderer
	 */
	public VGList(String[] data, ListCellRenderer<String> renderer) {
		super(filledData(data));
		this.setCellRenderer(renderer);
	}

	private static String[] filledData(String[] data) {
		int size = 23;
		if (data.length < size) {
			String[] tmp = new String[size];
			for (int i = 0; i < tmp.length; i++) {
				if (i >= data.length) {
					tmp[i] = " ";
				} else {
					tmp[i] = data[i];
				}
			}
			return tmp;
		}
		return data;
	}
}