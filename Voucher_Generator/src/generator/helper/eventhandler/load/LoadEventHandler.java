package generator.helper.eventhandler.load;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import generator.helper.exception.InvalidInputException;
import generator.models.code.Code;

/**
 * Provides skeletal implementation for an event handler.
 * 
 * @author Chris
 */
public abstract class LoadEventHandler implements ILoadEventHandler {

	// Fields

	private String extension; // valid file extension

	// Constructors

	public LoadEventHandler(String extension) {
		this.extension = extension;
	}

	// Method which needs to be defined

	/**
	 * Creates a list of code objects from the specified filepath.
	 * 
	 * @param filepath
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	protected abstract List<Code> parseFile(String filepath) throws FileNotFoundException, IOException;

	// Base Method Implementation

	@Override
	public List<Code> load(String filepath) throws InvalidInputException {
		if (!filepath.endsWith(extension))
			throw new InvalidInputException(String.format("Must be a .%s file", extension));

		try {
			return parseFile(filepath);
		} catch (FileNotFoundException e) {
			throw new InvalidInputException("File not found.");
		} catch (IOException e) {
			throw new InvalidInputException("Failed to load contents of the file.");
		}
	}
}
