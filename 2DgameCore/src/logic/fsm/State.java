package logic.fsm;

import java.util.ArrayList;

/**
 * A State used in a deterministic State machine. State instances are connected
 * using {@link Transition} instances.
 * 
 * @author stonneau
 * 
 */
public class State {
	protected ArrayList<Transition> transitions_;
	public final Boolean isTerminal;

	/**
	 * 
	 */
	public State() {
		transitions_ = new ArrayList<Transition>();
		isTerminal = false;
	}

	/**
	 * 
	 * @param isTerminal
	 *            Whether the State is terminal.
	 */
	public State(Boolean isTerminal) {
		transitions_ = new ArrayList<Transition>();
		this.isTerminal = isTerminal;
	}

	/**
	 * 
	 * @param isTerminal
	 *            Whether the State is terminal.
	 * @param transitions
	 *            a list of {@link Transition} that connects the State to other
	 *            State instances.
	 */
	public State(Boolean isTerminal, ArrayList<Transition> transitions) {
		this.isTerminal = isTerminal;
		transitions_ = transitions;
	}

	/**
	 * Connects the current State to another with a {@link Transition}
	 * 
	 * @param transition
	 */
	public void addTransition(Transition transition) {
		transitions_.add(transition);
	}

	/**
	 * Performs a Transition to another state if possible.
	 * 
	 * @param inputs
	 *            the current {@link Input}.
	 * @return The result of the Transition evaluations. Either the State the
	 *         that has been reached thanks to a Transition, or the current
	 *         State if no Transition could be performed.
	 */
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

	/**
	 * Automatically called When A {@link Transition} into this State has been
	 * performed. Not called when the State is specified as the initial State of
	 * a {@link FSM}.
	 * 
	 * @param oldState
	 *            The State from which the Transition has been performed.
	 * @param input
	 *            The input that allowed the Transition to be performed.
	 */
	public void OnEntering(State oldState, Input input) {
	};

	/**
	 * Automatically called When A {@link Transition} out of this State has been
	 * performed.
	 * 
	 * @param nextState
	 *            The State that will be reached thanks to the {@link Transition}.
	 * @param input
	 *            The input that allowed the {@link Transition} to be performed.
	 */
	public void OnLeaving(State nextState, Input input) {
	};
}
