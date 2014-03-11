/**
 * 
 */
package collision;

import static org.junit.Assert.*;

import org.junit.Test;

import physics.collision.Checker;
import physics.collision.shapes.Sphere2D;


/**
 * @author stonneau
 *
 */
public class CheckerTest {

	@Test
	public void test() {
		Sphere2D a = new Sphere2D(0, 0, 1); 
		Sphere2D b = new Sphere2D(1, 0, 1); 
		Sphere2D c = new Sphere2D(2, 0, 0.9f); 
		Checker check = new physics.collision.Checker();
		assertTrue(check.IsColliding(a, b));
		assertTrue(check.IsColliding(c, b));
		assertFalse(check.IsColliding(a, c));
	}

}
