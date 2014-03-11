package graphics;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class TextureFactory {
	private ArrayList<Texture> textures_;
	private ArrayList<String> loaded_;
	private static TextureFactory instance_= null;
	
	private TextureFactory() {
		textures_ = new ArrayList<Texture>();
	}
	
	public static TextureFactory GetInstance()
	{
		if(instance_ == null) instance_ = new TextureFactory();
		return instance_;
	}
	
	public int LoadTexture(String filename)
	{
		if(!loaded_.contains(filename))
		{
			Image image = (new ImageIcon(filename)).getImage();
			textures_.add(new Texture(image));
			loaded_.add(filename);
			return textures_.size() -1 ;
		}
		else
		{
			return loaded_.indexOf(filename);
		}
	}
	
	public Texture GetTexture(int index) throws Exception
	{
		if(index >= textures_.size()) throw new Exception("unknown texture index");
		return textures_.get(index);
	}
}
