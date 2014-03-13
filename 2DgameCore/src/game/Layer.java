package game;

/**
 * Layer descriptors for game objects. Used for collision masks, as well as
 * drawing hierarchy. 0 is the Background, 6 is the HUD.
 * 
 * @author stonneau
 * 
 */
public enum Layer {
	Background(0), Two(1), Three(2), Four(3), Five(4), Six(5), HUD(6), None(7);

	private final int value;

	private Layer(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
