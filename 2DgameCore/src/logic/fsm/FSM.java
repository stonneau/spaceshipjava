package logic.fsm;

import java.util.ArrayList;

/**
 * Deterministic Finite State Machine. Accepts Input instance and updates the
 * current State accordingly. A maximum of one Transition can be performed for a
 * call to update.
 * 
 * @author stonneau
 * 
 */
public class FSM {

	private ArrayList<Input> currentInputs_;
	private State currentState_;

	/**
	 * 
	 * @param currentState
	 *            Initial {@link State}
	 */
	public FSM(State currentState) {
		currentInputs_ = new ArrayList<Input>();
		currentState_ = currentState;
	}

	/**
	 * Adds an {@link Input} for the current frame. {@link Input} are treated
	 * sequentially, and since only one {@link Transition} is done for a call to
	 * update, the insertion order matters.
	 * 
	 * @param input
	 *            The input to be added.
	 */
	public void pushInput(Input input) {
		currentInputs_.add(input);
	}

	/**
	 * Given the current {@link Input}, checks whether a {@link Transition} is
	 * possible, and if so, performs it. The {@link Input} list is cleared after
	 * one call to update. A maximum of one {@link Transition} can be performed
	 * for a call to update.
	 * 
	 * @return true if a {@link Transition} was performed.
	 */
	public Boolean update() {
		State old = currentState_;
		currentState_ = currentState_.update(currentInputs_);
		currentInputs_.clear();
		return old != currentState_;
	}
}
