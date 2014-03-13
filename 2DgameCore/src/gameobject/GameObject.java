package gameobject;

import game.Game;

/**
 * Base interface for any object that needs to be updated at each frame
 * 
 * @author stonneau
 * 
 */
public interface GameObject {
	/**
	 * Called every tick by the {@link Game} instance.
	 * 
	 * @param msElapsed
	 *            number of ms elapsed since the last call
	 */
	public void update(float msElapsed);
}
