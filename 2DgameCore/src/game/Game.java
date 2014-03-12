package game;

import input.InputHandler;
import physics.Simulation;
import graphics.Gui;

/**
 * Main class of our engine. Contains initialization methods and calls different
 * updates and drawing methods
 * 
 * @author stonneau
 * 
 */
public class Game {
	protected Gui gui_;
	protected Simulation simulation_;
	protected InputHandler input_;

	private Boolean gameRunning_;
	private final int TARGET_FPS = 60;
	private long OPTIMAL_TIME = 1000000000 / TARGET_FPS;

	public Game(Gui gui, Simulation simulation, InputHandler inputHandler) {
		gameRunning_ = false;
		gui_ = gui;
		simulation_ = simulation;
		input_ = inputHandler;
	}

	public void start() {
		gameRunning_ = true;
		gameLoop();
	}

	void gameLoop() {
		long lastLoopTime = System.nanoTime();

		// keep looping round til the game ends
		while (gameRunning_) {
			// work out how long its been since the last update, this
			// will be used to calculate how far the entities should
			// move this loop
			long now = System.nanoTime();
			long updateLength = now - lastLoopTime;
			lastLoopTime = now;
			float delta = (float) (updateLength / ((double) OPTIMAL_TIME));

			// retrieve input data
			// update the game logic
			simulation_.update(delta);
			// draw everything
			gui_.Draw(delta);

			// we want each frame to take 10 milliseconds, to do this
			// we've recorded when we started the frame. We add 10 milliseconds
			// to this and then factor in the current time to give
			// us our final value to wait for
			// remember this is in ms, whereas our lastLoopTime etc. vars are in
			// ns.
			try {
				Thread.sleep((lastLoopTime - System.nanoTime() + OPTIMAL_TIME) / 1000000);
			} catch (Exception e) {
				// NOTHING
			}
		}
	}

}
