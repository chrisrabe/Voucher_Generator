/*	File: TextView.java
 * 
 * 	Date				Author				Changes
 * 	12 Oct 16			Chris Rabe			implemented some methods for prompting user
 * 	12 Oct 16			Chris Rabe			save and generate now available for user
 * 	15 Oct 16			Chris Rabe			implemented clear command
 * 	15 Oct 16			Chris Rabe			implemented addCode and clearCode commands
 */

package generator.gui.text.views;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import generator.Main;
import generator.backend.Code;
import generator.backend.InputException;
import generator.gui.text.Controller;

/**
 * Prints out user messages. Can be extended and replaced as a GUI
 * implementation. This class takes user interactions and forwards them to the
 * controller.
 * 
 * Version 0.3 offers text based view.
 * 
 * @author Chris Rabe
 */
public class TextView extends View {

	/** List of functions mapped to their description */
	private Map<String, String> functions = null;

	public TextView(Controller controller) {
		super(controller);
		initialiseMap();
		start();
	}

	// Methods

	/**
	 * Receives a command which contains arguments
	 */
	@Override
	public void executeCommand(String input) {
		// check if they are commands which does not require arguments
		if (input.equals("help")) {
			listFunctions();
			return;
		} else if (input.equals("distribute")) {
			controller.distribute();
			return;
		}
		// execute commands that require arguments
		String[] instruction = input.split(" ");
		String cmd = instruction[0];
		// get the arguments
		String[] args = null;
		try {
			args = getArgs(cmd, instruction);
		} catch (InputException e) {
			System.out.println(e.getMessage());
			return;
		}
		if (cmd.equals("save")) {
			controller.save(args[0]);
		} else if (cmd.equals("load")) {
			controller.load(args[0]);
		} else if (cmd.equals("show")) {
			print(controller.show(args[0]));
		} else if (cmd.equals("list")) {
			print(controller.getList(args[0]));
		} else if (cmd.equals("reduce")) {
			controller.reduce(args[0]);
		} else if (cmd.equals("show")) {
			controller.show(args[0]);
		} else if (cmd.equals("addDesc")) {
			controller.addDescription(args[0]);
		} else if (cmd.equals("delDesc")) {
			controller.delDescription(args[0]);
		} else if (cmd.equals("generate")) {
			controller.generate(args);
		} else if (cmd.equals("edit")) {
			controller.editCode(args);
		} else if (cmd.equals("clear")) {
			controller.clearAll(args[0]);
		} else if (cmd.equals("delCode")) {
			controller.delCode(args[0]);
		} else if (cmd.equals("addCode")) {
			controller.addCode(args);
		}
	}

	// Printing Methods

	private void print(List<? extends Object> list) {
		if (list == null) {
			return;
		}
		if (list.isEmpty()) {
			System.out.println("Nothing to show.");
			return;
		}
		for (Object obj : list) {
			if (obj instanceof String) {
				System.out.println((String) obj);
			} else if (obj instanceof Code) {
				System.out.println(obj.toString());
			}
		}
	}

	private void print(Code code) {
		if (code == null) {
			return;
		}
		System.out.println(code.toString());
	}

	// Helper Methods

	private void listFunctions() {
		for (Map.Entry<String, String> entry : functions.entrySet()) {
			System.out.print(entry.getKey() + "\t" + entry.getValue() + "\n");
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
		System.out.println(String.format("VOUCHER GENERATOR : version %.2f", Main.VERSION));
		System.out.println("Type 'help' to see more options.");
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
			functions.put("delDesc", "delDesc <description> \n\t removes the description from the generator.");
			functions.put("save",
					"save <filename> \n\t saves all the codes and stores it into a file with the given filename");
			functions.put("load", "load <filename> \n\t reads all the codes in the file.");
			functions.put("reduce", "reduce <new_size> \n\t reduces the size of the code stored in the generator.");
			functions.put("distribute", "\n\tdistributes the descriptions to the codes generated.");
			functions.put("clear", "clear <CODE | DESC> \n\t removes all the codes listed in the generator.");
			functions.put("addCode", "addCode <code> <description> \n\t adds a custom code into the generator.");
			functions.put("delCode", "delCode <code> \n\t removes the code specified within the generator.");
		}
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
			} else if (functions.containsKey(input.split(" ")[0])) {
				executeCommand(input);
			} else {
				System.out.println("Invalid command.");
			}
			waitForInput();
		}
		System.out.println("Session closed.");
		sc.close();
	}
}
