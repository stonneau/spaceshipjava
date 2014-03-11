package physics;
import math.Vector2;

public class MovingEntity implements gameobject.GameObject {


	public final Vector2 minSpeed;
	public final Vector2 maxSpeed;
	public final Vector2 minAcc;
	public final Vector2 maxAcc;
	
	protected Vector2 currentSpeed_;
	protected Vector2 currentAcceleration_;
	
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

	public void Accelerate(Vector2 delta) {
		// TODO Auto-generated method stub
		currentAcceleration_ = currentAcceleration_.plus(delta);
		currentAcceleration_.bound(minAcc, maxAcc);
	}
	
	public void SetAcceleration(Vector2 acceleration) {
		// TODO Auto-generated method stub
		currentAcceleration_ = acceleration;
		currentAcceleration_.bound(minAcc, maxAcc);
	}
	
	public void Stop() {
		// TODO Auto-generated method stub
		currentSpeed_ = new Vector2(0,0);
		currentAcceleration_ = new Vector2(0,0);
	}
	
}
