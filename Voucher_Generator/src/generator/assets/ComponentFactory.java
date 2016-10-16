/*	File: ComponentFactory.java
 * 
 * 	Date			Author				Changes
 * 	16 Oct 16		Chris Rabe			created ComponentFactory.java
 */

package generator.assets;

import java.awt.Image;
import java.io.File;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

import generator.gui.graphics.VControl;
import generator.gui.graphics.VControl.View;
import generator.gui.graphics.views.*;

/**
 * This class contains methods which creates JComponents needed for the view as
 * well as initialisation methods for the GUI.
 * 
 * @author Chris
 */
public class ComponentFactory {

	public static JButton createButton(Image img) {
		JButton btn = new JButton();
		btn.setIcon(new ImageIcon(img));
		btn.setOpaque(false);
		btn.setContentAreaFilled(false);
		btn.setBorder(null);
		btn.setFocusPainted(false);
		return btn;
	}

	public static JLabel createLabel(String text) {
		JLabel label = new JLabel(text);
		return label;
	}

	public static JScrollPane createScrollList(List<? extends Object> list) {
		String categories[] = toArray(list);
		JList<String> jlist = new JList<String>(categories);
		JScrollPane scroll = new JScrollPane(jlist);
		return scroll;
	}

	public static JFileChooser createChooser(String title) {
		JFileChooser fc = new JFileChooser(title);
		fc.setCurrentDirectory(new File("."));
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		return fc;
	}

	public static ImageIcon createVoucherIcon() {
		ImageIcon icon = new ImageIcon(Assets.getVoucherIcon());
		return icon;
	}

	public static ImageIcon createDescIcon() {
		ImageIcon icon = new ImageIcon(Assets.getDescriptionIcon());
		return icon;
	}

	public static View[] createViews(VControl control) {
		int num = 1;
		View[] tmp = new View[num];
		tmp[0] = new GeneratorView(control);
		return tmp;
	}

	// Helper Methods

	private static String[] toArray(List<? extends Object> list) {
		String[] tmp = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			tmp[i] = list.get(i).toString();
		}
		return tmp;
	}
}
