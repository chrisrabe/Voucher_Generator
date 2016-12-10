package generator.helper.eventhandler.save;

import java.io.IOException;
import java.util.List;

import generator.models.code.Code;

/**
 * Writes the code into an xml file.
 * 
 * @author Chris
 */
public class XMLSaveEventHandler extends SaveEventHandler {

	public XMLSaveEventHandler() {
		super("xml");
	}

	@Override
	protected void writeToFile(String filepath, List<Code> codes) throws IOException {
		// TODO Auto-generated method stub
	}

}
