package input;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Achieves the binding between the keys attributed to a given player and the
 * commands associated with it represented by an integer to work with enums.
 * This allows client codes to treat several players with different
 * configurations with the same code.
 * 
 * @author stonneau
 * 
 */
public class Controller {
	/**
	 * Listener for a given {@link Controller}. When update is called on the
	 * {@link Controller} in case of a keyboard event the appropriate method
	 * will be called.
	 * 
	 * @author stonneau
	 * 
	 */
	public interface ControllerListener {
		/**
		 * Called when a key registered for the {@link Controller} has been
		 * pressed.
		 * 
		 * @param value
		 *            the pressed key
		 * @param timePressed
		 *            the time the key was pressed, in ms.
		 */
		void onKeyPressed(Integer value, float timePressed);

		/**
		 * Called when a key registered for the {@link Controller} has been
		 * released.
		 * 
		 * @param value
		 *            the pressed key
		 * @param timePressed
		 *            the time the key was pressed, in ms.
		 */
		void onKeyReleased(Integer value, float timePressed);

		/**
		 * Called when a key registered for the {@link Controller} has been
		 * triggered.
		 * 
		 * @param value
		 *            the pressed key
		 */
		void onKeyTyped(Integer value);
	}

	public final HashMap<Character, Integer> values;
	private InputState currentState_;
	private ArrayList<ControllerListener> listeners_;

	/**
	 * 
	 * @param values
	 *            a translation table that associates a {@link Character} with
	 *            an index for a key. Only the {@link Character} instances
	 *            present in this table will be handled by the
	 *            {@link Controller}.
	 */
	public Controller(HashMap<Character, Integer> values) {
		this.values = values;
		currentState_ = new InputState();
		listeners_ = new ArrayList<ControllerListener>();
	}

	/**
	 * Registers a {@link ControllerListener}, called at every update in case of
	 * a key event.
	 * 
	 * @param listener
	 */
	public void addControllerListener(ControllerListener listener) {
		listeners_.add(listener);
	}

	/**
	 * Removes a previously registered {@link ControllerListener}.
	 * 
	 * @param listener
	 */
	public void removeControllerListener(ControllerListener listener) {
		listeners_.remove(listener);
	}

	/**
	 * update the current state of the Controller. Informs all the registered
	 * {@link ControllerListener} of the filtered key events that happened since
	 * the last call to update.
	 * 
	 * @param state
	 *            the updated InputState.
	 */
	synchronized void update(final InputState state) {
		currentState_ = state;
		for (CharacterTime characterTime : state.pressed) {
			Integer value = values.get(characterTime.character);
			if (value != null) {
				for (ControllerListener listener : listeners_) {
					listener.onKeyPressed(value, characterTime.time);
				}
			}
		}
		for (CharacterTime characterTime : state.released) {
			Integer value = values.get(characterTime.character);
			if (value != null) {
				for (ControllerListener listener : listeners_) {
					listener.onKeyReleased(value, characterTime.time);
				}
			}
		}
		for (Character character : state.typed) {
			Integer value = values.get(character);
			if (value != null) {
				for (ControllerListener listener : listeners_) {
					listener.onKeyTyped(value);
				}
			}
		}
	}
}
