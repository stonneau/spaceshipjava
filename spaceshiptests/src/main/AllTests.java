package main;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import physics.MovingEntityTest;
import physics.SimulationTest;
import collision.CheckerTest;

@RunWith(Suite.class)
@SuiteClasses({ CheckerTest.class, MovingEntityTest.class, SimulationTest.class })
public class AllTests {

}
