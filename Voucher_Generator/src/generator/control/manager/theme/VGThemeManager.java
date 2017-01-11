package generator.control.manager.theme;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import vgcomponents.themes.*;

/**
 * This is a theme manager which utilises the in-library themes
 * 
 * @author Chris
 */
public class VGThemeManager extends ThemeManager {

	public VGThemeManager() {
		super(createThemes());
	}

	private static Collection<IVGTheme> createThemes() {
		List<IVGTheme> themes = new ArrayList<IVGTheme>();
		themes.add(new VGTheme());
		themes.add(new DarkTheme());
		return themes;
	}
}
