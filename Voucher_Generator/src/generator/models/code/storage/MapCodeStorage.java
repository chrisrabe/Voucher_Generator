package generator.models.code.storage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import generator.helper.exception.EmptyCollectionException;
import generator.helper.exception.InvalidInputException;
import generator.models.code.Code;

/**
 * This code storage utilises a hashmap to store all of its codes for faster
 * retrieval operations.
 * 
 * @author Chris
 */
public class MapCodeStorage implements ICodeStorage {

	private Map<String, Code> codes;

	public MapCodeStorage() {
		codes = new HashMap<String, Code>();
	}

	@Override
	public List<Code> getCodes() {
		return new ArrayList<Code>(codes.values());
	}

	@Override
	public void setCodes(Collection<Code> codes) {
		this.codes.clear();
		for (Code code : codes) {
			this.codes.put(code.getID(), code);
		}
	}

	@Override
	public void add(Code code) {
		codes.put(code.getID(), code);
	}

	@Override
	public void remove(String id) throws InvalidInputException, EmptyCollectionException {
		if (codes.isEmpty()) {
			throw new EmptyCollectionException("There are currently no vouchers to remove.");
		} else if (codes.containsKey(id)) {
			codes.remove(id);
		} else {
			throw new InvalidInputException(String.format("%s doesn't exist.", id));
		}
	}

	@Override
	public Code get(String id) throws EmptyCollectionException {
		if (codes.isEmpty()) {
			throw new EmptyCollectionException("There are currently no vouchers.");
		}
		return codes.get(id);
	}

	@Override
	public void set(String id, Code newCode) throws InvalidInputException, EmptyCollectionException {
		if (codes.isEmpty()) {
			throw new EmptyCollectionException("There are currently no vouchers to edit.");
		} else if (codes.containsKey(id)) {
			codes.replace(id, newCode);
		} else {
			throw new InvalidInputException(String.format("%s doesn't exist.", id));
		}
	}

	@Override
	public boolean contains(String id) {
		return codes.containsKey(id);
	}

	@Override
	public int size() {
		return codes.size();
	}

	@Override
	public void clear() {
		codes.clear();
	}

}
