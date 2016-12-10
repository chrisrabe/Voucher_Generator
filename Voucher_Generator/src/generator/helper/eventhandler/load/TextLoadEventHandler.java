package generator.helper.eventhandler.load;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import generator.models.code.Code;

/**
 * This class loads .txt files. This may lead to unwanted side effects if the
 * user wants the value of '=' in the code or the description.
 * 
 * @author Chris
 */
public class TextLoadEventHandler extends LoadEventHandler {

	public TextLoadEventHandler() {
		super("txt");
	}

	@Override
	protected List<Code> parseFile(String filepath) throws FileNotFoundException, IOException {
		List<Code> tmp = new ArrayList<Code>();

		File file = new File(filepath);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String s = null;
		while ((s = br.readLine()) != null) {
			tmp.add(parseCode(s));
		}
		br.close();
		return tmp;
	}

	private Code parseCode(String code) throws IOException {
		String[] vars = code.split("[,]");
		if (vars.length != 3)
			throw new IOException("Invalid file contents.");

		String id = parseID(vars[0]);
		String description = parseDescription(vars[1]);
		boolean redeemed = parseRedeemed(vars[2]);

		return new Code(id, description, redeemed);
	}

	private boolean parseRedeemed(String context) throws IOException {
		String[] vars = context.split("[=]");
		if (vars.length != 2)
			throw new IOException("Invalid file contents.");

		return vars[1].trim().equals("true") ? true : false;
	}

	private String parseDescription(String context) {
		String[] vars = context.split("[=]");
		if (vars.length > 2) {
			String[] tmp = new String[2];
			tmp[0] = vars[0];
			// Merge the contexts after the "="
			StringBuilder sb = new StringBuilder();
			for (int i = 1; i < vars.length; i++) {
				sb.append(vars[i] + " ");
			}
			tmp[1] = sb.toString();
			vars = tmp;
		}
		return vars[1];
	}

	private String parseID(String context) throws IOException {
		String[] vars = context.split("[=]");
		if (vars.length != 2)
			throw new IOException("Invalid file contents.");

		return vars[1];
	}

}
