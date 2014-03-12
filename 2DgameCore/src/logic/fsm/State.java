package logic.fsm;

import java.util.ArrayList;

public class State {
	protected ArrayList<Transition> transitions_;
	public final Boolean isTerminal;

	public State() {
		transitions_ = new ArrayList<Transition>();
		isTerminal = false;
	}

	public State(Boolean isTerminal) {
		transitions_ = new ArrayList<Transition>();
		this.isTerminal = isTerminal;
	}

	public State(Boolean isTerminal, ArrayList<Transition> transitions) {
		this.isTerminal = isTerminal;
		transitions_ = transitions;
	}

	public void addTransition(Transition transition) {
		transitions_.add(transition);
	}

	public State update(ArrayList<Input> inputs) {
		for (Transition transition : transitions_) {
			Input input = transition.getAcceptedInput(inputs);
			if (input != null) {
				State next = transition.to;
				this.OnLeaving(next, input);
				next.OnEntering(this, input);
				return next;
			}
		}
		return this;
	}

	public State update(float ms, ArrayList<Input> inputs) {
		return this.update(inputs);
	}

	public void OnEntering(State oldState, Input input) {
	};

	public void OnLeaving(State nextState, Input input) {
	};
}
