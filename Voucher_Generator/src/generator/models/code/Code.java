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

	public String getID() {
		return _id;
	}

	public void setID(String id) {
		_id = id;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public boolean isRedeemed() {
		return _redeemed;
	}

	public void setRedeemed(boolean redeemed) {
		_redeemed = redeemed;
	}

	// Object Methods

	@Override
	public String toString() {
		return "id=" + _id + ", description=" + _description + ", redeemed=" + _redeemed;
	}
}
