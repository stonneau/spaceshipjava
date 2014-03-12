package physics.collision.shapes;

/**
 * Representation of a 2D sphere
 * used for collision checking
 * @author stonneau
 *
 */
public class Sphere2D extends Shape2D {
	/**
	 * radius of the sphere
	 */
	public final float r;
	public final float r2;


	/**
	 * Constructor for the 2d sphere
	 * @param x abscissa position of the center
	 * @param y ordinate position of the center 
	 * @param r radius 
	 */
	public Sphere2D(float x, float y, float r)
	{
		super(x, y);
		this.r = r;
		r2 = r * r;
	}

	@Override
	public Rectangle2D boundingBox()
	{
		return new Rectangle2D(position.x, position.y, r, r);
	}
}
