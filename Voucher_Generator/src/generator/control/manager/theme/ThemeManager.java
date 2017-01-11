package generator.control.manager.theme;

import java.util.ArrayList;
import java.util.Collection;

import javax.swing.ListCellRenderer;

import vgcomponents.themes.IVGTheme;
import vgcomponents.themes.renderer.VGThemeRenderer;

/**
 * This class simply contains a theme renderer.
 * 
 * @author Chris
 */
public abstract class ThemeManager implements IThemeManager {

	protected IVGTheme theme;
	protected Collection<IVGTheme> themes;
	private boolean themeChanged;

	public ThemeManager(Collection<IVGTheme> themes) {
		if (themes.isEmpty())
			throw new RuntimeException("No themes detected");
		this.themes = themes;
		this.theme = new ArrayList<IVGTheme>(themes).get(0);
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

	@Override
	public Collection<IVGTheme> getThemes() {
		return themes;
	}

}
