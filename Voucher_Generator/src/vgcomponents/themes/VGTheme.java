package vgcomponents.themes;

import java.awt.Color;

/**
 * Provides a standard theme for the voucher generator.
 * 
 * @author Chris
 */
public class VGTheme implements IVGTheme {

	@Override
	public Color getForegroundColour() {
		return new Color(40, 40, 40);
	}

	@Override
	public Color getMainColour1() {
		return new Color(221, 221, 221);
	}

	@Override
	public Color getMainColour2() {
		return new Color(139, 175, 200);
	}

	@Override
	public Color getSelectedBGColour1() {
		return new Color(121, 121, 121);
	}

	@Override
	public Color getSelectedBGColour2() {
		return new Color(39, 75, 100);
	}

	@Override
	public Color getSelectedFGColour() {
		return new Color(255, 255, 255);
	}

	@Override
	public Color getBorderColour() {
		return new Color(255, 255, 255);
	}
}
