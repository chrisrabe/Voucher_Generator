package generator.models.code;

/**
 * Represents a code object which has a unique id, a description and a flag
 * which indicates whether it has been redeemed or not.
 * 
 * @author Chris
 */
public class Code {

	// Fields
	private String _id;
	private String _description;
	private boolean _redeemed;

	// Constructors

	public Code(String id) {
		_id = id;
	}

	public Code(String id, String description) {
		this(id);
		_description = description;
	}

	// Getters and Setters

	public String get_id() {
		return _id;
	}

	public void set_id(String id) {
		_id = id;
	}

	public String get_description() {
		return _description;
	}

	public void set_description(String description) {
		_description = description;
	}

	public boolean is_redeemed() {
		return _redeemed;
	}

	public void set_redeemed(boolean redeemed) {
		_redeemed = redeemed;
	}
}
