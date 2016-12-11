package generator.tests.xml.load;

import java.io.File;
import java.util.List;

import generator.helper.eventhandler.load.LoadEventHandler;
import generator.helper.eventhandler.load.XMLLoadEventHandler;
import generator.helper.exception.InvalidInputException;
import generator.models.code.Code;

public class TestXMLLoadEventHandler {

	public static void main(String[] args) {
		test_01_LoadFile();
	}

	public static void test_01_LoadFile() {
		LoadEventHandler handler = new XMLLoadEventHandler();
		String filepath = "./test.xml";
		File file = new File(filepath);
		if (file.exists()) {
			System.out.println(String.format("Loading %s", file.getAbsolutePath()));
			try {
				List<Code> tmp = handler.load(filepath);
				for (Code code : tmp) {
					System.out.println(code.toString());
				}
			} catch (InvalidInputException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		System.out.println(String.format("Cannot find file at %s", file.getAbsolutePath()));
	}
}
