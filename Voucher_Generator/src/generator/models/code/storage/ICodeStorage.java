package generator.models.code.storage;

import java.util.Collection;

import generator.helper.exception.EmptyCollectionException;
import generator.helper.exception.InvalidInputException;
import generator.models.code.Code;

/**
 * Provides skeleton methods which are needed for a code storage.
 * 
 * @author Chris
 */
public interface ICodeStorage {

	/**
	 * Gets all the codes in the storage.
	 * 
	 * @return
	 */
	public Collection<Code> getCodes();

	/**
	 * Replaces the collection of codes.
	 * 
	 * @param codes
	 */
	public void setCodes(Collection<Code> codes);

	/**
	 * Adds the new code into the storage.
	 * 
	 * @param code
	 */
	public void add(Code code);

	/**
	 * Removes the code related to the string id. Throws an exception if it
	 * doesn't exist.
	 * 
	 * @param id
	 * @throws InvalidInputException
	 * @throws EmptyCollectionException
	 */
	public void remove(String id) throws InvalidInputException, EmptyCollectionException;

	/**
	 * Retrieves the code that is related the the string id. If it doesn't
	 * exist, it returns null.
	 * 
	 * @param id
	 * @return
	 * @throws EmptyCollectionException
	 */
	public Code get(String id) throws EmptyCollectionException;

	/**
	 * Sets the code related to the string id. If the string id doesn't exist,
	 * then it throws an InvalidInputException.
	 * 
	 * @param id
	 * @param newCode
	 * @throws EmptyCollectionException
	 */
	public void set(String id, Code newCode) throws InvalidInputException, EmptyCollectionException;

	/**
	 * Returns true if the given id exists in the storage.
	 * 
	 * @param id
	 * @return
	 */
	public boolean contains(String id);

	/**
	 * Returns the total number of codes in the storage.
	 * 
	 * @return
	 */
	public int size();

	/**
	 * Removes all the codes stored.
	 */
	public void clear();
}
