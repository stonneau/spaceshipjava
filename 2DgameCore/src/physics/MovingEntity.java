package physics;
import math.Vector2;

/**
 * Class handling speed and acceleration variations
 * happening to a moving entity
 * @author stonneau
 *
 */
public class MovingEntity implements gameobject.GameObject {

	/**
	 * Minimum Speed (in x and y ) reachable by the entity
	 */
	public final Vector2 minSpeed;
	/**
	 * Maximum Speed (in x and y ) reachable by the entity
	 */
	public final Vector2 maxSpeed;
	/**
	 * Minimum Acceleration (in x and y ) reachable by the entity
	 */
	public final Vector2 minAcc;
	/**
	 * Maximum Acceleration (in x and y ) reachable by the entity
	 */
	public final Vector2 maxAcc;
	
	/**
	 * current speed value
	 */
	protected Vector2 currentSpeed_;

	/**
	 * current acceleration value
	 */
	protected Vector2 currentAcceleration_;
	
	/**
	 * 
	 * @param minSpeed Minimum Speed (in x and y ) reachable by the entity
	 * @param maxSpeed Maximum Speed (in x and y ) reachable by the entity
	 * @param minAcc Minimum Acceleration (in x and y ) reachable by the entity
	 * @param maxAcc Maximum Acceleration (in x and y ) reachable by the entity
	 */
	public MovingEntity(Vector2 minSpeed, Vector2 maxSpeed, Vector2 minAcc, Vector2 maxAcc)
	{
		this.minSpeed = minSpeed; this.maxSpeed = maxSpeed;
		this.minAcc = minAcc; this.maxAcc = maxAcc;
		currentSpeed_ = new Vector2(0,0); currentAcceleration_ = new Vector2(0,0);
	}
	
	@Override
	public void Update(float msElapsed) {
		// TODO Auto-generated method stub
		currentSpeed_ = currentSpeed_.plus(currentAcceleration_.scalarMult(msElapsed));
		currentSpeed_.bound(minSpeed, maxSpeed);
	}	

	/**
	 * Increments the current acceleration by delta, while respecting boundaries
	 * @param delta
	 */
	public void Accelerate(Vector2 delta) {
		// TODO Auto-generated method stub
		currentAcceleration_ = currentAcceleration_.plus(delta);
		currentAcceleration_.bound(minAcc, maxAcc);
	}
	
	/**
	 * Sets the current acceleration to a given, while respecting boundaries
	 * @param acceleration the new value for the current acceleration
	 */
	public void SetAcceleration(Vector2 acceleration) {
		// TODO Auto-generated method stub
		currentAcceleration_ = acceleration;
		currentAcceleration_.bound(minAcc, maxAcc);
	}
	
	/**
	 * Sets current acceleration and speed to 0.
	 */
	public void Stop() {
		// TODO Auto-generated method stub
		currentSpeed_ = new Vector2(0,0);
		currentAcceleration_ = new Vector2(0,0);
	}
	
}
