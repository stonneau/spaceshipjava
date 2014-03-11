package collision;

import collision.shapes.Sphere2D;

/**
 * Class performing collision checking
 * between avaiable Shapes (as of today : Sphere2D)
 * @author stonneau
 *
 */
public class Checker {
	/**
	 * 
	 */
	public Checker()
	{
		// NOTHING
	}
	
	/**
	 * Collision checking between two Sphere2D
	 * @param a one Sphere2D
	 * @param b another Sphere2D
	 * @return whether or not a and b are colliding
	 */
	Boolean IsColliding(Sphere2D a, Sphere2D b)
	{
		double xDif = a.X() - b.X();
		double yDif = a.Y() - b.Y();
		double distanceSquared = xDif * xDif + yDif * yDif;
		return distanceSquared < (a.r + b.r) * (a.r + b.r);
	}
}
