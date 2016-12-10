package generator.models.description.storage;

import java.util.Collection;

import generator.helper.exception.EmptyCollectionException;
import generator.helper.exception.InvalidInputException;

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
	 * @throws EmptyCollectionException
	 */
	public void remove(String description) throws EmptyCollectionException;

	/**
	 * Retrieves the description at the given index.
	 * 
	 * @param index
	 * @return
	 * @throws InvalidInputException
	 * @throws EmptyCollectionException
	 */
	public String get(int index) throws InvalidInputException, EmptyCollectionException;

	/**
	 * Returns true if the storage currently has the given string.
	 * 
	 * @param description
	 * @return
	 */
	public boolean contains(String description);

	/**
	 * Returns the number of descriptions stored.
	 * 
	 * @return
	 */
	public int size();

	/**
	 * Clears the storage.
	 */
	public void clear();
}
