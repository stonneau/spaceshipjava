package input;

import java.util.ArrayList;

/**
 * Container for all the key events that happened in the previous tick.
 * Distinguishes between pressed, released and typed keys. Associates a time
 * value with the pressed and released keys, indicating for how long they have
 * been pressed.
 * 
 * @author stonneau
 * 
 */
public class InputState {

	public InputState() {
		pressed = new ArrayList<CharacterTime>();
		released = new ArrayList<CharacterTime>();
		typed = new ArrayList<Character>();
	}

	public void clear() {
		pressed.clear();
		released.clear();
		typed.clear();
	}

	public ArrayList<CharacterTime> pressed;
	public ArrayList<CharacterTime> released;
	public ArrayList<Character> typed;

}
