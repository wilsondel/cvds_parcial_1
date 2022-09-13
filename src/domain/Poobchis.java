package domain;

import java.io.Serializable;

public class Poobchis implements Serializable {
    private Board board;
    private Player p1, p2;
    private boolean currentPlayer, nextPlayer;

    public Poobchis(){
        board = new Board();
        p1 = new Player("P1");
        p2 = new Player("P2");
        currentPlayer = true;
        nextPlayer = true;
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

    /**
     * @param player - P1 or P2 according player turn
     * @param result - dice values
     * @param nameNumber - piece number to move
     * @param pieceMoveResult - value dice in order to move the piece
     */
    public void play(String player, int[] result,int nameNumber, int pieceMoveResult){
//        int[] result = p1.getRealValue();
        if (player.equals("P1")) {
            board.evaluateBox(result,p1,nameNumber,pieceMoveResult);
        } else {
            board.evaluateBox(result,p2,nameNumber,pieceMoveResult);
        }
        nextPlayer = !currentPlayer;
    }

    public Board getBoard() {
        return board;
    }

    /**
     * @return P1 or P2 according to player turn
     */
    public String player () {
        currentPlayer=nextPlayer;
        if (currentPlayer == true){
            return "P1";
        }
        return "P2";
    }

    public int getSuccessPiece(){
        return board.getSuccessPieces().getAmountPieces();
    }

    public int[] getNumPieceList(){
        String playerTurn = player();
        int[] namesP1 = {1,2,3,4};
        if (playerTurn.equals("P2")) {
            int[] namesP2 = {5,6,7,8};
            return namesP2;
        }
        return namesP1;
    }

    public void setPowerPieces(String powerPieces){
        board.setPiecePower(powerPieces);
    }

}
