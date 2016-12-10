package generator.models.code.storage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import generator.helper.exception.InvalidInputException;
import generator.models.code.Code;

/**
 * This code storage utilises a hashmap to store all of its codes for faster
 * retrieval operations.
 * 
 * @author Chris
 */
public class MapCodeStorage implements ICodeStorage {

	private Map<String, Code> _codes;

	public MapCodeStorage() {
		_codes = new HashMap<String, Code>();
	}

	@Override
	public List<Code> getCodes() {
		return new ArrayList<Code>(_codes.values());
	}

	@Override
	public void setCodes(Collection<Code> codes) {
		_codes.clear();
		for (Code code : codes) {
			_codes.put(code.getID(), code);
		}
	}

	@Override
	public void add(Code code) {
		_codes.put(code.getID(), code);
	}

	@Override
	public void remove(String id) throws InvalidInputException {
		if (_codes.containsKey(id)) {
			_codes.remove(id);
		} else {
			throw new InvalidInputException(String.format("%s doesn't exist.", id));
		}
	}

	@Override
	public Code get(String id) {
		return _codes.get(id);
	}

	@Override
	public void set(String id, Code newCode) throws InvalidInputException {
		if (_codes.containsKey(id)) {
			_codes.replace(id, newCode);
		} else {
			throw new InvalidInputException(String.format("%s doesn't exist.", id));
		}
	}

	@Override
	public boolean contains(String id) {
		return _codes.containsKey(id);
	}

	@Override
	public int size() {
		return _codes.size();
	}

	@Override
	public void clear() {
		_codes.clear();
	}

}
