package generator.control.manager.code.configuration;

import java.util.ArrayList;
import java.util.List;

import generator.helper.exception.InvalidInputException;
import generator.helper.groups.character.CharacterGroup;

/**
 * This indicates some configuration which are used for generating the code.
 * 
 * @author Chris
 */
public class ManagerConfiguration {

	private List<CharacterGroup> characterGroups = new ArrayList<CharacterGroup>();
	private List<String> groupNames = new ArrayList<String>();

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
			groupNames.add(group.getName());
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

	public CharacterGroup getCharacterGroup(String name) {
		for (CharacterGroup group : characterGroups) {
			if (group.getName().equals(name)) {
				return group;
			}
		}
		return null;
	}

	public void addCharacterGroup(CharacterGroup group) throws InvalidInputException {
		if (!groupNames.contains(group.getName())) {
			groupNames.add(group.getName());
			characterGroups.add(group);
		} else {
			throw new InvalidInputException("The name must be unique!");
		}
	}

	/**
	 * Removes the character group with the given name.
	 * 
	 * @param name
	 * @throws InvalidInputException
	 */
	public void removeCharacterGroup(String name) throws InvalidInputException {
		int index = 0;
		for (CharacterGroup group : characterGroups) {
			if (group.getName().equals(name)) {
				characterGroups.remove(index);
				groupNames.remove(index);
				return;
			}
			index++;
		}
		throw new InvalidInputException("Given name is not found");
	}
}
