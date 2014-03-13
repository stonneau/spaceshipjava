package game;

import input.InputHandler;
import logic.fsm.FSM;
import logic.fsm.State;

/**
 * Main class of our engine. The game loop is start with a call to start.
 * 
 * @author stonneau
 * 
 */
public class Game {
	private FSM gameFSM_;
	private InputHandler inputHandler_;

	private final int TARGET_FPS = 60;
	private long OPTIMAL_TIME = 1000000000 / TARGET_FPS;

	/**
	 * 
	 * @param gameFsm
	 *            {@link FSM} Handling the game states. If a terminal
	 *            {@link State} is reached the game stops.
	 */
	public Game(FSM gameFsm) {
		gameFSM_ = gameFsm;
		inputHandler_ = new InputHandler();
	}

	/**
	 * Starts the game loop. The only way to get out of the main loop is to
	 * reach a terminal {@link State}
	 */
	public void start() {
		gameLoop();
	}

	/**
	 * Game loop. Each tick, input are handled, then the simulation is updated,
	 * and last rendering is done.
	 */
	void gameLoop() {
		long lastLoopTime = System.nanoTime();

		// keep looping round til the game ends
		while (!gameFSM_.getCurrentState().isTerminal) {
			// work out how long its been since the last update, this
			// will be used to calculate how far the entities should
			// move this loop
			long now = System.nanoTime();
			long updateLength = now - lastLoopTime;
			lastLoopTime = now;
			float delta = (float) (updateLength / ((double) OPTIMAL_TIME));
			inputHandler_.update(delta);
			gameFSM_.update(delta);

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
