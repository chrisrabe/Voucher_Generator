package generator.helper.eventhandler.save;

import java.io.IOException;
import java.util.List;

import generator.helper.exception.InvalidInputException;
import generator.models.code.Code;

public abstract class SaveEventHandler implements ISaveEventHandler {
	// Fields
	private String extension;

	// Constructors

	public SaveEventHandler(String extension) {
		this.extension = extension;
	}

	// Abstract Methods

	/**
	 * Writes the given code to the specified file path.
	 * 
	 * @param filepath
	 * @param code
	 * @throws IOException
	 */
	protected abstract void writeToFile(String filepath, List<Code> codes) throws IOException;

	// Methods

	@Override
	public void save(String filepath, List<Code> codes) throws InvalidInputException {
		String validPath = attachFileExtension(filepath);
		try {
			writeToFile(validPath, codes);
		} catch (IOException e) {
			throw new InvalidInputException(String.format("Failed to save file to %s", filepath));
		}
	}

	// Helper Methods

	private String attachFileExtension(String filePath) {
		String[] tmp = filePath.split("[.]");
		return String.format("%s.%s", tmp[0], extension);
	}

}
