package domain;

import java.io.Serializable;

public class Poobchis implements Serializable {
    private Board board;
    private Player p1, p2;

    public Poobchis(){
        board = new Board();
        p1 = new Player("P1");
        p2 = new Player("P2");
    }

    public Player getP1() {
        return p1;
    }

    public Player getP2() {
        return p2;
    }

    public void finish() {
        System.exit(0);
    }

    public void play(String player, int[] result,int nameNumber, int pieceMoveResult){
//        int[] result = p1.getRealValue();
        if (player.equals("P1")) {
            board.evaluateBox(result,p1,nameNumber,pieceMoveResult);
        } else {
            board.evaluateBox(result,p2,nameNumber,pieceMoveResult);
        }

    }

    public Board getBoard() {
        return board;
    }

}
