/* File: Generator.java
 * Date				Author				Changes
 * Aug 22 16		Chris Rabe			create Generator.java
 * Aug 25 16		Chris Rabe			added method 'load'
 * Oct 12 16		Chris Rabe			fixed code generation bug
 * Oct 12 16		Chris Rabe			rewritten save method
 * Oct 12 16		Chris Rabe			fixed load bug
 * Oct 12 16		Chris Rabe			extended functionality - can now reduce size
 * Oct 15 16		Chris Rabe			can now add custom codes
 * Oct 15 16		Chris Rabe			can now clear all descriptions and codes in one command
 */
package generator.backend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class stores all information about the generator. It contains all the
 * generation logic and file creation logic. This is the Model in the MVC Design
 * pattern.
 * 
 * @author Chris Rabe
 * @version 0.3
 */
public class Generator {
	// variables needed for code generation
	private static final char[] UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	private static final char[] LOWERCASE = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	private static final char[] NUMBERS = "0123456789".toCharArray();

	/** stores all generated or loaded code */
	private List<Code> codes;
	/* stores all user defined descriptions */
	private List<String> descriptions;

	public Generator() {
		this.codes = new ArrayList<Code>();
		this.descriptions = new ArrayList<String>();
	}

	/**
	 * This constructor should only be used for testing purposes.
	 * 
	 * @param codes
	 * @param descriptions
	 */
	public Generator(List<Code> codes, List<String> descriptions) {
		this.codes = codes;
		this.descriptions = descriptions;
	}

	// Getters for the controller to use

	public List<Code> getCodes() {
		return codes;
	}

	public List<String> getDescriptions() {
		return descriptions;
	}

	// Methods

	/**
	 * Removes all the codes generated.
	 */
	public void clearCodes() {
		this.codes.clear();
	}

	/**
	 * Removes all the description created.
	 */
	public void clearDesc() {
		this.descriptions.clear();
	}

	/**
	 * Adds the given description to the list of descriptions for the vouchers.
	 * It checks that none of the descriptions are duplicates. It also converts
	 * the string object passed into the method to lowercase.
	 * 
	 * @param description
	 * @throws InputException
	 */
	public void addDescription(String description) throws InputException {
		String item = description.toLowerCase();
		if (descriptions.contains(description)) {
			throw new InputException("Description already exists");
		}
		descriptions.add(item);
	}

	/**
	 * Removes the given description from the list of codes and the list of
	 * descriptions.
	 * 
	 * @param desc
	 * @throws InputException
	 */
	public void removeDescription(String desc) throws InputException {
		if (desc == null) {
			throw new InputException("Description must not be null");
		}
		// Remove from list of description
		descriptions.remove(desc);
		// Remove codes which has the description
		for (Code c : codes) {
			if (c.getDescription().equals(desc)) {
				c.setDescription("");
			}
		}
	}

	/**
	 * Distributes the description as evenly as possible. The user must have
	 * added a few descriptions in the generator first and have generated a
	 * bunch of empty Code objects.
	 * 
	 * @throws InputException
	 */
	public void distributeDesc() throws InputException {
		if (descriptions.isEmpty()) {
			throw new InputException("Descriptions must be added first.");
		}
		if (codes.isEmpty()) {
			throw new InputException("Code must be generated first.");
		}
		int index = 0; // description index
		for (Code c : codes) {
			if (index >= descriptions.size()) {
				index = 0; // go back to start
			}
			c.setDescription(descriptions.get(index));
			index++;
		}
	}

	/**
	 * Retrieves the Code object with the given code string. Throws an
	 * inputException if the code does not exist.
	 * 
	 * @param code
	 * @return
	 * @throws InputException
	 */
	public Code getCode(String code) throws InputException {
		for (Code c : codes) {
			if (c.equals(code)) {
				return c;
			}
		}
		throw new InputException("Code not found");
	}

	/**
	 * Adds custom vouchers to the generator. The code added must not be
	 * contained within the list of codes.
	 * 
	 * @param code
	 * @param description
	 * @throws InputException
	 */
	public void addCode(String code, String description) throws InputException {
		Code tmp = new Code(code, description);
		for (Code c : codes) {
			if (c.getCode().equals(code)) {
				throw new InputException("Code already exists.");
			}
		}
		this.codes.add(tmp);
	}

	/**
	 * Removes the code inside the generator. The code must exist.
	 * 
	 * @param code
	 * @throws InputException
	 */
	public void removeCode(String code) throws InputException {
		for (Code c : codes) {
			if (c.getCode().equals(code)) {
				codes.remove(c);
				return;
			}
		}
		throw new InputException("Code does not exist.");
	}

