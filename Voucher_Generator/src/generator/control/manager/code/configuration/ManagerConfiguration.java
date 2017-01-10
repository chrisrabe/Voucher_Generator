package generator.control.manager.code.configuration;

import java.util.ArrayList;
import java.util.List;

import generator.helper.groups.character.CharacterGroup;

/**
 * This indicates some configuration which are used for generating the code.
 * 
 * @author Chris
 */
public class ManagerConfiguration {

	private List<CharacterGroup> characterGroups = new ArrayList<CharacterGroup>();;

	// Constructors

	/**
	 * Creates a configuration which holds upper case, lower case and number
	 * character groups.
	 */
	public ManagerConfiguration() {
		this(new CharacterGroup("Upper Case Letters", "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray()),
				new CharacterGroup("Lower Case Letters", "abcdefghijklmnopqrstuvwxyz".toCharArray()),
				new CharacterGroup("Numbers", "0123456789".toCharArray()));
	}

	/**
	 * Adds all the character groups into the list of character groups.
	 * 
	 * @param characterGroups
	 */
	public ManagerConfiguration(CharacterGroup... characterGroups) {
		for (CharacterGroup group : characterGroups) {
			this.characterGroups.add(group);
		}
	}

	// Getter and Setters

	public List<CharacterGroup> getCharacterGroups() {
		return characterGroups;
	}

	public void setCharacterGroups(List<CharacterGroup> characterGroups) {
		this.characterGroups = characterGroups;
	}

	// Methods

	public CharacterGroup getCharacterGroup(int index) {
		return characterGroups.get(index);
	}

	public void addCharacterGroup(CharacterGroup group) {
		characterGroups.add(group);
	}

	/**
	 * Removes all the character groups with the given name. If two or more
	 * character groups have the same name, then those groups are deleted as
	 * well.
	 * 
	 * @param name
	 */
	public void removeCharacterGroup(String name) {
		int index = 0;
		for (CharacterGroup group : characterGroups) {
			if (group.getName().equals(name)) {
				characterGroups.remove(index);
			}
			index++;
		}
	}
}
