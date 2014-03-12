package input;

import input.InputHandler.CharacterTime;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * this class is used to achieve the binding between the keys
 * attributed to a given player and the command associated with it
 * represented by an integer to work with enums.
 * @author stonneau
 *
 */
public class Controller {
	public interface ControllerListener
	{
		void onKeyPressed(Integer value, float timePressed);
		void onKeyReleased(Integer value, float timePressed);
		void onKeyTyped(Integer value);
	}
	
	public final HashMap<Character, Integer> values;	
	private InputState currentState_;
	
	public Controller(HashMap<Character, Integer> values)
	{
		this.values = values;
		currentState_ = new InputState();
	}

	public void update(InputState state_) {
		currentState_ = new InputState();
	}

	public InputState getCurrentState() {
		return currentState_;
	}
}
