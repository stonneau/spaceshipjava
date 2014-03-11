package physics;

import static org.junit.Assert.*;

import math.Vector2;

import org.junit.Test;

public class MovingEntityTest {

	@Test
	public void test() {
		Vector2 minSpeed = new Vector2(-1f, -0.5f);
		Vector2 maxSpeed = new Vector2(1f, 0.5f);
		Vector2 minAcc = new Vector2(-1f, -1f);
		Vector2 maxAcc = new Vector2(1f, 0.5f);
		MovingEntity entity = new MovingEntity(1, minSpeed, maxSpeed, minAcc, maxAcc);
		/*boundary checks*/
		entity.Accelerate(new Vector2(10f,10f));
		entity.Update(1);
		assertEquals(entity.currentSpeed_, new Vector2(1f,0.5f));
		entity.Stop();
		assertEquals(entity.currentSpeed_, new Vector2(0f,0f));
		assertEquals(entity.currentAcceleration_, new Vector2(0f,0f));
		entity.Accelerate(new Vector2(-10f,-10f));
		entity.Update(1);
		assertEquals(entity.currentSpeed_, new Vector2(-1f,-0.5f));
		entity.Stop();
		entity.Accelerate(new Vector2(10f,10f));
		entity.Update(0.05f);
		entity.Update(0.05f);
		assertEquals(entity.currentSpeed_, new Vector2(0.1f,0.05f));

		entity.SetAcceleration(new Vector2(0.1f,0.1f));
		entity.Update(1f);
		assertEquals(entity.currentSpeed_, new Vector2(0.2f,0.15f));
	}

}
