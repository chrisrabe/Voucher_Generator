package generator.tests.xml.save;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import generator.helper.eventhandler.save.SaveEventHandler;
import generator.helper.eventhandler.save.XMLSaveEventHandler;
import generator.helper.exception.InvalidInputException;
import generator.models.code.Code;

/**
 * This class tests whether the XMLSaveEventHandler can parse a list of code and
 * produce the file expected.
 * 
 * @author Chris
 */
public class TestXMLSaveEventHandler {

	public static void main(String[] args) {
		test_01_WriteToFile();
	}

	public static void test_01_WriteToFile() {
		SaveEventHandler handler = new XMLSaveEventHandler();
		String filename = "./test.xml";
		File file = new File(filename);
		try {
			handler.save(filename, createTestCodes());
		} catch (InvalidInputException e) {
			e.printStackTrace();
		}
		System.out.println(String.format("Saved to %s.", file.getAbsolutePath()));
	}

	// Helper Methods

	private static List<Code> createTestCodes() {
		List<Code> tmp = new ArrayList<Code>();
		tmp.add(new Code("a", "b", false));
		tmp.add(new Code("c", "d", false));
		tmp.add(new Code("e", "f", true));
		tmp.add(new Code("g", "h", false));
		return tmp;
	}
}
