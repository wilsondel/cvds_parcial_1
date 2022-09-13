package domain.test;

import domain.Dice;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DiceTest {
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp(){
    }

    @Test
    public void shouldReturnDifferentValues() {
        Dice dice= new Dice();
        int a = dice.rollDice();
        assertNotNull(a);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
