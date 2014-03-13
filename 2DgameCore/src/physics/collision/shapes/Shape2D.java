package physics.collision.shapes;

import physics.Simulation;
import math.Vector2;

/**
 * Base class for collision shapes in the {@link Simulation}.
 * 
 * @author stonneau
 * 
 */
public abstract class Shape2D {

	/**
	 * position of the center of the shape
	 */
	public Vector2 position;

	public Shape2D(float x, float y) {
		position = new Vector2(x, y);
	}

	/**
	 * 
	 * @return The minimal {@link Rectangle2D} englobing the Shape2d.
	 */
	public abstract Rectangle2D boundingBox();
}
