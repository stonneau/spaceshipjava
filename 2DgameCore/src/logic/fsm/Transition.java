package logic.fsm;

import java.util.ArrayList;

/**
 * Translation from one State to another, performed if a condition, expressed as
 * a list of Inputs, is validated.
 * 
 * @author stonneau
 * 
 */
public class Transition {
	private ArrayList<Input> inputs_;
	public final State to;

	/**
	 * 
	 * @param input
	 *            A {@link Input} condition for transitionning.
	 * @param to
	 *            the State into which the transition will be performed.
	 */
	public Transition(Input input, State to) {
		inputs_ = new ArrayList<Input>();
		inputs_.add(input);
		this.to = to;
	}

	/**
	 * 
	 * @param inputs
	 *            A condition for transitionning. Transition will be performed
	 *            if any of the provided {@link Input} has been provided.
	 * @param to
	 *            the State into which the transition will be performed.
	 */
	public Transition(ArrayList<Input> inputs, State to) {
		inputs_ = inputs;
		this.to = to;
	}

	/**
	 * Given a list of current {@link Input}, checks whether the
	 * {@link Transition} is possible. If so, returns the {@link Input} that
	 * allows the transition to be performed.
	 * 
	 * @param inputs
	 *            A list of current {@link Input}.
	 * @return An accepted {@link Input}, null otherwise
	 */
	public Input getAcceptedInput(ArrayList<Input> inputs) {
		for (Input input : inputs) {
			if (isValid(input)) {
				return input;
			}
		}
		return null;
	}

	private Boolean isValid(Input input) {
		for (Input myInput : inputs_) {
			if (myInput.equals(input)) {
				return true;
			}
		}
		return false;
	}
}
