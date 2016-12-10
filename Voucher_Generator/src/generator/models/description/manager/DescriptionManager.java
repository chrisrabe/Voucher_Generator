package generator.models.description.manager;

import generator.models.description.storage.IDescriptionStorage;

/**
 * This class provides a skeletal implementation of the description manager.
 * 
 * @author Chris
 */
public abstract class DescriptionManager implements IDescriptionManager {

	protected IDescriptionStorage _storage;

	public DescriptionManager(IDescriptionStorage storage) {
		_storage = storage;
	}

	// Getters

	public IDescriptionStorage getStorage() {
		return _storage;
	}
}
