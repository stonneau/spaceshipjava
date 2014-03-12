package physics;

import physics.collision.shapes.Sphere2D;

public abstract class LocatedEntity {

	public Sphere2D shape;
	public final float mass; // 0 means immobile

	public LocatedEntity(float r) {
		shape = new Sphere2D(0, 0, r);
		this.mass = 0f;
	}

	public LocatedEntity(float r, float mass) {
		shape = new Sphere2D(0, 0, r);
		this.mass = mass;
	}

	public LocatedEntity(float x, float y, float r) {
		shape = new Sphere2D(x, y, r);
		this.mass = 0f;
	}

	public LocatedEntity(float x, float y, float r, float mass) {
		shape = new Sphere2D(x, y, r);
		this.mass = mass;
	}

	public abstract void onCollision(LocatedEntity other);
}
