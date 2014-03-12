package math;

import java.awt.geom.Point2D;
import java.lang.Math;

/**
 * An extension to the relatively impotent java.awt.geom.Point2D.Double,
 * Vector2D allows mathematical manipulation of 2-component vectors.
 * 
 * @author Jadrian Miles
 * @version 20031122
 */
public class Vector2 extends Point2D.Float {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.geom.Point2D.Double#Point2D.Double()
	 */
	public Vector2() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.geom.Point2D.Double#Point2D.Double()
	 */
	public Vector2(float x, float y) {
		super(x, y);
	}

	/**
	 * Copy constructor
	 */
	public Vector2(Vector2 v) {
		x = v.x;
		y = v.y;
	}

	/**
	 * @return the radius (length, modulus) of the vector in polar coordinates
	 */
	public double getR() {
		return Math.sqrt(x * x + y * y);
	}

	/**
	 * @return the angle (argument) of the vector in polar coordinates in the
	 *         range [-pi/2, pi/2]
	 */
	public float getTheta() {
		return (float)Math.atan2(y, x);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.geom.Point2D.Double#setLocation(double, double)
	 */
	public void set(float x, float y) {
		super.setLocation(x, y);
	}

	/**
	 * Sets the vector given polar arguments.
	 * 
	 * @param r
	 *            The new radius
	 * @param t
	 *            The new angle, in radians
	 */
	public void setPolar(float r, float t) {
		super.setLocation(r * Math.cos(t), r * Math.sin(t));
	}

	/** Sets the vector's radius, preserving its angle. */
	public void setR(float r) {
		float t = getTheta();
		setPolar(r, t);
	}

	/** Sets the vector's angle, preserving its radius. */
	public void setTheta(float t) {
		float r = (float)getR();
		setPolar(r, t);
	}

	/** The sum of the vector and rhs */
	public Vector2 plus(Vector2 rhs) {
		return new Vector2(x + rhs.x, y + rhs.y);
	}

	/** The difference of the vector and rhs: this - rhs */
	public Vector2 minus(Vector2 rhs) {
		return new Vector2(x - rhs.x, y - rhs.y);
	}

	public boolean equals(Vector2 rhs) {
		return x == rhs.x && y == rhs.y;
	}

	/** Product of the vector and scalar */
	public Vector2 scalarMult(float scalar) {
		return new Vector2(scalar * x, scalar * y);
	}

	/** Dot product of the vector and rhs */
	public float dotProduct(Vector2 rhs) {
		return x * rhs.x + y * rhs.y;
	}

	/**
	 * Since Vector2D works only in the x-y plane, (u x v) points directly along
	 * the z axis. This function returns the value on the z axis that (u x v)
	 * reaches.
	 * 
	 * @return signed magnitude of (this x rhs)
	 */
	public float crossProduct(Vector2 rhs) {
		return x * rhs.y - y * rhs.x;
	}

	/** Product of components of the vector: compenentProduct( <x y>) = x*y. */
	public float componentProduct() {
		return x * y;
	}

	/** Componentwise product: <this.x*rhs.x, this.y*rhs.y> */
	public Vector2 componentwiseProduct(Vector2 rhs) {
		return new Vector2(x * rhs.x, y * rhs.y);
	}

	/**
	 * An alias for getR()
	 * @return the length of this
	 */
	public float length() {
		return (float)getR();
	}

	/**
	 * Bound instance between two other vector values
	 * @return the length of this
	 */
	public void bound(Vector2 boundMin, Vector2 boundMax)
	{
		if(x < boundMin.x)
		{
			x = boundMin.x;
		}
		if(y < boundMin.y)
		{
			y = boundMin.y;
		}
		if(x > boundMax.x)
		{
			x = boundMax.x;
		}
		if(y > boundMax.y)
		{
			y = boundMax.y;
		}
	}

	/**
	 * Returns a new vector with the same direction as the vector but with
	 * length 1, except in the case of zero vectors, which return a copy of
	 * themselves.
	 */
	public Vector2 unitVector() {
		if (getR() != 0) {
			return new Vector2(x / (float)getR(), y / (float)getR());
		}
		return new Vector2(0,0);
	}

	/** Polar version of the vector, with radius in x and angle in y */
	public Vector2 toPolar() {
		return new Vector2((float)Math.sqrt(x * x + y * y), (float)Math.atan2(y, x));
	}

	/** Rectangular version of the vector, assuming radius in x and angle in y*/
	public Vector2 toRect() {
		return new Vector2((float)(x * Math.cos(y)), (float)(x * Math.sin(y)));
	}

	/** @return Standard string representation of a vector: "<x, y>" */
	@Override
	public String toString() {
		return "<" + x + ", " + y + ">";
	}
}