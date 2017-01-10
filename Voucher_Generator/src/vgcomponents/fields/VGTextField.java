package vgcomponents.fields;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JTextField;

/**
 * This class is a custom text field for the voucher generator.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class VGTextField extends JTextField {

	/**
	 * Creates a VGTextField which contains a custom width and height and has a
	 * font size of 30 by default.
	 * 
	 * @param with
	 * @param height
	 */
	public VGTextField(int with, int height) {
		this(with, height, 30);
	}

	/**
	 * Create a VGTextField which is always focusable and has a custom width,
	 * height, and font size.
	 * 
	 * @param width
	 * @param height
	 * @param fontSize
	 */
	public VGTextField(int width, int height, int fontSize) {
		this(width, height, fontSize, true);
	}

	/**
	 * Creates a VGTextArea which can or cannot be focusable and has a custom
	 * width,height, and font size.
	 * 
	 * @param width
	 * @param height
	 * @param fontSize
	 * @param focusable
	 */
	public VGTextField(int width, int height, int fontSize, boolean focusable) {
		if (!focusable)
			this.setBackground(new Color(244, 244, 244));
		this.setForeground(Color.BLACK);
		this.setFont(new Font("Cooper Black", Font.PLAIN, fontSize));
		this.setEditable(focusable);
		this.setPreferredSize(new Dimension(width, height));
	}
}
