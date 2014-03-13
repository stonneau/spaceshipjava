package graphics.animation;

import graphics.Rectangle;
import graphics.Texture;

/**
 * Base class for sprite animations. Assumes that an animation is composed of
 * sprites of an equal dimension aligned horizontally in an image. The method
 * getRectangleToDraw() returns which portion of a {@link Texture} should be
 * drawn at the moment. In this implementation when the last frame is reached
 * the last sprite remains displayed. See specialized classes for other
 * behaviours.
 * 
 * @author stonneau
 * 
 */
public class Animation {
	public final int maxFrame;
	public final int x;
	public final int y;
	public final int frameRate;

	protected int currentFrame_;
	protected Rectangle rectangle_;

	private float currentFrameRate_;

	/**
	 * Create a sprite animation. The first sprite is located by a
	 * {@link Rectangle} the upper left corner of which has (0,0) as coordinate
	 * 
	 * @param width
	 *            width of any sprite of the animation
	 * @param height
	 *            height of any sprite of the animation
	 * @param frames
	 *            number of sprites composing the animation
	 * @param frameRate
	 *            time in ms before switching to the following sprite
	 */
	public Animation(int width, int height, int frames, int frameRate) {
		x = 0;
		y = 0;
		maxFrame = frames;
		currentFrame_ = 0;
		this.frameRate = frameRate;
		currentFrameRate_ = 0;
		rectangle_ = new Rectangle(0, 0, width, height);
	}

	/**
	 * Create a sprite animation. The first sprite is located by a
	 * {@link Rectangle} the upper left corner of which has (x,y) as coordinate.
	 * 
	 * @param x
	 *            start abscissa of the first sprite
	 * @param y
	 *            start ordinate of the first sprite
	 * @param width
	 *            width of any sprite of the animation
	 * @param height
	 *            height of any sprite of the animation
	 * @param frames
	 *            number of sprites composing the animation
	 * @param frameRate
	 *            time in ms before switching to the following sprite
	 */
	public Animation(int x, int y, int width, int height, int frames,
			int frameRate) {
		this.x = x;
		this.y = y;
		maxFrame = frames;
		currentFrame_ = 0;
		this.frameRate = frameRate;
		currentFrameRate_ = 0;
		rectangle_ = new Rectangle(x, y, width, height);
	}

	/**
	 * Restart the frame counter and set the timeElpased for the Animation to 0,
	 * hence resetting it to its first frame.
	 */
	public void reset() {
		currentFrame_ = 0;
	}

	/**
	 * Based on the total time elapsed determines the current frame.
	 * 
	 * @param msElapsed
	 * @return
	 */
	public Boolean update(float msElapsed) {
		currentFrameRate_ = currentFrameRate_ + msElapsed;
		if (currentFrameRate_ > frameRate) {
			currentFrameRate_ = currentFrameRate_ - frameRate;
			if (selectFrame()) {
				onLastFrameReached();
				return true;
			}
			rectangle_.x = x + rectangle_.width * currentFrame_;
			rectangle_.y = y;
		}
		return false;
	}

	/**
	 * Indicates which part of the {@link Texture} related to the Animation should be
	 * drawn.
	 * 
	 * @return
	 */
	public Rectangle getRectangleToDraw() {
		return rectangle_;
	}

	/**
	 * Called automatically when the last Frame has been reached. Can be
	 * overriden by specialized class for other behaviours, for instance to loop
	 * on the animation.
	 */
	protected void onLastFrameReached() {
		// NOTHING
	}

	/**
	 * Updates the current frame. Can be overriden by specialized class for
	 * other behaviours.
	 * 
	 * @return true if the last frame has been reached.
	 */
	protected Boolean selectFrame() {
		currentFrame_ = currentFrame_ + 1;
		if (currentFrame_ >= maxFrame) {
			currentFrameRate_ = maxFrame;
			return true;
		}
		return false;
	}
}
