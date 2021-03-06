package physics.collision;

import physics.collision.shapes.Rectangle2D;
import physics.collision.shapes.Sphere2D;

/**
 * Class performing collision checking between available Shapes (as of today :
 * Sphere2D)
 * 
 * @author stonneau
 * 
 */
public class Checker {
	/**
	 * 
	 */
	public Checker() {
		// NOTHING
	}

	/**
	 * Collision checking between two Sphere2D
	 * 
	 * @param a
	 *            one {@link Sphere2D}
	 * @param b
	 *            another {@link Sphere2D}
	 * @return whether or not a and b are colliding
	 */
	public Boolean isColliding(Sphere2D a, Sphere2D b) {
		double xDif = a.position.x - b.position.x;
		double yDif = a.position.y - b.position.y;
		double distanceSquared = xDif * xDif + yDif * yDif;
		return distanceSquared < (a.r + b.r) * (a.r + b.r);
	}

	/**
	 * Collision checking between two {@link Rectangle2D}
	 * 
	 * @param rectA
	 *            one {@link Rectangle2D}
	 * @param rectB
	 *            another {@link Rectangle2D}
	 * @return whether or not a and b are colliding
	 */
	public Boolean isColliding(Rectangle2D rectA, Rectangle2D rectB) {
		return (rectA.x1() < rectB.x2() && rectA.x2() > rectB.x1()
				&& rectA.y1() < rectB.y2() && rectA.y2() > rectB.y1());
	}

	/**
	 * Collision checking between a {@link Rectangle2D} and a {@link Sphere2D}
	 * 
	 * @param rect
	 *            a {@link Rectangle2D}
	 * @param circle
	 *            a {@link Sphere2D}
	 * @return whether or not a and b are colliding
	 */
	public Boolean isColliding(Rectangle2D rect, Sphere2D circle) {
		float distanceX = Math.abs(circle.position.x - rect.position.x);
		float distanceY = Math.abs(circle.position.y - rect.position.y);

		if (distanceX > (rect.widthhalf + circle.r)) {
			return false;
		}
		if (distanceY > (rect.heighthalf + circle.r)) {
			return false;
		}

		if (distanceX <= (rect.widthhalf)) {
			return true;
		}
		if (distanceY <= (rect.heighthalf)) {
			return true;
		}

		float cornerDistance_sq = (distanceX - rect.widthhalf)
				* (distanceX - rect.widthhalf) + (distanceY - rect.heighthalf)
				* (distanceY - rect.heighthalf);

		return (cornerDistance_sq <= (circle.r2));
	}

	/**
	 * Collision checking between a {@link Rectangle2D} and a {@link Sphere2D}
	 * 
	 * @param circle
	 *            a {@link Sphere2D}
	 * @param rect
	 *            a {@link Rectangle2D}
	 * @return whether or not a and b are colliding
	 */
	public Boolean isColliding(Sphere2D circle, Rectangle2D rect) {
		return isColliding(rect, circle);
	}
}
