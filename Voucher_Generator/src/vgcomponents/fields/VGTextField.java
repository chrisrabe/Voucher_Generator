package vgcomponents.fields;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextArea;

/**
 * This class is a custom text field for the voucher generator.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class VGTextField extends JTextArea {

	/**
	 * Creates a VGTextField which contains a custom width, height and has a
	 * font size of 20 by default.
	 * 
	 * @param rows
	 * @param columns
	 */
	public VGTextField(int rows, int columns) {
		this(rows, columns, 30);
	}

	/**
	 * Creates a VGTextField which is always focusable and has a custom width,
	 * height and font size.
	 * 
	 * @param rows
	 * @param columns
	 * @param fontSize
	 */
	public VGTextField(int rows, int columns, int fontSize) {
		this(rows, columns, fontSize, true);
	}

	/**
	 * Creates a VGTextField which can or cannot be focusable and has a custom
	 * width and height and font size.
	 * 
	 * @param rows
	 * @param columns
	 * @param fontSize
	 * @param focusable
	 */
	public VGTextField(int rows, int columns, int fontSize, boolean focusable) {
		super(rows, columns);
		if (!focusable)
			this.setBackground(new Color(224, 224, 224));
		this.setForeground(Color.BLACK);
		this.setFont(new Font("Cooper Black", Font.PLAIN, fontSize));
		this.setLineWrap(true);
		this.setWrapStyleWord(true);
		this.setEditable(focusable);
	}
}
