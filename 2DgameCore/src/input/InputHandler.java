package input;

import gameobject.GameObject;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * this class centralizes the keyboard inputs
 * so that the update is made only once for a tick.
 * I'm not sure whether this is good but this could be good for //ism
 * anyways a nice feature is that it stores the time a given key has been pressed.
 * @author stonneau
 *
 */
public class InputHandler implements KeyListener, GameObject{
	
	public class CharacterTime
	{
		public Character character;
		public float time;
		public CharacterTime(Character character)
		{
			this.character = character;
			time = 0;
		}
	}

	private InputState state_;
	private InputState nextState_;
	private ArrayList<Controller> controllers_;
	
	public InputHandler()
	{
		nextState_ = new InputState();
		state_ = new InputState();
		controllers_ = new ArrayList<Controller>();
	}
			
    public void keyPressed(KeyEvent event)
    {
    	nextState_.pressed.add(new CharacterTime(event.getKeyChar()));
    }

    public void keyTyped(KeyEvent event)
    {
    	nextState_.typed.add(event.getKeyChar());
    }

    public void keyReleased(KeyEvent event)
    {
    	nextState_.pressed.add(new CharacterTime(event.getKeyChar()));
    }

	@Override
	public void update(float msElapsed) {
		for (CharacterTime chart : nextState_.pressed) {
			for (CharacterTime previous : state_.pressed) {
				if(chart.character.equals(previous.character))
				{
					chart.time += previous.time;
				}
			}
		}
		for (CharacterTime chart : nextState_.released) {
			for (CharacterTime previous : state_.pressed) {
				if(chart.character.equals(previous.character))
				{
					chart.time += previous.time;
				}
			}
		}
		InputState temp = state_;
		state_ = nextState_;
		nextState_ = temp;
		nextState_.clear();
		for (Controller controller : controllers_) {
			controller.update(state_);
		}
	}
	
	public InputState getState()
	{
		return state_;
	}
	
	public void addController(Controller controller)
	{
		controllers_.add(controller);
	}
	
	public void removeController(Controller controller)
	{
		controllers_.remove(controller);
	}
}
