package graphics;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

/**
 * Static class handling the loading of images, turning them into textures.
 * 
 * @author stonneau
 * 
 */
public class TextureFactory {
	private ArrayList<Texture> textures_;
	private ArrayList<String> loaded_;
	private static TextureFactory instance_ = null;

	private TextureFactory() {
		textures_ = new ArrayList<Texture>();
		loaded_ = new ArrayList<String>();
	}

	/**
	 * loads a {@link Texture} from an image filename and returns an index for
	 * that texture. If the Texture has already been loaded, simply returns its
	 * index. Throws if the image could not be loaded.
	 * 
	 * @param filename
	 *            path to the image
	 * @return an unique identifier for the Texture
	 * @throws Exception
	 */
	public int loadTexture(String filename) throws Exception {
		if (!loaded_.contains(filename)) {
			Image image = Toolkit.getDefaultToolkit().getImage(filename);
			;
			textures_.add(new Texture(image));
			loaded_.add(filename);
			return textures_.size() - 1;
		} else {
			return loaded_.indexOf(filename);
		}
	}

	/**
	 * Retrieve a given {@link Texture} given its unique index. Throws if the
	 * index does not match with a {@link Texture}.
	 * 
	 * @param index
	 *            index of the {@link Texture}
	 * @return The required {@link Texture}.
	 * @throws Exception
	 */
	public Texture getTexture(int index) throws Exception {
		if (index >= textures_.size())
			throw new Exception("unknown texture index");
		return textures_.get(index);
	}

	public static TextureFactory getInstance() {
		if (instance_ == null)
			instance_ = new TextureFactory();
		return instance_;
	}
}
