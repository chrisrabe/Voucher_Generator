package generator.models.description.storage;

import java.util.Collection;

public interface IDescriptionStorage {

	/**
	 * Retrieves a collection of descriptions from the storage.
	 * 
	 * @return
	 */
	public Collection<String> getDescriptions();

	/**
	 * Sets the collection of descriptions in the storage.
	 * 
	 * @param descriptions
	 */
	public void setDescriptions(Collection<String> descriptions);

	/**
	 * Adds a new description in the storage.
	 * 
	 * @param description
	 */
	public void add(String description);

	/**
	 * removes the description from the storage.
	 * 
	 * @param description
	 */
	public void remove(String description);

	/**
	 * Retrieves the description at the given index.
	 * 
	 * @param index
	 * @return
	 */
	public String get(int index);

	/**
	 * Clears the storage.
	 */
	public void clear();
}
