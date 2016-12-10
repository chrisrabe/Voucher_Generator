package generator.helper.groups.character;

/**
 * Represents a character group mapped to a flag which indicates whether it is
 * activated or not.
 * 
 * @author Chris
 */
public class CharacterGroup {

	// Fields

	private char[] characters;
	private boolean active;

	// Constructors

	/**
	 * Creates a character group which is active by default.
	 * 
	 * @param characters
	 */
	public CharacterGroup(char[] characters) {
		this(characters, true);
	}

	/**
	 * Creates a character group which can be active or inactive.
	 * 
	 * @param characters
	 * @param active
	 */
	public CharacterGroup(char[] characters, boolean active) {
		this.characters = characters;
		this.active = active;
	}

	// Getters and Setters

	public char[] getCharacters() {
		return characters;
	}

	public void setCharacters(char[] characters) {
		this.characters = characters;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}