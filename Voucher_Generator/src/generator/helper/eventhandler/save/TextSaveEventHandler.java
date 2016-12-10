package generator.helper.eventhandler.save;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import generator.models.code.Code;

/**
 * Saves the code into a .txt file.
 * 
 * @author Chris
 */
public class TextSaveEventHandler extends SaveEventHandler {

	public TextSaveEventHandler() {
		super("txt");
	}

	// Save Handler methods

	@Override
	protected void writeToFile(String filepath, List<Code> codes) throws IOException {
		File file = new File(filepath);
		file.createNewFile();
		List<String> lines = toString(codes);
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		bw.flush();
		for (String line : lines) {
			bw.write(line);
		}
		bw.close();
	}

	// Helper Methods

	private List<String> toString(List<Code> codes) {
		List<String> tmp = new ArrayList<String>();
		for (Code c : codes) {
			tmp.add(c.toString() + "\n");
		}
		return tmp;
	}

}
