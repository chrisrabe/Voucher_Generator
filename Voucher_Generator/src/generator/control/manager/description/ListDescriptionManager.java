package generator.control.manager.description;

import java.util.Collection;

import generator.helper.exception.EmptyCollectionException;
import generator.helper.exception.InvalidInputException;
import generator.models.code.Code;
import generator.models.description.storage.ListDescriptionStorage;

/**
 * This is a description manager which uses a list storage to store all the
 * description strings.
 * 
 * @author Chris
 */
public class ListDescriptionManager extends DescriptionManager {

	public ListDescriptionManager() {
		super(new ListDescriptionStorage());
	}

	@Override
	public void distribute(Collection<Code> codes) throws EmptyCollectionException {
		// First check if the given list is not empty
		if (codes.isEmpty())
			throw new EmptyCollectionException("Vouchers must be generated first.");

		int index = 0; // description index

		for (Code c : codes) {
			if (index >= storage.size()) {
				index = 0; // go back to start
			}
			try {
				c.setDescription(storage.get(index));
			} catch (InvalidInputException e) {
				break; // exit out the method if this happens
			}
			index++;
		}
	}
}
