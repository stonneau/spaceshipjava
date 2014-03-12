package logic.fsm;

import java.util.ArrayList;

public abstract class State
{
    protected ArrayList<Transition> transitions_;
    public final Boolean isTerminal;

    public State()
    {
        transitions_ = new ArrayList<Transition>();
        isTerminal = false;
    }

    public State(Boolean isTerminal)
    {
        transitions_ = new ArrayList<Transition>();
        this.isTerminal = isTerminal;
    }

    public State(Boolean isTerminal, ArrayList<Transition> transitions)
    {
    	this.isTerminal = isTerminal;
        transitions_ = transitions;
    }

    public void AddTransition(Transition transition)
    {
        transitions_.add(transition);
    }

    public State Update(ArrayList<Input> inputs)
    {
        for (Transition transition : transitions_)
        {
            Input input = transition.GetAcceptedInput(inputs);
            if ( input != null )
            {
                State next = transition.to;
                this.OnLeaving(next, input);
                next.OnEntering(this, input);
                return next;
            }
        }
        return this;
    }

    public State Update(float ms, ArrayList<Input> inputs)
    {
        return this.Update(inputs);
    }

    public abstract void OnEntering(State oldState, Input input);
    public abstract void OnLeaving(State nextState, Input input);
}
