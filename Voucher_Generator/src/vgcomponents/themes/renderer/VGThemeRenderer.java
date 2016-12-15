package vgcomponents.themes.renderer;

import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.border.LineBorder;

import vgcomponents.themes.IVGTheme;

/**
 * Creates a theme renderer which changes the foreground and background of the
 * cell based on the theme object passed.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class VGThemeRenderer extends JLabel implements ListCellRenderer<String> {
	// Fields
	private IVGTheme theme;
	private int fontSize;

	public VGThemeRenderer(IVGTheme theme) {
		this(theme, 20);
	}

	public VGThemeRenderer(IVGTheme theme, int fontSize) {
		this.theme = theme;
		this.fontSize = fontSize;
		this.setOpaque(true);
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends String> list, String value, int index,
			boolean isSelected, boolean cellHasFocus) {
		this.setText(value);
		this.setFont(new Font("Cooper Black", Font.PLAIN, fontSize));
		if (isSelected) {
			this.setForeground(theme.getSelectedFGColour());
			this.setBackground(index % 2 == 0 ? theme.getSelectedBGColour2() : theme.getSelectedBGColour1());
		} else {
			this.setForeground(theme.getForegroundColour());
			this.setBackground(index % 2 == 0 ? theme.getMainColour2() : theme.getMainColour1());
		}
		if (theme.getBorderColour() != null)
			this.setBorder(new LineBorder(theme.getBorderColour()));
		return this;
	}

}
