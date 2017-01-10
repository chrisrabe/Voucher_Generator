package generator.control.manager.theme;

import javax.swing.ListCellRenderer;

import vgcomponents.themes.IVGTheme;
import vgcomponents.themes.renderer.VGThemeRenderer;

/**
 * This class simply contains a theme renderer.
 * 
 * @author Chris
 */
public class ThemeManager implements IThemeManager {

	private IVGTheme theme;
	private boolean themeChanged;

	public ThemeManager(IVGTheme theme) {
		this.theme = theme;
	}

	@Override
	public ListCellRenderer<String> getCellRenderer() {
		themeChanged = false; // recently retrieved, so set it to false
		return new VGThemeRenderer(theme);
	}

	@Override
	public void setTheme(IVGTheme theme) {
		if (theme != null) { // Cannot be null
			this.theme = theme;
			themeChanged = true;
		}
	}

	@Override
	public boolean themeChanged() {
		return themeChanged;
	}

}
