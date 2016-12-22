package generator.control.manager.code;

import java.util.ArrayList;
import java.util.List;

import generator.control.manager.code.configuration.ManagerConfiguration;
import generator.helper.exception.InvalidInputException;
import generator.helper.exception.TimeoutException;
import generator.helper.groups.character.CharacterGroup;
import generator.models.code.Code;
import generator.models.code.storage.MapCodeStorage;

/**
 * This code manager uses a map code storage for its storing and retrieval
 * operations.
 * 
 * @author Chris
 */
public class MapCodeManager extends CodeManager {

	// Constructors

	/**
	 * Creates a code manager which uses a default configuration manager. The
	 * default configuration manager allows the manager to generate codes with
	 * any character types.
	 */
	public MapCodeManager() {
		this(new ManagerConfiguration());
	}

	/**
	 * Creates a code manager which has specific manager configuration
	 * conditions.
	 * 
	 * @param config
	 */
	public MapCodeManager(ManagerConfiguration config) {
		super(new MapCodeStorage(), config);
	}

	// Methods

	@Override
	public void generateCode(int chars, int size) throws InvalidInputException, TimeoutException {
		List<CharacterGroup> groups = config.getCharacterGroups();
		final int MAX_RETRIES = 100; // after 100 tries, it times out.
		int retries = 0; // keeps track of retrials.
		int generated = 0; // number of codes generated.

		while (generated < size) {
			retries = 0;
			String id = generateCodeID(chars, groups);
			while (storage.contains(id)) {
				retries++;
				id = generateCodeID(chars, groups);
				if (retries == MAX_RETRIES) {
					throw new TimeoutException("Generate operation took too long.");
				}
			}
			storage.add(new Code(id));
			generated++;
		}
	}

	@Override
	public void reduce(int newSize) {
		if (newSize >= storage.size()) {
			return;
		}

		List<Code> tmp = new ArrayList<Code>();
		for (Code code : storage.getCodes()) {
			tmp.add(code);
			if (tmp.size() == newSize) {
				break;
			}
		}

		storage.setCodes(tmp);
	}

}
