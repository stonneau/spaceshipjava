package graphics.animation;

import graphics.Rectangle;

public class Animation
{
	public final int maxFrame_;
	public final int x_;
	public final int y_;
    // in milliseconds
    public final int frameRate_;
    
	protected  int currentFrame_;
    protected Rectangle rectangle_;
    
    private float currentFrameRate_;

    public Animation(int width, int height, int frames, int frameRate)
    {
        x_ = 0;
        y_ = 0;
        maxFrame_ = frames;
        currentFrame_ = 0;
        frameRate_ = frameRate;
        currentFrameRate_ = 0;
        rectangle_ = new Rectangle( 0, 0, width, height);
    }

    public Animation(int x, int y, int width, int height, int frames, int frameRate)
    {
        x_ = x;
        y_ = y;
        maxFrame_ = frames;
        currentFrame_ = 0;
        frameRate_ = frameRate;
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
        if ( currentFrame_ >= maxFrame_ )
        {
            currentFrameRate_ = maxFrame_;
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
        if (currentFrameRate_ > frameRate_)
        {
            currentFrameRate_ = currentFrameRate_ - frameRate_;          
            if (SelectFrame())
            {
                OnLastFrameReached();
                return true;
            }
            rectangle_.x = x_ + rectangle_.width * currentFrame_;
            rectangle_.y = y_;
        }
        return false;
    }

    public Rectangle GetRectangleToDraw()
    {
        return rectangle_;
    }
}
