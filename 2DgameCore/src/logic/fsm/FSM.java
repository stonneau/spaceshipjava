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

    public void PushInput(Input input)
    {
        currentInputs_.add(input);
    }

    public Boolean Update()
    {
        State old = currentState_;
        currentState_ = currentState_.Update(currentInputs_);
        currentInputs_.clear();
        return old == currentState_;
    }
}
