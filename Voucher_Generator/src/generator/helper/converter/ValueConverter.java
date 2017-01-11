package generator.helper.converter;

import java.util.Collection;

import generator.control.manager.code.configuration.ManagerConfiguration;
import generator.control.manager.theme.IThemeManager;
import generator.helper.groups.character.CharacterGroup;
import generator.models.code.Code;
import vgcomponents.themes.IVGTheme;

/**
 * Provides methods which transforms any item into a string array.
 * 
 * @author Chris
 */
public abstract class ValueConverter {

	public static String[] convertCodeToArray(Collection<Code> codes) {
		String[] tmp = new String[codes.size()];
		int count = 0;
		for (Code code : codes) {
			StringBuilder sb = new StringBuilder();
			sb.append(String.format("%s [%s] :   %s", code.getID(), code.isRedeemed() ? "redeemed" : "available",
					code.getDescription()));
			tmp[count] = sb.toString();
			count++;
		}
		return tmp;
	}

	public static String[] convertDescriptionsToArray(Collection<String> descriptions) {
		String[] tmp = new String[descriptions.size()];
		int count = 0;
		for (String s : descriptions) {
			tmp[count] = s;
			count++;
		}
		return tmp;
	}

	public static String[] convertConfigurationToArray(ManagerConfiguration config) {
		Collection<CharacterGroup> charGroups = config.getCharacterGroups();
		String[] tmp = new String[charGroups.size()];
		int count = 0;
		for (CharacterGroup group : charGroups) {
			tmp[count] = group.getName();
			count++;
		}
		return tmp;
	}

	public static String[] convertThemesToArray(IThemeManager themeManager) {
		Collection<IVGTheme> themes = themeManager.getThemes();
		String[] tmp = new String[themes.size()];
		int count = 0;
		for (IVGTheme theme : themes) {
			tmp[count] = theme.getThemeName();
			count++;
		}
		return tmp;
	}
}