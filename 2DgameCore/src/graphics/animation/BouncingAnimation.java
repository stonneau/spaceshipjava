package graphics.animation;

public class BouncingAnimation extends Animation
{
    private int delta;
    private Boolean first = true;
    
    public BouncingAnimation(int width, int height, int frames, int frameRate)
    {
    	super(width, height, frames, frameRate);
        delta = 1;
    }

    public BouncingAnimation(int x, int y, int width, int height, int frames, int frameRate)
    {
    	super(x, y, width, height, frames, frameRate);
        delta = 1;
    }

    protected Boolean SelectFrame()
    {
        currentFrame_ = currentFrame_ + delta;
        if ( first )
        {
            first = false;
        }
        else if (currentFrame_ == 0 || currentFrame_ == maxFrame)
        {
            return true;
        }
        return false;
    }

    protected void OnLastFrameReached()
    {
        delta = delta * -1;
    }
}
