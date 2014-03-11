package collision.shapes;

public class Sphere2D {
	private float x_;
	private float y_;
	public final float r;
	
	public Sphere2D(float x, float y, float r)
	{
		x_ = x; y_ = y; this.r = r;
	}
	
	public float X()
	{
		return x_;
	}
	
	public float Y()
	{
		return y_;
	}
}
