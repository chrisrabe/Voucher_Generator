package generator.control.manager.description;

import java.util.Collection;

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

	/**
	 * Retrieves the descriptions inside the storage.
	 * 
	 * @return
	 */
	public Collection<String> getDescriptions() {
		return storage.getDescriptions();
	}

	@Override
	public void addDescription(String description) throws InvalidInputException {
		if (storage.contains(description))
			throw new InvalidInputException("The description already exists.");
		storage.add(description);
	}

	/**
	 * Clears the storage
	 */
	public void clear() {
		storage.clear();
	}
}
