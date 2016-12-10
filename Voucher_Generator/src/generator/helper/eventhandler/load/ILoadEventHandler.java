package generator.helper.eventhandler.load;

import java.util.List;

import generator.helper.exception.InvalidInputException;
import generator.models.code.Code;

/**
 * Provides method contracts for load event handlers.
 * 
 * @author Chris
 */
public interface ILoadEventHandler {

	/**
	 * Loads the file from the specified filepath.
	 * 
	 * @param filepath
	 * @return a list of code objects
	 * @throws InvalidInputException
	 */
	public List<Code> load(String filepath) throws InvalidInputException;
}
