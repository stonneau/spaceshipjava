package main;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import physics.MovingEntityTest;
import collision.CheckerTest;

@RunWith(Suite.class)
@SuiteClasses({ CheckerTest.class, MovingEntityTest.class })
public class AllTests {

}
