package vgcomponents.themes;

import java.awt.Color;

/**
 * This represents a technology theme. It has a dark and light gray alternating
 * colours, with a light blue selection highlight.
 * 
 * @author Chris
 */
public class DarkTheme implements IVGTheme {

	@Override
	public Color getForegroundColour() {
		return new Color(255, 255, 255);
	}

	@Override
	public Color getMainColour1() {
		return new Color(64, 64, 64);
	}

	@Override
	public Color getMainColour2() {
		return new Color(40, 40, 40);
	}

	@Override
	public Color getSelectedBGColour1() {
		return new Color(56, 85, 116);
	}

	@Override
	public Color getSelectedBGColour2() {
		return new Color(56, 85, 116);
	}

	@Override
	public Color getSelectedFGColour() {
		return new Color(191, 220, 251);
	}

	@Override
	public Color getBorderColour() {
		return new Color(253, 253, 253);
	}

	@Override
	public String getThemeName() {
		return "Dark";
	}

}
