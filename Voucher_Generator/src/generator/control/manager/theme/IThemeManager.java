package generator.control.manager.theme;

import java.util.Collection;

import javax.swing.ListCellRenderer;

import vgcomponents.themes.IVGTheme;

/*
 * This class manages the themes of the JLists.
 */
public interface IThemeManager {

	/**
	 * Returns the cell renderer
	 * 
	 * @return
	 */
	public ListCellRenderer<String> getCellRenderer();

	/**
	 * Returns a collection of themes
	 * 
	 * @return
	 */
	public Collection<IVGTheme> getThemes();

	/**
	 * Returns true if the theme has been recently changed.
	 * 
	 * @return
	 */
	public boolean themeChanged();

	/**
	 * Changes the theme.
	 * 
	 * @param theme
	 */
	public void setTheme(IVGTheme theme);
	
	public IVGTheme getTheme(int index);

	public void setChanged(boolean state);
}
