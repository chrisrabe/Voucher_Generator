package vgcomponents.labels;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

/**
 * This is a custom label for the voucher generator.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class VGLabel extends JLabel {

	public VGLabel(String text, int fontSize) {
		super(text);
		Font font = new Font("Cooper Black", Font.PLAIN, fontSize);
		this.setFont(font);
		this.setForeground(Color.WHITE);
		this.setOpaque(false);
		this.setFocusable(false);
	}
}
