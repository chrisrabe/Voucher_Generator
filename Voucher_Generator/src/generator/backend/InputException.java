package generator.backend;

/**
 * This class represents an exception for invalid inputs. It is thrown if the
 * user enters and invalid command or invalid inputs.
 * 
 * @author Chris Rabe
 */
@SuppressWarnings("serial")
public class InputException extends Exception {
	public InputException(String msg) {
		super(msg);
	}
}