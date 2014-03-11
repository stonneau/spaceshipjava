package graphics.animation;

public class LoopAnimation extends Animation
{
    public LoopAnimation(int width, int height, int frames, int frameRate)
    {
    	super(width, height, frames, frameRate);
    }


    public LoopAnimation(int x, int y, int width, int height, int frames, int frameRate)
    {
        super(x, y, width, height, frames, frameRate);
    }

    protected Boolean SelectFrame()
    {
        super.SelectFrame();
        if ( currentFrame_ >= maxFrame_)
        {
            currentFrame_ = 0;
        }
        return false;
    }
}
