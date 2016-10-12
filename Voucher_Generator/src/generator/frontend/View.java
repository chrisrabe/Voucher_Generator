/*	File: View.java
 * 	Author
 * 	Chris Rabe			300334207
 * 
 * 	Date				Author				Changes
 * 	12 Oct 16			Chris Rabe			implemented some methods for prompting user
 */

package generator.frontend;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import generator.backend.Controller;

/**
 * Prints out user messages. Can be extended and replaced as a GUI
 * implementation. This class takes user interactions and forwards them to the
 * controller.
 * 
 * Version 0.2 offers text based view.
 * 
 * @author Chris Rabe
 */
public class View {

	private Controller controller;

	/** List of functions mapped to their description */
	private Map<String, String> functions = null;

	public View(Controller controller) {
		this.controller = controller;
		initialiseMap();
		start();
	}

	/**
	 * This is the loop which waits for user input
	 */
	private void start() {
		printOpeningMessage();
		Scanner sc = new Scanner(System.in);
		waitForInput();
		while (sc.hasNext()) {
			String input = sc.nextLine();
			if (input.equals("quit")) {
				break;
			}
			executeCommand(input);
			waitForInput();
		}
		System.out.println("Session closed.");
		sc.close();
	}

	private void executeCommand(String input) {
		if (input.equals("help")) {
			listFunctions();
		}
	}

	/**
	 * This is printed out when the view is waiting for the user for input. It's
	 * in a method so that the waiting symbol can easily be changed.
	 */
	private void waitForInput() {
		System.out.print(">");
	}

	/**
	 * Prints the opening message of the program.
	 */
	private void printOpeningMessage() {
		System.out.println(String.format("VOUCHER GENERATOR : version %.2f", Controller.VERSION));
		System.out.println("Type 'help' to see more options.");
	}

	private void listFunctions() {
		for (Map.Entry<String, String> entry : functions.entrySet()) {
			System.out.print(entry.getKey() + "\t" + entry.getValue() + "\n");
		}
	}

	/**
	 * Initialises the map of commands. If you want to add more commands, this
	 * is where you put it - but don't forget to add another condition inside
	 * the executeCommand() method!
	 * 
	 * @see executeCommand
	 */
	private void initialiseMap() {
		if (functions == null) {
			functions = new HashMap<String, String>();
			functions.put("help", "Lists all available options");
			functions.put("edit", "edit <code> <newDescription>\n\t Edits description of a given code");
			functions.put("show", "show <code>\n\t Shows details about the specified code");
			functions.put("generate",
					"generate <n> <c>\n\t Generates \"n\" number of codes which consists of \"c\" number of characters.");
			functions.put("list",
					"list <CODE | DESC>\n\t Lists all possible code if input is \"CODE\".\n\t Lists all possible descriptions if input is \"DESC\"");
			functions.put("quit", "Exits the program");
			functions.put("addDesc",
					"addDesc <enter description here>\n\t adds a description into the list of producible descriptions");
			functions.put("save",
					"save <filename> \n\t saves all the codes and stores it into a file with the given filename");
			functions.put("load", "opens a JFilechooser and reads all the codes in the file.");
		}
	}
}
