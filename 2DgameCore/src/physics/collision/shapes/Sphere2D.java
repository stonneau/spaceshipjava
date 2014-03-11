package physics.collision.shapes;

import math.Vector2;

/**
 * Representation of a 2D sphere
 * used for collision checking
 * @author stonneau
 *
 */
public class Sphere2D {
	/**
	 * position of the center of the sphere
	 */
	public Vector2 position;
	/**
	 * radius of the sphere
	 */
	public final float r;
	
	/**
	 * Constructor for the 2d sphere
	 * @param x abscissa position of the center
	 * @param y ordinate position of the center 
	 * @param r radius 
	 */
	public Sphere2D(float x, float y, float r)
	{
		position = new Vector2(x,y); this.r = r;
	}
}
