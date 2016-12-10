package generator.helper.exception;

/**
 * This exception should be thrown at invalid method calls.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class InvalidInputException extends Exception {

	/**
	 * Creates an instance of the invalid input exception.
	 * 
	 * @param msg
	 */
	public InvalidInputException(String msg) {
		super(msg);
	}
}
