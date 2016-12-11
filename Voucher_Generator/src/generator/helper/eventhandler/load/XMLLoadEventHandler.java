package generator.helper.eventhandler.load;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import generator.models.code.Code;

/**
 * Loads the xml files produced by the xml save event handler.
 * 
 * @author Chris
 */
public class XMLLoadEventHandler extends LoadEventHandler {

	public XMLLoadEventHandler() {
		super("xml");
	}

	@Override
	protected List<Code> parseFile(String filepath) throws FileNotFoundException, IOException {
		List<Code> tmp = new ArrayList<Code>();
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

		try {
			DocumentBuilder builder = dbFactory.newDocumentBuilder();
			Document doc = builder.parse(new File(filepath));
			doc.getDocumentElement().normalize();

			XPath xPath = XPathFactory.newInstance().newXPath();
			String expression = "/codes/code";
			NodeList nodes = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);
			for (int i = 0; i < nodes.getLength(); i++) {
				Node node = nodes.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					tmp.add(toCode((Element) node));
				}
			}
		} catch (ParserConfigurationException | SAXException | XPathExpressionException e) {
			throw new IOException();
		}
		return tmp;
	}

	private Code toCode(Element node) {
		String id = node.getAttribute("id");
		String desc = node.getElementsByTagName("description").item(0).getTextContent();
		boolean redeemed = node.getAttribute("redeemed").equals("true") ? true : false;
		return new Code(id, desc, redeemed);
	}

}
