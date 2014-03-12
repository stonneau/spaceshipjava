package graphics;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class TextureTest {

	@Test
	public void test() {
		TextureFactory factory = TextureFactory.getInstance();
		int id;
		try {
			id = factory.loadTexture("/content/ChuChu_walk_east.png");
			int id2 = factory.loadTexture((new File("/content/ChuChu_walk_east2.png").getAbsolutePath()));
			assertEquals(id, factory.loadTexture((new File("/content/ChuChu_walk_east.png")).getAbsolutePath()));
			assertFalse(id == id2);
		} 
		catch (Exception e) {
			e.printStackTrace();
			assertFalse(true);
		}
	}
}
