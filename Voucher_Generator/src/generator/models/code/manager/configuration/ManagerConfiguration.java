package generator.models.code.manager.configuration;

import java.util.ArrayList;
import java.util.List;

import generator.helper.groups.character.CharacterGroup;

/**
 * This indicates some configuration which are used for generating the code.
 * 
 * @author Chris
 */
public class ManagerConfiguration {

	private List<CharacterGroup> _characterGroups = new ArrayList<CharacterGroup>();;

	// Constructors

	/**
	 * Creates a configuration which holds upper case, lower case and number
	 * character groups.
	 */
	public ManagerConfiguration() {
		this(new CharacterGroup("ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray()),
				new CharacterGroup("abcdefghijklmnopqrstuvwxyz".toCharArray()),
				new CharacterGroup("0123456789".toCharArray()));
	}

	/**
	 * Adds all the character groups into the list of character groups.
	 * 
	 * @param characterGroups
	 */
	public ManagerConfiguration(CharacterGroup... characterGroups) {
		for (CharacterGroup group : characterGroups) {
			_characterGroups.add(group);
		}
	}

	// Getter and Setters

	public List<CharacterGroup> getCharacterGroups() {
		return _characterGroups;
	}

	public void setCharacterGroups(List<CharacterGroup> characterGroups) {
		_characterGroups = characterGroups;
	}

	// Methods

	public CharacterGroup getCharacterGroup(int index) {
		return _characterGroups.get(index);
	}

	public void removeCharacterGroup(int index) {
		_characterGroups.remove(index);
	}
}
