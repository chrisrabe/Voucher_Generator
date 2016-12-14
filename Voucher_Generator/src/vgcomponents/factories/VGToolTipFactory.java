package vgcomponents.factories;

public abstract class VGToolTipFactory {

	public static String createToolTip(String text, int size) {
		return String.format(
				"<html><body bgcolor=\"#282828\"><p><font size=%d color=\"#ffffff\">%s</font></p></body></html>", size,
				text);
	}
}
