package graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import graphics.animation.LoopAnimation;

public class GraphicsTestAppli extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Texture texture_;
	public LoopAnimation animation_; 
	public Image image; 
	public GraphicsTestAppli()
	{
		super();
		TextureFactory factory = TextureFactory.GetInstance();
		try {
			texture_ = factory.GetTexture(factory.LoadTexture("content/ChuChu_walk_east.png"));
			animation_ = new LoopAnimation(16, 16, 4, 500);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		image = Toolkit.getDefaultToolkit().getImage("content/ChuChu_walk_east.png");
	}

	public void paintComponent(Graphics g){
	   // Draw our Image object.
	   g.drawImage(texture_.image,50,10, this); // at location 50,10
	   g.drawImage(texture_.image,50,10, this); // at location 50,10
	   Rectangle rect = animation_.GetRectangleToDraw();
	   int delta = 50;
	   g.drawImage(texture_.image, delta, delta, delta + rect.width, delta + rect.height, rect.x, rect.y,
			   rect.x + rect.width, rect.y + rect.height, this);
	   
	   animation_.Update(500);
	   delta = 75;
	   g.drawImage(texture_.image, delta, delta, delta + rect.width, delta + rect.height, rect.x, rect.y,
			   rect.x + rect.width, rect.y + rect.height, this);
	     // 200 wide and high
	   
	   animation_.Update(500);
	   delta = 100;
	   g.drawImage(texture_.image, delta, delta, delta + rect.width, delta + rect.height, rect.x, rect.y,
			   rect.x + rect.width, rect.y + rect.height, this);
	   

	   animation_.Update(500);
	   delta = 125;
	   g.drawImage(texture_.image, delta, delta, delta + rect.width, delta + rect.height, rect.x, rect.y,
			   rect.x + rect.width, rect.y + rect.height, this);
	   
	   animation_.Update(500);
	   delta = 150;
	   g.drawImage(texture_.image, delta, delta, delta + rect.width, delta + rect.height, rect.x, rect.y,
			   rect.x + rect.width, rect.y + rect.height, this);
	  }
		
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	   JFrame frame = new JFrame("ShowImage");
	   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   frame.setSize(600,400);

	   GraphicsTestAppli panel = new GraphicsTestAppli();
	   frame.setContentPane(panel);
	   frame.setVisible(true);
	}

}
