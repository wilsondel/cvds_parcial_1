package domain.test;

import domain.Piece;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class PieceTest {
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp(){
    }

    @Test
    public void shouldVerifyNumberName() {
        Piece piece= new Piece(Color.CYAN, 1);
        int numPos = piece.getNumberName();
        assertEquals(1,numPos);
    }

    @Test
    public void shouldVerifyColor() {
        Piece piece= new Piece(Color.CYAN, 1);
        Color colorPiece = piece.getColor();
        assertEquals(Color.cyan,colorPiece);
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
