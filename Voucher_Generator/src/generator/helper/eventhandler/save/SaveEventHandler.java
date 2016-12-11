package generator.helper.eventhandler.save;

import java.io.File;
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
		File file = new File(filePath);
		String absolutePath = file.getAbsolutePath();
		String path = absolutePath.substring(0, absolutePath.length() - file.getName().length());
		String[] names = file.getName().split("[.]");
		String newName = String.format("%s.%s", names[0], extension);
		return String.format("%s%s", path, newName);
	}

}
