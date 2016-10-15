/*	File: View.java
 * 	
 * 	Date				Author					Changes
 * 	15 Oct 16			Chris Rabe				implemented methods for getting arguments for clear and adding codes 
 */
package generator.gui.text.views;

import generator.backend.InputException;
import generator.gui.text.Controller;

/**
 * Provides a skeletal implementation of the Views used for this program.
 * 
 * @author Chris
 */
public abstract class View {
	protected Controller controller;

	public View(Controller controller) {
		this.controller = controller;
	}

	public abstract void executeCommand(String input);

	// Helper Methods

	/**
	 * Retrieves the arguments based on the command given.
	 * 
	 * @param cmd
	 * @param instruction
	 * @return
	 * @throws InputException
	 */
	protected String[] getArgs(String cmd, String[] instruction) throws InputException {
		if (validArgLength(cmd, instruction)) {
			String[] tmp = getInstruction(cmd, instruction);
			switch (tmp.length) {
			case 2:
				return new String[] { tmp[1] };
			case 3:
				return new String[] { tmp[1], tmp[2] };
			default:
				return null;
			}
		} else {
			throw new InputException("Invalid argument length.");
		}
	}

	/**
	 * Checks if the length of the arguments are valid
	 * 
	 * @param cmd
	 * @param instruction
	 * @return
	 */
	protected boolean validArgLength(String cmd, String[] instruction) {
		String[] tmp = getInstruction(cmd, instruction);
		if (tmp == null) {
			return false;
		}
		switch (tmp.length) {
		case 2:
			return cmd.equals("load") || cmd.equals("save") || cmd.equals("show") || cmd.equals("list")
					|| cmd.equals("addDesc") || cmd.equals("reduce") || cmd.equals("delDesc") || cmd.equals("clear")
					|| cmd.equals("delCode");
		case 3:
			return cmd.equals("edit") || cmd.equals("generate") || cmd.equals("addCode");
		default:
			return false;
		}
	}

	/**
	 * Combines all the arguments which are related to description into just one
	 * argument
	 * 
	 * @param cmd
	 * @param instruction
	 * @return
	 */
	private String[] getInstruction(String cmd, String[] instruction) {
		String[] tmp = instruction;
		if (cmd.equals("addDesc") || cmd.equals("delDesc")) {
			if (tmp.length < 2) {
				return null;
			}
			StringBuilder sb = new StringBuilder();
			for (int i = 1; i < tmp.length; i++) {
				sb.append(tmp[i] + " ");
			}
			tmp = new String[] { instruction[0], sb.toString() };
		} else if (cmd.equals("edit") || cmd.equals("addCode")) {
			if (tmp.length < 3) {
				return null;
			}
			StringBuilder sb = new StringBuilder();
			for (int i = 2; i < tmp.length; i++) {
				sb.append(tmp[i] + " ");
			}
			tmp = new String[] { instruction[0], instruction[1], sb.toString() };
		}
		return tmp;
	}
}
