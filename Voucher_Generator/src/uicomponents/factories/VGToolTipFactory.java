package uicomponents.factories;

public abstract class VGToolTipFactory {

	public static String createToolTip(String text, int size) {
		return String.format("<html><body><p><font size=%d>%s</font></p></body></html>", size, text);
	}
}
