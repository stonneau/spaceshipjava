package logic.fsm;

import java.util.ArrayList;

public class FSM{

	private ArrayList<Input> currentInputs_;
    private State currentState_;


    public FSM(State currentState)
    {
        currentInputs_ = new ArrayList<Input>();
        currentState_ = currentState;
    }

    public void pushInput(Input input)
    {
        currentInputs_.add(input);
    }

    public Boolean update()
    {
        State old = currentState_;
        currentState_ = currentState_.update(currentInputs_);
        currentInputs_.clear();
        return old == currentState_;
    }
}
