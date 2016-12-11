package generator.helper.eventhandler.save;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

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
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = dbFactory.newDocumentBuilder();
			DOMSource source = toXMLDocument(builder.newDocument(), codes);
			// Write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			StreamResult document = new StreamResult(new File(filepath));
			transformer.transform(source, document);
		} catch (Exception e) {
			// Exit out the method if something goes wrong.
			throw new IOException();
		}
	}

	private DOMSource toXMLDocument(Document doc, List<Code> codes) {
		Element root = doc.createElement("codes");
		for (Code code : codes) {
			root.appendChild(toCodeElement(doc, code));
		}
		doc.appendChild(root);
		return new DOMSource(doc);
	}

	private Element toCodeElement(Document doc, Code code) {
		Element codeElem = doc.createElement("code");
		// Create id attribute
		Attr idAttr = doc.createAttribute("id");
		idAttr.setValue(code.getID());
		// Create description node
		Element description = doc.createElement("description");
		description.appendChild(doc.createTextNode(code.getDescription()));
		// Create redeemed attribute
		Attr redeemedAttr = doc.createAttribute("redeemed");
		redeemedAttr.setValue(String.valueOf(code.isRedeemed()));
		// Put everything together
		codeElem.setAttributeNode(idAttr);
		codeElem.setAttributeNode(redeemedAttr);
		codeElem.appendChild(description);
		return codeElem;
	}

}
