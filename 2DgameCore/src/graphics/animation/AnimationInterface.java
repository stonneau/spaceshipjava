package graphics.animation;

import graphics.Rectangle;


public interface AnimationInterface
{

    void Reset();

    Boolean Update(float msElapsed);

    Rectangle GetRectangleToDraw();
}

