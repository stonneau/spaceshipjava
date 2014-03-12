package logic.fsm;

import static org.junit.Assert.*;

import org.junit.Test;

public class FSMTest {

	public FSMTest() {
		// TODO Auto-generated constructor stub
	}

	@Test
	public void test() {
		Input input0 = new Input(0);
		Input input1 = new Input(1);
		Input input2 = new Input(2);
		DummyState a = new DummyState(false);
		DummyState b = new DummyState(false);
		DummyState c = new DummyState(true);
		Transition ab = new Transition(input0, b);
		Transition ac = new Transition(input1, c);
		Transition ba = new Transition(input2, a);
		a.addTransition(ac);
		a.addTransition(ab);
		b.addTransition(ba);
		logic.fsm.FSM fsm = new logic.fsm.FSM(a);
		assertFalse(a.entered);
		
		fsm.update();
		assertFalse(a.exited);
		fsm.pushInput(new Input(0));
		fsm.update();
		assertTrue(a.exited);
		assertTrue(b.entered);
		

		fsm.pushInput(new Input(1));
		fsm.update();
		assertFalse(a.entered);
		assertFalse(b.exited);

		fsm.pushInput(new Input(2));
		fsm.update();
		assertTrue(a.entered);
		assertTrue(b.exited);
		

		fsm.update();
		assertFalse(c.entered);
		
		fsm.pushInput(new Input(1));
		fsm.update();
		assertTrue(c.entered);
	}

}
