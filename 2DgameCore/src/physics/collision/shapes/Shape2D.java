package physics.collision.shapes;

import math.Vector2;

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
	 * @return
	 */
	public abstract Rectangle2D boundingBox();
}
