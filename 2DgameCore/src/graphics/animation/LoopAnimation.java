package graphics.animation;

public class LoopAnimation extends Animation {
	public LoopAnimation(int width, int height, int frames, int frameRate) {
		super(width, height, frames, frameRate);
	}

	public LoopAnimation(int x, int y, int width, int height, int frames,
			int frameRate) {
		super(x, y, width, height, frames, frameRate);
	}

	@Override
	protected Boolean selectFrame() {
		super.selectFrame();
		if (currentFrame_ >= maxFrame) {
			currentFrame_ = 0;
		}
		return false;
	}
}
