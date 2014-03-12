package logic.fsm;

public class DummyState extends State{
	public Boolean entered;
	public Boolean exited;
	public DummyState(Boolean isTermial)
	{
		super(isTermial);
		entered = false;
		exited = false;
	}
	
	public void OnEntering(State oldState, Input input)
	{
		entered = true;
	}
    public void OnLeaving(State nextState, Input input)
    {
    	exited = true;
    }
    
}
