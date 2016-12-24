package generator.helper.converter;

import java.util.Collection;

import generator.models.code.Code;

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
		if (descriptions.isEmpty())
			return null;
		String[] tmp = new String[descriptions.size()];
		int count = 0;
		for (String s : descriptions) {
			tmp[count] = s;
			count++;
		}
		return tmp;
	}
}