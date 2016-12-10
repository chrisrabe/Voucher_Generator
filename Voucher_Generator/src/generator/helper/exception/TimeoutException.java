package generator.helper.exception;

/**
 * This exception is thrown if an operation is taking too long to execute.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class TimeoutException extends Exception {

	/**
	 * Creates a new timeout exception with a custom message.
	 * 
	 * @param msg
	 */
	public TimeoutException(String msg) {
		super(msg);
	}
}
