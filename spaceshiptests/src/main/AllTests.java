package main;

import logic.fsm.FSM;
import logic.fsm.FSMTest;
import graphics.TextureTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import physics.MovingEntityTest;
import physics.SimulationTest;
import collision.CheckerTest;

@RunWith(Suite.class)
@SuiteClasses({ CheckerTest.class, MovingEntityTest.class, SimulationTest.class, 
	TextureTest.class, FSMTest.class })
public class AllTests {

}
