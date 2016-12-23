package generator.control.manager.description;

import java.util.Collection;
import java.util.List;

import generator.helper.exception.EmptyCollectionException;
import generator.helper.exception.InvalidInputException;
import generator.models.code.Code;

/**
 * This interface provides operations regarding descriptions.
 * 
 * @author Chris
 */
public interface IDescriptionManager {

	/**
	 * Adds a new description into the storage.
	 * 
	 * @param description
	 * @throws InvalidInputException
	 */
	public void addDescription(String description) throws InvalidInputException;

	/**
	 * Distributes existing descriptions to the codes.
	 * 
	 * @param codes
	 */
	public void distribute(List<Code> codes) throws EmptyCollectionException;

	/**
	 * Retrieves the descriptions inside the storage.
	 * 
	 * @return
	 */
	public Collection<String> getDescriptions();

	/**
	 * Clears the storage
	 */
	public void clear();
}
