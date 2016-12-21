package generator.control.helper;

/**
 * This interface takes a special parameter in order to contruct their view. The
 * special parameter is symbolised by the generic value of T. This is mainly
 * used for displays which require a parameter in order to display something.
 * 
 * @author Chris
 *
 * @param <T>
 */
public interface IDialogController<T> extends IDisplayController {

	/**
	 * Retrieves the generic argument for this controller.
	 * 
	 * @return
	 */
	public T getArgument();

	/**
	 * Sets the generic argument for this controller.
	 * 
	 * @param parameter
	 */
	public void setArgument(T parameter);
}
