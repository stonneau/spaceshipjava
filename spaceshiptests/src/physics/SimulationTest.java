package physics;

import static org.junit.Assert.*;

import math.Vector2;

import org.junit.Test;

import physics.collision.CollisionLayer;


public class SimulationTest {

	@Test
	public void test() {		
		Vector2 minSpeed = new Vector2(-1f, -0.5f);
		Vector2 maxSpeed = new Vector2(1f, 0.5f);
		Vector2 minAcc = new Vector2(-1f, -1f);
		Vector2 maxAcc = new Vector2(1f, 0.5f);
		MovingEntity ma = new MovingEntity(new Vector2(0,0),1, minSpeed, maxSpeed, minAcc, maxAcc);
		ma.SetAcceleration(new Vector2(1f,0.5f));

		DummyLocatedEntity b = new DummyLocatedEntity(2, 2, 1);
		DummyLocatedEntity c = new DummyLocatedEntity(2, 2, 1);

		Simulation sim = new Simulation();
		sim.AddLocatedEntity(b, CollisionLayer.One);
		sim.AddLocatedEntity(c, CollisionLayer.Two);
		sim.AddMovingEntity(ma, CollisionLayer.One);
		
		sim.Update(0.5f);
		assertFalse(b.visited);		
		assertFalse(c.visited);		
			
		sim.Update(0.75f);
		assertTrue(b.visited);		
		assertFalse(c.visited);	
	}

}
