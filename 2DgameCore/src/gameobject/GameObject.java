package gameobject;
/**
 * Base interface for any object that needs to be updated at each frame
 * @author stonneau
 *
 */
public interface GameObject {
	/**
	 * 
	 * @param msElapsed number of ms elapsed since the
	 * last call
	 */
	public void update(float msElapsed);
}
