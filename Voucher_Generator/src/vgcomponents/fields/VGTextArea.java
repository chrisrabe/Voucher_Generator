package vgcomponents.fields;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextArea;

/**
 * This class is a custom text area for the voucher generator.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class VGTextArea extends JTextArea {

	/**
	 * Creates a VGTextArea which contains a custom row and column and has a
	 * font size of 30 by default.
	 * 
	 * @param rows
	 * @param columns
	 */
	public VGTextArea(int rows, int columns) {
		this(rows, columns, 30);
	}

	/**
	 * Creates a VGTextArea which is always focusable and has a custom row,
	 * column and font size.
	 * 
	 * @param rows
	 * @param columns
	 * @param fontSize
	 */
	public VGTextArea(int rows, int columns, int fontSize) {
		this(rows, columns, fontSize, true);
	}

	/**
	 * Creates a VGTextArea which can or cannot be focusable and has a custom
	 * row and column and font size.
	 * 
	 * @param rows
	 * @param columns
	 * @param fontSize
	 * @param focusable
	 */
	public VGTextArea(int rows, int columns, int fontSize, boolean focusable) {
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
