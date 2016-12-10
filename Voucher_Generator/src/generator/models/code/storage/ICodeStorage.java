package generator.models.code.storage;

import java.util.Collection;

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
	 */
	public void remove(String id) throws InvalidInputException;

	/**
	 * Retrieves the code that is related the the string id. If it doesn't
	 * exist, it returns null.
	 * 
	 * @param id
	 * @return
	 */
	public Code get(String id);

	/**
	 * Sets the code related to the string id. If the string id doesn't exist,
	 * then it throws an InvalidInputException.
	 * 
	 * @param id
	 * @param newCode
	 */
	public void set(String id, Code newCode) throws InvalidInputException;

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
