package physics;

import physics.collision.shapes.Sphere2D;

/**
 * An entity that has a world position, a mass, and a collision {@link Sphere2D}
 * in our game. A mass of 0 means the entity is immobile. The world position
 * refers to the geometric center of the LocatedEntity.
 * 
 * @author stonneau
 * 
 */
public abstract class LocatedEntity {

	public Sphere2D shape;
	public final float mass; // 0 means immobile

	/**
	 * An Entity located at (0,0) in our world.
	 * 
	 * @param r
	 *            Radius of the collision {@link Sphere2D}.
	 */
	public LocatedEntity(float r) {
		shape = new Sphere2D(0, 0, r);
		this.mass = 0f;
	}

	/**
	 * An Entity located at (0,0) in our world.
	 * 
	 * @param r
	 *            Radius of the collision {@link Sphere2D}.
	 * @param mass
	 *            The mass of the LocatedEntity. A value of 0 means it is
	 *            immobile.
	 */
	public LocatedEntity(float r, float mass) {
		shape = new Sphere2D(0, 0, r);
		this.mass = mass;
	}

	/**
	 * 
	 * @param x
	 *            World x position of the Entity
	 * @param y
	 *            World y position of the Entity
	 * @param r
	 *            Radius of the collision {@link Sphere2D}.
	 */
	public LocatedEntity(float x, float y, float r) {
		shape = new Sphere2D(x, y, r);
		this.mass = 0f;
	}

	/**
	 * 
	 * @param x
	 *            World x position of the Entity
	 * @param y
	 *            World y position of the Entity
	 * @param r
	 *            Radius of the collision {@link Sphere2D}.
	 * @param mass
	 *            The mass of the LocatedEntity. A value of 0 means it is
	 *            immobile.
	 */
	public LocatedEntity(float x, float y, float r, float mass) {
		shape = new Sphere2D(x, y, r);
		this.mass = mass;
	}

	/**
	 * Called upon Collision
	 * 
	 * @param other
	 *            the LocatedEntity with which the current LocatedEntity is
	 *            colliding.
	 */
	public abstract void onCollision(LocatedEntity other);
}
