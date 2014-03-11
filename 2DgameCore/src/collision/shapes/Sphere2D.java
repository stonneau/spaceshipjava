package collision.shapes;

/**
 * Representation of a 2D sphere
 * used for collision checking
 * @author stonneau
 *
 */
public class Sphere2D {
	/**
	 * abscissa position of the center of the sphere
	 */
	private float x_;
	/**
	 * ordinate position of the center of the sphere
	 */
	private float y_;
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
		x_ = x; y_ = y; this.r = r;
	}
	
	/**
	 *
	 * @return the X value of the sphere center
	 */
	public float X()
	{
		return x_;
	}
	
	/**
	 * 
	 * @return he Y value of the sphere center
	 */
	public float Y()
	{
		return y_;
	}
}
