package input;

import input.InputHandler.CharacterTime;

import java.util.ArrayList;

public class InputState
{
	public InputState()
	{
		pressed  = new ArrayList<CharacterTime>();
		released = new ArrayList<CharacterTime>();
		typed    = new ArrayList<Character>();
	}
	
	public void clear()
	{
		pressed.clear();
		released.clear();
		typed.clear();			
	}
	
	public ArrayList<CharacterTime> pressed;
	public ArrayList<CharacterTime> released;
	public ArrayList<Character> typed;
	
}
