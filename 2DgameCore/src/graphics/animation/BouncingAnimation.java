package graphics.animation;

/**
 * A BouncingAnimation is an infinite {@link Animation} that plays the frames in
 * a reverse order when the last frame is reached. Once the first frame has been
 * reached again the traversal goes in the initial order, and so on.
 * 
 * @author stonneau
 * 
 */
public class BouncingAnimation extends Animation {
	private int delta;
	private Boolean first = true;

	public BouncingAnimation(int width, int height, int frames, int frameRate) {
		super(width, height, frames, frameRate);
		delta = 1;
	}

	public BouncingAnimation(int x, int y, int width, int height, int frames,
			int frameRate) {
		super(x, y, width, height, frames, frameRate);
		delta = 1;
	}

	@Override
	protected Boolean selectFrame() {
		currentFrame_ = currentFrame_ + delta;
		if (first) {
			first = false;
		} else if (currentFrame_ == 0 || currentFrame_ == maxFrame) {
			return true;
		}
		return false;
	}

	@Override
	protected void onLastFrameReached() {
		delta = delta * -1;
	}
}
