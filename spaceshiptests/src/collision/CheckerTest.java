/**
 * 
 */
package collision;

import static org.junit.Assert.*;

import org.junit.Test;

import physics.collision.Checker;
import physics.collision.shapes.Rectangle2D;
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
		Rectangle2D d = new Rectangle2D(0, 0, 1.1f, 1.1f); 
		Rectangle2D e = new Rectangle2D(1, 0, 1f, 1f); 
		Rectangle2D f = new Rectangle2D(1.f, 1.f, 0.428f, 0.428f);
		Rectangle2D g = new Rectangle2D(3, 1, 1f, 1f);
		Rectangle2D h = new Rectangle2D(1.f, 1.f, 0.6f, 0.6f);
		
		Checker check = new physics.collision.Checker();
		assertTrue(check.IsColliding(a, b));
		assertTrue(check.IsColliding(c, b));
		assertFalse(check.IsColliding(a, c));	

		assertTrue(check.IsColliding(e, d));
		assertFalse(check.IsColliding(e, g));
		
		assertTrue(check.IsColliding(d, a));
		assertFalse(check.IsColliding(a, f));
		assertTrue(check.IsColliding(a, h));
	}

}
