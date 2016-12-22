package generator.control.manager.code;

import java.util.Collection;
import java.util.List;

import generator.helper.exception.InvalidInputException;
import generator.helper.exception.TimeoutException;
import generator.models.code.Code;

public interface ICodeManager {

	/**
	 * Generates a number of codes indicated by the size parameter. Each code id
	 * has a length of the 'chars' parameter.
	 * 
	 * @param chars
	 * @param size
	 * @throws InvalidInputException
	 * @throws TimeoutException
	 */
	public void generateCode(int chars, int size) throws InvalidInputException, TimeoutException;

	/**
	 * Reduces the number of codes inside the storage to the new size.
	 * 
	 * @param newSize
	 */
	public void reduce(int newSize);

	/**
	 * Stores all the given codes into the storage.
	 * 
	 * @param codes
	 */
	public void storeAll(List<Code> codes);

	/**
	 * Retrieves all the codes in the storage.
	 * 
	 * @return
	 */
	public Collection<Code> getCodes();

	/**
	 * Clears all the codes in the storage.
	 */
	public void clear();
}
