package logic.fsm;

import java.util.ArrayList;

public class Transition {
	private ArrayList<Input> inputs_;
	public final State to;

	public Transition(Input input, State to) {
		inputs_ = new ArrayList<Input>();
		inputs_.add(input);
		this.to = to;
	}

	public Transition(ArrayList<Input> inputs, State to) {
		inputs_ = inputs;
		this.to = to;
	}

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