	/**
	 * Finds the Code object with the passed code string. If the Code object
	 * exists, then it replaces the description inside the Code object with the
	 * new description.
	 * 
	 * @param code
	 * @param description
	 * @throws InputException
	 */
	public void editCode(String code, String description) throws InputException {
		if (code == null || description == null) {
			throw new InputException("Must pass a code and a description string.");
		}
		Code c = getCode(code);
		c.setDescription(description);
	}

	/**
	 * Saves all the code inside the file object passed. If codes were not
	 * generated, then it throws an error.
	 * 
	 * @param file
	 * @throws InputException
	 */
	public void save(File file) throws InputException {
		if (codes.isEmpty()) {
			throw new InputException("Must generate code first before saving.");
		}
		List<String> lines = getCodeString();
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(file));
			bw.flush();
			for (String line : lines) {
				bw.write(line);
			}
			bw.close();
		} catch (IOException e) {
			throw new InputException(e.getMessage());
		}
	}

	/**
	 * Reads the file passed and loads all existing codes.
	 * 
	 * @param file
	 * @throws InputException
	 */
	public void load(File file) throws InputException {
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String s = null;
			while ((s = br.readLine()) != null) {
				codes.add(parseCode(s));
			}
			br.close();
		} catch (IOException e) {
			throw new InputException(e.getMessage());
		}
	}

	/**
	 * Generates 'n' number of unique codes which consists of 'c' characters.
	 * Each code is guaranteed to be different from each other.
	 * 
	 * It keeps track of how many retries it used for generating a code string.
	 * If there are too much retries, then it means that 'n' is larger than it
	 * should and clears out the list of code and then throws an error.
	 * 
	 * @param n
	 * @param c
	 */
	public void generate(int n, int c) throws InputException {
		final int MAX_RETRIES = 100; // it will be odd if it retried 100 times.
		int retries = 0;
		while (codes.size() != n) {
			retries = 0;
			String code = generateCodeString(c);
			while (isCreated(code)) {
				retries++;
				code = generateCodeString(c);
				if (retries == MAX_RETRIES) {
					throw new InputException("Number of codes possible is lower than request.");
				}
			}
			this.codes.add(new Code(code));
		}
	}

	/**
	 * Reduces the list of codes generated to the a new size.
	 * 
	 * @param newSize
	 */
	public void reduceCodeSize(int newSize) {
		List<Code> tmp = new ArrayList<Code>();
		while (tmp.size() != newSize) {
			tmp.add(codes.get(tmp.size()));
		}
		this.codes = tmp;
	}

	// Helper Methods

	/**
	 * Reads the line of string and converts it to a code object.
	 * 
	 * @param s
	 * @return
	 * @throws InputException
	 */
	private Code parseCode(String s) throws InputException {
		String[] vars = s.split(",");
		String code = null;
		String description = null;
		boolean isRedeemed = false;
		try {
			code = vars[0].split(":")[1];
			description = vars[1].split(":").length > 1 ? vars[1].split(":")[1] : "";
			String bool = vars[2].split(":")[1].trim();
			isRedeemed = bool.equals("true") ? true : false;
		} catch (Exception e) {
			throw new InputException("Got error");
		}
		return new Code(code, description, isRedeemed);
	}

	/**
	 * Converts the list of codes generated to a list of string so that it can
	 * be written onto the file.
	 * 
	 * @return
	 */
	private List<String> getCodeString() {
		List<String> tmp = new ArrayList<String>();
		for (Code c : codes) {
			tmp.add(c.toString() + "\n");
		}
		return tmp;
	}

	/**
	 * This method checks if the given code string is already generated and is
	 * stored within the list.
	 * 
	 * @param code
	 * @return
	 */
	private boolean isCreated(String code) {
		for (Code c : codes) {
			if (c.equals(code)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Creates a code string with the given number of characters. It randomly
	 * selects characters from the UPPERCASE, LOWERCASE, and NUMBERS fields and
	 * places returns the code.
	 * 
	 * @param characters
	 * @return
	 */
	private String generateCodeString(int characters) {
		StringBuilder sb = new StringBuilder();
		while (sb.length() != characters) {
			int field = (int) (Math.random() * 3);
			switch (field) {
			case 0: // select a random character from the uppercase field
				sb.append(UPPERCASE[(int) (Math.random() * UPPERCASE.length)]);
				break;
			case 1: // select a random character from the lowercase field
				sb.append(LOWERCASE[(int) (Math.random() * LOWERCASE.length)]);
				break;
			case 2: // select a random character from the numbers field
				sb.append(NUMBERS[(int) (Math.random() * NUMBERS.length)]);
				break;
			}
		}
		return sb.toString();
	}
}
