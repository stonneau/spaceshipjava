package physics.collision;

public enum CollisionLayer {
	One(0),
	Two(1),
	Three(2),
	Four(3),
	Five(4),
	Six(5),
	Seven(6),
	None(7);
	
    private final int value;
    private CollisionLayer(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
