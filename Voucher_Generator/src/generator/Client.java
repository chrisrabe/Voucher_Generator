/* File: Client.java
 * Date				Author				Changes
 * Aug 27 16		Chris Rabe			added some java documentation
 * Aug 27 16		Chris Rabe			implemented some command methods
 */

package generator;

import generator.backend.Generator;
import generator.backend.InputException;
import generator.frontend.View;

/**
 * This class reacts to user inputs and responds to them accordingly. It calls
 * methods from the Generator and ensures that all the preconditions of the
 * generator methods are met first. It also handles any exceptions thrown by the
 * generator.
 * 
 * @author Chris Rabe
 */
public class Client {

	private Generator generator;

	public Client() {
		this.generator = new Generator();
		new View(this);
	}

	/**
	 * Finds the Code object with the passed code string. If the Code object
	 * exists, then it replaces the description inside the Code object with the
	 * new description.
	 * 
	 * @param code
	 * @param description
	 */
	public void editCode(String code, String description) {
		try {
			generator.editCode(code, description);
		} catch (InputException e) {
			handleException(e);
		}
	}

	/**
	 * Generates 'n' number of unique codes which consists of 'c' characters.
	 * Each code is guaranteed to be different from each other. It keeps track
	 * of how many retries it used for generating a code string. If there are
	 * too much retries, then it means that 'n' is larger than it should and
	 * clears out the list of code and then throws an error.
	 * 
	 * @param n
	 * @param c
	 */
	public void generate(int n, int c) {
		try {
			generator.generate(n, c);
		} catch (InputException e) {
			handleException(e);
		}
	}

	// Show - retrieves the code

	// List - retrieves data (all descriptions or all codes)

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
