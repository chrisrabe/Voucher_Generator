/* File: Client.java
 * Date				Author				Changes
 * Aug 27 16		Chris Rabe			added some java documentation
 * Aug 27 16		Chris Rabe			implemented some command methods
 */

package generator.backend;

import java.util.List;

/**
 * This class reacts to user inputs and responds to them accordingly. It calls
 * methods from the Generator and ensures that all the preconditions of the
 * generator methods are met first. It also handles any exceptions thrown by the
 * generator.
 * 
 * @author Chris Rabe
 */
public class Controller {

	/**
	 * Symbolises the version of the program
	 */
	public static final double VERSION = 0.2;

	private Generator generator;

	public Controller() {
		this.generator = new Generator();
	}

	/**
	 * This method is passed a two segment string which must contain the code
	 * and description. The first segment must be the code which needs to be
	 * edited and the second segment must be the description which needs to be
	 * stored within the code.
	 * 
	 * @param input
	 *            - two segment string containing code and description
	 */
	public void editCode(String input) {
		try {
			String[] data = input.split(" ");
			if (data.length != 2) {
				throw new InputException("Invalid code -- must have two args.");
			}
			generator.editCode(data[0], data[1]);
		} catch (InputException e) {
			handleException(e);
		}
	}

	/**
	 * This method takes in a string which contains two string values separated
	 * by a space. The first argument (n) symbolises the number of codes which
	 * the user wants to generate. The second argument (c) symbolises the length
	 * of the codes generated.
	 * 
	 * @param input
	 *            - two segment input containing n and c parameters
	 */
	public void generate(String input) {
		try {
			String[] data = input.split(" ");
			if (data.length != 2) {
				throw new InputException("Invalid input -- must have two args.");
			}
			int n = Integer.valueOf(data[0]);
			int c = Integer.valueOf(data[1]);
			generator.generate(n, c);
		} catch (InputException e) {
			handleException(e);
		}
	}

	/**
	 * Retrieves the code inside the generator with the string parameter name.
	 * 
	 * @param code
	 * @return
	 */
	public Code show(String code) {
		try {
			return generator.getCode(code);
		} catch (InputException e) {
			handleException(e);
			return null;
		}
	}

	/**
	 * Retrieves a specific list based on the string type. Valid
	 * 
	 * @param param
	 * @return
	 */
	public List<? extends Object> getList(String param) {
		switch (param) {
		case "CODE":
			return generator.getCodes();
		case "DESC":
			return generator.getDescriptions();
		default:
			return null;
		}
	}

	// AddDescription - adds description to generator

	// Save - Creates new file -- MUST be a new file name

	// Load - open JFilechooser and loads all the code into the program

	// Helper methods

	/**
	 * This is where all exceptions should be handled. Need to be changed if GUI
	 * is implemented!!!
	 * 
	 * @param e
	 */
	private void handleException(InputException e) {
		System.out.println(e.getMessage());
	}

}
