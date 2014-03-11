package collision;

import collision.shapes.Sphere2D;

public class Checker {
	public Checker()
	{
		// NOTHING
	}
	
	Boolean IsColliding(Sphere2D a, Sphere2D b)
	{
		double xDif = a.X() - b.X();
		double yDif = a.Y() - b.Y();
		double distanceSquared = xDif * xDif + yDif * yDif;
		return distanceSquared < (a.r + b.r) * (a.r + b.r);
	}
}
