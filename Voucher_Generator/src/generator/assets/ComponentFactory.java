/*	File: ComponentFactory.java
 * 
 * 	Date			Author				Changes
 * 	16 Oct 16		Chris Rabe			created ComponentFactory.java
 */

package generator.assets;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

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

	public static JButton createButton(String text) {
		JButton btn = new JButton(text);
		btn.setFocusable(false);
		return btn;
	}

	public static JLabel createLabel(String text) {
		JLabel label = new JLabel(text);
		label.setName(text);
		label.setBorder(new EmptyBorder(0, 0, 25, 0));
		label.setForeground(Color.BLACK);
		label.setFocusable(false);
		return label;
	}

	public static JScrollPane createScrollList(List<? extends Object> list) {
		return new JScrollPane(createJList(list));
	}

	public static JList<String> createJList(List<? extends Object> list) {
		String categories[] = toArray(list);
		return new JList<String>(categories);
	}

	public static JFileChooser createChooser(String title) {
		JFileChooser fc = new JFileChooser(title);
		fc.setCurrentDirectory(new File("."));
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		return fc;
	}

	public static ImageIcon createVoucherIcon(double scale) {
		ImageIcon icon = new ImageIcon(Assets.scaleImage(Assets.getVoucherIcon(), scale));
		return icon;
	}

	public static ImageIcon createDescIcon(double scale) {
		ImageIcon icon = new ImageIcon(Assets.scaleImage(Assets.getDescriptionIcon(), scale));
		return icon;
	}

	public static JTextField createTextField() {
		JTextField tf = new JTextField();
		Dimension size = new Dimension(100, 25);
		tf.setPreferredSize(size);
		tf.setMaximumSize(size);
		tf.setForeground(Color.BLACK);
		tf.setHorizontalAlignment(JTextField.CENTER);
		tf.setEditable(true);
		return tf;
	}

	public static JComboBox<String> createStringCombo(String[] content) {
		JComboBox<String> cb = new JComboBox<String>(content);
		cb.setSelectedIndex(0);
		Dimension size = new Dimension(100, 25);
		cb.setPreferredSize(size);
		cb.setMaximumSize(size);
		return cb;
	}

	public static JTabbedPane createTabbedPane() {
		JTabbedPane tPane = new JTabbedPane();
		return tPane;
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
