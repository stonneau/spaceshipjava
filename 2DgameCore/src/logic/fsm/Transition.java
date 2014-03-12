package logic.fsm;

import java.util.ArrayList;

public class Transition
{
    private ArrayList<Input> inputs_;
    public final State to;

    public Transition(Input input, State to)
    {
        inputs_ = new ArrayList<Input>();
        inputs_.add(input);
        this.to = to;
    }

    public Transition( ArrayList<Input> inputs, State to)
    {
        inputs_ = inputs;
        this.to = to;
    }

    private Boolean IsValid(Input input)
    {
        for (Input myInput : inputs_)
        {
            if (myInput.Equals(input))
            {
                return true;
            }
        }
        return false;
    }

    public Input GetAcceptedInput(ArrayList<Input> inputs)
    {
    	for (Input input : inputs_)
        {
            if (IsValid(input))
            {
                return input;
            }
        }
        return null;
    }
}
