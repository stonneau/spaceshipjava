package physics.collision.shapes;

public class Rectangle2D extends Shape2D {
	public final float width;
	public final float height;	

	public final float widthhalf;
	public final float heighthalf;

	public Rectangle2D(float x, float y, float width, float height)
	{
		super(x, y);
		this.width = width; this.height=height;
		widthhalf = width /2;
		heighthalf = height/2;
	}

	@Override
	public Rectangle2D boundingBox() {
		return this;
	}

	public float x1()
	{
		return position.x - widthhalf;
	}
	public float x2()
	{
		return position.x + widthhalf;
	}
	public float y1()
	{
		return position.y - heighthalf;
	}
	public float y2()
	{
		return position.y + heighthalf;
	}
}