package logic.fsm;

/**
 * An input for a Finite State machine
 * 
 * @author stonneau
 * 
 */
public class Input {
	public final int type;

	/**
	 * 
	 * @param type a unique identifier for an Input type;
	 */
	public Input(int type) {
		this.type = type;
	}

	/**
	 * 
	 * @param input the compared Input
	 * @return true if the compared Input is equivalent
	 */
	public Boolean equals(Input input) {
		return type == input.type;
	}
}