package input;

/**
 * Container class for a {@link Character} and a time value indicating for how long is
 * has been pressed.
 * 
 * @author stonneau
 * 
 */
public class CharacterTime {
	public Character character;
	public float time;

	public CharacterTime(Character character) {
		this.character = character;
		time = 0;
	}
}