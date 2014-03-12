package game;

import physics.Simulation;
import graphics.Gui;

/**
 * Main class of our engine.
 * Contains initialization methods
 * and calls different updates and drawing methods
 * @author stonneau
 *
 */
public class Game {
	protected Gui gui_;
	protected Simulation simulation_;
	protected input.Input input_;

	private Boolean gameRunning_;
	final int TARGET_FPS = 60;
	final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;  
	
	public Game(Gui gui,Simulation simulation, input.Input input)
	{
		gameRunning_ = false;
		gui_ = gui;
		simulation_ = simulation;
		input_ = input;
	}
	
	public void Start()
	{
		gameRunning_ = true;
		GameLoop();
	}
	
	void GameLoop()
	{
	   long lastLoopTime = System.nanoTime(); 
	
	   // keep looping round til the game ends
	   while (gameRunning_)
	   {
	      // work out how long its been since the last update, this
	      // will be used to calculate how far the entities should
	      // move this loop
		   long now = System.nanoTime();
		   long updateLength = now - lastLoopTime;
		   lastLoopTime = now;
		   float delta =(float)(updateLength / ((double)OPTIMAL_TIME));
	
	   	  //retrieve input data
	      input_.Update(delta);
	      // update the game logic
	      simulation_.Update(delta);
	      // draw everything
		  gui_.Draw(delta);
	      
	      // we want each frame to take 10 milliseconds, to do this
	      // we've recorded when we started the frame. We add 10 milliseconds
	      // to this and then factor in the current time to give 
	      // us our final value to wait for
	      // remember this is in ms, whereas our lastLoopTime etc. vars are in ns.
	      try
	      {
	    	  Thread.sleep((lastLoopTime-System.nanoTime() + OPTIMAL_TIME)/1000000);
    	  }
	      catch(Exception e)
	      {
	    	  // NOTHING
	      }
	   }
	}
	
	
}
