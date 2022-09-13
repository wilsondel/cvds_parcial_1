package domain.test;

import static org.junit.Assert.*;

import domain.Box;
import domain.Piece;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

public class BoxTest {
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp(){
    }

    @Test
    public void shouldReturnColorPiece() {
        Box box = new Box();
        box.addPiece(new Piece(Color.cyan));
        Color color = box.getColorPiece();
        assertEquals(Color.cyan,color);
    }

    @Test
    public void shouldReturnSizePieces() {
        Box box = new Box();
        box.addPiece(new Piece(Color.cyan));
        box.addPiece(new Piece(Color.cyan));
        box.addPiece(new Piece(Color.cyan));
        box.addPiece(new Piece(Color.cyan));
        Piece[] pieces = {new Piece(Color.cyan),new Piece(Color.cyan),new Piece(Color.cyan),new Piece(Color.cyan)};
        box.addPiece(pieces);
        int sizePieces = box.getPieces().size();
        assertEquals(8,sizePieces);
    }

    @Test
    public void shouldDeletePieces() {
        Box box = new Box();
        Piece[] pieces = {new Piece(Color.cyan),new Piece(Color.cyan),new Piece(Color.cyan),new Piece(Color.cyan)};
        box.addPiece(pieces);
        box.removePiece();
        int sizePieces = box.getPieces().size();
        assertEquals(0,sizePieces);
    }

    @Test
    public void shouldReturnPieceReference() {
        Box box = new Box();
        Piece piece1 = new Piece(Color.cyan,1);
        Piece[] pieces = {piece1,new Piece(Color.cyan,2),new Piece(Color.cyan,3),new Piece(Color.cyan,4)};
        box.addPiece(pieces);
        assertTrue(piece1 == box.pieceReference(1));
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
