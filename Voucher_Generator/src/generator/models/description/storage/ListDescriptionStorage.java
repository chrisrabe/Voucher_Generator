package generator.models.description.storage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import generator.helper.exception.EmptyCollectionException;
import generator.helper.exception.InvalidInputException;

/**
 * This class is stores all descriptions inside a list collection.
 * 
 * @author Chris
 */
public class ListDescriptionStorage implements IDescriptionStorage {

	private List<String> descriptions;

	public ListDescriptionStorage() {
		descriptions = new ArrayList<String>();
	}

	@Override
	public Collection<String> getDescriptions() {
		return descriptions;
	}

	@Override
	public void setDescriptions(Collection<String> descriptions) {
		this.descriptions = new ArrayList<String>(descriptions);
	}

	@Override
	public void add(String description) {
		descriptions.add(description);
	}

	@Override
	public void remove(String description) throws EmptyCollectionException {
		if (descriptions.isEmpty()) {
			throw new EmptyCollectionException("There are no descriptions to remove.");
		}
		descriptions.remove(description);
	}

	/**
	 * Returns the description at the chosen index. If the given index is not
	 * within the bounds of the list, it throws an exception.
	 * 
	 * @param index
	 * @return
	 * @throws InvalidInputException
	 * @throws EmptyCollectionException
	 */
	@Override
	public String get(int index) throws InvalidInputException, EmptyCollectionException {
		if (descriptions.isEmpty()) {
			throw new EmptyCollectionException("There are no descriptions stored.");
		}
		if (0 <= index && index < descriptions.size()) {
			return descriptions.get(index);
		}
		throw new InvalidInputException(String.format("Index %d is out of bounds", index));
	}

	@Override
	public boolean contains(String description) {
		return descriptions.contains(description);
	}

	@Override
	public void clear() {
		descriptions.clear();
	}

	@Override
	public int size() {
		return descriptions.size();
	}

}
