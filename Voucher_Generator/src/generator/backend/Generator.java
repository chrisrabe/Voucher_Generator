/* File: Generator.java
 * Date				Author				Changes
 * Aug 22 16		Chris Rabe			create System.java
 */
package generator.backend;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * This class stores all information about the generator. It contains all the
 * generation logic and file creation logic. This is the Model in the MVC Design
 * pattern.
 * 
 * @author Chris Rabe
 */
public class Generator {
	// variables needed for code generation
	private static final char[] UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	private static final char[] LOWERCASE = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	private static final char[] NUMBERS = "0123456789".toCharArray();
	private static final Charset CHARSET = StandardCharsets.UTF_8;

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
		for (Code c : codes) {
			if (c.equals(code)) {
				c.setDescription(description);
				return;
			}
		}
		throw new InputException("Code not found.");
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
		try {
			Files.write(file.toPath(), lines, CHARSET);
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
	 * Reduces the list of codes generated to the a new size.
	 * 
	 * @param newSize
	 */
	public void reduceCodeSize(int newSize) {
		List<Code> tmp = new ArrayList<Code>();
		while (tmp.size() != newSize) {
			tmp.add(codes.get(tmp.size()));
		}
	}

	// Helper Methods

	/**
	 * Converts the list of codes generated to a list of string so that it can
	 * be written onto the file.
	 * 
	 * @return
	 */
	private List<String> getCodeString() {
		List<String> tmp = new ArrayList<String>();
		for (Code c : codes) {
			tmp.add(c.toString());
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
				sb.append(UPPERCASE[(int) Math.random() * UPPERCASE.length]);
				break;
			case 1: // select a random character from the lowercase field
				sb.append(LOWERCASE[(int) Math.random() * LOWERCASE.length]);
				break;
			case 2: // select a random character from the numbers field
				sb.append(NUMBERS[(int) Math.random() * NUMBERS.length]);
				break;
			}
		}
		return sb.toString();
	}
}
