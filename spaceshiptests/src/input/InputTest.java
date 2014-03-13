package input;

import static org.junit.Assert.*;

import input.Controller.ControllerListener;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.util.HashMap;

import org.junit.Test;

public class InputTest {

	public class DummyControllerListener implements ControllerListener{

		int pressed;
		int typed;
		int released;
		float time;
		
		public DummyControllerListener() {
			pressed = -1; typed = -1; released = -1; time = 0;
		}
		
		@Override
		public void onKeyPressed(Integer value, float timePressed) {
			pressed = value; time = timePressed;
		}

		@Override
		public void onKeyReleased(Integer value, float timePressed) {
			released = value; time = timePressed;
			
		}

		@Override
		public void onKeyTyped(Integer value) {
			typed = value;
		}
		
		
	}
	
	@Test
	public void test() {
		InputHandler inputHandler = new InputHandler();
		HashMap<Character, Integer> values1 = new HashMap<Character, Integer>(2);
		HashMap<Character, Integer> values2 = new HashMap<Character, Integer>(2);
		values1.put(new Character("e".charAt(0)), 0);
		values1.put(new Character("b".charAt(0)), 1);
		values2.put(new Character("b".charAt(0)), 2);
		values2.put(new Character("c".charAt(0)), 3);
		Controller controller1 = new Controller(values1);
		Controller controller2 = new Controller(values2);
		inputHandler.addController(controller2);
		inputHandler.addController(controller1);
		DummyControllerListener l1 = new DummyControllerListener();
		DummyControllerListener l2 = new DummyControllerListener();
		controller2.addControllerListener(l2);
		controller1.addControllerListener(l1);
		
		KeyEvent e = new KeyEvent(new Component() {}, 0, 0, 0, 0, "e".charAt(0));
		KeyEvent b = new KeyEvent(new Component() {}, 0, 0, 0, 0, "b".charAt(0));
		KeyEvent c = new KeyEvent(new Component() {}, 0, 0, 0, 0, "c".charAt(0));
		inputHandler.keyTyped(e);
		assertTrue(l1.typed == -1);
		
		inputHandler.update(1);
		assertTrue(l1.typed == 0);
		assertTrue(l1.released == -1);
		assertTrue(l1.pressed == -1);
		l1.typed = -1;
		
		assertTrue(l2.pressed == -1);
		assertTrue(l2.released == -1);
		assertTrue(l2.typed == -1);
		

		inputHandler.keyPressed(e);
		inputHandler.keyTyped(b);
		inputHandler.update(1);
		assertTrue(l1.time == 1f);
		assertTrue(l1.pressed == 0);
		assertTrue(l1.released == -1);
		assertTrue(l1.typed == 1);
		
		assertTrue(l2.pressed == -1);
		assertTrue(l2.released == -1);
		assertTrue(l2.typed == 2);
		

		l1.pressed = -1;
		l2.typed  = -1;l1.typed = -1;
		
		inputHandler.keyReleased(e);
		inputHandler.keyReleased(c);
		inputHandler.update(1);
		assertTrue(l1.time == 2f);
		assertTrue(l1.pressed == -1);
		assertTrue(l1.released == 0);
		assertTrue(l1.typed == -1);

		assertTrue(l2.time == 0f);
		assertTrue(l2.pressed == -1);
		assertTrue(l2.released == 3);
		assertTrue(l2.typed == -1);
	}

}
