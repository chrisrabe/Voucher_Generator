package generator.models.code;

/**
 * Represents a code object which has a unique id, a description and a flag
 * which indicates whether it has been redeemed or not.
 * 
 * @author Chris
 */
public class Code {

	// Fields
	private String id;
	private String description = " ";
	private boolean redeemed;

	// Constructors

	public Code(String id) {
		this.id = id;
	}

	public Code(String id, String description) {
		this(id);
		this.description = description;
	}

	public Code(String id, String description, boolean redeemed) {
		this(id, description);
		this.redeemed = redeemed;
	}

	// Getters and Setters

	public String getID() {
		return id;
	}

	public void setID(String id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isRedeemed() {
		return this.redeemed;
	}

	public void setRedeemed(boolean redeemed) {
		this.redeemed = redeemed;
	}

	// Object Methods

	@Override
	public String toString() {
		return "id:" + id + ", description:" + description + ", redeemed:" + redeemed;
	}
}
