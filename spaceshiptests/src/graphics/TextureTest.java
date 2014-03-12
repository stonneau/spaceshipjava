package graphics;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class TextureTest {

	@Test
	public void test() {
		TextureFactory factory = TextureFactory.GetInstance();
		int id;
		try {
			id = factory.LoadTexture("/content/ChuChu_walk_east.png");
			int id2 = factory.LoadTexture((new File("/content/ChuChu_walk_east2.png").getAbsolutePath()));
			assertEquals(id, factory.LoadTexture((new File("/content/ChuChu_walk_east.png")).getAbsolutePath()));
			assertFalse(id == id2);
		} 
		catch (Exception e) {
			e.printStackTrace();
			assertFalse(true);
		}
	}
}
