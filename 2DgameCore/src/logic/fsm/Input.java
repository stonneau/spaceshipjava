package logic.fsm;

public class Input
{
	public final int type;

	public Input(int type)
	{
		this.type = type;
	}

	public Boolean equals(Input input)
	{
		return type == input.type;
	}
}