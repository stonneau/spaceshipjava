package physics.collision.shapes;

/**
 * Representation of a 2D Rectangle used for collision checking
 * 
 * @author stonneau
 * 
 */
public class Rectangle2D extends Shape2D {
	public final float width;
	public final float height;

	public final float widthhalf;
	public final float heighthalf;

	/**
	 * 
	 * @param x
	 *            x world position of the center of the Rectangle2D
	 * @param y
	 *            y world position of the center of the Rectangle2D
	 * @param width
	 * @param height
	 */
	public Rectangle2D(float x, float y, float width, float height) {
		super(x, y);
		this.width = width;
		this.height = height;
		widthhalf = width / 2;
		heighthalf = height / 2;
	}

	@Override
	public Rectangle2D boundingBox() {
		return this;
	}

	/**
	 * 
	 * @return the Leftmost x value of the {@link Rectangle2D}.
	 */
	public float x1() {
		return position.x - widthhalf;
	}

	/**
	 * 
	 * @return the rightMost x value of the {@link Rectangle2D}.
	 */
	public float x2() {
		return position.x + widthhalf;
	}

	/**
	 * 
	 * @return the upper y value of the {@link Rectangle2D}.
	 */
	public float y1() {
		return position.y - heighthalf;
	}

	/**
	 * 
	 * @return the lower y value of the {@link Rectangle2D}.
	 */
	public float y2() {
		return position.y + heighthalf;
	}
}