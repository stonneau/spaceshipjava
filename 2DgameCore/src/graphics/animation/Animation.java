package graphics.animation;

import graphics.Rectangle;
/**
 * base class for sprite animations.
 * Assumes that an animation is composed of sprites of an equal 
 * dimension aligned horizontally in an image.
 * @author stonneau
 *
 */
public class Animation
{
	public final int maxFrame;
	public final int x;
	public final int y;
    // in milliseconds
    public final int frameRate;
    
	protected  int currentFrame_;
    protected Rectangle rectangle_;
    
    private float currentFrameRate_;

    /**
     * Create a sprite animation. The first sprite is located by a Rectangle the
     * upper left corner of which has (0,0) as coordinate 
     * @param width width of any sprite of the animation
     * @param height height of any sprite of the animation
     * @param frames number of sprites composing the animation
     * @param frameRate time in ms before switching to the following sprite
     */
    public Animation(int width, int height, int frames, int frameRate)
    {
        x = 0;
        y = 0;
        maxFrame = frames;
        currentFrame_ = 0;
        this.frameRate = frameRate;
        currentFrameRate_ = 0;
        rectangle_ = new Rectangle( 0, 0, width, height);
    }


    /**
     * Create a sprite animation. The first sprite is located by a Rectangle the
     * upper left corner of which has (x,y) as coordinate 
     * @param x start abscissa of the first sprite
     * @param y start ordinate of the first sprite
     * @param width width of any sprite of the animation
     * @param height height of any sprite of the animation
     * @param frames number of sprites composing the animation
     * @param frameRate time in ms before switching to the following sprite
     */
    public Animation(int x, int y, int width, int height, int frames, int frameRate)
    {
        this.x = x;
        this.y = y;
        maxFrame = frames;
        currentFrame_ = 0;
        this.frameRate = frameRate;
        currentFrameRate_ = 0;
        rectangle_ = new Rectangle(x,y,width,height);
    }

    //returns true whether the animation is achieved
    protected void OnLastFrameReached()
    {
        //NOTHING
    }

    //returns true whether finalFrame is reached
    protected Boolean SelectFrame()
    {
        currentFrame_ = currentFrame_ + 1;
        if ( currentFrame_ >= maxFrame )
        {
            currentFrameRate_ = maxFrame;
            return true;
        }
        return false;
    }
    
    public void Reset()
    {
        currentFrame_ = 0;
    }

    public Boolean Update(float msElapsed)
    {
        currentFrameRate_ = currentFrameRate_ + msElapsed;
        if (currentFrameRate_ > frameRate)
        {
            currentFrameRate_ = currentFrameRate_ - frameRate;          
            if (SelectFrame())
            {
                OnLastFrameReached();
                return true;
            }
            rectangle_.x = x + rectangle_.width * currentFrame_;
            rectangle_.y = y;
        }
        return false;
    }

    public Rectangle GetRectangleToDraw()
    {
        return rectangle_;
    }
}
