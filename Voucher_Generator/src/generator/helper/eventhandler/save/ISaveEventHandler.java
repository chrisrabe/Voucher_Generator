package generator.helper.eventhandler.save;

import java.util.List;

import generator.helper.exception.InvalidInputException;
import generator.models.code.Code;

/**
 * Provides method contracts for save event handlers.
 * 
 * @author Chris
 */
public interface ISaveEventHandler {

	/**
	 * Saves the vouchers into the specified file path.
	 * 
	 * @param filePath
	 */
	public void save(String filePath, List<Code> codes) throws InvalidInputException;
}
