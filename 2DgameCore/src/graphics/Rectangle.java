package graphics;

/**
 * Simple descriptor for a rectangle. Used to determine the sprite boundaries to
 * draw from a {@link Texture}.
 * 
 * @author stonneau
 * 
 */
public class Rectangle {
	/**
	 * Leftmost x value of the Rectangle.
	 */
	public int x;
	/**
	 * Upmost x value of the Rectangle.
	 */
	public int y;
	/**
	 * width of the Rectangle.
	 */
	public final int width;
	/**
	 * height of the Rectangle.
	 */
	public final int height;

	/**
	 * 
	 * @param x
	 *            Leftmost x value of the Rectangle.
	 * @param y
	 *            Upmost y value of the Rectangle.
	 * @param width
	 * @param height
	 */
	public Rectangle(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
}
