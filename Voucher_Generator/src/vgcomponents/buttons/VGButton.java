package vgcomponents.buttons;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

/**
 * Creates a customised JButton for the voucher generator. It's a dark button
 * which changes foreground upon mouse enter.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class VGButton extends JButton {

	public VGButton(String text) {
		this(text.length() * 25, 50, text);
	}

	public VGButton(int width, int height, String text) {
		this(width, height, 5, text);
	}

	public VGButton(int width, int height, int borderThickness, String text) {
		this(width, height, 20, borderThickness, text);
	}

	public VGButton(int width, int height, int fontSize, int borderThickness, String text) {
		super(text);
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.setFont(new Font("Cooper Black", Font.PLAIN, fontSize));
		this.setBackground(new Color(40, 40, 40));
		this.setFocusable(false);
		this.setBorder(new LineBorder(Color.WHITE, borderThickness));
		this.setForeground(Color.WHITE);
		this.setPreferredSize(new Dimension(width, height));
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				VGButton.this.setForeground(new Color(191, 220, 251));
				VGButton.this.setBorder(new LineBorder(new Color(191, 220, 251), borderThickness));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				VGButton.this.setForeground(Color.WHITE);
				VGButton.this.setBorder(new LineBorder(Color.WHITE, borderThickness));
			}
		});
	}

}
