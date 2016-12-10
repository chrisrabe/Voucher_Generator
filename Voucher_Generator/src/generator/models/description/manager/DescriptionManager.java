package generator.models.description.manager;

import generator.helper.exception.InvalidInputException;
import generator.models.description.storage.IDescriptionStorage;

/**
 * This class provides a skeletal implementation of the description manager.
 * 
 * @author Chris
 */
public abstract class DescriptionManager implements IDescriptionManager {

	protected IDescriptionStorage storage;

	public DescriptionManager(IDescriptionStorage storage) {
		this.storage = storage;
	}

	// Getters

	public IDescriptionStorage getStorage() {
		return storage;
	}

	// Methods

	@Override
	public void addDescription(String description) throws InvalidInputException {
		if (storage.contains(description))
			throw new InvalidInputException("The description already exists.");
		storage.add(description);
	}
}
