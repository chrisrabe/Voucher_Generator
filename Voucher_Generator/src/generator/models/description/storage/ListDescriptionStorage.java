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

	private List<String> _descriptions;

	public ListDescriptionStorage() {
		_descriptions = new ArrayList<String>();
	}

	@Override
	public Collection<String> getDescriptions() {
		return _descriptions;
	}

	@Override
	public void setDescriptions(Collection<String> descriptions) {
		_descriptions = new ArrayList<String>(descriptions);
	}

	@Override
	public void add(String description) {
		_descriptions.add(description);
	}

	@Override
	public void remove(String description) throws EmptyCollectionException {
		if (_descriptions.isEmpty()) {
			throw new EmptyCollectionException("There are no descriptions to remove.");
		}
		_descriptions.remove(description);
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
		if (_descriptions.isEmpty()) {
			throw new EmptyCollectionException("There are no descriptions stored.");
		}
		if (0 <= index && index < _descriptions.size()) {
			return _descriptions.get(index);
		}
		throw new InvalidInputException(String.format("Index %d is out of bounds", index));
	}

	@Override
	public boolean contains(String description) {
		return _descriptions.contains(description);
	}

	@Override
	public void clear() {
		_descriptions.clear();
	}

	@Override
	public int size() {
		return _descriptions.size();
	}

}
