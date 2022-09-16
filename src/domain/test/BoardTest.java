package domain.test;

import static org.junit.Assert.*;

import domain.Board;
import domain.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;


public class BoardTest {

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp(){
    }

    @Test
    public void shouldCreateBoard() {
        Board board = new Board();
        int size = board.getCompleteMatrix().length;
        assertEquals(20,size);
    }

    @Test
    public void shouldValidateBasePieceP1() {
        Board board = new Board();
        Player p1 = new Player("P1");
        int[] result = {5,4};
        board.evaluateBox(result,p1,1,result[1]);
        ArrayList<Integer> piecesBases = board.getBaseP1().lookPieces();
        boolean flag = piecesBases.contains(1);
        assertFalse(flag);
    }

    @Test
    public void shouldValidateBasePieceP2() {
        Board board = new Board();
        Player p2 = new Player("P2");
        int[] result = {5,4};
        board.evaluateBox(result,p2,5,result[1]);
        ArrayList<Integer> piecesBases = board.getBaseP2().lookPieces();
        boolean flag = piecesBases.contains(5);
        assertFalse(flag);
    }

    @Test
    public void shouldValidateHomeWayPieceP1() {
        Board board = new Board();
        Player p1 = new Player("P1");
        int[] result = {5,1};
        board.evaluateBox(result,p1,1,result[1]);
        for (int i = 0; i < 65; i++){
            board.evaluateBox(result,p1,1,result[1]);
        }
        boolean flag = board.homeWayContains(board.getHomeWayP1(),1);
        assertTrue(!flag);
    }

    @Test
    public void shouldValidateHomeWayPieceP2() {
        Board board = new Board();
        Player p2 = new Player("P2");
        int[] result = {5,1};
        board.evaluateBox(result,p2,5,result[1]);
        for (int i = 0; i < 63; i++){
            board.evaluateBox(result,p2,5,result[1]);
        }
        boolean flag = board.homeWayContains(board.getHomeWayP2(),5);
        assertTrue(true);
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
