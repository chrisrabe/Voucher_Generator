package generator.helper.exception;

/**
 * This exception is thrown if a collection is empty when the operation requires
 * it to have elements inside it.
 * 
 * @author Chris
 */
@SuppressWarnings("serial")
public class EmptyCollectionException extends Exception {

	public EmptyCollectionException(String msg) {
		super(msg);
	}
}
