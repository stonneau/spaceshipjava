package input;

import input.InputHandler.CharacterTime;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * this class is used to achieve the binding between the keys attributed to a
 * given player and the command associated with it represented by an integer to
 * work with enums.
 * 
 * @author stonneau
 * 
 */
public class Controller {
	public interface ControllerListener {
		void onKeyPressed(Integer value, float timePressed);

		void onKeyReleased(Integer value, float timePressed);

		void onKeyTyped(Integer value);
	}

	public final HashMap<Character, Integer> values;
	private InputState currentState_;
	private ArrayList<ControllerListener> listeners_;

	public Controller(HashMap<Character, Integer> values) {
		this.values = values;
		currentState_ = new InputState();
		listeners_ = new ArrayList<ControllerListener>();
	}

	public void update(InputState state_) {
		currentState_ = state_;
		for (CharacterTime characterTime : state_.pressed) {
			Integer value = values.get(characterTime.character);
			if (value != null) {
				for (ControllerListener listener : listeners_) {
					listener.onKeyPressed(value, characterTime.time);
				}
			}
		}
		for (CharacterTime characterTime : state_.released) {
			Integer value = values.get(characterTime.character);
			if (value != null) {
				for (ControllerListener listener : listeners_) {
					listener.onKeyReleased(value, characterTime.time);
				}
			}
		}
		for (Character character : state_.typed) {
			Integer value = values.get(character);
			if (value != null) {
				for (ControllerListener listener : listeners_) {
					listener.onKeyTyped(value);
				}
			}
		}
	}

	public InputState getCurrentState() {
		return currentState_;
	}

	public void addControllerListener(ControllerListener listener) {
		listeners_.add(listener);
	}

	public void removeControllerListener(ControllerListener listener) {
		listeners_.remove(listener);
	}
}
