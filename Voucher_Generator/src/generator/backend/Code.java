/* File: Code.java
 * Date			Author			Changes
 * Mar 10 16	Chris Rabe		created code class
 * May 8 16		Chris Rabe		added javadocs
 * May 8 16		Chris Rabe		overrided the toString() method
 * Aug 22 16	Chris Rabe		removed other .equals method 
 * Aug 22 16	Chris Rabe		overrided the hashcode method as well
 * Aug 25 16	Chris Rabe		added a new constructor
 */
package generator.backend;

/**
 * Represents a redeemable code. Each code has a unique id mapped to a
 * description. It also has a flag which indicates whether or not it has been
 * redeemed.
 * 
 * @author Chris Rabe
 */
public class Code {
	/** unique id which characterises this code */
	private String code;
	/** describes the purpose of the code */
	private String description;
	/** flag which indicates whether the code is activated or not */
	private boolean isRedeemed;

	public Code(String code) {
		this.code = code;
		this.description = "";
	}

	public Code(String code, String description) {
		this(code);
		this.description = description;
	}

	public Code(String code, String description, boolean redeemed) {
		this(code, description);
		this.isRedeemed = redeemed;
	}

	// Getters and Setters

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isRedeemed() {
		return isRedeemed;
	}

	public void setRedeemed(boolean isRedeemed) {
		this.isRedeemed = isRedeemed;
	}

	// Object methods

	@Override
	public String toString() {
		return String.format("Code:%s, Description:%s, Redeemed: %b", code, description, isRedeemed);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (isRedeemed ? 1231 : 1237);
		return result;
	}

	/**
	 * This method can allow comparison with another Code object and a String
	 * object. If another Code object had been passed, then both this object and
	 * the other object must have the same fields in order to be equal. If a
	 * String object had been passed, then it only compares if the code field is
	 * the same.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		// Compare with another Code object
		if (obj instanceof Code) {
			Code other = (Code) obj;
			if (!other.code.equals(this.code)) {
				return false;
			}
			if (!other.description.equals(this.description)) {
				return false;
			}
			if (other.isRedeemed != this.isRedeemed) {
				return false;
			}
			return true;
		} else if (obj instanceof String) { // Compare with a string
			String other = (String) obj;
			return code.equals(other);
		}
		return false;
	}

}
