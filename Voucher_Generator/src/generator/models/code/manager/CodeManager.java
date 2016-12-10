package generator.models.code.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import generator.helper.exception.InvalidInputException;
import generator.helper.groups.character.CharacterGroup;
import generator.models.code.Code;
import generator.models.code.manager.configuration.ManagerConfiguration;
import generator.models.code.storage.ICodeStorage;

/**
 * This class provides an abstract implementation of the code manager. It
 * enforces that the code manager must have a code storage.
 * 
 * @author Chris
 */
public abstract class CodeManager implements ICodeManager {

	// Fields

	protected ICodeStorage storage;
	protected ManagerConfiguration config;

	public CodeManager(ICodeStorage storage, ManagerConfiguration config) {
		this.storage = storage;
		this.config = config;
	}

	// Getters and Setters

	public ManagerConfiguration getConfigurations() {
		return config;
	}

	public void setConfigurations(ManagerConfiguration config) {
		this.config = config;
	}

	public ICodeStorage getStorage() {
		return storage;
	}

	// ICodeManager Methods

	@Override
	public void storeAll(List<Code> codes) {
		for (Code code : codes) {
			storage.add(code);
		}
	}

	@Override
	public Collection<Code> getCodes() {
		return storage.getCodes();
	}

	@Override
	public void clear() {
		storage.clear();
	}

	// Helper Methods

	/**
	 * Generates a code string with the length of the given chars parameter.
	 * 
	 * @param chars
	 * @param groups
	 * @return
	 */
	protected String generateCodeID(int chars, List<CharacterGroup> groups) throws InvalidInputException {
		// First grab all the active groups
		List<CharacterGroup> activeGroups = getActiveGroups(groups);
		if (activeGroups.isEmpty())
			throw new InvalidInputException("There are no active character groups.");

		// Start generating the code string.
		StringBuilder sb = new StringBuilder();
		while (sb.length() != chars) {
			int groupIndex = (int) (Math.random() * activeGroups.size());
			CharacterGroup group = activeGroups.get(groupIndex);
			char[] characters = group.getCharacters();
			sb.append(characters[(int) (Math.random() * characters.length)]);
		}
		return sb.toString();
	}

	/**
	 * Retrieves all the active character groups inside the groups parameter.
	 * 
	 * @param groups
	 * @return
	 */
	private List<CharacterGroup> getActiveGroups(List<CharacterGroup> groups) {
		List<CharacterGroup> tmp = new ArrayList<CharacterGroup>();
		for (CharacterGroup group : groups) {
			if (group.isActive())
				tmp.add(group);
		}
		return tmp;
	}
}
