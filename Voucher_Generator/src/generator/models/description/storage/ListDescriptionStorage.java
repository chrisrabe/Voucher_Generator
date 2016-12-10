package generator.models.description.storage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
	public void remove(String description) {
		_descriptions.remove(description);
	}

	/**
	 * Returns the description at the chosen index. If the given index is not
	 * within the bounds of the list, it returns null.
	 * 
	 * @param index
	 * @return
	 */
	@Override
	public String get(int index) {
		if (0 <= index && index < _descriptions.size()) {
			return _descriptions.get(index);
		}
		return null;
	}

	@Override
	public void clear() {
		_descriptions.clear();
	}
}
