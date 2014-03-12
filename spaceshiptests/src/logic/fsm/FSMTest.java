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
		a.AddTransition(ac);
		a.AddTransition(ab);
		b.AddTransition(ba);
		logic.fsm.FSM fsm = new logic.fsm.FSM(a);
		assertFalse(a.entered);
		
		fsm.Update();
		assertFalse(a.exited);
		fsm.PushInput(new Input(0));
		fsm.Update();
		assertTrue(a.exited);
		assertTrue(b.entered);
		

		fsm.PushInput(new Input(1));
		fsm.Update();
		assertFalse(a.entered);
		assertFalse(b.exited);

		fsm.PushInput(new Input(2));
		fsm.Update();
		assertTrue(a.entered);
		assertTrue(b.exited);
		

		fsm.Update();
		assertFalse(c.entered);
		
		fsm.PushInput(new Input(1));
		fsm.Update();
		assertTrue(c.entered);
	}

}
